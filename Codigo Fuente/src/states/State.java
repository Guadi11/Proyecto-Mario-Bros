package states;

import archivos.ControladorSonidosAcciones;
import archivos.Sprite;
import juego.Jugador;


public abstract class State {
	
	protected Jugador jugador;
	protected Sprite sprite;
	protected ControladorSonidosAcciones controladorSonidosAccion;
	protected Normal normal;
	protected SuperMario superMario;
	protected Fuego fuego;
	protected Invulnerable invulnerable;
	
	
	public State(Jugador jugador) {
	        this.jugador = jugador;	
	        controladorSonidosAccion= new ControladorSonidosAcciones();
	}

	public Sprite getSprite() {
	        return sprite;
	}
	
	public abstract void recibirDaño();
	public abstract int obtenerPuntosEstrella();
	public abstract int obtenerPuntosSChamp();
	public abstract int obtenerPuntosFFuego();
	
	public abstract void activar();
	
	public abstract void recibirSuperChampiñon();
	public abstract void recibirFlorDeFuego();
	public abstract void recibirEstrella();
	public abstract void reproducirSonidoSalto();
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
