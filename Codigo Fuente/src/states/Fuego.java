package states;

import java.util.ArrayList;
import archivos.Sprite;
import java.util.List;
import elementos.PowerUp;
import elementos.BolaDeFuego;
import powerUps.Estrella;
import juego.Jugador;

public class Fuego extends SuperMario{
	
	protected Jugador jugador;
	protected List<BolaDeFuego> bolasDeFuego = new ArrayList<>();
	protected Sprite sprite;
	
	
	public Fuego(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("/imagenes/modoUno/mariofuego.png");
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void activar() {
       // super.actualizar(); 
        lanzarBolaDeFuego();
    }
	
    public void lanzarBolaDeFuego() {
        BolaDeFuego nuevaBola = new BolaDeFuego(jugador.getPosX(), jugador.getPosY(), null);
        bolasDeFuego.add(nuevaBola);
    }
    
    public void aumentarEstado(PowerUp p) {
    	    if (p instanceof Estrella) {
    	        jugador.setState(new SuperMario(jugador));
    	    }
    	  
    }

    public int obtenerPuntosFFuego() {
          return 50;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
