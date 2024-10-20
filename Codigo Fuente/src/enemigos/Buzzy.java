package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Buzzy extends Enemigo{

	public Buzzy(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	public void visitar(Jugador jugador) {
		int puntosDaño = this.puntosQueResta();
		jugador.getInfo().actualizarPuntaje(-puntosDaño);
		jugador.getState().recibirDaño();
	}

	public void aceptarVisita(Visitor visitor) {
		//visitor.visit(this);
	}

	public int recibirDaño() {
		this.morir();
		int puntos=this.puntosQueDa();
		return puntos;
	}

	public int puntosQueResta() {
		return 15;
	}

	public int puntosQueDa() {
		return 30;
	}

	public void moverse() {
		/* cambiar cuando esten colisione/heapbox
		 int nuevaPosicionX=posicionX + velocidad*(1/60);
		 
		setPosX(nuevaPosicionX);
		if (velocidad<0) {
			//imagen.cambiarImagen("Goomba_a_izq.png");
		}else
			//imagen.cambiarImagen("Goomba_a_der.png");
		
		//imagen.actualizarPosicion(posicionX, posicionY);*/
	}

}
