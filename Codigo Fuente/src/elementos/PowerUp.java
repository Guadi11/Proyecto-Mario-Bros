package elementos;

import archivos.Sprite;
import colisiones.Visitor;

public abstract class PowerUp extends Movible implements Visitor{
	public PowerUp(int x, int y, Sprite im) {
		super(x, y, im);
	}
}
