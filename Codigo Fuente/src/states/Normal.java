package states;

import archivos.Sprite;
import elementos.PowerUp;
import powerUps.SuperChampiñon;
import powerUps.Estrella;
import powerUps.FlorDeFuego;
import juego.Jugador;


public class Normal extends State{

	//protected Jugador jugador;
	protected Sprite sprite; 
	
	public Normal(Jugador jugador) {
		super(jugador);
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite("imagenes/modoUno/mario.png");
	}
	
	public Sprite getSprite() {
		return this.sprite;
		
	}
	
	public void aumentarEstado (PowerUp p) {
		if ((p instanceof SuperChampiñon)  || (p instanceof FlorDeFuego)) {
			jugador.getState().getSuperMario().activar();
		}
		else if (p instanceof Estrella){
			jugador.getState().getInvulnerable().setAnterior(this);
			jugador.getState().getInvulnerable().activar();
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
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
	
}
