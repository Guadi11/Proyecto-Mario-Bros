package elementos;

import java.awt.Rectangle;

import archivos.Sprite;
import colisiones.Visitor;
import juego.Jugador;

public abstract class Plataforma extends Elemento implements Visitor{


	public Plataforma (int x, int y, Sprite imagen) {
		super (x,y,imagen);
	}
	
	protected void ubicarArriba(Jugador jugador) {
		jugador.setPosY((int) (this.getPosY() + jugador.getAlto()));
		jugador.setVelY(0);
		jugador.setJumped(false);
	}
	
	@Override
	public void visitar(PowerUp power) {
		//Vacio
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		
		System.out.println("entra a visitar bola de fueo de plataforma ");
		/*int techoEnemigo = bola.getPosY();
		int pisoEnemigo = bola.getPosY() - bola.getAlto();
		int extrIzqEnemigo = bola.getPosX();
		int extrDerEnemigo = bola.getPosX() + bola.getAncho();

		int techoElemento = this.getPosY();
		int pisoElemento = this.getPosY() - this.getAlto();
		int extrDerElemento = this.getPosX() + this.getAncho();
		int extrIzqElemento = this.getPosX();


		int alto = 0;
		if(bola.getPosY() >= this.getPosY()) {
			alto = techoElemento - pisoEnemigo;
		} else {
			alto = techoEnemigo - pisoElemento;
		}

		int ancho = 0;
		if(bola.getPosX() < this.getPosX()) {//jugador esta a la izquierda
			ancho = extrDerEnemigo - extrIzqElemento;
		} else { //Jugador esta a la derecha
			ancho = extrDerElemento - extrIzqEnemigo;
		}*/
		
		int alto = calcularAlturaInterseccion(bola);
		int ancho = calcularAnchoInterseccion(bola);
		
		boolean colisionDeLado = alto >= ancho;

		if(colisionDeLado) {
			System.out.println("detecto colision de lado la bola de fuego");
				bola.morir();

		} 
	}
}
