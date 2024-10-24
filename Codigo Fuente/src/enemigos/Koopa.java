package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;

public class Koopa extends Enemigo{
		
	public Koopa (int x, int y, Sprite imagen) {
			super (x,y,imagen);
		}
		
		public void visitar (Jugador jugador) {
			//si es de arriba, cambia de imagen y deja de moverse (algun boolean). Segundo golpe (desde donde sea) se mueve y
			//muere al chocar con plataforma. Usar el boolean. 
			//sino, mata a jugador
			int puntosDaño = this.puntosQueResta();
			jugador.getInfo().actualizarPuntaje(-puntosDaño);
			jugador.getState().recibirDaño();
		}
		
		@Override
		public void visitar(Elemento elem) {
			// vacio
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
		
		public void moverse() {
			/* modificar
			int nuevaPosicionX=posicionX + velocidad*(1/60);
			
		if (velocidad<0) {
			//imagen.cambiarImagen("Koopa_a_izq.png");
		}
		setPosX(nuevaPosicionX);
		//imagen.actualizarPosicion (posicionX, posicionY); */
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
			// entra a este metodo cuando el visitor sea una bola de fuego
			visitor.visitar(this);
		}

}
