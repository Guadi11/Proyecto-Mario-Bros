package plataformas;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import elementos.Elemento;
import elementos.Plataforma;
import juego.Jugador;

public class Vacio extends Plataforma implements VisitorAJugador{ 

	public Vacio(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		//tiene que reiniciar nivel si o si
		jugador.getInfo().restarVida();
	}
	
	@Override
	public void visitar(Elemento elem) {
		//no se como, pero que se caiga. Ademas muere
		
	}

}
