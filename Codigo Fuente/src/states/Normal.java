package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;
import parseo.GameFactory;


public class Normal extends State {

	protected Sprite sprite;

	public Normal(Jugador jugador) {
		super(jugador);
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

	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
		this.getSuperMario().setControlador(controlador);
		this.getSuperMario().setFabrica(fabrica);
		this.getSuperMario().activar();			
	}

	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
		this.getSuperMario().setControlador(controlador);
		this.getSuperMario().setFabrica(fabrica);
		this.getSuperMario().activar();
	}

	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
		this.getInvulnerable().setControlador(controlador);
		this.getInvulnerable().setFabrica(fabrica);
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

	public boolean esGrande() {
		return false;
	}

	@Override
	public void disparar() { 
	}

	@Override
	public boolean esInvulnerable() {
		return false;
	}

	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
		this.rutaCarpeta = fabrica.getRutaCarpeta();
		this.sprite = new Sprite(rutaCarpeta + "/mario.png");
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
