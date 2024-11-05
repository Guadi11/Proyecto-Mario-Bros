package elementos;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import states.State;

public abstract class PowerUp extends Elemento implements VisitorAJugador, Visitable{
	
	protected int velocidad = 2;
	protected State estadoMario;
	
	public PowerUp(int x, int y, Sprite imagen) {
		super(x, y, imagen);
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
}
