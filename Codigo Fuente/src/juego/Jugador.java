package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Elemento;
import elementos.ElementoJugador;
import elementos.Enemigo;
import elementos.Movible;
import elementos.Plataforma;
import enemigos.Buzzy;
import enemigos.Goomba;
import enemigos.Koopa;
import enemigos.Lakitu;
import enemigos.Piranha;
import states.State;
import states.Normal;

public class Jugador extends Movible implements Visitor, Visitable, ElementoJugador{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX, velY;
	protected boolean isJumped;
	protected Nivel nivel;
	
	public Jugador(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
		isJumped = false;
		info = new InfoJugador(this);
		estado = new Normal(this);
		
	}
	public void setState(State estado) {
		this.estado = estado;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
		this.info.setNivel(nivel);
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
		int limite_derecho = 7471;
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
		actualizarPosicionHitbox();
		notificar();
    }
	
	public void moverse() {
		
	}

	public void saltar() {
		if (!isJumped) { 
	        velY = -19; 
	        isJumped = true;
	    }	
	}
	public void aceptarVisita(Visitor visitor) {
		System.out.println("Entro al aceptarJ");
		visitor.visitar(this);
	}
	public void visitar(Enemigo enemigo) {
		System.out.println("aver");
		/*int puntosGanados=enemigo.recibirDaño();
		info.actualizarPuntaje(puntosGanados);*/
	}
	public void visitar(Goomba g) {
		System.out.println("Entro al visitor.");
		if (esColisionDesdeArriba(g)) {
			g.recibirDaño();
			System.out.println("Goomba recibio daño desde arriba.");
		}
			else {
				//this.recibirDaño();
				System.out.println("Jugador recibe daño.");
			}
	}
	
	public void visitar(Buzzy b) {
		
	}
	public void visitar(Lakitu l) {
		
	}
	public void visitar(Koopa k) {
		
	}
	public void visitar(Piranha p) {
	
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
	public boolean esColisionDesdeArriba(Elemento elementoAVisitar) {
		//return getHitbox().getMaxY() <= elementoAVisitar.getHitbox().getMinY();
		return getHitbox().getMaxY() <= elementoAVisitar.getHitbox().getMinY() && 
				getHitbox().getMaxY() >= elementoAVisitar.getHitbox().getMinY() - getHitbox().getHeight();
	}
		
}

