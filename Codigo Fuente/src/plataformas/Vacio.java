package plataformas;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Plataforma;
import juego.Jugador;

public class Vacio extends Plataforma implements Visitor{

	public Vacio(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	public void visitar (Jugador jugador) {
		jugador.getInfo().restarVida();
	}
}
