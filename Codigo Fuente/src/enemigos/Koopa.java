package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Koopa extends Enemigo{
		public Koopa (int x, int y, Sprite im) {
			super (x,y,im);
		}
		public void visitar (Jugador j) {
			int puntosDaño=this.puntosQueResta();
			j.recibirDaño(puntosDaño);
		}
		public void aceptarVisita (Visitor v) {
			//v.visit (this);
		}
		public void recibirDaño() {
			this.morir();
			this.puntosQueDa();
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
