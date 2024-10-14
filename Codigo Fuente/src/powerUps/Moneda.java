package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;

public class Moneda extends PowerUp{

	public Moneda(int x, int y, Sprite im) {
		super(x, y, im);
	}
	public void visitar (Jugador j) {
		j.getInfo().actualizarPuntaje(puntosQueDa());
		morir();
	}
	public int puntosQueDa() {
		return 5;
	}
	public void morir() {
		//imagen.eliminar()
	}
	public void moverse() {
	}

}
