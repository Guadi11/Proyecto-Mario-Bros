package Launcher;

import java.awt.EventQueue;

import juego.ControladorPartida;
import vista.ControladorPantallas;

public class Launcher {

	public static void main(String [] args) {
		
		/*
		ControladorPartida partida =  new ControladorPartida();
		ControladorPantallas pantallas = new ControladorPantallas(partida);
		partida.setControladorPantallas(pantallas);
		pantallas.mostrarPantallaInicial();
		*/
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						ControladorPartida partida =  new ControladorPartida();
						ControladorPantallas pantallas = new ControladorPantallas(partida);
						partida.setControladorPantallas(pantallas);
						pantallas.mostrarPantallaInicial();
						//pantallas.mostrarPantallaJuego();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
