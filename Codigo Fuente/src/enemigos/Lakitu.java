package enemigos;

import java.util.ArrayList;
import java.util.List;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import elementos.PowerUp;
import juego.ControladorPartida;
import juego.GameFactory;
import juego.Jugador;


public class Lakitu extends Enemigo{

	protected Enemigo Spiny;
	//protected List<Spiny> spinys;
	protected long ultimoLanzamiento;
	protected long intervaloLanzamientoSpinys=2000;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	
	public Lakitu (int x, int y, Sprite im) {
		super (x,y,im);
		this.velocidad=3;
		//spinys= new ArrayList<>();
		ultimoLanzamiento=System.currentTimeMillis();
		
	}
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - ultimoLanzamiento >= intervaloLanzamientoSpinys) {
            lanzarSpiny();
            ultimoLanzamiento = ahora;
        }
        //spinys.removeIf(spiny -> spiny.getPosY() > ALTURA_MAXIMA);
    }
	
	public void lanzarSpiny() {
		Spiny nuevoSpiny = fabrica.crearSpiny(this.posicionX, this.posicionY + 1);
		this.nivel.agregarEnemigo(nuevoSpiny);
		controladorPartida.registrarObserverElementoIndividual(nuevoSpiny);
		nuevoSpiny.serLanzado();
		/*
		Spiny nuevoSpiny = new Spiny(this.posicionX, this.posicionY + 1, nube);
        spinys.add(nuevoSpiny);*/
    }
	
	public void visitar (Jugador j) {
		int puntosDaño=this.puntosQueResta();
		//j.recibirDaño(puntosDaño);
	}
	public void aceptarVisita (Visitor v) {
		//v.visit (this);
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
	public void moverse() {
		int nuevaPosicionX=(int) (posicionX + velocidad*(1/60));
		if (velocidad<0) {
			//imagen.cambiarImagen("Lakitu_a_izq.png");
		}else {
			//imagen.cambiarImagen ("Lakitu_a_der.png");
		}
		setPosX(nuevaPosicionX);
		//imagen.actualizarPosicion (posicionX, posicionY);
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
	
	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
	}
	public void setControlador(ControladorPartida partida) {
		this.controladorPartida = partida;
	}
	

}
