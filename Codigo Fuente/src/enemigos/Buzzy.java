package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Buzzy extends Enemigo{

	public Buzzy(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}

	public void visitar(Jugador j) {
		int puntosDaño=this.puntosQueResta();
		j.getInfo().actualizarPuntaje(-puntosDaño);
	}

	public void aceptarVisita(Visitor v) {
		//v.visit(this);
	}

	public void recibirDaño() {
		this.morir();
		this.puntosQueDa();
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
