package colisiones;

import juego.Nivel;
import elementos.*;

public class ControladorColisiones {
	protected Nivel nivel;
	
	public ControladorColisiones(Nivel n) {
		nivel = n;
	}
	
	public void detectarColision() {
		for (Enemigo e:nivel.getEnemigos()) {
			if (nivel.getJugador().getHitbox().intersects(e.getHitbox())) {
				nivel.getJugador().aceptarVisita(e);
				
			}	
		}
			for (PowerUp e:nivel.getPowerUps()) {
				if (nivel.getJugador().getHitbox().intersects(e.getHitbox())) {
					nivel.getJugador().aceptarVisita(e);
			}			
		}
	}
}
