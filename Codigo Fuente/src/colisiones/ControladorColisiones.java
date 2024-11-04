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
	
	public void detectarColisionJugador() {
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
				if(p.estaMuerto()) {
					iteratorPlat.remove();
				}
			}     
	    }
	}
	
	
	public void detectarColisionEnemigos(Enemigo e) { //o elemento
		Rectangle enemigoHitbox = e.getHitbox();
		Iterator<Plataforma> iteratorPlat = nivel.getPlataformas().iterator();    
	    while (iteratorPlat.hasNext()) {
	    	Plataforma p = iteratorPlat.next();
	       
	    	if (enemigoHitbox.intersects(p.getHitbox())) {
	    		e.ColisionaConBloque(true);
	    		e.aceptarVisita(p);
			}     
	    }
	    
	    Iterator<BolaDeFuego> iteratorBolasFuego = nivel.getBolasDeFuego().iterator(); 
	    while(iteratorBolasFuego.hasNext()) {
	    	BolaDeFuego b = iteratorBolasFuego.next();
	    	
	    	if(enemigoHitbox.intersects(b.getHitbox())) {
	    		e.aceptarVisita(b);
	    		if(e.estaMuerto()) {
	    			iteratorBolasFuego.remove();
				}
	    	}
	    }
		
	}
	
	public void detectarColisionBolasDeFuego(BolaDeFuego b) {
		Rectangle bolaFuegoHitbox = b.getHitbox();
		Iterator<Plataforma> iteratorPlat = nivel.getPlataformas().iterator();    
	    while (iteratorPlat.hasNext()) {
	    	Plataforma p = iteratorPlat.next();
	       
	    	if (bolaFuegoHitbox.intersects(p.getHitbox())) {
	    		b.aceptarVisita(p);
			}     
	    }	
	}
}
