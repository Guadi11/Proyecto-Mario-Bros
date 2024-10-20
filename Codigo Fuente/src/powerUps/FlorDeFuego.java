package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class FlorDeFuego extends PowerUp{
	
	public FlorDeFuego(int x, int y, Sprite im) {
		super(x, y, im);

	}
	
	public void moverse() {
	}
	
	public void visitar(Jugador j) {
		estadoMario=j.getState();
		estadoMario.aumentarEstado(this);
		j.getInfo().actualizarPuntaje(puntosQueDa());
		morir();
	}
	
	public void morir() {
		//imagen.eliminar()
	}
	
	public int puntosQueDa () {
		return estadoMario.obtenerPuntosFFuego();
	}
	
}
