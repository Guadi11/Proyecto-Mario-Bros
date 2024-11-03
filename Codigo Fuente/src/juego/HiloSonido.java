package juego;

import archivos.Sonido;

public class HiloSonido extends Thread {
protected boolean enEjecucion;
protected Sonido backGround;
	
	
public HiloSonido() {
    enEjecucion = true;
    backGround = new Sonido ("audio/background.wav");
    backGround.configurarLoop();
}

 public void run(){
	 while (enEjecucion) {
            if (!backGround.enReproduccion()) {
                backGround.reanudar(); // Reanuda si no está en reproducción
            }
            try {
                Thread.sleep(16); // Aproximadamente 60 fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
 }
 public void pararLoop() {
		backGround.stopLoop();
		enEjecucion=false;
}
 public void detenerLoop() {
	 backGround.detener();
	 enEjecucion=false;
 }
 public void reanudar() {
	 if (!enEjecucion) {
            enEjecucion = true;
            backGround.reanudar(); // Reanuda el audio desde donde se detuvo
        }
    }
 public void detener() {
	 backGround.detener();
	 enEjecucion=false;
 }
 public boolean enEjecucion() {
	 return enEjecucion;
 }
}
