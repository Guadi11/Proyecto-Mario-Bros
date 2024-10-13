package plataformas;

import archivos.Sprite;
import elementos.Enemigo;
import elementos.Plataforma;
import enemigos.Piranha;

public class Tuberia extends Plataforma{
	protected Enemigo piranha;
	public Tuberia(int x, int y, Sprite im) {
		super(x, y, im);
		crearPiranha();
	}

	public void crearPiranha() {
		piranha=new Piranha (posicionX, posicionY+1, imagen);
	}
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
