package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import juego.Jugador;

public class BolaDeFuego extends Elemento implements VisitorBolaDeFuego, Visitable{
	protected Jugador jugador;
	private int velX;

	public BolaDeFuego(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		velX = 0;
	}

	public void actualizar() {
		velX = 5;
		this.setPosX(this.posicionX + velX);
		actualizarPosicionHitbox();
		notificar(); 	
	}

	public void visitar(Enemigo enemigo) {
		int puntosPorMatar = enemigo.puntosQueDa();
		enemigo.morir();
		jugador.getInfo().actualizarPuntaje(puntosPorMatar);
		this.morir();
	}

	@Override
	public void visitar(Elemento elem) {
		// Vacio.
	}

	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// Entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio.
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// Entra a este metodo cuando el visitor sea plataforma (sin incluir vacio).
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// Entra a este metodo cuando el visitor sea una bola de fuego. No entra nunca aca.
		visitor.visitar(this);
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
