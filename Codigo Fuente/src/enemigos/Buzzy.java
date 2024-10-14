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

	@Override
	public Sprite getSprite() {
		return imagen;
	}

	@Override
	public int getPosX() {
		return posicionX;
	}

	@Override
	public int getPosY() {
		return posicionY;
	}

	@Override
	public void visitar(Jugador j) {
		int puntosDaño=this.puntosQueResta();
		j.getInfo().actualizarPuntaje(-puntosDaño);
	}

	@Override
	public void aceptarVisita(Visitor v) {
		//v.visit(this);
	}

	@Override
	public void recibirDaño() {
		this.morir();
		this.puntosQueDa();
	}

	@Override
	public int puntosQueResta() {
		return 15;
	}

	@Override
	public int puntosQueDa() {
		return 30;
	}

	@Override
	public void moverse(int velocidad) {
		int nuevaPosicionX=posicionX + velocidad*(1/60);
		setPosX(nuevaPosicionX);
		if (velocidad<0) {
			//imagen.cambiarImagen("Goomba_a_izq.png");
		}else
			//imagen.cambiarImagen("Goomba_a_der.png");
		
		//imagen.actualizarPosicion(posicionX, posicionY);
	}

}
