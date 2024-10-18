package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class FlorDeFuego extends PowerUp{
	
	public FlorDeFuego(int x, int y, Sprite imagen) {
		super(x, y, imagen);

	}
	
	public void moverse() {
		
	}
	
	public void visitar(Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.aumentarEstado(this);
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		morir();
	}
	
	public void morir() {
		//imagen.eliminar()
	}
	
	public int puntosQueDa () {
		return estadoMario.obtenerPuntosFFuego();
	}
}
