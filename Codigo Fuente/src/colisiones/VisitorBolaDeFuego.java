package colisiones;

import elementos.Enemigo;

public interface VisitorBolaDeFuego extends Visitor {

	public void visitar(Enemigo enemigo);
}
