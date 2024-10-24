package colisiones;

import juego.Jugador;

public interface VisitorAJugador extends Visitor {
	//Para los elementos en los cuales la visita a Jugador es diferente. Enemigo y PowerUp y vacio
	
	public  void visitar(Jugador jugador); 

}
