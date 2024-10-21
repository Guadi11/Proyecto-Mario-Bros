package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Koopa extends Enemigo{
		
	public Koopa (int x, int y, Sprite imagen) {
			super (x,y,imagen);
		}
		
		public void visitar (Jugador jugador) {
			int puntosDaño = this.puntosQueResta();
			jugador.getInfo().actualizarPuntaje(-puntosDaño);
			jugador.getState().recibirDaño();
		}
		
		public void aceptarVisita (Visitor visitor) {
			//visitor.visitar (this);
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
}
