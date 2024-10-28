package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import observers.Observer;

public abstract class Enemigo extends Movible implements VisitorAJugador, Visitable{
	
	protected Observer observer;
	protected long velocidadEnMill = 3000;
	protected int velX, velY;
	protected boolean colisionArriba = false;
	
	public Enemigo(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
	}

	public abstract int puntosQueResta();
	public abstract int puntosQueDa();
	
	public void moverIzquierda() {
		velX = -2;
	}
	
	public void moverDerecha() {
		velX = 4;
	}
	
	public void actualizar() {
		moverIzquierda();
		this.setPosX(posicionX + velX); 
		actualizarPosicionHitbox();
		notificar();
	}
	public void colisionDesdeArriba() {
		colisionArriba = true;
	}
	public boolean fueColisionArriba() {
		return colisionArriba;
	}
}
