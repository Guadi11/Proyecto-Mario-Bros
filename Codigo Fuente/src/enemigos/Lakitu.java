package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.ControladorPartida;
import parseo.GameFactory;
import juego.Jugador;
import observers.AdaptadorPosicionPixel;


public class Lakitu extends Enemigo{

	protected Enemigo Spiny;
	protected long ultimoLanzamiento;
	protected long intervaloLanzamientoSpinys = 3000;
	protected GameFactory fabrica;
	protected ControladorPartida controladorPartida;
	protected long ahora; 
	
	public Lakitu (int x, int y, Sprite im) {
		super (x,y,im);
		ultimoLanzamiento = System.currentTimeMillis();
	}
	public void actualizar() {
		int limiteDerecho =  AdaptadorPosicionPixel.transformarX(7471);
		int limiteY_ventana = 0;
		moverEnDireccion();
		this.setPosX(posicionX + velX);
		
		if (posicionX < 0) {
	        posicionX = 0; 
	        this.moverDerecha();
	    }else if (posicionX > limiteDerecho) {
	    	posicionX = limiteDerecho;	
	    	this.moverIzquierda();
	    }
		if (posicionY < limiteY_ventana)
			morir();
		
		actualizarPosicionHitbox();
		notificar();
		actualizarSpiny();
	}	
	
	public void actualizarSpiny() {
        ahora = System.currentTimeMillis();
        if (ahora - ultimoLanzamiento >= intervaloLanzamientoSpinys) {
        	System.out.println("lanza Spiny");
            lanzarSpiny();
            ultimoLanzamiento = ahora;
        }
    }
	
	public void lanzarSpiny() {
		Spiny nuevoSpiny = fabrica.crearSpiny(this.posicionX, this.posicionY - 36); //ver posY
		controladorPartida.getHiloEnemigo().registrarEnemigo(nuevoSpiny);
		controladorPartida.registrarObserverElementoIndividual(nuevoSpiny);
		nuevoSpiny.setNivel(this.nivel);
		
    }
	
	public void visitar (Jugador jugador) {
		//Si es de arriba, muere. Sino, mata a jugador
		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));
			jugador.setVelY(0);
			jugador.setJumped(false);
			jugador.saltarAlMatar();
			jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
			morir();
			this.estoyMuerto = true;
		} else {
			jugador.getInfo().actualizarPuntaje(-this.puntosQueResta());
			jugador.getState().recibirDaño();
		}
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
		return 30;
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