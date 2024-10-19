package colisiones;

import elementos.Elemento;

public interface Visitor {
  public default void visitar(Elemento elementoAVisitar) {}; 
}
