package plataformas;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import elementos.Elemento;
import elementos.Plataforma;
import juego.Jugador;

public class Castillo extends Plataforma implements VisitorAJugador{

	public Castillo(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	@Override
	public void visitar(Elemento elem) {
		//vacio
	}

	@Override
	public void visitar(Jugador jugador) {
		//gestiona el ganar nivel
		//this.nivel.getControladorPartida().victoria(jugador.getInfo().getPuntaje());
	}

}
