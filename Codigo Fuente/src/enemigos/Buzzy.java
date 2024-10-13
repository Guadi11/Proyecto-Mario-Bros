package enemigos;

import archivos.Sprite;
import colisiones.Visitor;
import elementos.Enemigo;
import juego.Jugador;

public class Buzzy extends Enemigo{

	public Buzzy(int x, int y, Sprite im) {
		super(x, y, im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void visitar(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDaño() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int puntosQueResta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int puntosQueDa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

}
