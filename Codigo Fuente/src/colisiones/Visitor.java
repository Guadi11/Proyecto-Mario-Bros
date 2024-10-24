package colisiones;

import elementos.Elemento;

public interface Visitor {
  //public  void visitar(Jugador jugador); 
	public void visitar(Elemento elem);
}
