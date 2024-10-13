package plataformas;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Plataforma;
import elementos.PowerUp;

public class BloqueDePregunta extends Plataforma implements Visitable{

	protected PowerUp powerUp;

	public BloqueDePregunta(int x, int y, Sprite im) {
		super(x, y, im);
	}

	public void generarPowerUp() {
		nivel.agregarPowerUp(powerUp);
	}
	public void aceptarVisita (Visitor v) {
		v.visit(this);
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
