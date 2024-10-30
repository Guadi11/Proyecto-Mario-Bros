package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;


public class SuperMario extends State{
	
	protected Sprite sprite;
	protected long tiempoActivacion;
	protected final long duracion =6500;
	
	public SuperMario(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("imagenes/modoUno/supermario.png");
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite(this.sprite.getRutaImagen());
		actualizarMedidas(); /*
		System.out.println("altura hitbox izquierdo grande: " + jugador.getBoundsLeft().height);
		System.out.println("ancho hitbox izquierdo grande: " + jugador.getBoundsLeft().width);
		System.out.println("altura hitbox derecho grande: " + jugador.getBoundsRight().height);
		System.out.println("ancho hitbox derecho: " + jugador.getBoundsRight().width);
		System.out.println("altura hitbox top grande: " + jugador.getBoundsTop().height);
		System.out.println("ancho hitbox top grande: " + jugador.getBoundsTop().width);
		System.out.println("altura hitbox bot grande: " + jugador.getBoundsBottom().height);
		System.out.println("ancho hitbox bot grande: " + jugador.getBoundsBottom().width);  */
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
	
	public void recibirDaño() {
		this.getNormal().activar();
		//en algun lugar se esta llamando erroneamente a jugador.getInfo().recibirDaño() y reinicia cuando no deberia
	}
	
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
        	this.getNormal().activar();
        }
	}
	
	public void reproducirSonidoSalto() {
		controladorSonidosAccion.reproducirSonido(TipoSonidos.saltaSuperMario);
	}
	
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}
	
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
		this.getFuego().activar();
	}
	
	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
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
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
	
	public boolean esGrande() {
		return true;
	}

}
