package states;

import archivos.Sprite;
import elementos.PowerUp;
import powerUps.SuperChampiñon;
import powerUps.Estrella;
import powerUps.FlorDeFuego;


public class Normal extends State{
	
	protected Sprite sprite;
	
	public Normal() {
		this.sprite = new Sprite("imagenes/modoUno/mario.png");
	}
	
	public Sprite getSprite() {
		return this.sprite;
		
	}
	
	public void aumentarEstado (PowerUp p) {
		if (p instanceof SuperChampiñon) {
			jugador.setState(new SuperMario());
		}
		else if (p instanceof FlorDeFuego) {
			jugador.setState(new Fuego());
			
		} else if (p instanceof Estrella){
			jugador.setState(new Invulnerable());
		}
	}
	
	public void recibirDaño() {
		jugador.getInfo().restarVida();
	}
	
	public int obtenerPuntosEstrella() {
		return 20;
	}
	
	public int obtenerPuntosSChamp() {
		return 10;
	}
	
	public int obtenerPuntosFFuego() {
		return 5;
	}
	
}
