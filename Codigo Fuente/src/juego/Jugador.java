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
	protected int velX, velY;
	protected boolean isJumped;
	
	public Jugador(int x, int y, Sprite im) {
		super(x, y, im);
		velX = 0;
		velY = 0;
		isJumped = false;
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
		velX = 5;
		
	}

	public void moverIzquierda() {
		velX = -5;
		
		
	}

	public void frenarMovimiento() {
		velX = 0;
		
	}
	public void actualizar() {
		int altura_piso = 441;
		int limite_derecho = 7481;
		posicionX += velX;
		posicionY += velY;
		
		if (posicionY < altura_piso) {
		        velY += 1; 
		    } else {
		        posicionY = altura_piso;
		        velY = 0; 
		        isJumped = false;
		    }
		
		if (posicionX < 0) {
	        posicionX = 0; 
	    } else 
	    	if (posicionX > limite_derecho) 
	    		posicionX = limite_derecho;	
		notificar();
    }
	public void moverse() {
		
	}

	public void saltar() {
		if (!isJumped) { 
	        velY = -15; 
	        isJumped = true;
	    }	
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


