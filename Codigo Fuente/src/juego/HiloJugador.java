package juego;

import colisiones.ControladorColisiones;

public class HiloJugador extends Thread {
	protected ControladorPartida controlador;
	protected ControladorColisiones colisiones;
	protected boolean enEjecucion;
	
	
	public HiloJugador(ControladorPartida controlador, ControladorColisiones colisiones) {
        this.controlador = controlador;
        this.colisiones = colisiones;
        enEjecucion = true;
    }
	
	 public void run(){
	 	while(enEjecucion){
	 		 synchronized (controlador.getNivelActual().getEnemigos()) { // Sincroniza el acceso a la lista de enemigos
	             controlador.getNivelActual().getJugador().actualizar();              
	             colisiones.detectarColision(); 
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
