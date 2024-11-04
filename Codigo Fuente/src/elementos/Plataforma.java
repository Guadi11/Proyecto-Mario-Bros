package elementos;

import java.awt.Rectangle;

import archivos.Sprite;
import colisiones.VisitorPlataformas;
import juego.Nivel;

public abstract class Plataforma extends Elemento implements VisitorPlataformas{
	
	protected Nivel nivel;

	public Plataforma (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	public void morir() {
		this.nivel.removerElemento(this);
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
    //lo copie aca porque los de las plataformas los hice bien especificos que cubran todo, probando
	public Rectangle getBoundsBottom() {
		return new Rectangle(
				 (int) (this.getHitbox().getX()),
			     (int) (this.getHitbox().getY() - this.getHitbox().getHeight()/2),
			     (int) this.getHitbox().getWidth(),
			     (int) this.getHitbox().getHeight()/2); 
	}
	
	public Rectangle getBoundsTop() {
		
		 return new Rectangle(
				    (int) (this.getHitbox().getX()),
			        (int) this.getHitbox().getY(),  
			        (int)  this.getHitbox().getWidth(), 
			        (int) this.getHitbox().getHeight()/2);
	}
	
	public Rectangle getBoundsRight() {
		
		return new Rectangle(
		        (int) (this.getHitbox().getX() + this.getHitbox().getWidth() - this.getHitbox().getWidth()/10),
		        (int) this.getHitbox().getY()-2, 
		        (int) (this.getHitbox().getWidth()/10), 
		        (int) this.getHitbox().getHeight()-4);
	} 
	
	public Rectangle getBoundsLeft() {
		 return new Rectangle(
			        (int) this.getHitbox().getX(),
			        (int) this.getHitbox().getY()-2,
			        (int) (this.getHitbox().getWidth()/10), 
			        (int) this.getHitbox().getHeight()-4);
	} 
	
}
