package plataformas;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.ControladorPartida;
import parseo.GameFactory;

public class BloqueDePregunta extends Plataforma implements Visitable{

	protected String powerUp;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	
	public BloqueDePregunta(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	public void generarPowerUp() {
		PowerUp creado = null;
		int posicionYCreado = this.posicionY-30; //ir probando ubicacion, seria el bloque de arriba
		switch(powerUp) {
			case "Moneda":
				creado = fabrica.crearMoneda(posicionX, posicionYCreado);
				break;
			
			case "SuperChampiñon":
				creado = fabrica.crearSuperChampiñon(posicionX, posicionYCreado);
				break;
			
			case "FlorDeFuego":
				creado = fabrica.crearFlorDeFuego(posicionX, posicionYCreado);
				break;
			
			case "Estrella":
				creado = fabrica.crearEstrella(posicionX, posicionYCreado);
				break;
			
			case "ChampiñonVerde":
				creado = fabrica.crearChampiñonVerde(posicionX, posicionYCreado);
				break;
		}
		
		if(creado != null) {
			this.nivel.agregarPowerUp(creado);
			controladorPartida.registrarObserverElementoIndividual(creado);
		}
	}
	
	public void aceptarVisita (Visitor visitor) {
		//visitor.visitar(this);
	}
	public void morir() {
		//imagen.changeSprite("Bloque apagado")
		this.generarPowerUp();
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
}
