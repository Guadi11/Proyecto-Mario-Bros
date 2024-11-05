package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;

public class Koopa extends Enemigo{
		
	protected boolean escondido;
	
	public Koopa (int x, int y, Sprite imagen) {
			super (x,y,imagen);
			escondido = false;
			
		}
	
		public void visitar (Jugador jugador) {
			if(!jugador.getState().esInvulnerable()) {
				if(chocaArriba(jugador)) {
					chocar(jugador);
					if(escondido) {
						enemigoMuere(jugador);
					} else {
						escondido = true;
					}
				} else {
					jugadorMuere(jugador);
				}
			}else {
				enemigoMuere(jugador);
			}
		}
		
		private void enemigoMuere(Jugador jugador) {
			jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
			morir();
		}

		private void jugadorMuere(Jugador jugador) {
			jugador.getInfo().actualizarPuntaje(-this.puntosQueResta());
			jugador.getState().recibirDaño();
		}

		@Override
		public void visitar(Elemento elem) {
			// Vacio.
		}
		
		public int recibirDaño() {
			this.morir();
			return this.puntosQueDa();
		}
		
		public int puntosQueResta() {
			return 45;
		}
		
		public int puntosQueDa() {
			return 90;
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
			// Entra a este metodo cuando el visitor sea una bola de fuego.
			visitor.visitar(this);
		}
}
