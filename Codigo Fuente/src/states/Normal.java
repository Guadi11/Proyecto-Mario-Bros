package states;

import elementos.PowerUp;

public class Normal extends State{

	public Normal() {
		//jugador.getSprite().cambiar(Normal);
	}
	public void aumentarEstado (PowerUp p) {
		jugador.setState(this);
	}
	public void recibirDaño() {
		jugador.getInfo().restarVida();
	}
	public int obtenerPuntosEstrella() {
		return 20;
	}
	public int obtenerPuntosSChamp() {
		return 10;
	}
	public int obtenerPuntosFFuego() {
		return 5;
	}
	
}
