package Launcher;


import archivos.TopRanking;
import colisiones.ControladorColisiones;
import juego.ControladorPartida;
import vista.ControladorPantallas;

import java.awt.EventQueue;
import java.io.*;;

public class Launcher {

		
		/*
		ControladorPartida partida =  new ControladorPartida();
		ControladorPantallas pantallas = new ControladorPantallas(partida);
		partida.setControladorPantallas(pantallas);
		pantallas.mostrarPantallaInicial();
		*/
		
	public static void main(String [] args) {		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						TopRanking ranking = new TopRanking();
						try {
							FileInputStream fileInputStream = new FileInputStream("./puntajes.tdp");
							ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
							ranking = (TopRanking) objectInputStream.readObject();
							objectInputStream.close();
						}
						catch (IOException | ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						ControladorPartida partida =  new ControladorPartida(ranking);
						ControladorPantallas pantallas = new ControladorPantallas(partida);
						partida.setControladorPantallas(pantallas);
						pantallas.mostrarPantallaInicial();
						new ControladorColisiones(partida.getNivelActual());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
