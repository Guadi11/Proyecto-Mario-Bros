package elementos;

import archivos.Sprite;
import colisiones.Visitor;

public class BolaDeFuego extends Movible implements Visitor{
	public BolaDeFuego(int x, int y, Sprite im) {
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


	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

}
