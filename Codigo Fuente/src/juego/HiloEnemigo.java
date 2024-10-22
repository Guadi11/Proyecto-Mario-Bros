package juego;

import elementos.Enemigo;

public class HiloEnemigo extends Thread {
	protected ControladorPartida controlador;
	protected boolean enEjecucion;
	
	public HiloEnemigo(ControladorPartida controlador) {
		this.controlador = controlador;
		enEjecucion = true;
	}

	public void run(){
	 	while(enEjecucion){
	 		for (Enemigo e:controlador.getNivelActual().getEnemigos()) {
	 			e.actualizar();
	 			System.out.println("Entro.");
	 		}
	 		//colisiones.detectarColision(); luego de moverse chequea las colisiones
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
