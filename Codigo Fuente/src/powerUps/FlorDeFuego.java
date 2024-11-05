package powerUps;

import archivos.Sprite;
import archivos.TipoSonidos;
import elementos.Elemento;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class FlorDeFuego extends PowerUp{

	public FlorDeFuego(int x, int y, Sprite imagen) {
		super(x, y, imagen);

	}

	public void visitar(Jugador jugador) {
		State estadoMario = jugador.getState();
		estadoMario.recibirFlorDeFuego();
		morir();
	}

	public void morir() {
		this.nivel.removerElemento(this);
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoAccion(TipoSonidos.powerUp);
	}

	@Override
	public void visitar(Elemento elem) {
		// Vacio. 
	}
}
