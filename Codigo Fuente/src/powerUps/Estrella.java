package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class Estrella extends PowerUp{
	private long limiteInferior;
	
	public Estrella(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.aumentarEstado(this);
		jugador.setEstrella(true);
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		morir();
	}
	
	public int puntosQueDa() {
		return estadoMario.obtenerPuntosEstrella();
	}
	
	public void morir() {
		//imagen.eliminar()
	}
	
	public void moverse() {
		descender();
		movimientoADerecha();
	}
	
	public void descender() {
		if (posicionY < limiteInferior)
			setPosY(posicionY-1);
	}
	
	public void movimientoADerecha() {
		int nuevaPosicionX = posicionX + velocidad*(1/60);
		setPosX(nuevaPosicionX);
	}
	/*private long establecerLimiteInferior() {
		return alturaVentana- alturaDelSuelo;
	}*/

}
