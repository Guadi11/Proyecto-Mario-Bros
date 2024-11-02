package juego;

import java.util.ArrayList;
import java.util.List;

import colisiones.ControladorColisiones;
import elementos.BolaDeFuego;
import elementos.Enemigo;

public class HiloEnemigo extends Thread {
	protected ControladorPartida controlador;
	protected ControladorColisiones colisiones;
	protected boolean enEjecucion;
	protected List<Enemigo> enemigosPendientes;
	protected List<BolaDeFuego> bolasFuegoPendientes;
	
	public HiloEnemigo(ControladorPartida controlador, ControladorColisiones colisiones) {
		this.controlador = controlador;
		this.colisiones = colisiones;
		enEjecucion = true;
		enemigosPendientes = new ArrayList<>(); 
		bolasFuegoPendientes = new ArrayList<>(); 
	}

	public void run(){
	 	while(enEjecucion){
	 		synchronized (controlador.getNivelActual().getEnemigos()) { //  && controlador.getNivelActual().getBolasDeFuego()
	            for (Enemigo e : controlador.getNivelActual().getEnemigos()) {
	                e.actualizar();
	                colisiones.detectarColisionEnemigos(e);
	            }
	            
	            if (!enemigosPendientes.isEmpty()) {
	                controlador.getNivelActual().getEnemigos().addAll(enemigosPendientes);
	                enemigosPendientes.clear();
	            }
	            for (BolaDeFuego b : controlador.getNivelActual().getBolasDeFuego()) {
	            	b.actualizar();
	            	//falta chequear que bola de fuego colisione con plataformas
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
	
	public synchronized void registrarBolaDeFuego(BolaDeFuego bolaFuego) {
		bolasFuegoPendientes.add(bolaFuego);
	}

}
