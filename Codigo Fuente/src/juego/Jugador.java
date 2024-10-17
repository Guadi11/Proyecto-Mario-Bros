package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.ElementoJugador;
import elementos.Enemigo;
import elementos.Movible;
import states.Invulnerable;
import states.State;

public class Jugador extends Movible implements Visitor, Visitable, ElementoJugador{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX;
	
	
	public Jugador(int x, int y, Sprite im) {
		super(x, y, im);
		velX = 0;
		info = new InfoJugador(this);
	}

	
	//Get
	public State getState() {
		return this.estado;
	}
	
	public InfoJugador getInfo() {
		return this.info;
	}

	public void setEstrella(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void setState(State estado) {
		// TODO Auto-generated method stub
		
	}

	public void moverDerecha() {
		velX = 8;
		
	}

	public void moverIzquierda() {
		velX = -8;
		
		
	}

	public void frenarMovimiento() {
		velX = 0;
		
	}
	public void actualizar() {
		posicionX += velX;
		
		if (posicionX < 0) {
	        posicionX = 0; // Limite izquierdo
	    } else if (posicionX > 750) 
	        posicionX = 750; // Limite derecho 
		
		notificar();
    }
	public void moverse() {
		
	}


	public void saltar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getMonedas() {
		// TODO Auto-generated method stub
		return this.info.getMonedas();
	}


	@Override
	public int getPuntaje() {
		// TODO Auto-generated method stub
		return this.info.getPuntaje();
	}


	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return this.info.getVida();
	}


	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return this.velX;
	}
		
}


