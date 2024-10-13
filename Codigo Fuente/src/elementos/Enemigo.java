package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import juego.Jugador;
import juego.Nivel;
import observers.Observer;

public abstract class Enemigo extends Movible implements Visitor, Visitable{
	protected float velocidad;
	protected Observer observer;
	protected Nivel nivel;

	public void visitar (Jugador j) {}
	public Enemigo(int x, int y, Sprite im) {
		super(x, y, im);
	}
	public void aceptarVisita (Visitor v) {}
	public void recibirDaño() {}
	public int puntosQueResta() {}
	public int puntosQueDa() {}
	public void morir() {
		imagen.eliminar();
	}
	public void setNivel(Nivel n) {}
}
