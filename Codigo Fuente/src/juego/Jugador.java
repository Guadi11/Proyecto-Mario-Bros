package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import archivos.Sonido;
import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.ElementoJugador;
import elementos.Movible;
import observers.AdaptadorPosicionPixel;
import states.State;
import states.SuperMario;
import states.Fuego;
import states.Invulnerable;
import states.Normal;


public class Jugador extends Movible implements Visitable, ElementoJugador{
	
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
		
		//genera problema no inicializar aca adentro el estado?
		inicializarEstados();
	}
	
	private void inicializarEstados() {
		Normal normal = new Normal(this);
		SuperMario superMario = new SuperMario(this);
	    Fuego fuego = new Fuego(this);
	    Invulnerable invulnerable = new Invulnerable(this);
	    
	    normal.setFuego(fuego);
	    normal.setSuperMario(superMario);
	    normal.setInvulnerable(invulnerable);
	    
	    fuego.setNormal(normal);
	    fuego.setSuperMario(superMario);
	    fuego.setInvulnerable(invulnerable);
	    
	    superMario.setNormal(normal);
	    superMario.setFuego(fuego);
	    superMario.setInvulnerable(invulnerable);
	    
	    invulnerable.setNormal(normal);
	    invulnerable.setSuperMario(superMario);
	    invulnerable.setFuego(fuego);
	    
	    estado = normal;
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
		int altura_piso = AdaptadorPosicionPixel.transformarY(441); 
		int limite_derecho =  AdaptadorPosicionPixel.transformarX(7471);
		
		//int altura_piso = 441;
		//int limite_derecho = 7471;
		
		/*if(estado instanceof SuperMario)
			altura_piso = 405;*/
		
		posicionX += velX;
		posicionY += velY;
		
		if (posicionY > altura_piso) {
		        velY -= 1; 
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
	        velY = 19; 
	        isJumped = true;
	        sonidoSalto().reproducirSonido();
	    }	
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
		//boolean colision = AdaptadorPosicionPixel.transformarY((int) this.hitbox.getMinY()) >= AdaptadorPosicionPixel.transformarY((int) (elementoAVisitar.getHitbox().getHeight()/2));
		boolean colision = (this.posicionY - this.hitbox.getHeight()) >= (elementoAVisitar.getPosY());
		//return getHitbox().getMaxY() <= elementoAVisitar.getHitbox().getMinY();
		/*return getHitbox().getMaxY() <= elementoAVisitar.getHitbox().getMinY() && 
				getHitbox().getMaxY() >= elementoAVisitar.getHitbox().getMinY() - getHitbox().getHeight();*/
		return colision;
	}

	public Sonido sonidoSalto() {
		Sonido sonidoSalto = new Sonido("audio/jump.wav");
		return sonidoSalto;
	}
	
	public Sonido sonidoMuerte() {
		Sonido sonidoMuerte = new Sonido("audio/marioDies.wav");
		return sonidoMuerte;
	}

	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		//entra en este metodo cuando el visitor sea enemigo, powerUp o vacio
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// entra en este metodo cuando el visitor sea una plataforma (no vacio)
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// entra a este metodo cuando el visitor sea una bola de fuego, lo cual nunca sucede
	}
		
}

