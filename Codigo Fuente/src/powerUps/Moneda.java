package powerUps;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.PowerUp;
import juego.Jugador;

public class Moneda extends PowerUp{

	public Moneda(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		jugador.getInfo().aumentarMoneda();
		morir();
	}
	
	@Override
	public void visitar(Elemento elem) {
		//vacio
	}
	
	public int puntosQueDa() {
		return 5;
	}
	
	public void moverse() {
		
	}
	
	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// entra a este metodo cuando el visitor sea plataforma (sin incluir vacio)
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// entra a este metodo cuando el visitor sea una bola de fuego. No entra nunca aca
		visitor.visitar(this);
	}
}
