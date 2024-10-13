package plataformas;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Plataforma;

public class Vacio extends Plataforma implements Visitor{

	public Vacio(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
