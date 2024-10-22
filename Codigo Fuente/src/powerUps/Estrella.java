package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;


public class Estrella extends PowerUp{
	
	protected long limiteInferior;
	
	
	public Estrella(int x, int y, Sprite im) {
		super(x, y, im);
	}

	public void visitar (Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.aumentarEstado(this);
		jugador.getInfo().actualizarPuntaje(estadoMario.obtenerPuntosEstrella());
		morir();
	}
	
	public void morir() {
		setHitbox(0,0);
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
	public void movimientoAIzquierda() {
		int nuevaPosicionX=posicionX- velocidad*(1/60);
		setPosX(nuevaPosicionX);
	}

}
