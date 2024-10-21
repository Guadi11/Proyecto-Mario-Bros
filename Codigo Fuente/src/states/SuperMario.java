package states;

import elementos.PowerUp;
import archivos.Sprite;
import powerUps.FlorDeFuego;
import powerUps.Estrella;
import juego.Jugador;


public class SuperMario extends State{
	
	//protected Jugador jugador;
	protected State volverANormal= new Normal(jugador);
	protected Sprite sprite;
	protected long tiempoActivacion;
	protected final long duracion =6500;
	
	public SuperMario(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("/imagenes/modoUno/supermario.png");
	}
	
	public Sprite getSprite() {
		//return this.sprite;
		this.sprite = new Sprite("/imagenes/modoUno/supermario.png");
		return sprite;
	}
	
	public void recibirDaño() {
		jugador.setState(volverANormal);
	}
	
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
            jugador.setState(volverANormal);
        }
	}
	
	@Override
	public void aumentarEstado(PowerUp p) {
		if (p instanceof FlorDeFuego) {
			jugador.setState(new Fuego(jugador));
			
		} else if (p instanceof Estrella){
			jugador.setState(new Invulnerable(jugador));
		
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
