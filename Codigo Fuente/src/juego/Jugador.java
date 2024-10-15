package juego;

import archivos.Sprite;
import colisiones.Visitable;
import colisiones.Visitor;
import elementos.Enemigo;
import elementos.Movible;
import states.Invulnerable;
import states.State;

public class Jugador extends Movible implements Visitor, Visitable{
	
	protected State estado;
	protected InfoJugador info;
	protected int velX;
	
	
	public Jugador(int x, int y, Sprite im) {
		super(x, y, im);
		velX = 0;
	}

	
	//Get
	public State getState() {
		return this.estado;
	}
	
	public InfoJugador getInfo() {
		return this.info;
	}

	public void setEstrella(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void setState(State estado) {
		// TODO Auto-generated method stub
		
	}

	public void moverDerecha() {
		System.out.println("entro a mover derecha de jugador");
		velX = 8;
		System.out.println("Posicion actual en X: " + this.posicionX);
		
	}

	public void moverIzquierda() {
		velX = -8;
		
		
	}

	public void frenarMovimiento() {
		velX = 0;
		
	}
	public void actualizar() {
		this.posicionX = posicionX + velX; // Actualiza la posición en función de la velocidad
        // aca podriamos añadir tambien la logica del salto. Falta chequear que no se exceda del limite de la pantalla
		notificar();
    }
	public void moverse() {
		
	}


	public void saltar() {
		// TODO Auto-generated method stub
		
	}
		
}


