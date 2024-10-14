package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Spiny extends Enemigo{
	protected long ALTURA_MAXIMA=600;
	private int nuevaPosicionX=0;
	private int nuevaPosicionY=0;
	public Spiny (int x, int y, Sprite im) {
		super (x,y,im);
	}
public void serLanzado() {
	while (getPosY() < ALTURA_MAXIMA) {
	nuevaPosicionY=(int) (posicionY-velocidadEnMill*(1/60));
	setPosY(nuevaPosicionY);
	nuevaPosicionX= (int) (posicionX - velocidadEnMill*(1/60));
	setPosX (nuevaPosicionX);
	}
	moverse();
}
public void moverse() { //para cuando se desplaza por el suelo
	/*ver tema colisiones/heapbox y sentido del enemigo
	if (sentido==-1) {
		//imagen.cambiarImagen("Spiny_a_izq.png");
	}else {
		//imagen.cambiarImagen("Sprite_a_der.png");
	}
	int nuevaPosicionX= (int) (posicionX +(velocidad*(1/60))*sentido);
	this.setPosX(nuevaPosicionX);*/
}
public void visitar (Jugador j) {
	int puntosDaño=this.puntosQueResta();
	j.recibirDaño(puntosDaño);
}
public void aceptarVisita (Visitor v) {
	//v.visit(this);
}
public void recibirDaño() {
	this.morir();
	this.puntosQueDa();
}
public int puntosQueResta() {
	return 30;
}
public int puntosQueDa() {
	return 60;
}
}
