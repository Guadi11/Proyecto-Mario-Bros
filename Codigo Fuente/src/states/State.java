package states;

import elementos.PowerUp;
import archivos.Sprite;
import juego.Jugador;


public abstract class State {
	
	protected Jugador jugador;
	protected Sprite sprite;
	
	
	public State(Jugador jugador) {
	        this.jugador = jugador;
	}

	public Sprite getSprite() {
	        return sprite;
	}
	
	public abstract void aumentarEstado(PowerUp p);
	public abstract void recibirDaño();
	public abstract int obtenerPuntosEstrella();
	public abstract int obtenerPuntosSChamp();
	public abstract int obtenerPuntosFFuego();
}
