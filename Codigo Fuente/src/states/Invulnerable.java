package states;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;
import parseo.GameFactory;


public class Invulnerable extends State{

	protected long tiempoActivacion;
	protected final long duracion = 6500;
	protected State estadoAnterior;
	protected Sprite spriteGrande, spriteNormal, sprite;
	protected Timer timer;


	public Invulnerable(Jugador jugador) {
		super(jugador);
		this.estadoAnterior = jugador.getState();
	}

	public void activar() {
		jugador.setState(this);
		if (estadoAnterior.esGrande()) {
			sprite = spriteGrande;
		} else {
			sprite = spriteNormal;
		}
		jugador.getSprite().setSprite(sprite.getRutaImagen());
		this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().detenerLoop();
		this.jugador.getInfo().getNivel().getControladorPartida().getControladorSonidos().detenerSonidoJuego(TipoSonidos.speedBackground);
		this.controladorSonidosAccion.reproducirSonido(TipoSonidos.agarroEstrella);
		iniciarTemporizador();
		actualizarMedidas();
	}

	private void actualizarMedidas() {
		ImageIcon iconoImagen = new ImageIcon(sprite.getRutaImagen());
		Image imagen = iconoImagen.getImage();
		int ancho = imagen.getWidth(null);
		int alto = imagen.getHeight(null);
		int posY = (int) (jugador.getPosY() + (alto - jugador.getHitbox().getHeight()));

		this.jugador.getHitbox().setBounds(jugador.getPosX(), posY, ancho, alto);
	}

	public void reproducirSonidoSalto() {
		estadoAnterior.reproducirSonidoSalto();
	}

	private void iniciarTemporizador() {
		timer = new Timer((int) duracion, e -> { 
			this.controladorSonidosAccion.detenerSonido(TipoSonidos.agarroEstrella);

			// Verificar si es necesario reactivar speedBackground
			if (this.jugador.getInfo().getNivel().getControladorPartida().getControladorPantallas().getTiempoRestante() <= 60) {
				this.jugador.getInfo().getNivel().getControladorPartida().getControladorSonidos().reproducirSonidoJuego(TipoSonidos.speedBackground);
			}

			// Reactivar el sonido de fondo si corresponde
			if (!this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().enEjecucion()) {
				this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().renaudar();
			}

			estadoAnterior.activar();
			this.timer.stop();
		});
		timer.setRepeats(false); // Asegurarse de que solo se ejecute una vez
		timer.start();
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
	}

	public void actualizar() {
		long ahora = System.currentTimeMillis();
		if ((ahora - tiempoActivacion) >= duracion) {
			this.estadoAnterior.activar();
		}
	}

	public void recibirDaño() {
		// No recibe daño.
	}

	public int obtenerPuntosEstrella() {
		return 35;
	}

	public int obtenerPuntosSChamp() {
		return estadoAnterior.obtenerPuntosSChamp();
	}

	public int obtenerPuntosFFuego() {
		return estadoAnterior.obtenerPuntosFFuego();
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public boolean esGrande() {
		return false;
	}

	@Override
	public void disparar() {	
	}

	@Override
	public boolean esInvulnerable() {
		return true;
	}

	@Override
	public void setFabrica(GameFactory factory) {
		this.fabrica = factory;
		this.rutaCarpeta = fabrica.getRutaCarpeta();
		this.spriteGrande = new Sprite(rutaCarpeta + "/invulnerable.png"); 
		this.spriteNormal = new Sprite(rutaCarpeta + "/invulnerablemini.png");
		sprite = spriteGrande;
	}

	public void setAnterior(State anterior) {
		this.estadoAnterior = anterior;
	}

}
