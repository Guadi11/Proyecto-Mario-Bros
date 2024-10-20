package parseo;

import archivos.Sprite;
import elementos.BolaDeFuego;
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
		return null;
	}
	
	public Koopa crearKoopa(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/koopa1.png");
		Koopa koopa = new Koopa(x, y, sprite);
		return koopa;
	}
	
	public Goomba crearGoomba(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/goomba1.png");
		Goomba goomba = new Goomba(x, y, sprite);
		
		return goomba;
	}
	
	public Spiny crearSpiny(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/spiny1.png");
		Spiny spiny = new Spiny(x, y, sprite);
		
		return spiny;
	}
	
	public Piranha crearPiranha(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/piranha1.png");
		Piranha piranha = new Piranha(x, y, sprite);
		
		return piranha;
	}
	
	public Buzzy crearBuzzy(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/buzzy1.png");
		Buzzy buzzy = new Buzzy(x, y, sprite);
		
		return buzzy;
	}
	
	public SuperChampiñon crearSuperChampiñon(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/superChampiñon.png");
		SuperChampiñon superChamp = new SuperChampiñon(x, y, sprite);
		
		return superChamp;
	}
	
	public Estrella crearEstrella(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/estrella.png");
		Estrella estrella = new Estrella(x, y, sprite);
		
		return estrella;
	}
	
	public ChampiñonVerde crearChampiñonVerde(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/champiñonVerde.png");
		ChampiñonVerde champVerde = new ChampiñonVerde(x, y, sprite);
		
		return champVerde;
	}
	
	public FlorDeFuego crearFlorDeFuego(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/florDeFuego.png");
		FlorDeFuego florFuego = new FlorDeFuego(x, y, sprite);
		
		return florFuego;
	}
	
	public Moneda crearMoneda(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/moneda.png");
		Moneda moneda = new Moneda(x, y, sprite);
		
		return moneda;
	}
	
	public BolaDeFuego crearBolaDeFuego(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bolaDeFuego.png");
		BolaDeFuego bolaFuego = new BolaDeFuego(x, y, sprite);
		
		return bolaFuego;
	}
	
	public BloqueDePregunta crearBloqueDePregunta(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueDePregunta.png");
		BloqueDePregunta bloquePregunta = new BloqueDePregunta(x, y, sprite);
		
		return bloquePregunta;
	}
	
	public LadrilloSolido crearLadrilloSolido(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/ladrilloSolido.png");
		LadrilloSolido ladrillo = new LadrilloSolido(x, y, sprite);
		
		return ladrillo;
	}
	
	public Vacio crearVacio(int x, int y) {
		Vacio vacio = new Vacio(x, y, null);
		
		return vacio;
	}
	
	public Tuberia crearTuberias(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/tuberia.png");
		Tuberia tuberia = new Tuberia(x, y, sprite);
		
		return tuberia;
	}
	
	public BloqueSolido crearBloqueSolido(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/bloqueSolido.png");
		BloqueSolido bloqueSolido = new BloqueSolido(x, y, sprite);
		
		return bloqueSolido;
	}
	
	public Jugador crearJugador(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/mario.png");
		Jugador jugador = new Jugador(x, y, sprite);
		
		return jugador;
	}
	
	public Fondo crearFondo(int x, int y) {
		Sprite sprite = new Sprite(rutaCarpeta + "/background.png");
		Fondo fondo = new Fondo(x, y, sprite);
		
		return fondo;
	}
	
	
	
	
	
}
