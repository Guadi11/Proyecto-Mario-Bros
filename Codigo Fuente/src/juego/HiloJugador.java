package juego;

import colisiones.ControladorColisiones;

public class HiloJugador extends Thread {
	ControladorPartida controlador;
	ControladorColisiones colisiones;
	public HiloJugador() {
		
	}
	
	public HiloJugador(ControladorPartida controlador, ControladorColisiones c) {
        this.controlador = controlador;
        colisiones = c;
    }
	
	 public void run(){
	 	while(true){
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
	 
	 
	  
	 
	
	
}
