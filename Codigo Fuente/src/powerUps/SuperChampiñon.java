package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class SuperChampiñon extends PowerUp{
	
	private long limiteInferior=441;
	
	
	public SuperChampiñon(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	public void visitar (Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.aumentarEstado(this);
		jugador.getInfo().actualizarPuntaje(estadoMario.obtenerPuntosSChamp());
		morir();
	}
	/*
	public int puntosQueDa() {
		return estadoMario.obtenerPuntosSChamp();
	}
	*/
	public void morir() {
		//imagen.eliminar
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
