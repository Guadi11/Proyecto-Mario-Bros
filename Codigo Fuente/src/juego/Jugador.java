package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.ElementoJugador;
import elementos.Movible;
import observers.AdaptadorPosicionPixel;
import states.*;



public class Jugador extends Movible implements Visitable, ElementoJugador{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX, velY;
	protected boolean isJumped;
	protected Nivel nivel;
	protected boolean colisionConBloque;
	
	
	public Jugador(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
		isJumped = false;
		info = new InfoJugador(this);

		colisionConBloque = false;

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
	public void setVelX(int v) {
		this.velX = v;
	}

	public void setVelY(int v) {
		this.velY = v;
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
		int alturaPiso = AdaptadorPosicionPixel.transformarY(441); 
		int limiteDerecho =  AdaptadorPosicionPixel.transformarX(7471);
		
		
		posicionX += velX;
		posicionY += velY;
		
		if (posicionY > alturaPiso) {
		        velY -= 1; 
		}else {
		        posicionY = alturaPiso;
		        velY = 0; 
		        isJumped = false;
		}
		
		if (posicionX < 0) {
	        posicionX = 0; 
	    }else if (posicionX > limiteDerecho) {
	    	posicionX = limiteDerecho;	
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
	        estado.reproducirSonidoSalto();
	    }	
	}
	
	public void setJumped(boolean valor) {
		this.isJumped = valor;
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

