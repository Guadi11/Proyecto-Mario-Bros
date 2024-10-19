package plataformas;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Plataforma;

public class LadrilloSolido extends Plataforma implements Visitable{
	
	public LadrilloSolido(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void morir() {
		//imagen.eliminar();
	}
	
	public void aceptarVisita(Visitor visitor) {
		visitor.visitar(this);
	}

}
