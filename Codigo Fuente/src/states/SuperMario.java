package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;
import parseo.GameFactory;


public class SuperMario extends State{

	protected Sprite sprite;
	protected long tiempoActivacion;

	public SuperMario(Jugador jugador) {
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
		this.jugador.getHitbox().setBounds(jugador.getPosX(), posY-30, ancho, alto);
	}

	public void recibirDaño() {
		this.getNormal().activar();
	}

	public void reproducirSonidoSalto() {
		controladorSonidosAccion.reproducirSonido(TipoSonidos.saltaSuperMario);
	}

	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}

	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
		this.getFuego().setControlador(controlador);
		this.getFuego().setFabrica(fabrica);
		this.getFuego().activar();
	}

	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
		this.getInvulnerable().setControlador(controlador);
		this.getInvulnerable().setFabrica(fabrica);
		this.getInvulnerable().setAnterior(this);
		this.getInvulnerable().activar();
	}

	public int obtenerPuntosEstrella() {
		return 30;
	}

	public int obtenerPuntosSChamp() {
		return 50;
	}

	public int obtenerPuntosFFuego() {
		return 30;
	}

	public boolean esGrande() {
		return true;
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
		this.sprite = new Sprite(rutaCarpeta + "/supermario.png");
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
