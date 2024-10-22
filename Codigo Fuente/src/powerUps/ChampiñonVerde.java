package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;

public class ChampiñonVerde extends PowerUp{
	private long limiteInferior=441;
	
	public ChampiñonVerde(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		jugador.getInfo().sumarVida();
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		morir();
	}
	
	public int puntosQueDa() {
		return 100;
	}
	
	public void morir() {
		setHitbox(0,0);
		//imagen.eliminar();
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
