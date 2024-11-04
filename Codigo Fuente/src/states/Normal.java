package states;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import archivos.TipoSonidos;
import elementos.BolaDeFuego;
import juego.Jugador;


public class Normal extends State {
	
	protected Sprite sprite; 
	
	public Normal(Jugador jugador) {
		super(jugador);
		this.sprite = new Sprite("imagenes/modoUno/mario.png");
	}
	
	public void activar() {
		jugador.setState(this);
		jugador.getSprite().setSprite(this.sprite.getRutaImagen());
		//jugador.getSprite().setSprite("imagenes/modoUno/mario.png");
		actualizarMedidas();  /*
		System.out.println("altura hitbox izq normal: " + jugador.getBoundsLeft().height);
		System.out.println("ancho hitbox izq normal: " + jugador.getBoundsLeft().width);
		System.out.println("altura hitbox der normal: " + jugador.getBoundsRight().height);
		System.out.println("ancho hitbox der normal: " + jugador.getBoundsRight().width);
		System.out.println("altura hitbox top normal: " + jugador.getBoundsTop().height);
		System.out.println("ancho hitbox top normal: " + jugador.getBoundsTop().width);
		System.out.println("altura hitbox bot normal: " + jugador.getBoundsBottom().height);
		System.out.println("ancho hitbox bot normal: " + jugador.getBoundsBottom().width);  */
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
	
	public Sprite getSprite() { //este getSprite creo que no es llamado nunca
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

	@Override
	public void disparar() { //esto despues sacarlo de normal
		 lanzarBolaDeFuego();
	}

	 public void lanzarBolaDeFuego() {     //esto despues sacarlo de normal    
		 int posicionYBola = (int) (jugador.getPosY() - jugador.getHitbox().getHeight()/4);
		 BolaDeFuego nuevaBola = this.fabrica.crearBolaDeFuego(jugador.getPosX(), posicionYBola); //ver pos
		 controlador.getHiloEnemigo().registrarBolaDeFuego(nuevaBola);
		 controlador.registrarObserverElementoIndividual(nuevaBola);
		 nuevaBola.setNivel(jugador.getInfo().getNivel());
		 nuevaBola.setJugador(jugador);
	 }

	@Override
	public boolean esInvulnerable() {
		return false;
	}
	
}
