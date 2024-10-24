package states;

import archivos.Sprite;
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
		//jugador.actualizarPosicionHitbox(); //actualizar pos jugador, alto y ancho de hitbox en un metodo aparte
		
		//gador.setPosY(jugador.getPosY()-30);
	//ugador.actualizarPosicionHitbox();
//jugador.setHitbox(jugador.getHitbox().width, 72);
		//la posicion esta ajustada pero no se por qué cae abajo del piso
	}
	
	public Sprite getSprite() {
		//return this.sprite;
		this.sprite = new Sprite("imagenes/modoUno/supermario.png");

		return sprite;
	}
	
	public void recibirDaño() {
		this.getNormal().activar();
		//en algun lugar se esta llamando erroneamente a jugador.getInfo().recibirDaño() y reinicia cuando no deberia
	}
	
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
        	this.getNormal().activar();
        }
	}
	
	@Override
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}
	
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
		this.getFuego().activar();
	}
	
	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
		this.getInvulnerable().setAnterior(this);
		this.getInvulnerable().activar();
		
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
	
	public boolean esGrande() {
		return true;
	}

}
