package enemigos;

import java.util.ArrayList;
import java.util.List;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import elementos.PowerUp;
import juego.Jugador;


public class Lakitu extends Enemigo{

	protected PowerUp Spiny;
	protected Sprite nube;
	protected List<Spiny> spinys;
	protected long ultimoLanzamiento;
	protected long intervaloLanzamientoSpinys=2000;
	public Lakitu (int x, int y, Sprite im) {
		super (x,y,im);
		this.velocidad=3;
		crearNube();
		spinys= new ArrayList<>();
		ultimoLanzamiento=System.currentTimeMillis();
		
	}
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - ultimoLanzamiento >= intervaloLanzamientoSpinys) {
            lanzarSpiny();
            ultimoLanzamiento = ahora;
        }
        for (Spiny spiny : spinys) {
            spiny.serLanzado();
        }
        spinys.removeIf(spiny -> spiny.getPosY() > ALTURA_MAXIMA);
    }
	public void lanzarSpiny() {
        Spiny nuevoSpiny = new Spiny(this.posicionX, this.posicionY + 1);
        spinys.add(nuevoSpiny);
    }
	public void crearNube () {
		nube=new Sprite (posicionX-1, posicionY-1);
		nube.dibujar("Nube.png");
	}
	public void visitar (Jugador j) {
		int puntosDaño=this.puntosQueResta();
		j.recibirDaño(puntosDaño);
	}
	public void aceptarVisita (Visitor v) {
		v.visit (this);
	}
	public void recibirDaño() {
		this.morir();
		this.puntosQueDa();
	}
	public int puntosQueResta() {
		return Spiny.puntosQueResta();
	}
	public int puntosQueDa() {
		return 60;
	}
	public void moverse(int velocidad) {
		int nuevaPosicionX=posicionX + velocidad*(1/60);
	if (velocidad<0) {
		imagen.cambiarImagen("Lakitu_a_izq.png");}
	else
		imagen.cambiarImagen ("Lakitu_a_der.png");
	setPosX(nuevaPosicionX);
	imagen.actualizarPosicion (posicionX, posicionY);
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
