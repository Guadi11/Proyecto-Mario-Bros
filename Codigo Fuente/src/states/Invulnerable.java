package states;

import elementos.PowerUp;
import archivos.Sprite;
import juego.Jugador;


public class Invulnerable extends State{
	
	//protected Jugador jugador;
	protected long tiempoActivacion;
	protected final long duracion =6500;
	protected State estadoAnterior;
	protected Sprite sprite;
	
	
	public Invulnerable(Jugador jugador) {
		super(jugador);
	}
	
	public void activar() {
		jugador.setState(this);
		if(estadoAnterior instanceof Normal) {
			jugador.getSprite().setSprite("imagenes/modoUno/invulnerablemini.png");
		}
		else if ((estadoAnterior instanceof SuperMario) || (estadoAnterior instanceof Fuego))
			jugador.getSprite().setSprite("imagenes/modoUno/mariofuego.png");
			jugador.setPosY(jugador.getPosY()-30);
			jugador.actualizarPosicionHitbox();
			jugador.setHitbox(jugador.getHitbox().width, 72);
			//la posicion esta ajustada pero no se por qué cae abajo del piso
	}
	
	public void setAnterior(State anterior) {
		this.estadoAnterior = anterior;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void aumentarEstado (PowerUp estrella) {
		estadoAnterior = jugador.getState();
        jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis(); 
    }
	
	public void actualizar() {
            long ahora = System.currentTimeMillis();
            if (ahora - tiempoActivacion >= duracion) {
                jugador.setState(estadoAnterior);
            }
    }
	
	public void recibirDaño() {
		estadoAnterior.activar();
	}
	
	public int obtenerPuntosEstrella() {
		return estadoAnterior.obtenerPuntosEstrella();
	}
	
	public int obtenerPuntosSChamp() {
		return estadoAnterior.obtenerPuntosSChamp();
	}
	
	public int obtenerPuntosFFuego() {
		return estadoAnterior.obtenerPuntosFFuego();
	}
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
