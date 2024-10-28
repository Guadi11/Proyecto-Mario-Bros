package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import observers.Observer;

public abstract class Enemigo extends Movible implements VisitorAJugador, Visitable{
	
	protected Observer observer;
	protected long velocidadEnMill = 3000;
	protected int velX, velY;
	protected boolean aIzquierda;
	
	
	public Enemigo(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
		aIzquierda = true;
	}

	public abstract int puntosQueResta();
	public abstract int puntosQueDa();
	
	public void moverIzquierda() {
		aIzquierda = true;
		//velX = -2;
	}
	
	public void moverDerecha() {
		aIzquierda = false;
		//velX = 4;
	}
	public void moverEnDireccion() {
		if(aIzquierda) {
			velX = -2;
		}else {
			velX = 2;
		}
	}
	
	public void actualizar() {
		moverEnDireccion();
		//moverIzquierda();
		this.setPosX(posicionX + velX); 
		actualizarPosicionHitbox();
		notificar();
	}
}
