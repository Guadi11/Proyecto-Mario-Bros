package states;

import elementos.PowerUp;
import archivos.Sprite;
import powerUps.FlorDeFuego;
import powerUps.Estrella;
import juego.Jugador;


public class SuperMario extends State{
	
	protected Sprite sprite;
	protected long tiempoActivacion;
	protected final long duracion =6500;
	
	public SuperMario(Jugador jugador) {
		super(jugador);
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite("imagenes/modoUno/supermario.png");
		jugador.setPosY(jugador.getPosY()-30);
		jugador.actualizarPosicionHitbox();
		jugador.setHitbox(jugador.getHitbox().width, 72);
		//la posicion esta ajustada pero no se por qué cae abajo del piso
	}
	
	public Sprite getSprite() {
		//return this.sprite;
		this.sprite = new Sprite("/imagenes/modoUno/supermario.png");
		return sprite;
	}
	
	public void recibirDaño() {
		this.getNormal().activar();
	}
	
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
        	this.getNormal().activar();
        }
	}
	
	@Override
	public void aumentarEstado(PowerUp p) {
		if (p instanceof FlorDeFuego) {
			this.getFuego().activar();
		} else if (p instanceof Estrella){
			this.getInvulnerable().setAnterior(this);
			this.getInvulnerable().activar();
		}
	}
	
	public int obtenerPuntosEstrella() {
		return 30;
	}
	
	public int obtenerPuntosSChamp() {
		return 50;
	}
	
	public int obtenerPuntosFFuego() {
		return 30;
	}
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
