package plataformas;

import archivos.Sprite;
import archivos.TipoSonidos;
import colisiones.VisitorAJugador;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.Jugador;

public class Castillo extends Plataforma implements VisitorAJugador{

	public Castillo(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	@Override
	public void visitar(Elemento elem) {
		//vacio
	}

	@Override
	public void visitar(Jugador jugador) {
		this.nivel.getControladorPartida().siguienteNivel();
		sonido();
		System.out.println("Entro al castillo.");
		//gestiona el ganar nivel
		//this.nivel.getControladorPartida().victoria(jugador.getInfo().getPuntaje());
	}
	public void sonido() {
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoJuego(TipoSonidos.finNivel);
	}
	
	public void visitar(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PowerUp power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		// TODO Auto-generated method stub
		
	}

}
