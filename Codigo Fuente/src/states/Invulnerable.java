package states;

import elementos.PowerUp;
import archivos.Sprite;


public class Invulnerable extends State{
	
	protected long tiempoActivacion;
	protected final long duracion =6500;
	State estadoAnterior;
	protected Sprite sprite;
	
	public Invulnerable() {
		estadoAnterior = jugador.getState();
		if(estadoAnterior instanceof Normal) {
			this.sprite = new Sprite("/imagenes/modoUno/invulnerablemini.png");
		}
		else if ((estadoAnterior instanceof SuperMario) || (estadoAnterior instanceof Fuego))
			this.sprite = new Sprite("/imagenes/modoUno/invulnerable.png");
		//jugador.getSprite().cambiar(Invulnerable);
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void aumentarEstado (PowerUp estrella) {
		estadoAnterior=jugador.getState();
        jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis(); 
    }
	
	public void actualizar() {
            long ahora = System.currentTimeMillis();
            if (ahora - tiempoActivacion >= duracion) {
                jugador.setState(estadoAnterior); //no se acá que pasa con el sprite
            }
    }
	
	public void recibirDaño() {
		jugador.setState(estadoAnterior);
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

}
