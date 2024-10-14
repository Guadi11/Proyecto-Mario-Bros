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

	public Sprite getSprite() {
		return imagen;
	}

	public int getPosX() {
		return posicionX;
	}

	public int getPosY() {
		return posicionY;
	}

	@Override
	public void visitar(Jugador j) {
	int restarPuntos=puntosQueResta();
	j.getInfo().actualizarPuntaje(restarPuntos);
	}

	@Override
	public void aceptarVisita(Visitor v) {
		v.visit(this);
	}

	@Override
	public int recibirDaño() {
		this.morir();
		this.puntosQueDa();
	}

	@Override
	public int puntosQueResta() {
		return 30;
	}

	@Override
	public int puntosQueDa() {
		return 30;
	}

	@Override
	public void moverse() {
		ahora = System.currentTimeMillis();
        if (ahora - ultimaAparicion >= intervaloParaSalir)
        	comenzarAscenso();
	}
	private void comenzarAscenso() {
		//ver como hacer para el ascenso y que se quede cierto tiempo fuera
		int posicionXactual=posicionX;
		while (posicionXactual<posicion)
	}

}
