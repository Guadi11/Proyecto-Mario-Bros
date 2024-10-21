package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Piranha extends Enemigo{
	protected long intervaloParaSalir = 3000;
	private int estadoPiranha; // 0 = Descenso, 1 = Ascenso, 2 = Espera arriba
	protected long tiempoFueraTuberia = 2000;
	protected long contadorTiempoFuera = 0;
	protected long ahora;
	private long tiempoCambioEstado;
	private final long duracionEspera = 2000;
	
	public Piranha(int x, int y, Sprite im) {
		super(x, y, im);
		iniciarMovimientoPiranha();
		tiempoCambioEstado=System.currentTimeMillis();
	}
	public void iniciarMovimientoPiranha() {
		long ahora = System.currentTimeMillis();
		switch (estadoPiranha) {
        case 0: 
            if (this.getPosY() > posicionY) { 
                this.descender(); 
            }else {
                estadoPiranha = 1; 
            }
            break;

        case 1: 
            if (this.getPosY() < posicionY + 4) { 
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
	public void moverse() {
        	comenzarAscenso();
	}
	public void comenzarAscenso() {
			this.setPosY(posicionY+1);
			//ir cambiando imagen para que parexca que asciende
	}
	public void descender() {
			this.setPosY(posicionY-1);
			//cambiar imagenes
	}
	public void visitar(Jugador jugador) {
		int restarPuntos = puntosQueResta();
		jugador.getInfo().actualizarPuntaje(-restarPuntos);
		jugador.getState().recibirDaño();
	}
	public void aceptarVisita(Visitor visitor) {
		//visitor.visitar(this);
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

}
