package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Goomba extends Enemigo{
	
	public Goomba (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	public void visitar (Jugador jugador) {
		if (jugador.esColisionDesdeArriba(this)) { //aca gestionar que jugador elimino a goomba
			System.out.println("Goomba recibio daño desde arriba.");
		}
			else {
				int puntosDaño = this.puntosQueResta();
				int puntajeActual = jugador.getInfo().getPuntaje();
				jugador.getState().recibirDaño();
				if (puntajeActual-puntosDaño>=0) {
					jugador.getInfo().actualizarPuntaje(-puntosDaño);
				}
				else jugador.getInfo().actualizarPuntaje(-puntajeActual);
	
			}
	}
	
	
	public void aceptarVisita (Visitor visitor) {
		//visitor.visitar(this);
	}
	
	public int recibirDaño() {
		this.morir();
		return this.puntosQueDa();
	}
	
	public int puntosQueResta() {
		return 30;
	}
	
	public int puntosQueDa() {
		return 60;
	}
	
	public void moverse() {
		/* modificar
		 int nuevaPosicionX=posicionX + velocidad*(1/60);
		 
		if (velocidad<0) {
			//imagen.cambiarImagen("Goomba_a_izq.png");
		}else
			//imagen.cambiarImagen("Goomba_a_der.png");
		setPosX(nuevaPosicionX);
		//imagen.actualizarPosicion(posicionX, posicionY);*/
	}
	
	public void morir() {
		setHitbox(0,0);
		//this.nivel.removerElemento(this);
	}
}
