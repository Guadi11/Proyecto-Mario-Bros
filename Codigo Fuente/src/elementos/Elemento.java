package elementos;

import java.awt.Rectangle;
import archivos.Sprite;
import juego.Nivel;
import observers.Observer;

public abstract class Elemento implements ElementoLogico{
	
	protected Rectangle hitbox;
	protected Sprite imagen;
	protected Observer observer;
	protected int posicionX,posicionY;
	protected Nivel nivel;
	
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
	
	public void setPosX(int pos) {
		this.posicionX = pos;
	}
	
	public void setPosY( int pos) {
		this.posicionY = pos;
	}
	
	public void actualizarPosicionHitbox() {
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
	public void morir() {
		this.nivel.removerElemento(this);
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
		public Rectangle getBoundsBottom() {
			return new Rectangle(
					 (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4),  
				     (int) (this.getHitbox().getY() - this.getHitbox().getHeight()/2), //chequear +5
				     (int) this.getHitbox().getWidth(),  // /2 o rstarle un numero fijo tipo 5, 10
				     (int) this.getHitbox().getHeight()/2); 
		}
		
		public Rectangle getBoundsTop() {
			
			 return new Rectangle(
					// (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4), x
					 // (int) this.getHitbox().getWidth()/2,  ancho
					    (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4), //+5
				        (int) this.getHitbox().getY() +5,  //(this.getHitbox().getY() + this.getHitbox().getHeight()/2)
				        (int)  this.getHitbox().getWidth()/2, 
				        (int) this.getHitbox().getHeight()/2);
		}
		
		public Rectangle getBoundsRight() {
			
			return new Rectangle(
			        (int) (this.getPosX() + this.getHitbox().getWidth() - 5),
			        (int) this.getPosY() - 5, 
			        5, 
			        (int) this.getHitbox().getHeight() - 10);
		} 
		
		public Rectangle getBoundsLeft() {
			 return new Rectangle(
				        (int) this.getPosX(),
				        (int) this.getPosY() - 5,  
				        5, 
				        (int) this.getHitbox().getHeight() - 10);
		} 
		
}
