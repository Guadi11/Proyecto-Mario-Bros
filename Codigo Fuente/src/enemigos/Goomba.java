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
				jugador.getState().recibirDaño();
				jugador.getInfo().actualizarPuntaje(-puntosDaño);
				//this.recibirDaño();
				System.out.println("Jugador recibe daño.");
			}
		/*int puntosDaño = this.puntosQueResta();
		jugador.getState().recibirDaño();
		jugador.getInfo().actualizarPuntaje(-puntosDaño);*/
	}
	
	public void aceptarVisita (Visitor visitor) {
		//visitor.visitar (this);
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
		//this.nivel.removerElemento(this);
	}
}
