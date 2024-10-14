package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Enemigo;
import elementos.Movible;
import states.Invulnerable;
import states.State;

public class Jugador extends Movible implements Visitor, Visitable{
	
	protected State estado;
	protected InfoJugador info;
	protected float velocidad;
	
	
	public Jugador(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}

	
	//Get
	public State getState() {
		return this.estado;
	}
	
	public InfoJugador getInfo() {
		return this.info;
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
		
	}


	public void setEstrella(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void setState(State estado) {
		// TODO Auto-generated method stub
		
	}
		
}


