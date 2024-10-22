package juego;

import java.awt.event.KeyEvent;
import java.util.List;

import parseo.*;
import archivos.Ranking;
import colisiones.ControladorColisiones;
import elementos.*;
import observers.Observer;
import observers.ObserverGrafico;
import vista.ControladorEntreJuegoVista;

public class ControladorPartida {

	protected ControladorEntreJuegoVista pantallas;
	protected NivelBuilder creadorNivel;
	protected GameFactory fabrica;
	protected Ranking ranking;
	protected Nivel nivelActual;
	protected float timerNivel; 
	protected String nombreJugador;
	protected int numNivelActual;
	protected ControladorColisiones colisiones;
	protected HiloJugador hiloJugador;
	protected HiloEnemigo hiloEnemigo;
	
	
	public ControladorPartida() {
		this.ranking = new Ranking();
		this.numNivelActual = 1;
	}
	
	public void iniciarPartida(GameFactory factory){
		this.fabrica = factory;
		fabrica.setControladorPartida(this);
		this.creadorNivel = new NivelBuilder(fabrica, numNivelActual);
		this.nivelActual = this.creadorNivel.getNivel();
		nivelActual.setControladorPartida(this);
		registrarObservers();
		colisiones = new ControladorColisiones(nivelActual);
		hiloJugador = new HiloJugador(this,colisiones); /*agrege el parametro colisiones y por ende su atributo*/
		hiloJugador.start();
		hiloEnemigo = new HiloEnemigo(this);
		//hiloEnemigo.start();
		
	}
	
	public void reiniciarNivel(){
		hiloJugador.detener();
		int monedas = this.nivelActual.getJugador().getMonedas();
		int puntaje = this.nivelActual.getJugador().getPuntaje();
		int vidas = this.nivelActual.getJugador().getVida();
		
		pantallas.reiniciarNivel();
		iniciarPartida(this.fabrica);
		
		this.nivelActual.getJugador().getInfo().setMonedas(monedas);
		this.nivelActual.getJugador().getInfo().actualizarPuntaje(puntaje);
		this.nivelActual.getJugador().getInfo().setVidas(vidas);	
	}
	
	private void registrarObservers() {
		registrarObserverJugador(this.nivelActual.getJugador());
		registrarObserversPlataformas(this.nivelActual.getPlataformas());
		registrarObserversEnemigos(this.nivelActual.getEnemigos());
		// observers provisorios para el testeo de power ups
		registrarObserversPowerUps(this.nivelActual.getPowerUps());
	}
	
	private void registrarObserversPowerUps(List<PowerUp> powerUps) {
		for(PowerUp elemento : powerUps) {
			Observer observer = pantallas.registrarElemento(elemento);
			elemento.registrarObserver(observer);
		}
	}
	
	private void registrarObserverJugador(Jugador player){
		Observer observerJugador = pantallas.registrarElemento(player);
		player.registrarObserver(observerJugador);
	}
	
	private void registrarObserversPlataformas(List<Plataforma> plataforma){
		for(Plataforma elemento : plataforma) {
			Observer observer = pantallas.registrarElemento(elemento);
			elemento.registrarObserver(observer);
		}
	}
	private void registrarObserversEnemigos(List<Enemigo> enem){
		for(Enemigo elemento : enem) {
			Observer observer = pantallas.registrarElemento(elemento);
			elemento.registrarObserver(observer);
		}
	}
	
	public void registrarObserverElementoIndividual(Elemento elem){
		//sirve para spinys, piranha, power ups
			Observer observer = pantallas.registrarElemento(elem);
			elem.registrarObserver(observer);
	}
	
	public void removerObserver(ObserverGrafico observer) {
		this.pantallas.removerObserver(observer);
	}

	public void iniciarNivel(Nivel nivel){
		//TODO
	}
	
	public void siguienteNivel(){
		//TODO
	}
	
	public void gameOver(int puntajeFinal){
		hiloJugador.detener();
		this.pantallas.mostrarPantallaGameOver();
		//this.nivelActual = null;
	}
	
	public void victoria(int puntajeFinal) {
		//TODO
	}
	
	public void timeOut() {
		//TODO
	}
	
	public void notificarNuevoFrame() {
		//TODO
	}
	//Setters
	public void setControladorPantallas(ControladorEntreJuegoVista controlador){
		this.pantallas = controlador;
	}
	
	public void setNombreJugador(String nombre){
		this.nombreJugador = nombre;
	}
	
	
	//getters
	public Ranking getRanking(){
		return this.ranking;
	}
	
	public int getNumNivel() {
		return this.numNivelActual;
	}
	
	public void activeMovement(KeyEvent e) {
		int tecla = e.getKeyCode();
    	
	    switch (tecla) {
	        case KeyEvent.VK_LEFT:
	            nivelActual.getJugador().moverIzquierda();
	            break;
	        case KeyEvent.VK_RIGHT:
	        	nivelActual.getJugador().moverDerecha();
	            break;
	        case KeyEvent.VK_UP:
	        	nivelActual.getJugador().saltar();
	            break;
	    }
	}
	public void desactiveMovement (KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) {
	        nivelActual.getJugador().frenarMovimiento(); // Detiene el movimiento al soltar las teclas
		}

	}
	public Nivel getNivelActual() {
		return nivelActual;
	}
}
