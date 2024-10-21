package elementos;

import archivos.Sprite;
import colisiones.Visitor;
import states.State;

public abstract class PowerUp extends Movible implements Visitor{
	protected int velocidad=2;
	protected State estadoMario;
	public PowerUp(int x, int y, Sprite im) {
		super(x, y, im);
	}
	
}
