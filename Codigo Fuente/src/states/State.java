package states;

import archivos.ControladorSonidosAcciones;
import archivos.Sprite;
import juego.ControladorPartida;
import juego.Jugador;
import parseo.GameFactory;


public abstract class State {
	
	protected Jugador jugador;
	protected Sprite sprite;
	protected ControladorSonidosAcciones controladorSonidosAccion;
	protected ControladorPartida controlador;
	protected GameFactory fabrica;
	protected String rutaCarpeta;
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
	public abstract void disparar();
	
	public abstract void recibirSuperChampiñon();
	public abstract void recibirFlorDeFuego();
	public abstract void recibirEstrella();
	public abstract void reproducirSonidoSalto();
	public abstract void setFabrica(GameFactory factory);
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
	public void setControlador(ControladorPartida controlador) {
		this.controlador = controlador;
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

	public abstract boolean esGrande();
	public abstract boolean esInvulnerable();

}
