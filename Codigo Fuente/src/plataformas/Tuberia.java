package plataformas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
		//jugador choca contra tuberia (redefinir pos)
		/*
		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			System.out.println("toco al bloque arriba");
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));
			jugador.setVelY(0);
			jugador.setJumped(false);
	
		} 
		else if(jugador.getBoundsRight().intersects(this.getBoundsLeft())) { //this.getBoundsLeft()
			System.out.println("toco a la tuberia por la izquierda");
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		}
		else if(jugador.getBoundsLeft().intersects(this.getBoundsRight())) {
			System.out.println("toco a la tuberia por la derecha");
			jugador.setPosX((int) (this.getPosX() + jugador.getHitbox().getWidth()));
		}  
		else if(jugador.getBoundsTop().intersects(this.getBoundsBottom())){
			System.out.println("toco a la tuberia por abajo");
			jugador.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			jugador.setVelY(0);
		}
		*/
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(
				 (int) (this.getHitbox().getX()) +6,  // (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4)
			     (int) (this.getHitbox().getY() - this.getHitbox().getHeight()/2), //chequear +5
			     (int) this.getHitbox().getWidth() -12,  // /2 o rstarle un numero fijo tipo 5, 10
			     (int) this.getHitbox().getHeight()/2); 
	}
	
	public Rectangle getBoundsTop() {
		
		 return new Rectangle(
				// (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4), x
				 // (int) this.getHitbox().getWidth()/2,  ancho
				    (int) (this.getHitbox().getX() + this.getHitbox().getWidth()/2 - this.getHitbox().getWidth()/4), //+5
			        (int) this.getHitbox().getY()+1,  //(this.getHitbox().getY() + this.getHitbox().getHeight()/2)
			        (int)  this.getHitbox().getWidth()/2, 
			        (int) this.getHitbox().getHeight()/2);
	}
	
	public Rectangle getBoundsRight() {
		Rectangle toReturn = new Rectangle(
		        (int) (this.getPosX() + this.getHitbox().getWidth() - 5),
		        (int) this.getPosY() - 5, 
		        5, 
		        (int) this.getHitbox().getHeight() - 10);		
		
		return toReturn;
	} 
	
	public Rectangle getBoundsLeft() {
		 return new Rectangle(
			        (int) this.getPosX(),
			        (int) this.getPosY() - 5,  
			        5, 
			        (int) this.getHitbox().getHeight() - 10);
	} 
	

	@Override
	public void visitar(Enemigo enemigo) {
		//si choca al costado le cambia la direccion. Si es arriba solo funcion de piso
		
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
