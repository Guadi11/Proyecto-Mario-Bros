package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import elementos.BolaDeFuego;
import enemigos.Spiny;
import juego.ControladorPartida;
import juego.Jugador;

public class Fuego extends SuperMario{
	
	protected Sprite sprite;
	protected State estadoAnterior;
	
	public Fuego(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("imagenes/modoUno/mariofuego.png");
		controlador = null;
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite(this.sprite.getRutaImagen());
		actualizarMedidas();
	}	
	private void actualizarMedidas() {
		ImageIcon iconoImagen = new ImageIcon(this.sprite.getRutaImagen());
		Image imagen = iconoImagen.getImage();
		int ancho = imagen.getWidth(null);
		int alto = imagen.getHeight(null);
		int posY = (int) (jugador.getPosY() + (alto - jugador.getHitbox().getHeight()));
		
		this.jugador.setPosY(posY);
		this.jugador.getHitbox().setBounds(jugador.getPosX(), posY, ancho, alto);
	}
	
	public Sprite getSprite() {//este getSprite creo que no es llamado nunca
		return sprite;
	}

	public void disparar() { 
        lanzarBolaDeFuego();
    }
	
    public void lanzarBolaDeFuego() {     
    	int posicionYBola = (int) (jugador.getPosY() - jugador.getHitbox().getHeight()/4);
        BolaDeFuego nuevaBola = this.fabrica.crearBolaDeFuego(jugador.getPosX(), posicionYBola); //ver pos
        controlador.getHiloEnemigo().registrarBolaDeFuego(nuevaBola);
        controlador.registrarObserverElementoIndividual(nuevaBola);
        nuevaBola.setNivel(jugador.getInfo().getNivel());
        nuevaBola.setJugador(jugador);
    }
	
	@Override
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}
	
	@Override
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
	}
	
    public void recibirEstrella() {
    	jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
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
		return true;
	}
}
