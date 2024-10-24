package colisiones;

import juego.Nivel;

import java.awt.Rectangle;

import elementos.*;

public class ControladorColisiones {
	protected Nivel nivel;
	
	public ControladorColisiones(Nivel n) {
		nivel = n;
	}
	
	public void detectarColision() {
		for (Enemigo e:nivel.getEnemigos()) {
			 Rectangle jugadorHitbox = nivel.getJugador().getHitbox(); 	
			
			if (jugadorHitbox.intersects(e.getHitbox())) {
				if (jugadorHitbox.intersects(e.getBoundsTop())){
					System.out.println("Colisión desde arriba detectada");
					e.colisionDesdeArriba();
				}
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
