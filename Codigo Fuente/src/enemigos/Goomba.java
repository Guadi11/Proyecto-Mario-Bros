package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Goomba extends Enemigo{
	
	public Goomba (int x, int y, Sprite im) {
		super (x,y,im);
	}
	public void visitar (Jugador j) {
		int puntosDaño=this.puntosQueResta();
		//j.recibirDaño(puntosDaño);
	}
	public void aceptarVisita (Visitor v) {
		//v.visit (this);
	}
	public void recibirDaño() {
		this.morir();
		this.puntosQueDa();
	}
	public int puntosQueResta() {
		return 30;
	}
	public int puntosQueDa() {
		return 60;
	}
	public void moverse(int velocidad) {
		int nuevaPosicionX=posicionX + velocidad*(1/60);
		if (velocidad<0) {
			//imagen.cambiarImagen("Goomba_a_izq.png");
		}else
			//imagen.cambiarImagen("Goomba_a_der.png");
		setPosX(nuevaPosicionX);
		//imagen.actualizarPosicion(posicionX, posicionY);
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
	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}
}
