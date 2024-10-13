package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Piranha extends Enemigo{
	public Piranha(int x, int y, Sprite im) {
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
	public void visitar(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDaño() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int puntosQueResta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int puntosQueDa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

}
