package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Spiny extends Enemigo{
	public Spiny (int x, int y, Sprite im) {
		super (x,y,im);
		this.velocidad=5;
	}
public void serLanzado() {
	int  nuevaPosicionY=(int) (posicionY-velocidad*(1/60));
	setPosY(nuevaPosicionY);
	moverse(-1);
}
public void moverse(int sentido) {
	if (sentido==-1)
		imagen.cambiarImagen("Spiny_a_izq.png");
	else
		imagen.cambiarImagen("Sprite_a_der.png");
	int nuevaPosicionX=posicionX + [velocidad*(1/60)]*sentido;
}
public void visitar (Jugador j) {
	int puntosDaño=this.puntosQueResta();
	j.recibirDaño(puntosDaño);
}
public void aceptarVisita (Visitor v) {
	v.visit(this);
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
	
	public Sprite getSprite() {
		return imagen;
	}

	
	public int getPosX() {
		return posicionX;
	}

	
	public int getPosY() {
		return posicionY;
	}

}
