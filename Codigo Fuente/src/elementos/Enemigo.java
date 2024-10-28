package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import observers.AdaptadorPosicionPixel;
import observers.Observer;

public abstract class Enemigo extends Movible implements VisitorAJugador, Visitable{
	
	protected Observer observer;
	protected long velocidadEnMill = 3000;
	protected int velX, velY;
	protected boolean aIzquierda;
	protected boolean colisionConBloque;
	
	
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
		int alturaPiso = 109; 
		int limiteDerecho =  AdaptadorPosicionPixel.transformarX(7471);
		int limiteY_ventana = 0;
		moverEnDireccion();
		this.setPosX(posicionX + velX);
		posicionY += velY;
		
		if (!colisionConBloque)
			velY-=1;
			/*if (posicionY > alturaPiso){// || posicionY<alturaPiso) {
			    velY -= 1;
			}
				else { 
					posicionY = alturaPiso;
					velY = 0; 
						}*/
		
		if (posicionX < 0) {
	        posicionX = 0; 
	    }else if (posicionX > limiteDerecho) {
	    	posicionX = limiteDerecho;	
	    }
		if (posicionY<limiteY_ventana)
			morir();
		actualizarPosicionHitbox();
		notificar();

	}
	public void ColisionaConBloque(boolean c) {
		colisionConBloque = c;
	}
	public void setVelX(int direc) {
		this.velX = direc;
	}

	public void setVelY(int direc) {
		this.velY = direc;
	}
}
