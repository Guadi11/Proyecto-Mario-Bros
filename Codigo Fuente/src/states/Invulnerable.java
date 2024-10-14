package states;

import elementos.PowerUp;
import juego.Jugador;

public class Invulnerable extends State{
	private long tiempoActivacion;
	private final long duracion =6500;
	private boolean estaInvulnerable;
	State estadoAnterior;
	public void aumentarEstado (PowerUp p) {
		estadoAnterior=jugador.getState();
        jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis(); 
    }
	public void actualizar() {
        if (estaInvulnerable) {
            long ahora = System.currentTimeMillis();
            // Verifica si el tiempo transcurrido ha superado la duración
            if (ahora - tiempoActivacion >= duracion) {
                aumentarEstado()
            }
        }
    }
	public synchronized void activar(Jugador j) {
	            new Thread(() -> {
	                try {
	                    Thread.sleep(duracion);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                desactivar();
	            }).start();
}

	public synchronized void desactivar() {
	       
	    }
}
