package juego;

import java.util.ArrayList;
import java.util.List;

import colisiones.ControladorColisiones;
import elementos.Enemigo;

public class HiloEnemigo extends Thread {
	protected ControladorPartida controlador;
	protected ControladorColisiones colisiones;
	protected boolean enEjecucion;
	protected List<Enemigo> enemigosPendientes;
	
	public HiloEnemigo(ControladorPartida controlador, ControladorColisiones colisiones) {
		this.controlador = controlador;
		this.colisiones = colisiones;
		enEjecucion = true;
		enemigosPendientes = new ArrayList<>(); 
	}

	public void run(){
	 	while(enEjecucion){
	 		synchronized (controlador.getNivelActual().getEnemigos()) {
	            for (Enemigo e : controlador.getNivelActual().getEnemigos()) {
	                e.actualizar();
	                colisiones.detectarColisionEnemigos(e);
	            }
	            
	            if (!enemigosPendientes.isEmpty()) {
	                controlador.getNivelActual().getEnemigos().addAll(enemigosPendientes);
	                enemigosPendientes.clear();
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
	
	public synchronized void registrarEnemigo(Enemigo enemigo) {
	    enemigosPendientes.add(enemigo);
	}

}
