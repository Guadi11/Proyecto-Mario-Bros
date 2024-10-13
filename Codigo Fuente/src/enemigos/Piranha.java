package enemigos;

import archivos.Sprite;
import elementos.Enemigo;

public class Piranha extends Enemigo{
	public Piranha(int x, int y, Sprite im) {
		super(x, y, im);
	}

	public Sprite getSprite() {
		return imagen;
	}

	public int getPosX() {
		return posicionX;
	}

	public int getPosY() {
		return posicionY;
	}

}
