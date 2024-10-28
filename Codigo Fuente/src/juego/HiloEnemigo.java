package juego;

import colisiones.ControladorColisiones;
import elementos.Enemigo;

public class HiloEnemigo extends Thread {
	protected ControladorPartida controlador;
	protected ControladorColisiones colisiones;
	protected boolean enEjecucion;
	
	public HiloEnemigo(ControladorPartida controlador, ControladorColisiones colisiones) {
		this.controlador = controlador;
		this.colisiones = colisiones;
		enEjecucion = true;
	}

	public void run(){
	 	while(enEjecucion){
	 		synchronized (controlador.getNivelActual().getEnemigos()) {
	            for (Enemigo e : controlador.getNivelActual().getEnemigos()) {
	                e.actualizar();
	                colisiones.detectarColisionEnemigos(e);
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
