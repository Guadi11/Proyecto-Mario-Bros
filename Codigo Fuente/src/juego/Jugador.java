package juego;

import archivos.Sprite;
import archivos.TipoSonidos;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.ElementoJugador;
import elementos.Plataforma;
import observers.AdaptadorPosicionPixel;
import states.*;



public class Jugador extends Elemento implements Visitable, ElementoJugador{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX, velY;
	protected boolean isJumped;
	protected Nivel nivel;
	protected boolean arribaDeBloque;
	protected Plataforma ultimoBloque;
	protected String nombre;
	
	
	public Jugador(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
		velY = 0;
		isJumped = false;
		info = new InfoJugador(this);
		arribaDeBloque = false;
		ultimoBloque = null;

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
	    //estado.activar();
	}
	
	public void setState(State estado) {
		this.estado = estado;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
		this.info.setNivel(nivel);
	}
	public void setVelX(int direc) {
		this.velX = direc;
	}

	public void setVelY(int direc) {
		this.velY = direc;
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
		int alturaPiso = 72;
		int alturaMario = (int) (alturaPiso + this.getHitbox().getHeight());
		
		int limiteDerecho =  AdaptadorPosicionPixel.transformarX(7471);
		int limiteY_ventana = 0;
		//System.out.println("esta arriba de bloque?: "+arribaDeBloque);
		posicionX += velX;
		posicionY += velY;
		estaEnLaHitboxDelBloque();
		//System.out.println("Altura hitbox: "+this.getHitbox().getMaxY());
		
		if (!arribaDeBloque) { //ojo que este arriba del bloque solo lo estas activando cuando se sube a ladrillo solido, falta el resto
			if ( posicionY > alturaMario || posicionY < alturaMario ) {
			    velY -= 1;
			}
				else {
					velY = 0; 
				    isJumped = false;
						}
		}
		
		if (posicionX < 0) {
	        posicionX = 0; 
	    }else if (posicionX > limiteDerecho) {
	    	posicionX = limiteDerecho;	
	    }
		if (posicionY<limiteY_ventana)
			this.getInfo().restarVida();
		
		actualizarPosicionHitbox();
		notificar();
    }

	public void saltar() {
		if (!isJumped) { 
	        velY = 19; 
	        isJumped = true;
	        estado.reproducirSonidoSalto();
	    }	
	}
	
	public void saltarAlMatar() {
		if (!isJumped) { 
	        velY = 10; 
	        isJumped = true;
	        this.nivel.controladorPartida.controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteEnemigo);
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

	public int getVelocidadX() {
		return this.velX;
	}
	
	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		//Entra en este metodo cuando el visitor sea enemigo, powerUp o vacio.
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// Entra en este metodo cuando el visitor sea una plataforma (no vacio).
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// Entra a este metodo cuando el visitor sea una bola de fuego, lo cual nunca sucede.
	}
	
	public boolean estaArribaDeBloque() {
		return arribaDeBloque;
	}
	
	public void ultimoBloqueColision(Plataforma l) {
		ultimoBloque = l;
	}
	
	public void estaEnLaHitboxDelBloque(){
		if(ultimoBloque!=null)
			if (this.getHitbox().intersects(ultimoBloque.getHitbox())) {
				arribaDeBloque = true;
			}else arribaDeBloque = false;
	}

	public String getName() {
		return nombre;
	}
	
	public void setName(String nombre) {
		this.nombre=nombre;
	}
	
}

