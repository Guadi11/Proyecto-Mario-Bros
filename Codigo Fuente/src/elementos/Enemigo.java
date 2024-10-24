package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import juego.Nivel;
import observers.Observer;

public abstract class Enemigo extends Movible implements VisitorAJugador, Visitable{
	
	protected Observer observer;
	protected Nivel nivel;
	protected long velocidadEnMill = 3000;
	protected int velX, velY;
	
	public Enemigo(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
	}

	public abstract int puntosQueResta();
	public abstract int puntosQueDa();
	
	public void morir() {
		//imagen.eliminar();
		//puntosQueDa();
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void moverIzquierda() {
		velX = -2;
	}
	
	public void moverDerecha() {
		velX = 4;
	}
	
	public void actualizar() {
		moverIzquierda();
		posicionX += velX;
		actualizarPosicionHitbox();
		notificar();
	}
}
