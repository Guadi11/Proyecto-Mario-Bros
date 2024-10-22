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
		estadoMario.aumentarAFuego();
		jugador.getInfo().actualizarPuntaje(estadoMario.obtenerPuntosFFuego());
		morir();
	}
	
	public void aplicar(State estado) {
		estado.aumentarAFuego();
	}
	
	/*blic void morir() {
		setHitbox(0,0);
		//imagen.eliminar()
	}*/
}
