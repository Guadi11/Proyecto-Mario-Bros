package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import juego.Jugador;
import juego.Nivel;
import observers.Observer;

public abstract class Enemigo extends Movible implements Visitor, Visitable{
	protected Observer observer;
	protected Nivel nivel;
	protected long velocidadEnMill=3000; 
	
	public Enemigo(int x, int y, Sprite im) {
		super(x, y, im);
	}
	
	public abstract void aceptarVisita (Visitor v);
	public abstract int recibirDaño();
	public abstract int puntosQueResta();
	public abstract int puntosQueDa();
	public void morir() {
		//imagen.eliminar();
		puntosQueDa();
	}
	public void setNivel(Nivel n) {
		this.nivel = n;
	}
}
