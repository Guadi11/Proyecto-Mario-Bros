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
				     (int) (this.getHitbox().getY() - this.getHitbox().getHeight() + 5), //chequear
				     (int) this.getHitbox().getWidth()/2,  
				     (int) this.getHitbox().getHeight()/2);  
				    
		}
		
		public Rectangle getBoundsTop() {
			//System.out.println("Entro a getboundsTop");
			 return new Rectangle(
				        (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4), 
				        (int) (this.getHitbox().getY() + this.getHitbox().getHeight()/2),  // Parte superior del enemigo
				        (int) this.getHitbox().getWidth()/2, // Ancho total del enemigo
				        (int) this.getHitbox().getHeight()/2);// Solo una pequeña franja en la parte superior
		}
		/*	//no borrarlos!!!
		public Rectangle getBoundsRight() {
			
			return new Rectangle(
			        (int) (this.getPosX() + this.getHitbox().getWidth() - 5), // Solo 5px del borde derecho
			        (int) this.getPosY() - 5,  // Excluye un poco de la parte superior e inferior
			        5, // Un rectángulo muy estrecho en el lado derecho
			        (int) this.getHitbox().getHeight() - 10 // Excluye los primeros y últimos 5px verticales
			    );
			
			return new Rectangle( (int) (this.getHitbox().getX() + this.getHitbox().getWidth() - 5), //este 5 puedo ir cambiandolo, ancho del rect
					(int) (this.getHitbox().getY() - 5), //aca probablemente sea restarle 5 no sumarle
					5,//este 5 puedo ir cambiandolo, ancho del rect
					(int) this.getHitbox().getHeight() - 10); //5 arriba y 5 abajo  
		} 
		
		public Rectangle getBoundsLeft() {
			 return new Rectangle(
				        (int) this.getPosX(), // Límite izquierdo
				        (int) this.getPosY() - 5,  // Excluye la parte superior e inferior
				        5,  // Solo 5px del borde izquierdo
				        (int) this.getHitbox().getHeight() - 10  // Excluye los primeros y últimos 5px verticales
				    );
		
			
			return new Rectangle( (int) this.getHitbox().getX(),
					(int) (this.getHitbox().getY() - 5), //aca probablemente sea restarle 5 no sumarle
					5,//este 5 puedo ir cambiandolo, ancho del rect
					(int) (this.getHitbox().getHeight() - 10)); //5 arriba y 5 abajo;  
		} */
		
}
