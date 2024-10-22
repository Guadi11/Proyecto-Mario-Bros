package states;

import elementos.PowerUp;

import archivos.Sprite;
import juego.Jugador;


public abstract class State {
	
	protected Jugador jugador;
	protected Sprite sprite;

	protected Normal normal;
	protected SuperMario superMario;
	protected Fuego fuego;
	protected Invulnerable invulnerable;
	
	
	public State(Jugador jugador) {
	        this.jugador = jugador;	 	
	}

	public Sprite getSprite() {
	        return sprite;
	}
	
	//public abstract void aumentarEstado(PowerUp p);
	public abstract void recibirDaño();
	public abstract int obtenerPuntosEstrella();
	public abstract int obtenerPuntosSChamp();
	public abstract int obtenerPuntosFFuego();
	public abstract void activar();
	public abstract void aumentarASuperMario();
	public abstract void aumentarAFuego();
	public abstract void aumentarAInvulnerable();
	
	
	
	public void setNormal(Normal normal) {
		this.normal = normal;
	}
	
	public void setFuego(Fuego fuego) {
		this.fuego = fuego;
	}
	
	public void setSuperMario(SuperMario superMario) {
		this.superMario = superMario;
	}
	
	public void setInvulnerable(Invulnerable invulnerable) {
		this.invulnerable = invulnerable;
	}
	
	public Fuego getFuego() {
		return fuego;
	}
	
	public Normal  getNormal() {
		return normal;
	}
	
	public SuperMario getSuperMario() {
		return superMario;
	}
	
	public Invulnerable getInvulnerable() {
		return invulnerable;
	}

	protected abstract boolean esGrande();

}
