package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class Estrella extends PowerUp{
	private long limiteInferior;
	public Estrella(int x, int y, Sprite im) {
		super(x, y, im);
	}
	public void visitar (Jugador j) {
		j.getState().aumentarEstado(this);
		j.setEstrella(true);
		j.getInfo().actualizarPuntaje(puntosQueDa(j.getState()));
		morir();
	}
	public int puntosQueDa(State estado) {
		int puntos=0;
		switch (estado) {
			case Normal :{puntos=20;
			break;}
			case SuperMario: {puntos=30;
			break;
			}
			case Invencible: {puntos=35;
			break;
			}
		default:
			break;
		} return puntos;
	}
	public void morir() {
		//imagen.eliminar()
	}
	public void moverse() {
		descender();
		movimientoADerecha();
	}
	public void descender() {
		if (posicionY <limiteInferior)
			setPosY(posicionY-1);
	}
	public void movimientoADerecha() {
		int nuevaPosicionX= posicionX+velocidad*(1/60);
		setPosX(nuevaPosicionX);
	}
	/*private long establecerLimiteInferior() {
		return alturaVentana- alturaDelSuelo;
	}*/

}
