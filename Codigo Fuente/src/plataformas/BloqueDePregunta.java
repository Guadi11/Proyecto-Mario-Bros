package plataformas;

import archivos.Sprite;
import archivos.TipoSonidos;
import colisiones.VisitorPlataformas;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.ControladorPartida;
import juego.Jugador;
import parseo.GameFactory;

public class BloqueDePregunta extends Plataforma implements VisitorPlataformas{

	protected String powerUp;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	protected boolean activado;

	public BloqueDePregunta(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		activado = true;
	}

	public void generarPowerUp() {
		PowerUp creado = null;
		int posicionXCreado = this.posicionX;
		int posicionYCreado = this.posicionY + 36; //Bloque de arriba.
		switch(powerUp) {
		case "Moneda":
			posicionXCreado = this.posicionX + 5; //Se centra arriba del bloque.
			creado = fabrica.crearMoneda(posicionXCreado, posicionYCreado);
			break;

		case "SuperChampiñon":
			creado = fabrica.crearSuperChampiñon(posicionXCreado, posicionYCreado);
			break;

		case "FlorDeFuego":
			creado = fabrica.crearFlorDeFuego(posicionXCreado, posicionYCreado);
			break;

		case "Estrella":
			creado = fabrica.crearEstrella(posicionXCreado, posicionYCreado);
			break;

		case "ChampiñonVerde":
			creado = fabrica.crearChampiñonVerde(posicionXCreado, posicionYCreado);
			break;
		}

		if(creado != null) {
			this.nivel.agregarPowerUp(creado);
			controladorPartida.registrarObserverElementoIndividual(creado);
			creado.setNivel(this.nivel);
		}
	}

	//Get
	public Sprite getSprite() {
		return imagen;
	}

	public int getPosX() {
		return posicionX;
	}

	public int getPosY() {
		return posicionY;
	}

	//Set
	public void setPowerUp(String power) {
		this.powerUp = power;		
	}

	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
	}

	public void setControlador(ControladorPartida partida) {
		this.controladorPartida = partida;
	}

	@Override
	public void visitar(Jugador jugador) {
		if(chocaArriba(jugador)) {
			ubicarArriba(jugador);
		} 
		else if(chocaDerecha(jugador)) {
			jugador.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
		}
		else if(chocaIzquierda(jugador)) {
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		} 
		else if(chocaAbajo(jugador)){
			jugador.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			jugador.setVelY(0);
			if(activado) {
				generarPowerUp();
				activado = false;
				sonido();
			}
		}
	}

	public void sonido() {
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoJuego(TipoSonidos.aparecePowerUp);
	}

	public void visitar(Enemigo enemigo) {
		if(chocaArriba(enemigo)) {
			enemigo.setPosY((int) (this.getPosY() + enemigo.getHitbox().getHeight()));	
		} 
		else if(chocaDerecha(enemigo)) {
			enemigo.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
			enemigo.moverDerecha();
		}
		else if(chocaIzquierda(enemigo)) {
			enemigo.setPosX((int) (this.getPosX() - enemigo.getHitbox().getWidth()));
			enemigo.moverIzquierda();
		} 
		else if(chocaAbajo(enemigo)){
			enemigo.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
		}
	}

	@Override
	public void visitar(PowerUp power) {
		//Vacio
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//Vacio
	}

	@Override
	public void visitar(Elemento elem) {
		//Vacio
	}
}
