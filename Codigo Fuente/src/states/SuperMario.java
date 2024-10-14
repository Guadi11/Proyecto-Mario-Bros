package states;

import juego.Jugador;

public class SuperMario extends State{
	private long tiempoActivacion;
	private final long duracion =6500;
	public synchronized void activar(Jugador j) {
	    tiempoActivacion = System.currentTimeMillis();
	            new Thread(() -> {
	                try {
	                    Thread.sleep(duracion);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                desactivar(j);
	            }).start();
}

	public synchronized void desactivar(Jugador j) {
	        j.getState().
	    }
}
