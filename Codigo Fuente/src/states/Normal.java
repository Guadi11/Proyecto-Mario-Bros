package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;


public class Normal extends State {
	
	protected Sprite sprite; 
	
	public Normal(Jugador jugador) {
		super(jugador);
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite("imagenes/modoUno/mario.png");
		//actualizarMedidas();
	}
	private void actualizarMedidas() {
		ImageIcon iconoImagen = new ImageIcon("imagenes/modoUno/mario.png");
		Image imagen = iconoImagen.getImage();
		int ancho = imagen.getWidth(null);
		int alto = imagen.getHeight(null);
		int posY = (int) (jugador.getPosY() + (alto - jugador.getHitbox().getHeight()));
		
		this.jugador.setPosY(posY);
		this.jugador.getHitbox().setBounds(jugador.getPosX(), posY, ancho, alto);
	}
	
	public Sprite getSprite() {
		return this.sprite;
		
	}
	
	/*public void aumentarEstado (PowerUp p) {
		int posicionY = jugador.getPosY();
		if ((p instanceof SuperChampiñon)  || (p instanceof FlorDeFuego)) {
			jugador.getState().getSuperMario().activar();
			jugador.setPosY(posicionY-36);
		}
		else 
			if (p instanceof Estrella){
				System.out.println("WTF.");
				jugador.getState().getInvulnerable().setAnterior(this);
				jugador.getState().getInvulnerable().activar();
				jugador.setPosY(posicionY-36);
		}
	}*/
	
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
		this.getSuperMario().activar();			
	}
	
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
		this.getSuperMario().activar();
	}
	
	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
		this.getInvulnerable().setAnterior(this);
		this.getInvulnerable().activar();
	}
	public void reproducirSonidoSalto() {
		controladorSonidosAccion.reproducirSonido(TipoSonidos.saltaNormal);
	}
	public void recibirDaño() {
		jugador.getInfo().restarVida(); 
	}
	
	public int obtenerPuntosEstrella() {
		return 20;
	}
	
	public int obtenerPuntosSChamp() {
		return 10;
	}
	
	public int obtenerPuntosFFuego() {
		return 5;
	}
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
	
	public boolean esGrande() {
		return false;
	}

}
