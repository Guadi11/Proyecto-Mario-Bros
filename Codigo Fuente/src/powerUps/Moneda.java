package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;

public class Moneda extends PowerUp{

	public Moneda(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		jugador.getInfo().aumentarMoneda();
		morir();
	}
	
	public int puntosQueDa() {
		return 5;
	}
	
	public void morir() {
		setHitbox(0,0);
		//imagen.eliminar()
	}
	
	public void moverse() {
		
	}

}
