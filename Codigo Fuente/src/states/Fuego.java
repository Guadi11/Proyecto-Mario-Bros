package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;

public class Fuego extends SuperMario{
	
	protected Sprite sprite;
	protected State estadoAnterior;
	
	
	public Fuego(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("imagenes/modoUno/mariofuego.png");
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

	/*
	public void disparar() { 
        lanzarBolaDeFuego();
    }
	
    public void lanzarBolaDeFuego() {
        BolaDeFuego nuevaBola = new BolaDeFuego(jugador.getPosX(), jugador.getPosY(), null); //Crearlo bien con la fabrica
    }
    */
	
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
