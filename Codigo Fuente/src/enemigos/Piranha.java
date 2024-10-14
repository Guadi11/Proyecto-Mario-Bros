package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Piranha extends Enemigo{
	protected long intervaloParaSalir=3000;
	protected long ultimaAparicion;
	protected long tiempoFueraTuberia=2000;
	protected long contadorTiempoFuera=0;
	protected long ahora;
	public Piranha(int x, int y, Sprite im) {
		super(x, y, im);
		ultimaAparicion=System.currentTimeMillis();
	}

	public void visitar(Jugador j) {
	int restarPuntos=puntosQueResta();
	j.getInfo().actualizarPuntaje(-restarPuntos);
	}

	@Override
	public void aceptarVisita(Visitor v) {
		v.visit(this);
	}

	public void recibirDaño() {
		this.morir();
		this.puntosQueDa();
	}

	public int puntosQueResta() {
		return 30;
	}

	public int puntosQueDa() {
		return 30;
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

}
