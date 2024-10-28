package plataformas;

import archivos.Sprite;
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
	
	public BloqueDePregunta(int x, int y, Sprite imagen) {
		super(x, y, imagen);
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

	@Override
	public void visitar(Jugador jugador) {
		//chequeo si la colision es de abajo o no. 
		//En ambos casos el jugador choca contra el bloque, pero desde abajo genera powerUp y cambia imagen
		
		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));
			jugador.setVelY(0);
			jugador.setJumped(false);
	
		} 
		else if(jugador.getBoundsLeft().intersects(this.getBoundsRight())) {
			jugador.setPosX((int) (this.getPosX() + jugador.getHitbox().getWidth()));
		}
		else if(jugador.getBoundsRight().intersects(this.getBoundsLeft())) {
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		} 
		else if(jugador.getBoundsTop().intersects(this.getBoundsBottom())){
			System.out.println("golpeo desde abajo");
			jugador.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			jugador.setVelY(0);
			generarPowerUp();
		}
		
	}

	@Override
	public void visitar(Enemigo enemigo) {
		//enemigo choca contra bloque
		
	}

	@Override
	public void visitar(PowerUp power) {
		//powerUp choca contra bloque. Algunos caminan normal, otros rebotan (caso aparte?): estrella
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//la bola de fuego choca contra el bloque, va rebotando (no se si es algo que importe aca o es algo interno a bola de fuego)
		
	}

	@Override
	public void visitar(Elemento elem) {
		//dejarlo vacio
		
	}


}
