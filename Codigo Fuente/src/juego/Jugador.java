package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Movible;

public class Jugador extends Movible implements Visitor, Visitable{

	public Jugador(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}

	public void saltar() {
		// TODO Auto-generated method stub
		
	}

	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}

}
