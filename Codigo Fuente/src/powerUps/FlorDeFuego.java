package powerUps;

import archivos.Sprite;
import elementos.PowerUp;
import juego.Jugador;
import states.State;

public class FlorDeFuego extends PowerUp{
	public FlorDeFuego(int x, int y, Sprite im) {
		super(x, y, im);

	}
	public void moverse() {
	}
	public void visitar(Jugador j) {
		j.getState().aumentarEstado(this);
		j.getInfo().actualizarPuntaje(puntosQueDa(j.getState()));
		morir();
	}
	public void morir() {
		//imagen.eliminar()
	}
	public int puntosQueDa(State estado) {
		int puntos=0;
		switch (estado) {
			case Normal :{puntos=5;
			break;}
			case SuperMario: {puntos=30;
			break;
			}
			case Fuego: {puntos=50;
			break;
			}
		default:
			break;
		} return puntos;
	}
}
