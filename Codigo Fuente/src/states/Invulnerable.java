package states;

import archivos.Sprite;
import juego.Jugador;


public class Invulnerable extends State{
	
	protected long tiempoActivacion;
	protected final long duracion =6500;
	protected State estadoAnterior;
	protected Sprite sprite;
	
	
	public Invulnerable(Jugador jugador) {
		super(jugador);
	}
	
	public void activar() {
		jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis();
        if (estadoAnterior.esGrande()) {
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerable.png");
            //jugador.actualizarPosicionHitbox(); //actualizar pos jugador, alto y ancho de hitbox en un metodo aparte
        } else {
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerablemini.png");
        }

    }
			/*jugador.getSprite().setSprite("imagenes/modoUno/mariofuego.png");
			//jugador.setPosY(jugador.getPosY()-30);
			//jugador.actualizarPosicionHitbox();
			//jugador.setHitbox(jugador.getHitbox().width, 72);
			//la posicion esta ajustada pero no se por qué cae abajo del piso*/
	
	public void setAnterior(State anterior) {
		this.estadoAnterior = anterior;
	}
	
	public Sprite getSprite() {
		return this.getSprite();
	}
	
	@Override
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}
	@Override
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
	}
	
	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
	}
	
	public void actualizar() {
            long ahora = System.currentTimeMillis();
            if (ahora - tiempoActivacion >= duracion) {
                jugador.setState(estadoAnterior);
            }
    }
	
	public void recibirDaño() {
		estadoAnterior.activar();
		//en algun lugar se esta llamando erroneamente a jugador.getInfo().recibirDaño() y reinicia cuando no deberia
	}
	
	public int obtenerPuntosEstrella() {
		return 35;
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

	@Override
	protected boolean esGrande() {
		return false;
	}

}
