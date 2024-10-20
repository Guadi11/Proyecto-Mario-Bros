package elementos;

import archivos.Sprite;
import observers.Observer;

public abstract class Elemento implements ElementoLogico{

	protected int posicionX;
	protected int posicionY;
	protected Sprite imagen;
	protected Observer observer;
	
	public Elemento(int x, int y, Sprite imagen) {
		posicionX=x;
		posicionY=y;
		this.imagen=imagen;
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
	
	public void setPosX(int pos) {
		this.posicionX = pos;
	}
	
	public Observer getObserver() {
		return this.observer;
	}
	
	public void setPosY(int pos) {
		this.posicionY = pos;
	}
	
	public void registrarObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void eliminarObserver() {
	}
	
	public void notificar() {
		this.observer.actualizar();
	}
	
}
