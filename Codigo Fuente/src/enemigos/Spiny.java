package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;

public class Spiny extends Enemigo{
	protected long ALTURA_MAXIMA = 600;
	private int nuevaPosicionX = 0;
	private int nuevaPosicionY = 0;
	
	public Spiny (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	public void serLanzado() {
		while (getPosY() < ALTURA_MAXIMA) {
		nuevaPosicionY = (int) (posicionY - velocidadEnMill*(1/60));
		setPosY(nuevaPosicionY);
		nuevaPosicionX = (int) (posicionX - velocidadEnMill*(1/60));
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
		
	public void visitar (Jugador jugador) {
		//siempre hace daño al jugador, no importa de donde sea la colision. solo muere con bola de fuego
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
		return 30;
	}
	
	public int puntosQueDa() {
		return 0;
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
