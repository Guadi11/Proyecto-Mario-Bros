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
	
	
	public ControladorPartida() {
		this.ranking = new Ranking();
		this.numNivelActual = 1;
	}
	
	public void iniciarPartida(GameFactory factory){
		this.fabrica = factory;
		fabrica.setControladorPartida(this);
		this.creadorNivel = new NivelBuilder(fabrica, numNivelActual);
		this.nivelActual = this.creadorNivel.getNivel();
		registrarObservers();
		colisiones = new ControladorColisiones(nivelActual);
		HiloJugador hiloJugador = new HiloJugador(this,colisiones); /*agrege el parametro colisiones y por ende su atributo*/
		hiloJugador.start();
	}
	
	private void registrarObservers() {
		registrarObserverJugador(this.nivelActual.getJugador());
		registrarObserversPlataformas(this.nivelActual.getPlataformas());
		registrarObserversEnemigos(this.nivelActual.getEnemigos());
	}
	
	private void registrarObserverJugador(Jugador player){
		Observer observerJugador = pantallas.registrarElemento(player);
		player.registrarObserver(observerJugador);
	}
	
	private void registrarObserversPlataformas(List<Plataforma> elem){
		for(Plataforma elemento : elem) {
			Observer observer = pantallas.registrarElemento(elemento);
			elemento.registrarObserver(observer);
		}
	}
	private void registrarObserversEnemigos(List<Enemigo> elem){
		for(Enemigo elemento : elem) {
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
	
	public void reiniciarNivel(){
		int monedas = this.nivelActual.getJugador().getMonedas();
		int puntaje = this.nivelActual.getJugador().getPuntaje();
		int vidas = this.nivelActual.getJugador().getVida();
		
		this.nivelActual = this.creadorNivel.getNivel();
		
		this.nivelActual.getJugador().getInfo().setMonedas(monedas);
		this.nivelActual.getJugador().getInfo().actualizarPuntaje(puntaje);
		this.nivelActual.getJugador().getInfo().setVidas(vidas);
		
		pantallas.reiniciarNivel();
		registrarObservers();
		HiloJugador hiloJugador = new HiloJugador(this,colisiones);
		hiloJugador.start();
		
	}
	
	public void gameOver(int puntajeFinal){
		this.pantallas.mostrarPantallaGameOver();
		this.nivelActual = null;
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
