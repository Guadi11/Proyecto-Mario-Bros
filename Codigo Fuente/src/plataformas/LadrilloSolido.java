package plataformas;

import archivos.Sprite;
import archivos.TipoSonidos;
import colisiones.VisitorPlataformas;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.Jugador;

public class LadrilloSolido extends Plataforma implements VisitorPlataformas{
	
	public LadrilloSolido(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	@Override
	public void visitar(Jugador jugador) {
		jugador.ultimoBloqueColision(this);

		if(chocaArriba(jugador)) {
			ubicarArriba(jugador);
		} 
		else if(chocaDerecha(jugador)) {
			jugador.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
		}
		else if(chocaIzquierda(jugador)) {
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		} 
		else if(chocaAbajo(jugador)){
			jugador.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			jugador.setVelY(0);
			if(jugador.getState().esGrande()) {
				morir();
				estoyMuerto = true;
			}
		}
	}
	public void morir() {
		this.nivel.removerElemento(this);
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoAccion(TipoSonidos.rompeBloque);
	}

	@Override
	public void visitar(Enemigo enemigo) {
		if(chocaArriba(enemigo)) {
			enemigo.setPosY((int) (this.getPosY() + enemigo.getHitbox().getHeight()));
		} 
		else if(chocaDerecha(enemigo)) {
			enemigo.setPosX((int) (this.getPosX() + this.hitbox.getWidth()));
			enemigo.moverDerecha();
		}
		else if(chocaIzquierda(enemigo)) {
			enemigo.setPosX((int) (this.getPosX() - enemigo.getHitbox().getWidth()));
			enemigo.moverIzquierda();
		} 
		else if(chocaAbajo(enemigo)){
			enemigo.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
		}
	}

	@Override
	public void visitar(PowerUp power) {
		//Vacio.
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//Vacio.
	}

	@Override
	public void visitar(Elemento elem) {
		//Vacio.
	}

}
