package elementos;

import java.awt.Rectangle;
import archivos.Sprite;
import juego.Jugador;
import observers.Observer;

public abstract class Elemento implements ElementoLogico{
	
	protected Rectangle hitbox;
	protected Sprite imagen;
	protected Observer observer;
	protected int posicionX,posicionY;
	
	public Elemento(int x, int y, Sprite imagen) {
		posicionX = x;
		posicionY = y;
		hitbox = new Rectangle ();
		hitbox.setLocation(posicionX,posicionY);
		this.imagen=imagen;
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
	public void setPositionHitbox() {
		hitbox.setLocation(posicionX,posicionY);
	}
	public void setHitbox(int width, int height) {
		hitbox.setSize(width, height);
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	public Observer getObserver() {
		return this.observer;
	}
	
	public void registrarObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void eliminarObserver() {
	}
	
	public void notificar() {
		this.observer.actualizar();
	}
		
}
