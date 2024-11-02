package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import juego.InfoJugador;
import juego.Jugador;

public class BolaDeFuego extends Movible implements VisitorBolaDeFuego, Visitable{
	protected Jugador jugador;
	private int velocidadX;
    private int velocidadY;
    private int gravedad;
    //private boolean activa; para ver si desactivar o no al momento de tirarlas?
    private int direccion;
    private final int VELOCIDAD_INICIAL = 10;
    private final float VELOCIDAD_REBOTE = 0.7f;
    final int LIMITE_SUPERIOR = 0;
    final int LIMITE_INFERIOR = 600;
    final int LIMITE_IZQUIERDO = 0;
    final int LIMITE_DERECHO = 800;
	
    public BolaDeFuego(int x, int y, Sprite imagen) {
		super(x, y, imagen);

	}
    
    public void actualizar() {
    	System.out.println("entra al actualizar bola de fuego");
    	//movimiento de bola de fuego
    	//cuando choca con alguna plataforma muere
    	
    	//direccion = this.jugador.getVelocidadX();
		//establecerVelocidadX();
		//establecerVelocidadY();
    }
    
	public void establecerVelocidadX() {
		velocidadX = VELOCIDAD_INICIAL * direccion;
	}
	
	public void establecerVelocidadY() {
		velocidadY = VELOCIDAD_INICIAL;
	}
	
	public void moverse() {
        velocidadY += gravedad;
        setPosX(posicionX + velocidadX);
        setPosY(posicionY + velocidadY);

        final int PISO_Y = 441; 
        if (posicionY >= PISO_Y) {
            posicionY = PISO_Y;
            velocidadY = (int) (-velocidadY * VELOCIDAD_REBOTE);
        }
        verificarEliminacion();
    }
	
	public void verificarEliminacion() {
		if (posicionY > LIMITE_INFERIOR || posicionY < LIMITE_SUPERIOR || posicionX < LIMITE_IZQUIERDO || posicionX > LIMITE_DERECHO) { 
           // imagen.eliminar();
		}
	}
	
	public void visitar(Enemigo enemigo) {
		//no importa de donde sea la colision, los mata de una a todos
		int puntosPorMatar = enemigo.puntosQueDa();
		enemigo.morir();
		jugador.getInfo().actualizarPuntaje(puntosPorMatar);
	}
	
	@Override
	public void visitar(Elemento elem) {
		//vacio
	}

	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// entra a este metodo cuando el visitor sea plataforma (sin incluir vacio)
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// entra a este metodo cuando el visitor sea una bola de fuego. No entra nunca aca
		visitor.visitar(this);
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
