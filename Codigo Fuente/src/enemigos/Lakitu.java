package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.ControladorPartida;
import parseo.GameFactory;
import juego.Jugador;


public class Lakitu extends Enemigo{

	protected Enemigo Spiny;
	protected long ultimoLanzamiento;
	protected long intervaloLanzamientoSpinys = 2000;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	protected long ahora;
	
	public Lakitu (int x, int y, Sprite im) {
		super (x,y,im);
		ultimoLanzamiento = System.currentTimeMillis();
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
	
	private void observerSpiny(Spiny spiny) {
		controladorPartida.registrarObserverElementoIndividual(spiny);
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
	
	//Set
	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
	}
	
	public void setControlador(ControladorPartida partida) {
		this.controladorPartida = partida;
	}

}