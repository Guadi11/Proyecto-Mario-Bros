package parseo;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Fondo;
import enemigos.*;
import powerUps.*;
import plataformas.*;
import juego.*;

public abstract class GameFactory {

	protected String rutaCarpeta;
	protected ControladorPartida controladorPartida;
	
	protected GameFactory(String ruta) {
		this.rutaCarpeta = ruta;
	}
	
	public void setControladorPartida(ControladorPartida partida) {
		this.controladorPartida = partida;
	}
	
	public Lakitu crearLakitu(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/lakitu1.png");
		Lakitu lakitu = new Lakitu(x, y, sprite);
		lakitu.setFabrica(this);
		lakitu.setControlador(controladorPartida);
		setearHitbox(lakitu, sprite);
		
		return null;
	}
	
	public Koopa crearKoopa(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/koopa1.png");
		Koopa koopa = new Koopa(x, y, sprite);
		setearHitbox(koopa, sprite);
		
		return koopa;
	}
	
	public Goomba crearGoomba(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/goomba1.png");
		Goomba goomba = new Goomba(x, y, sprite);
		setearHitbox(goomba, sprite);
		
		return goomba;
	}
	
	public Spiny crearSpiny(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/spiny1.png");
		Spiny spiny = new Spiny(x, y, sprite);
		setearHitbox(spiny, sprite);
		
		return spiny;
	}
	
	public Piranha crearPiranha(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/piranha1.png");
		Piranha piranha = new Piranha(x, y, sprite);
		setearHitbox(piranha, sprite);
		
		return piranha;
	}
	
	public Buzzy crearBuzzy(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/buzzy1.png");
		Buzzy buzzy = new Buzzy(x, y, sprite);
		setearHitbox(buzzy, sprite);
		
		return buzzy;
	}
	
	public SuperChampiñon crearSuperChampiñon(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/superChampiñon.png");
		SuperChampiñon superChamp = new SuperChampiñon(x, y, sprite);
		setearHitbox(superChamp, sprite);
		
		return superChamp;
	}
	
	public Estrella crearEstrella(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/estrella.png");
		Estrella estrella = new Estrella(x, y, sprite);
		setearHitbox(estrella, sprite);
		
		return estrella;
	}
	
	public ChampiñonVerde crearChampiñonVerde(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/champiñonVerde.png");
		ChampiñonVerde champVerde = new ChampiñonVerde(x, y, sprite);
		setearHitbox(champVerde, sprite);
		
		return champVerde;
	}
	
	public FlorDeFuego crearFlorDeFuego(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/florDeFuego.png");
		FlorDeFuego florFuego = new FlorDeFuego(x, y, sprite);
		setearHitbox(florFuego, sprite);
		
		return florFuego;
	}
	
	public Moneda crearMoneda(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/moneda.png");
		Moneda moneda = new Moneda(x, y, sprite);
		setearHitbox(moneda, sprite);
		
		return moneda;
	}
	
	public BolaDeFuego crearBolaDeFuego(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bolaDeFuego.png");
		BolaDeFuego bolaFuego = new BolaDeFuego(x, y, sprite);
		setearHitbox(bolaFuego, sprite);
		
		return bolaFuego;
	}
	
	public BloqueDePregunta crearBloqueDePregunta(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueDePregunta.png");
		BloqueDePregunta bloquePregunta = new BloqueDePregunta(x, y, sprite);
		setearHitbox(bloquePregunta, sprite);
		
		return bloquePregunta;
	}
	
	public LadrilloSolido crearLadrilloSolido(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/ladrilloSolido.png");
		LadrilloSolido ladrillo = new LadrilloSolido(x, y, sprite);
		setearHitbox(ladrillo, sprite);
		
		return ladrillo;
	}
	
	public Vacio crearVacio(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/vacio.png");
		Vacio vacio = new Vacio(x, y, sprite);
		setearHitbox(vacio, sprite);
		
		return vacio;
	}
	
	public Tuberia crearTuberias(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/tuberia.png");
		Tuberia tuberia = new Tuberia(x, y, sprite);
		tuberia.setFabrica(this);
		tuberia.setControlador(controladorPartida);
		setearHitbox(tuberia, sprite);
		
		return tuberia;
	}
	
	public BloqueSolido crearBloqueSolido(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueTransparente.png");
		BloqueSolido bloqueSolido = new BloqueSolido(x, y, sprite);
		setearHitbox(bloqueSolido, sprite);
		
		return bloqueSolido;
	}
	
	public Jugador crearJugador(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/mario.png");
		Jugador jugador = new Jugador(x, y, sprite);
		setearHitbox(jugador, sprite);
		
		return jugador;
	}
	
	private void setearHitbox(Elemento elem, Sprite sprite) {
		ImageIcon iconoImagen = new ImageIcon(sprite.getRutaImagen());
		Image imagenOriginal = iconoImagen.getImage();
		int ancho = imagenOriginal.getWidth(null);
		int alto = imagenOriginal.getHeight(null);
		elem.setHitbox(ancho, alto);
	}

	
}
