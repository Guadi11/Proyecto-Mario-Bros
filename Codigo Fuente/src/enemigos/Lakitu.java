package enemigos;

import java.util.ArrayList;
import java.util.List;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import elementos.PowerUp;
import juego.ControladorPartida;
import parseo.GameFactory;
import juego.Jugador;


public class Lakitu extends Enemigo{

	protected Enemigo Spiny;
	//protected List<Spiny> spinys;
	protected long ultimoLanzamiento;
	protected long intervaloLanzamientoSpinys=2000;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	protected long ahora;
	public Lakitu (int x, int y, Sprite im) {
		super (x,y,im);
		//spinys= new ArrayList<>();
		ultimoLanzamiento=System.currentTimeMillis();
		
	}
	public void actualizar() {
        ahora = System.currentTimeMillis();
        if (ahora - ultimoLanzamiento >= intervaloLanzamientoSpinys) {
            lanzarSpiny();
            ultimoLanzamiento = ahora;
        }
    }
	
	public void lanzarSpiny() {
		enemigos.Spiny nuevoSpiny = inicializarSpiny();
		nuevoSpiny.serLanzado();
    }
	private Spiny inicializarSpiny() {
		Spiny nuevoSpiny = fabrica.crearSpiny(this.posicionX-1, this.posicionY);
		this.nivel.agregarEnemigo(nuevoSpiny);
		observerSpiny(nuevoSpiny);
		return nuevoSpiny;
	}
	private void observerSpiny(Spiny s) {
		controladorPartida.registrarObserverElementoIndividual(s);
	}
	public void visitar (Jugador j) {
		int puntosDaño=this.puntosQueResta();
		j.getInfo().actualizarPuntaje(-puntosDaño);
		j.getState().recibirDaño();
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
		/*ver tema colisiones/heapbox y sentido del enemigo
		 int nuevaPosicionX=(int) (posicionX + velocidad*(1/60));
		 
		if (velocidad<0) {
			//imagen.cambiarImagen("Lakitu_a_izq.png");
		}else {
			//imagen.cambiarImagen ("Lakitu_a_der.png");
		}
		setPosX(nuevaPosicionX);
		//imagen.actualizarPosicion (posicionX, posicionY);*/
	}
public void setFabrica(GameFactory factory) {
	this.fabrica = factory;
}
public void setControlador(ControladorPartida partida) {
	this.controladorPartida = partida;
}
	

}