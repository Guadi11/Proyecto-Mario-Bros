package elementos;

import archivos.Sprite;
import juego.Nivel;

public abstract class Plataforma extends Estatico {
	protected Nivel nivel;

	public Plataforma (int x, int y, Sprite im) {
		super (x,y,im);
	}
	public void setNivel(Nivel n) {}
	public void morir() {};
}
