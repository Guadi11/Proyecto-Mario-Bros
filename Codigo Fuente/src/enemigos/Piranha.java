package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;
import observers.AdaptadorPosicionPixel;

public class Piranha extends Enemigo{
	protected long intervaloParaSalir = 3000;
	private int estadoPiranha; // 0 = Descenso, 1 = Ascenso, 2 = Espera arriba
	protected long tiempoFueraTuberia = 2000;
	protected long contadorTiempoFuera = 0;
	protected long ahora;
	private long tiempoCambioEstado;
	private final long duracionEspera = 2000;
	private int alturaEscondida, alturaAfuera;
	
	public Piranha(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		estadoPiranha = 1;
		alturaEscondida = this.getPosY();
		alturaAfuera = (int) (alturaEscondida + this.getHitbox().getHeight());
		//iniciarMovimientoPiranha();
		tiempoCambioEstado = System.currentTimeMillis();
	}
	
	public void iniciarMovimientoPiranha() {
		//System.out.println("entra a iniciarMovimiento");
		long ahora = System.currentTimeMillis();
		switch (estadoPiranha) {
        case 0: 
            if (this.getPosY() > alturaEscondida) { 
                this.descender(); 
            }else {
                estadoPiranha = 1; 
            }
            break;

        case 1: 
            if (this.getPosY() < alturaAfuera) { 
                this.comenzarAscenso(); 
            }else {
                estadoPiranha = 2; 
                tiempoCambioEstado = ahora; 
            }
            break;

        case 2: 
            if (ahora - tiempoCambioEstado >= duracionEspera) {
                estadoPiranha = 0; 
            }
            break;
		}
	}
	
	public void comenzarAscenso() {
		velY +=1;
		posicionY += velY;
		//this.setPosY(posicionY+1); //ver esto
			//ir cambiando imagen para que parexca que asciende
	}
	public void descender() {
		velY -= 1;
		posicionY += velY;
			//this.setPosY(posicionY-1);
			//cambiar imagenes
	}
	public void actualizar() {
		iniciarMovimientoPiranha();
		//tiempoCambioEstado = System.currentTimeMillis();
	}
	
	public void visitar(Jugador jugador) {
		if(!jugador.getState().esInvulnerable()) {
			jugadorMuere(jugador);
		}else {
			enemigoMuere(jugador);
		}
	}
	
	private void enemigoMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
		morir();
	}

	private void jugadorMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(-puntosQueResta());
		jugador.getState().recibirDaño();
	}

	@Override
	public void visitar(Elemento elem) {
		// vacio
	}

	public int recibirDaño() {
		this.morir();
		return this.puntosQueDa();
	}

	public int puntosQueResta() {
		return 30;
	}

	public int puntosQueDa() {
		return 30;
	}
	
	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// Entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio.
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// Entra a este metodo cuando el visitor sea plataforma (sin incluir vacio).
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// Entra a este metodo cuando el visitor sea una bola de fuego.
		visitor.visitar(this);
	}


}
