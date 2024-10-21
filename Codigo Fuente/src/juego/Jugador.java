package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.ElementoJugador;
import elementos.Enemigo;
import elementos.Movible;
import elementos.Plataforma;
import states.State;
import states.Normal;

public class Jugador extends Movible implements Visitor, Visitable, ElementoJugador{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX, velY;
	protected boolean isJumped;
	
	public Jugador(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
		isJumped = false;
		info = new InfoJugador(this);
		//estado=new Normal(this);
		
	}
	public void setState(State estado) {
		this.estado = estado;
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
		}else {
		        posicionY = altura_piso;
		        velY = 0; 
		        isJumped = false;
		}
		
		if (posicionX < 0) {
	        posicionX = 0; 
	    }else if (posicionX > limite_derecho) {
	    	posicionX = limite_derecho;	
	    }	
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
	public void aceptarVisita(Visitor visitor) {
		visitor.visitar(this);
	}
	public void visitar(Enemigo enemigo) {
		int puntosGanados=enemigo.recibirDaño();
		info.actualizarPuntaje(puntosGanados);
	}
	public void visitar (Plataforma plataforma) {
		plataforma.morir();
	}
		
	//Get
	public State getState() {
		return this.estado;
	}
		
	public InfoJugador getInfo() {
		return this.info;
	}

	public int getMonedas() {
		return this.info.getMonedas();
	}

	public int getPuntaje() {
		return this.info.getPuntaje();
	}

	public int getVida() {
		return this.info.getVida();
	}

	public int getVelocidad() {
		return this.velX;
	}
		
}

