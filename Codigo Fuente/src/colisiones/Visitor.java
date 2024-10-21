package colisiones;

import elementos.Elemento;
import juego.Jugador;

public interface Visitor {
  public  void visitar(Jugador jugador); 
}
