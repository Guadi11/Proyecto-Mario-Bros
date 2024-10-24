package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import states.State;

public abstract class PowerUp extends Movible implements VisitorAJugador, Visitable{
	
	protected int velocidad = 2;
	protected State estadoMario;
	
	public PowerUp(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
}
