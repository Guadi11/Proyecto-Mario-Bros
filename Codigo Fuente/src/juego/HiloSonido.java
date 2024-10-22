package juego;

import archivos.Sonido;

public class HiloSonido {
protected boolean enEjecucion;
protected Sonido backGround;
	
	
	public HiloSonido() {
        enEjecucion = true;
        backGround = new Sonido ()
    }
	
	 public void run(){
	 	while(enEjecucion){
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
