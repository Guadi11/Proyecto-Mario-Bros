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
	protected int velX,velY;
	
	public Enemigo(int x, int y, Sprite im) {
		super(x, y, im);
		velX = 0;
		velY = 0;
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
	public void moverIzquierda() {
		velX = -4;
	}
	public void moverDerecha() {
		velX = 4;
	}
	public void actualizar() {
		moverIzquierda();
		posicionX += velX;
		System.out.println("PosicionX: "+this.posicionX);
	}
}
