package plataformas;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Plataforma;

public class LadrilloSolido extends Plataforma implements Visitable{
	public LadrilloSolido(int x, int y, Sprite im) {
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
	public void romperse() {
		//imagen.eliminar();
	}
	public void aceptarVisita(Visitor v) {
		//v.visit(this);
	}

}
