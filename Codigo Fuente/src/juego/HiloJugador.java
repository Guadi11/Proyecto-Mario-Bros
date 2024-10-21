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
	 		controlador.getNivelActual().getJugador().actualizar();
	 		colisiones.detectarColision(); //luego de moverse chequea las colisiones
	 		try {
				Thread.sleep(16); //se aproxima a 60fps
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	
	 	} 
	 
	 }
	 
	 public void detener() {
		 enEjecucion = false;
	 }
	 
	 
	  
	 
	
	
}
