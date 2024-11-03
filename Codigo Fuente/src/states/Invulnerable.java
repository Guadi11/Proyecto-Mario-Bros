package states;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;


public class Invulnerable extends State{
	
	protected long tiempoActivacion;
	protected final long duracion = 6500;
	protected State estadoAnterior;
	protected Sprite spriteGrande, spriteNormal, spriteActual;
	protected Timer timer;
	
	
	public Invulnerable(Jugador jugador) {
		super(jugador);
		this.estadoAnterior = jugador.getState();
		this.spriteGrande = new Sprite("imagenes/modoUno/invulnerable.png"); //esta imagen esta mal, es chiquita
		this.spriteNormal = new Sprite("imagenes/modoUno/invulnerablemini.png");
		spriteActual = spriteGrande;
	}
	
	public void activar() {
		jugador.setState(this);
        if (estadoAnterior.esGrande()) {
        	spriteActual = spriteGrande;
        } else {
        	spriteActual = spriteNormal;
        }
        jugador.getSprite().setSprite(spriteActual.getRutaImagen());
        this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().detenerLoop();
        this.controladorSonidosAccion.reproducirSonido(TipoSonidos.agarroEstrella);
        iniciarTemporizador();
        actualizarMedidas();
    }
	
	private void actualizarMedidas() {
		ImageIcon iconoImagen = new ImageIcon(spriteActual.getRutaImagen());
		Image imagen = iconoImagen.getImage();
		int ancho = imagen.getWidth(null);
		int alto = imagen.getHeight(null);
		int posY = (int) (jugador.getPosY() + (alto - jugador.getHitbox().getHeight()));
		
		//this.jugador.setPosY(posY);
		this.jugador.getHitbox().setBounds(jugador.getPosX(), posY, ancho, alto);
	}
	
	public void setAnterior(State anterior) {
		this.estadoAnterior = anterior;
	}
	
	public void reproducirSonidoSalto() {
		estadoAnterior.reproducirSonidoSalto();
	}
	
	public Sprite getSprite() {//este getSprite creo que no es llamado nunca
		return this.getSprite();
	}
	
	private void iniciarTemporizador() {
        timer = new Timer((int) duracion,e -> { 
            	this.controladorSonidosAccion.detenerSonido(TipoSonidos.agarroEstrella);
                if (!this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().enEjecucion()) {
                    this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().reanudar();
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
		this.estadoAnterior.activar();
		this.controladorSonidosAccion.detenerSonido(TipoSonidos.agarroEstrella);
		this.jugador.getInfo().getNivel().getControladorPartida().getHiloSonido().reanudar();
		//en algun lugar se esta llamando erroneamente a jugador.getInfo().recibirDaño() y reinicia cuando no deberia
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

}
