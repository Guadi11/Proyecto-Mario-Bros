package juego;

import java.util.List;

import archivos.Ranking;
import elementos.Elemento;
import observers.Observer;
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
	}
	
	private void registrarObservers() {
		// TODO Auto-generated method stub
		registrarObserverJugador(this.nivelActual.getJugador());
		registrarObserversElementos(this.nivelActual.getPlataformas());
		registrarObserversElementos(this.nivelActual.getEnemigos());
		//haria para los power ups pero no estan creados desde 0 o si??
	}
	
	private void registrarObserverJugador(Jugador player){
		Observer observerJugador = pantallas.registrarElemento(player);
		player.registrarObserver(observerJugador);
	}
	
	private void registrarObserversElementos(List<Elemento> elem){
		for(Elemento elemento : elem) {
			Observer observer = pantallas.registrarElemento(elemento);
			elemento.registrarObserver(observer);
		}
	}
	
	public void registrarObserverElementoIndividual(Elemento elem){
			Observer observer = pantallas.registrarElemento(elem);
			elem.registrarObserver(observer);
	}

	public void iniciarNivel(Nivel nivel){
		//TODO
	}
	
	public void siguienteNivel(){
		//TODO
	}
	
	public void reiniciarNivel(){
		//TODO
	}
	
	public void gameOver(int puntajeFinal){
		//TODO
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
	
}
