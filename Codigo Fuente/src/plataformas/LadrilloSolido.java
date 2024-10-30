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
		System.out.println("ladrillo solido: "+this.getHitbox().toString());
		System.out.println("Jugador: "+jugador.getHitbox().toString());
		jugador.ultimoBloqueColision(this);
		//chequeo si la colision es de abajo (y en superMario) o no. En ambos casos el jugador choca contra el bloque, pero en uno se rompe
		//romperse: animacion de romperse y morir
		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));// esto hace que mario se bugee 
			jugador.setVelY(0);
			jugador.setJumped(false);
	
		} 
		else if(jugador.getBoundsLeft().intersects(this.getBoundsRight())) {
			jugador.setPosX((int) (this.getPosX() + jugador.getHitbox().getWidth()));
		}
		else if(jugador.getBoundsRight().intersects(this.getBoundsLeft())) {
			jugador.setPosX((int) (this.getPosX() - jugador.getHitbox().getWidth()));
		} 
		else if(jugador.getBoundsTop().intersects(this.getBoundsBottom())){
			System.out.println("golpeo desde abajo");
			System.out.println("Estoy grande: " + jugador.getState().esGrande());
			jugador.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			jugador.setVelY(0);
			if(jugador.getState().esGrande()) {
				System.out.println("entra a es grande");
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
		//enemigo choca contra bloque
		if(enemigo.getBoundsBottom().intersects(this.getBoundsTop())) {
			enemigo.setPosY((int) (this.getPosY() + enemigo.getHitbox().getHeight()));
			//enemigo.setVelY(0);	
		} 
		else if(enemigo.getBoundsLeft().intersects(this.getBoundsRight())) {
			enemigo.setPosX((int) (this.getPosX() + enemigo.getHitbox().getWidth()));
			enemigo.moverDerecha();
		}
		else if(enemigo.getBoundsRight().intersects(this.getBoundsLeft())) {
			enemigo.setPosX((int) (this.getPosX() - enemigo.getHitbox().getWidth()));
			enemigo.moverIzquierda();
		} 
		else if(enemigo.getBoundsTop().intersects(this.getBoundsBottom())){
			System.out.println("golpeo desde abajo");
			enemigo.setPosY((int) (this.getPosY() - this.getHitbox().getHeight()));
			//enemigo.setVelY(0);
		}
	}

	@Override
	public void visitar(PowerUp power) {
		//powerUp choca contra bloque. Algunos caminan normal, otros rebotan (caso aparte?): estrella
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//la bola de fuego choca contra el bloque, va rebotando (no se si es algo que importe aca o es algo interno a bola de fuego)
		//si lo choca de costado muere la bola
		
	}

	@Override
	public void visitar(Elemento elem) {
		//dejarlo vacio
		
	}
	
}
