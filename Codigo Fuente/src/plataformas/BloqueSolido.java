package plataformas;

import archivos.Sprite;
import colisiones.VisitorPlataformas;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.Jugador;

public class BloqueSolido extends Plataforma implements VisitorPlataformas{
	
	public BloqueSolido(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}

	@Override
	public void visitar(Jugador jugador) {
		//jugador choca contra bloque. Nunca se rompe
		
	}

	@Override
	public void visitar(Enemigo enemigo) {
		//enemigo choca contra bloque. si lo choca de costado le cambia la direccion
		
	}

	@Override
	public void visitar(PowerUp power) {
		//powerUp choca contra bloque. Algunos caminan normal, otros rebotan (caso aparte?): estrella
		//si lo choca de costado le cambia la direccion
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		//la bola de fuego choca contra el bloque, va rebotando (no se si es algo que importe aca o es algo interno a bola de fuego)
		//si choca de costado muere la bola
		
	}

	@Override
	public void visitar(Elemento elem) {
		//dejarlo vacio
		
	}
	
}
