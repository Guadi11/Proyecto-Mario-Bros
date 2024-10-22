package states;

import archivos.Sprite;
import elementos.PowerUp;
import powerUps.SuperChampiñon;
import powerUps.Estrella;
import powerUps.FlorDeFuego;
import juego.Jugador;


public class Normal extends State {
	
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
	
	/*public void aumentarEstado (PowerUp p) {
		int posicionY = jugador.getPosY();
		if ((p instanceof SuperChampiñon)  || (p instanceof FlorDeFuego)) {
			jugador.getState().getSuperMario().activar();
			jugador.setPosY(posicionY-36);
		}
		else 
			if (p instanceof Estrella){
				System.out.println("WTF.");
				jugador.getState().getInvulnerable().setAnterior(this);
				jugador.getState().getInvulnerable().activar();
				jugador.setPosY(posicionY-36);
		}
	}*/
	
	public void aumentarASuperMario() {
		this.getSuperMario().activar();			
	}
	
	public void aumentarAFuego() {
		this.getFuego().activar();
	}
	
	public void aumentarAInvulnerable() {
		this.getInvulnerable().activar();
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
	
	public boolean esGrande() {
		return false;
	}

}
