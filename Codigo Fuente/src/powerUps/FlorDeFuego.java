package powerUps;

import archivos.Sprite;
import elementos.Elemento;
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
		estadoMario.recibirFlorDeFuego();
		morir();
	}
	
	@Override
	public void visitar(Elemento elem) {
		//vacio 
	}
	
	/*blic void morir() {
		setHitbox(0,0);
		//imagen.eliminar()
	}*/
}
