package plataformas;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Plataforma;
import elementos.PowerUp;
import juego.Jugador;

public class Vacio extends Plataforma implements VisitorAJugador{ 

	public Vacio(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		jugador.setVelY(-10);
			
	}
	
	@Override
	public void visitar(Elemento elem) {
		//no se como, pero que se caiga. Ademas muere
		
	}

	@Override
	public void visitar(Enemigo enemigo) {
		enemigo.ColisionaConBloque(false);
		enemigo.setVelY(-10);
		System.out.println("Entro loco.");
		
	}

	@Override
	public void visitar(PowerUp power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BolaDeFuego bola) {
		// TODO Auto-generated method stub
		
	}

}
