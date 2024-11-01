package juego;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Timer;

import parseo.*;
import archivos.ControladorSonidos;
import archivos.Ranking;
import archivos.TipoSonidos;
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
	protected String nombreJugador;
	protected int numNivelActual;
	protected ControladorColisiones colisiones;
	protected HiloJugador hiloJugador;
	protected HiloEnemigo hiloEnemigo;
	protected HiloSonido hiloSonido;
	protected ControladorSonidos controladorSonido;
	
	
	public ControladorPartida() {
		this.ranking = new Ranking();
		this.numNivelActual = 1;
	}
	
	public void iniciarPartida(GameFactory factory, int numeroNivel){
		this.fabrica = factory;
		fabrica.setControladorPartida(this);
		this.creadorNivel = new NivelBuilder(fabrica, numeroNivel);
		this.nivelActual = this.creadorNivel.getNivel();
		nivelActual.setControladorPartida(this);
		registrarObservers();
		
		colisiones = new ControladorColisiones(nivelActual);
		
		hiloJugador = new HiloJugador(this,colisiones); /*agregue el parametro colisiones y por ende su atributo*/
		hiloJugador.start();
		hiloEnemigo = new HiloEnemigo(this, colisiones);
		hiloEnemigo.start();
		hiloSonido = new HiloSonido();
		hiloSonido.start();
		controladorSonido= new ControladorSonidos();
		
	}
	
	public void reiniciarNivel(){
		hiloSonido.detener();
		hiloJugador.detener();
		hiloEnemigo.detener();
		controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteMario);
		
		if (pantallas.getTimerNivel()!=null) {
			pantallas.getTimerNivel().stop();
		}
		Timer delayTimer = new Timer(2000, e -> {
		int monedas = this.nivelActual.getJugador().getMonedas();
		int puntaje = this.nivelActual.getJugador().getPuntaje();
		int vidas = this.nivelActual.getJugador().getVida();
		
		pantallas.reiniciarNivel();
		iniciarPartida(this.fabrica, numNivelActual);
		
		this.nivelActual.getJugador().getInfo().setMonedas(monedas);
		this.nivelActual.getJugador().getInfo().actualizarPuntaje(puntaje);
		this.nivelActual.getJugador().getInfo().setVidas(vidas);	
	});
		delayTimer.setRepeats(false); // Para que el temporizador solo ejecute una vez
	    delayTimer.start();
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
		if(numNivelActual < 3) {
			numNivelActual++;
			hiloSonido.detener();
			hiloJugador.detener();
			hiloEnemigo.detener();
			controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteMario); 
			
			if (pantallas.getTimerNivel()!=null) {
				pantallas.getTimerNivel().stop();
			}
			Timer delayTimer = new Timer(2000, e -> {
			int monedas = this.nivelActual.getJugador().getMonedas();
			int puntaje = this.nivelActual.getJugador().getPuntaje();
			int vidas = this.nivelActual.getJugador().getVida();
			
			pantallas.reiniciarNivel();
			iniciarPartida(this.fabrica, numNivelActual);
			
			this.nivelActual.getJugador().getInfo().setMonedas(monedas);
			this.nivelActual.getJugador().getInfo().actualizarPuntaje(puntaje);
			this.nivelActual.getJugador().getInfo().setVidas(vidas);	
		});
			delayTimer.setRepeats(false); // Para que el temporizador solo ejecute una vez
		    delayTimer.start();
			
		}else {
			//victoria();
		}
		/* reproducir sonido de victoria()
		if(numNivelActual < 3) {
			numNivelActual++;
			reiniciarNivel();
		}else {
			victoria();
		} */
		
	}
	
	public void gameOver(int puntajeFinal){
		hiloJugador.detener();
		hiloEnemigo.detener();
		hiloSonido.detener();
		controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteMario);
		this.pantallas.mostrarPantallaGameOver();
		//this.nivelActual = null;
	}
	
	public void victoria(int puntajeFinal) {
		controladorSonido.reproducirSonidoJuego(TipoSonidos.finNivel);
	}
	
	public void timeOut() {
		//hiloSonido.detener();
		controladorSonido.detenerSonidoJuego(TipoSonidos.advertenciaTiempo);
		this.pantallas.mostrarPantallaTimeUp();
		this.reiniciarNivel();
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

	
	public String getNombreJugador() {
		return nombreJugador;
	}
	
	public void guardarNombreJugador(String nombre) {
		this.nombreJugador = nombre;
		System.out.println("Nombre guardado : " + nombreJugador);
	}

	public ControladorSonidos getControladorSonidos() {
		return controladorSonido;
	}
	public HiloSonido getHiloSonido() {
		return hiloSonido;
	}

	/*public void musicaEstrella() {
		hiloSonido.detener();
		this.
		controladorSonido.reproducirSonidoAccion(TipoSonidos.agarroEstrella);
	}*/

}
