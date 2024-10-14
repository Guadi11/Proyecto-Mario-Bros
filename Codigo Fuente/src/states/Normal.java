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
}
