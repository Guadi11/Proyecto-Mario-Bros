package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;
import observers.AdaptadorPosicionPixel;

public class Piranha extends Enemigo{
	private int minAltura;
	protected boolean subiendo;

	public Piranha(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		minAltura = y;
		subiendo = true;
	}
	public void subir() {
		velY=2;
	}

	public void bajar() {
		velY=-2;

	}
	public void estado() {
		int maxAltura = (int) (minAltura + this.getHitbox().getHeight());
		if (posicionY >= maxAltura) {
			posicionY = maxAltura;
			subiendo = false;
		} 
		else if (posicionY<=minAltura){
			posicionY = minAltura;
			subiendo = true;
		}

	}

	public void actualizar() {
		System.out.println("posicion 0Y: "+posicionY);
		if (subiendo) {
			subir();
		} else {
			bajar();
        }System.out.println("posicion 1Y: "+posicionY);
    
        posicionY += velY;
        
        System.out.println("velX: "+velY);
        System.out.println("posicion 2Y: "+posicionY);
        estado();
        System.out.println("posicion 3Y: "+posicionY);
        System.out.println("estado: "+subiendo);
        actualizarPosicionHitbox();
        System.out.println("posicion 4Y: "+posicionY);
        notificar();
        System.out.println("posicion 5Y: "+posicionY);
		
	}
	
	public void visitar(Jugador jugador) {
		if(!jugador.getState().esInvulnerable()) {
			jugadorMuere(jugador);
		}else {
			enemigoMuere(jugador);
		}
	}
	
	private void enemigoMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
		morir();
	}

	private void jugadorMuere(Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(-puntosQueResta());
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
		return 30;
	}
	
	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// Entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio.
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// Entra a este metodo cuando el visitor sea plataforma (sin incluir vacio).
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// Entra a este metodo cuando el visitor sea una bola de fuego.
		visitor.visitar(this);
	}


}
