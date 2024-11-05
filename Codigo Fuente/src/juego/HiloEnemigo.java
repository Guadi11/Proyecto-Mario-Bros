package juego;

import java.util.ArrayList;
import java.util.Iterator;
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
			synchronized (controlador.getNivelActual().getEnemigos()) { 
				Iterator<Enemigo> iteratorE = controlador.getNivelActual().getEnemigos().iterator();	 
				while (iteratorE.hasNext()) {
					Enemigo e = iteratorE.next();
					e.actualizar();
					colisiones.detectarColisionEnemigos(e);	
					if(e.estaMuerto()) {
						iteratorE.remove();
					}
				}

				Iterator<BolaDeFuego> iteratorBF = controlador.getNivelActual().getBolasDeFuego().iterator();
				while(iteratorBF.hasNext()) {
					BolaDeFuego b = iteratorBF.next();
					b.actualizar();
					colisiones.detectarColisionBolasDeFuego(b);
					if(b.estaMuerto()) {
						iteratorBF.remove();
					}
				}
				agregarPendientes();
			}
			try {
				Thread.sleep(16); // Aproximadamente 60fps
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void agregarPendientes() {
		if (!enemigosPendientes.isEmpty()) {
			controlador.getNivelActual().getEnemigos().addAll(enemigosPendientes);
			enemigosPendientes.clear();
		}
		if (!bolasFuegoPendientes.isEmpty()) {
			controlador.getNivelActual().getBolasDeFuego().addAll(bolasFuegoPendientes);
			bolasFuegoPendientes.clear();
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
