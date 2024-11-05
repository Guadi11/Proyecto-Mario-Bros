package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;

public class Goomba extends Enemigo{
	
	public Goomba (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	public void visitar (Jugador jugador) {
		if(!jugador.getState().esInvulnerable()) {
			if(chocaArriba(jugador)) {
				chocar(jugador);
				enemigoMuere(jugador);		
			} else {
				jugadorMuere(jugador);
			}
		}else {
			jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
			morir();
		}	
	}
	
	private void jugadorMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(-this.puntosQueResta());
		jugador.getState().recibirDaño();
	}

	private void enemigoMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
		morir();
	}

	public int puntosQueResta() {
		return 30;
	}
	
	public int puntosQueDa() {
		return 60;
	}	

	public void aceptarVisita(VisitorAJugador visitor) {
		// Entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio.
		visitor.visitar(this);
	}

	public void aceptarVisita(VisitorPlataformas visitor) {
		// Entra a este metodo cuando el visitor sea plataforma (sin incluir vacio).
		visitor.visitar(this);
	}

	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// Entra a este metodo cuando el visitor sea una bola de fuego.
		visitor.visitar(this);
	}

	@Override
	public void visitar(Elemento elem) {
		//vacio
	}
	
}
