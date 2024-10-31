package powerUps;

import archivos.Sprite;
import archivos.TipoSonidos;
import elementos.Elemento;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class SuperChampiñon extends PowerUp{
	
	private long limiteInferior = 441;
	
	public SuperChampiñon(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.recibirSuperChampiñon();
		morir();
	}
	public void morir() {
		this.nivel.removerElemento(this);
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoAccion(TipoSonidos.powerUp);
		}

	@Override
	public void visitar(Elemento elem) {
		// vacio
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
		int nuevaPosicionX = posicionX - velocidad*(1/60);
		setPosX(nuevaPosicionX);
	}
}
