package plataformas;

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
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;


	public Tuberia(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
	}

	public void setControlador(ControladorPartida controlador) {
		this.controladorPartida = controlador;
	}

	public void visitar(Jugador jugador) { 
		if(chocaArriba(jugador)) {
			ubicarArriba(jugador);
		} 
		else if(chocaIzquierda(jugador)) {
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		}
		else if(chocaDerecha(jugador)) {
			jugador.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
		}  	
	}	

	@Override
	public void visitar(Enemigo enemigo) {	
		if(chocaArriba(enemigo)) {
			enemigo.setPosY((int) (this.getPosY() + enemigo.getHitbox().getHeight()));
		} 
		else if(chocaIzquierda(enemigo)) { 
			enemigo.setPosX((int) (this.getPosX() - enemigo.getHitbox().getWidth()));
			enemigo.moverIzquierda();
		}
		else if(chocaDerecha(enemigo)) {
			enemigo.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
			enemigo.moverDerecha();
		} 
	}

	public void visitar(PowerUp power) {
		// Vacio.
	}

	public void visitar(BolaDeFuego bola) {
		// Vacio.
	}

	public void visitar(Elemento elem) {
		// Vacio.
	}
}
