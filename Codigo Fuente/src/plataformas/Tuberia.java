package plataformas;

import java.awt.Rectangle;

import archivos.Sprite;
import colisiones.VisitorPlataformas;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import enemigos.Piranha;
import juego.ControladorPartida;
import juego.Jugador;
import parseo.GameFactory;

public class Tuberia extends Plataforma implements VisitorPlataformas{
	protected Piranha piranha;
    protected boolean poseePiranha;
    protected GameFactory fabrica;
    protected ControladorPartida controladorPartida;
	
    public Tuberia(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		poseePiranha = false;
	}
    
    public void poseePiranha(boolean posee) {
    	poseePiranha = posee;
    	if(poseePiranha) {
    		crearPiranha();
    	}
    }
    
	public void crearPiranha() {
		piranha = fabrica.crearPiranha(this.posicionX-1, this.posicionY); //editar, seria el bloque de arriba
		this.nivel.agregarEnemigo(piranha);
		controladorPartida.registrarObserverElementoIndividual(piranha);
	}	
	
	//Set
    public void setFabrica(GameFactory factory) {
    	this.fabrica = factory;
    }
    
    public void setControlador(ControladorPartida controlador) {
    	this.controladorPartida = controlador;
    }

	@Override
	public void visitar(Jugador jugador) { 
		/*
		System.out.println("extremosuperior hitbox izquierdo tuberia: " + this.getBoundsLeft().y);
		System.out.println("extremo inferior hitbox izquierdo tuberia: " + (this.getBoundsLeft().y - this.getBoundsLeft().height));
		
		System.out.println("alto hitbox izquierdo tuberia: " + this.getBoundsLeft().height);
		System.out.println("ancho hitbox izquierdo tuberia: " + this.getBoundsLeft().width);
		System.out.println("alto hitbox derecho tuberia: " + this.getBoundsRight().height);
		System.out.println("ancho hitbox tuberia: " + this.getBoundsRight().width);
		System.out.println("alto hitbox top tuberia: " + this.getBoundsTop().height);
		System.out.println("ancho hitbox top tuberia: " + this.getBoundsTop().width);
		System.out.println("alto hitbox bot tuberia: " + this.getBoundsBottom().height);
		System.out.println("ancho hitbox bot tuberia: " + this.getBoundsBottom().width); */
		
		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			//System.out.println("toco al bloque arriba");
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));
			jugador.setVelY(0);
			jugador.setJumped(false);
	
		} 
		else if(jugador.getBoundsRight().intersects(this.getBoundsLeft())) {
			System.out.println("toco a la tuberia por la izquierda");
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		}
		else if(jugador.getBoundsLeft().intersects(this.getBoundsRight())) {
			System.out.println("toco a la tuberia por la derecha");
			jugador.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
		}  	
	}	

	@Override
	public void visitar(Enemigo enemigo) {
		//si choca al costado le cambia la direccion. Si es arriba solo funcion de piso
		//completar esto bien cuando la tuberia funcione		
		if(enemigo.getBoundsBottom().intersects(this.getBoundsTop())) {
			enemigo.setPosY((int) (this.getPosY() + enemigo.getHitbox().getHeight()));
		} 
		else if(enemigo.getBoundsRight().intersects(this.getBoundsLeft())) { 
			enemigo.setPosX((int) (this.getPosX() - enemigo.getHitbox().getWidth()));
			enemigo.moverIzquierda();
		}
		else if(enemigo.getBoundsLeft().intersects(this.getBoundsRight())) {
			enemigo.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
			enemigo.moverDerecha();
		} 
	}

	@Override
	public void visitar(PowerUp power) {
		//si choca al costado le cambia la direccion. Si es arriba solo funcion de piso
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//si choca al costado, bola de fuego muere. Si es arriba, sigue rebotando
		
	}

	@Override
	public void visitar(Elemento elem) {
		//dejarlo vacio
		
	}
}
