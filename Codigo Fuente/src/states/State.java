package states;

import elementos.PowerUp;
import juego.Jugador;


public abstract class State {
protected Jugador jugador;
	public abstract void aumentarEstado(PowerUp p);
	public abstract void recibirDaño();
	public abstract int obtenerPuntosEstrella();
	public abstract int obtenerPuntosSChamp();
	public abstract int obtenerPuntosFFuego();
}
