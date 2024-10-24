package juego;

import elementos.Enemigo;

public class HiloEnemigo extends Thread {
	protected ControladorPartida controlador;
	protected boolean enEjecucion;
	
	public HiloEnemigo(ControladorPartida controlador) {
		this.controlador = controlador;
		enEjecucion = true;
	}

	public void run(){
	 	while(enEjecucion){
	 		synchronized (controlador.getNivelActual().getEnemigos()) {
	            for (Enemigo e : controlador.getNivelActual().getEnemigos()) {
	                e.actualizar();
	            }
	        }
	        try {
	            Thread.sleep(16); // Aproximadamente 60fps
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 	}
	}
	public void detener() {
		 enEjecucion = false;
	 }
}
