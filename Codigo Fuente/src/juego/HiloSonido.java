package juego;

import archivos.Sonido;

public class HiloSonido extends Thread {
protected boolean enEjecucion;
protected Sonido backGround;
	
	
	public HiloSonido() {
        enEjecucion = true;
        backGround = new Sonido ("audio/background.wav");
    }
	
	 public void run(){
	 	while(enEjecucion){
	 		backGround.reproducirAudioFondo();
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
		 backGround.detener();
	 }
	 
}
