package states;

import elementos.PowerUp;

public class Invulnerable extends State{
	private long tiempoActivacion;
	private final long duracion =6500;
	State estadoAnterior;
	public Invulnerable() {
		//jugador.getSprite().cambiar(Invulnerable);
	}
	public void aumentarEstado (PowerUp estrella) {
		estadoAnterior=jugador.getState();
        jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis(); 
        //jugador.getSprite().cambiar("Invencible.png")
    }
	public void actualizar() {
            long ahora = System.currentTimeMillis();
            if (ahora - tiempoActivacion >= duracion) {
                jugador.setState(estadoAnterior);
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
