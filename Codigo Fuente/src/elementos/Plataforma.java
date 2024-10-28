package elementos;

import archivos.Sprite;
import colisiones.VisitorPlataformas;
import juego.Nivel;

public abstract class Plataforma extends Estatico implements VisitorPlataformas{
	
	protected Nivel nivel;

	public Plataforma (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	public void morir() {
		this.nivel.removerElemento(this);
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
