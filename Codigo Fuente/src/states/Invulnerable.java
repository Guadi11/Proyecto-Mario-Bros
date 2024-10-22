package states;

import elementos.PowerUp;
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
		State anterior = jugador.getState();
		jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis();
        if (anterior.esGrande()==true) {
            this.sprite = new Sprite("imagenes/modoUno/invulnerable.png");
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerable.png");
        } else {
            this.sprite = new Sprite("imagenes/modoUno/invulnerablemini.png");
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerablemini.png");
        }

    }
		
		//"imagenes/modoUno/invulnerablemini.png");
		//
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
	public void aumentarASuperMario() {
		
	}
	@Override
	public void aumentarAFuego() {
	
	}
	
	public void aumentarAInvulnerable() {
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
	
	public boolean esGrande() {
		return true;
	}

}
