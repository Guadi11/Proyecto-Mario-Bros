package states;

import archivos.Sprite;
import elementos.PowerUp;
import powerUps.Estrella;
import juego.Jugador;

public class Fuego extends SuperMario{
	
	//protected Jugador jugador;
	//protected List<BolaDeFuego> bolasDeFuego = new ArrayList<>();
	protected Sprite sprite;
	
	
	public Fuego(Jugador jugador) {
		super(jugador);

	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite("imagenes/modoUno/mariofuego.png");
		jugador.setPosY(jugador.getPosY()-30);
		jugador.actualizarPosicionHitbox();
		jugador.setHitbox(jugador.getHitbox().width, 72);
		//la posicion esta ajustada pero no se por qué cae abajo del piso
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	//esto va dentro de Jugador, no aca
	/*
	public void disparar() { 
        lanzarBolaDeFuego();
    }
	
    public void lanzarBolaDeFuego() {
        BolaDeFuego nuevaBola = new BolaDeFuego(jugador.getPosX(), jugador.getPosY(), null);
        bolasDeFuego.add(nuevaBola);
    }
    */
    public void aumentarEstado(PowerUp p) {
    	    if (p instanceof Estrella) {
    	    	this.getInvulnerable().setAnterior(this);
    	    	this.getInvulnerable().activar();
    	    }
    	  
    }

    public int obtenerPuntosFFuego() {
          return 50;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
