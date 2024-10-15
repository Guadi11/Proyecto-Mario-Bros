package juego;

public class HiloJugador extends Thread {
	ControladorPartida controlador;
	public HiloJugador() {
		
	}
	
	public HiloJugador(ControladorPartida controlador) {
        this.controlador = controlador;
    }
	
	 public void run(){
	 	while(true){
	 		controlador.getNivelActual().getJugador().actualizar();
	 		try {
				Thread.sleep(16); //se aproxima a 60fps
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	
	 	} 
	 
	 }
	 
	 
	  
	 
	
	
}
