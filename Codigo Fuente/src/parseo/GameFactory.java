package parseo;

import java.awt.Image;

import javax.swing.ImageIcon;

import archivos.Sprite;
import elementos.BolaDeFuego;
import elementos.Elemento;
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
	
	public Jugador crearJugador(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/mario.png");
		Jugador jugador = new Jugador(x, y, sprite);
		setearHitbox(jugador, sprite);
		jugador.getState().setFabrica(this);
		jugador.getState().setControlador(controladorPartida);
		
		//System.out.println("Jugador hitbox right posYsuperior: " +  jugador.getBoundsRight().y + ". hitbox right extremo inferior: " + (jugador.getBoundsRight().y - jugador.getBoundsRight().height));
		return jugador;
	}
	
	//Enemigos
	public Lakitu crearLakitu(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/lakitu1.png");
		Lakitu lakitu = new Lakitu(x, y, sprite);
		lakitu.setFabrica(this);
		lakitu.setControlador(controladorPartida);
		setearHitbox(lakitu, sprite);
		
		return lakitu;
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
	
	//Power Ups
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
		Moneda moneda = new Moneda(x, y + 5, sprite); //+ 5 asi flota 
		setearHitbox(moneda, sprite);
		
		return moneda;
	}
	
	//Bola de Fuego
	public BolaDeFuego crearBolaDeFuego(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bolaDeFuego.png");
		BolaDeFuego bolaFuego = new BolaDeFuego(x, y, sprite);
		setearHitbox(bolaFuego, sprite);
		
		return bolaFuego;
	}
	
	//Plataformas
	public BloqueDePregunta crearBloqueDePregunta(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueDePregunta.png");
		BloqueDePregunta bloquePregunta = new BloqueDePregunta(x, y, sprite);
		setearHitbox(bloquePregunta, sprite);
		bloquePregunta.setFabrica(this);
		bloquePregunta.setControlador(controladorPartida);
		
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
	
	public Tuberia crearTuberia1(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/tuberia.png");
		Tuberia tuberia = new Tuberia(x, y, sprite);
		tuberia.setFabrica(this);
		tuberia.setControlador(controladorPartida);
		setearHitbox(tuberia, sprite);
		/*
		System.out.println("extremosuperior hitbox izquierdo tuberia: " + tuberia.getBoundsLeft().y);
		System.out.println("extremo inferior hitbox izquierdo tuberia: " + (tuberia.getBoundsLeft().y - tuberia.getBoundsLeft().height));
		
		System.out.println("alto hitbox izquierdo tuberia: " + tuberia.getBoundsLeft().height);
		System.out.println("ancho hitbox izquierdo tuberia: " + tuberia.getBoundsLeft().width);
		System.out.println("alto hitbox derecho tuberia: " + tuberia.getBoundsRight().height);
		System.out.println("ancho hitbox tuberia: " + tuberia.getBoundsRight().width);
		System.out.println("alto hitbox top tuberia: " + tuberia.getBoundsTop().height);
		System.out.println("ancho hitbox top tuberia: " + tuberia.getBoundsTop().width);
		System.out.println("alto hitbox bot tuberia: " + tuberia.getBoundsBottom().height);
		System.out.println("ancho hitbox bot tuberia: " + tuberia.getBoundsBottom().width); */
		//System.out.println("Tuberia 1, x: "+ tuberia.getHitbox().getX() + ". posY: " +  tuberia.getHitbox().getY() + ". Ancho: " + tuberia.getHitbox().getWidth() + ". Alto: " + tuberia.getHitbox().getHeight());
		
		return tuberia;
	}
	public Tuberia crearTuberia2(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/tuberia2.png");
		Tuberia tuberia = new Tuberia(x, y, sprite);
		tuberia.setFabrica(this);
		tuberia.setControlador(controladorPartida);
		setearHitbox(tuberia, sprite);
		//System.out.println("Tuberia 2, x: "+ tuberia.getHitbox().getX() + ". posY: " +  tuberia.getHitbox().getY() + ". Ancho: " + tuberia.getHitbox().getWidth() + ". Alto: " + tuberia.getHitbox().getHeight());
		
		return tuberia;
	}
	public Tuberia crearTuberia3(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/tuberia3.png");
		Tuberia tuberia = new Tuberia(x, y, sprite);
		tuberia.setFabrica(this);
		tuberia.setControlador(controladorPartida);
		setearHitbox(tuberia, sprite);
		//System.out.println("Tuberia 3, x: "+ tuberia.getHitbox().getX() + ". posY: " + tuberia.getHitbox().getY() + ". Ancho: " + tuberia.getHitbox().getWidth() + ". Alto: " + tuberia.getHitbox().getHeight());
		
		return tuberia;
	}
	
	public BloqueSolido crearBloqueTransparente(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueTransparente.png");
		BloqueSolido bloqueSolido = new BloqueSolido(x, y, sprite);
		setearHitbox(bloqueSolido, sprite);
		
		return bloqueSolido;
	}
	
	public BloqueSolido crearBloqueSolido(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueSolido.png");
		BloqueSolido bloqueSolido = new BloqueSolido(x, y, sprite);
		setearHitbox(bloqueSolido, sprite);
		
		return bloqueSolido;
	}
	
	public Castillo crearCastillo(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueTransparente.png");
		Castillo castillo = new Castillo(x, y, sprite);
		setearHitbox(castillo, sprite);
		
		return castillo;
	}
	
	private void setearHitbox(Elemento elem, Sprite sprite) {
		ImageIcon iconoImagen = new ImageIcon(sprite.getRutaImagen());
		Image imagen = iconoImagen.getImage();
		int ancho = imagen.getWidth(null);
		int alto = imagen.getHeight(null);
		elem.setHitbox(ancho, alto);
	}
	public String getRutaCarpeta() {
		return this.rutaCarpeta;
	}
	
}
