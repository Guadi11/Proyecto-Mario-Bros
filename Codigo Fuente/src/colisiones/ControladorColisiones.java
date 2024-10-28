package colisiones;

import juego.Nivel;

import java.awt.Rectangle;
import java.util.Iterator;

import elementos.*;

public class ControladorColisiones {
	protected Nivel nivel;
	
	public ControladorColisiones(Nivel n) {
		nivel = n;
	}
	
	public void detectarColision() {
		Rectangle jugadorHitbox = nivel.getJugador().getHitbox(); 
		
		Iterator<Enemigo> iteratorE = nivel.getEnemigos().iterator();	 
		while (iteratorE.hasNext()) {
			Enemigo e = iteratorE.next();
			if (jugadorHitbox.intersects(e.getHitbox())) {
				nivel.getJugador().aceptarVisita(e);
				if(e.estaMuerto()) {
					iteratorE.remove();
				}
			}
		}
		
		Iterator<PowerUp> iteratorPU = nivel.getPowerUps().iterator();    
	    while (iteratorPU.hasNext()) {
	    	PowerUp p = iteratorPU.next();
	       
	    	if (jugadorHitbox.intersects(p.getHitbox())) {
				nivel.getJugador().aceptarVisita(p);
				iteratorPU.remove();
			}     
	    }
	    
	    Iterator<Plataforma> iteratorPlat = nivel.getPlataformas().iterator();    
	    while (iteratorPlat.hasNext()) {
	    	Plataforma p = iteratorPlat.next();
	       
	    	if (jugadorHitbox.intersects(p.getHitbox())) {
				nivel.getJugador().aceptarVisita(p);
			}     
	    }
	    
	}
}
