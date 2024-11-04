package Launcher;


import archivos.TopRanking;
import colisiones.ControladorColisiones;
import juego.ControladorPartida;
import vista.ControladorPantallas;

import java.awt.EventQueue;
import java.io.*;;

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
						TopRanking ranking = new TopRanking();
						try {
							FileInputStream fileInputStream = new FileInputStream("./puntajes.tdp");
							ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
							ranking = (TopRanking) objectInputStream.readObject();
							objectInputStream.close();
						}
						catch (FileNotFoundException e) {
							
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						catch (ClassNotFoundException e) {
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
