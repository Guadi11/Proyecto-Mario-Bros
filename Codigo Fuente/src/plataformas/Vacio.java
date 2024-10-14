package plataformas;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Plataforma;

public class Vacio extends Plataforma implements Visitor{

	public Vacio(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}
}
