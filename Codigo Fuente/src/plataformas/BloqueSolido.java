package plataformas;

import archivos.Sprite;
import elementos.Plataforma;

public class BloqueSolido extends Plataforma{
	public BloqueSolido(int x, int y, Sprite im) {
		super(x, y, im);
	}

	@Override
	public Sprite getSprite() {
		return imagen;
	}

	@Override
	public int getPosX() {
		return posicionX;
	}

	@Override
	public int getPosY() {
		return posicionY;
	}

}
