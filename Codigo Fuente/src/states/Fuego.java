package states;

import archivos.Sprite;
import elementos.PowerUp;
import powerUps.Estrella;
import juego.Jugador;

public class Fuego extends SuperMario{
	
	//protected List<BolaDeFuego> bolasDeFuego = new ArrayList<>();
	protected Sprite sprite;
	protected State estadoAnterior;
	
	
	public Fuego(Jugador jugador) {
		super(jugador);

	}
	
	public void activar() {
		estadoAnterior = jugador.getState();
		jugador.setState(this);
        //tiempoActivacion = System.currentTimeMillis();
        //this.sprite=new Sprite(null);

        // Usar el método esGrande() para determinar el sprite
         if(estadoAnterior.esGrande()) {
           // this.sprite = new Sprite("imagenes/modoUno/mariofuego.png");
            jugador.getSprite().setSprite("imagenes/modoUno/mariofuego.png");
         } else {
           //this.sprite = new Sprite("imagenes/modoUno/invulnerablemini.png");
           jugador.getSprite().setSprite("/imagenes/modoUno/supermario.png");}
        }
		
	
	
	public Sprite getSprite() {
		this.sprite = new Sprite("imagenes/modoUno/invulnerable.png");
		return sprite;
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
	@Override
	public void aumentarASuperMario() {
		
	}
	@Override
	public void aumentarAFuego() {
		
	}
	
    public void aumentarAInvulnerable() {
    	this.getInvulnerable().setAnterior(this);
    	this.getInvulnerable().activar();
    }
    	  
    public int obtenerPuntosFFuego() {
        return 50;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public boolean esGrande() {
		return false;
	}
    //jugador.setState(this);
	//jugador.getSprite().setSprite("imagenes/modoUno/mariofuego.png");
}
