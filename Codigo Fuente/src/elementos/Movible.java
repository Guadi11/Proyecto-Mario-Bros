package elementos;

import archivos.Sprite;

public abstract class Movible extends Elemento{
	public Movible (int x, int y, Sprite im) {
		super (x,y,im);
	}
	
	public abstract void moverse();
}
