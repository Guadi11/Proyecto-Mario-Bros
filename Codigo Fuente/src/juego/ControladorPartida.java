package juego;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Timer;

import parseo.*;
import archivos.ControladorSonidos;
import archivos.TipoSonidos;
import archivos.TopRanking;
import archivos.Usuario;
import colisiones.ControladorColisiones;
import elementos.*;
import observers.Observer;
import observers.ObserverGrafico;
import vista.ControladorEntreJuegoVista;

public class ControladorPartida {

	protected ControladorEntreJuegoVista pantallas;
	protected NivelBuilder creadorNivel;
	protected GameFactory fabrica;
	protected TopRanking ranking;
	protected Nivel nivelActual;
	protected int numNivelActual;
	protected ControladorColisiones colisiones;
	protected HiloJugador hiloJugador;
	protected HiloEnemigo hiloEnemigo;
	protected HiloSonido hiloSonido;
	protected ControladorSonidos controladorSonido;
	protected String nombreUsuario;
	
	
	public ControladorPartida(TopRanking r) {
		this.numNivelActual = 1;
		ranking = r;
	}
	
	public void iniciarPartida(GameFactory factory, int numeroNivel){
		this.fabrica = factory;
		fabrica.setControladorPartida(this);
		this.creadorNivel = new NivelBuilder(fabrica, numeroNivel);
		this.nivelActual = this.creadorNivel.getNivel();
		nivelActual.setControladorPartida(this);
		registrarObservers();
		
		colisiones = new ControladorColisiones(nivelActual);
		inicializarHilos(colisiones);
		controladorSonido= new ControladorSonidos();
		
	}
	private void inicializarHilos(ControladorColisiones colisiones) {
		hiloJugador = new HiloJugador(this,colisiones); /*agregue el parametro colisiones y por ende su atributo*/
		hiloJugador.start();
		hiloEnemigo = new HiloEnemigo(this, colisiones);
		hiloEnemigo.start();
		hiloSonido = new HiloSonido();
		hiloSonido.start();
	}
	public void reiniciarNivel(){
		detenerHilos();
		sonidoReinicio();
		timerParaReiniciar();
	}
	private void detenerHilos() {
		hiloSonido.detener();
		hiloJugador.detener();
		hiloEnemigo.detener();
	}
	private void sonidoReinicio() {
		controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteMario);
	}
	private void sonidoPaseNivel() {
		controladorSonido.reproducirSonidoJuego(TipoSonidos.finNivel);
		controladorSonido.reproducirSonidoJuego(TipoSonidos.fuegosArtificiales);
	}
	private void setAtributosInfoJugador(int monedas, int puntaje, int vidas) {
		this.nivelActual.getJugador().getInfo().setMonedas(monedas);
		this.nivelActual.getJugador().getInfo().actualizarPuntaje(puntaje);
		this.nivelActual.getJugador().getInfo().setVidas(vidas);	
		this.nivelActual.getJugador().getInfo().setNivel(nivelActual);
	}
	private void timerParaReiniciar() {
		if (pantallas.getTimerNivel()!=null) {
			pantallas.getTimerNivel().stop();
		}
		Timer delayTimer = new Timer(2000, e -> {
		int monedas = this.nivelActual.getJugador().getMonedas();
		int puntaje = this.nivelActual.getJugador().getPuntaje();
		int vidas = this.nivelActual.getJugador().getVida();
		reinicioPantallaYPartida();
		setAtributosInfoJugador(monedas, puntaje, vidas);
	});
		delayTimer.setRepeats(false); // Para que el temporizador solo ejecute una vez
	    delayTimer.start();
	}
	private void reinicioPantallaYPartida() {
		pantallas.reiniciarNivel();
		iniciarPartida(this.fabrica, numNivelActual);
		
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
	private void timerParaPasar() {
		if (pantallas.getTimerNivel()!=null) {
			pantallas.getTimerNivel().stop();
		}
		Timer delayTimer = new Timer(4500, e -> {
		int monedas = this.nivelActual.getJugador().getMonedas();
		int puntaje = this.nivelActual.getJugador().getPuntaje();
		int vidas = this.nivelActual.getJugador().getVida();
		resetPantallaYPartida();
		setAtributosInfoJugador(monedas, puntaje, vidas);
	});
		delayTimer.setRepeats(false); // Para que el temporizador solo ejecute una vez
	    delayTimer.start();
	}
	private void resetPantallaYPartida() {
		pantallas.pasarNivel();
		iniciarPartida(this.fabrica, numNivelActual);
		
	}
	public void siguienteNivel(){
		if(numNivelActual < 3) {
			numNivelActual++;
			detenerHilos();
			sonidoPaseNivel();
			timerParaPasar();
		}else {
			victoria();
		} 
	}
	
	public void gameOver(int puntajeFinal){
		hiloJugador.detener();
		hiloEnemigo.detener();
		hiloSonido.detener();
		controladorSonido.reproducirSonidoAccion(TipoSonidos.muerteMario);
		agregarUsuario();
		this.pantallas.mostrarPantallaGameOver();
		//this.nivelActual = null;
	}
	
	public void victoria() {
		controladorSonido.reproducirSonidoJuego(TipoSonidos.victoria);
		agregarUsuario();
		this.pantallas.mostrarPantallaVictoria();
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
		nombreUsuario = nombre;
	}
	
	
	//getters
	public TopRanking getRanking(){
		return this.ranking;
	}
	
	public int getNumNivel() {
		return this.numNivelActual;
	}
	
	public void activeMovement(KeyEvent e) {
		int tecla = e.getKeyCode();
    	
	    switch (tecla) {
	        case KeyEvent.VK_A: //KeyEvent.VK_LEFT
	            nivelActual.getJugador().moverIzquierda();
	            break;
	        case KeyEvent.VK_D: //KeyEvent.VK_RIGHT
	        	nivelActual.getJugador().moverDerecha();
	            break;
	        case KeyEvent.VK_W: // KeyEvent.VK_UP
	        	nivelActual.getJugador().saltar();
	            break;
	        case KeyEvent.VK_SPACE:
	        	nivelActual.getJugador().getState().disparar();
	    }
	}
	public void desactiveMovement (KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_A || tecla ==KeyEvent.VK_D) {
	        nivelActual.getJugador().frenarMovimiento(); // Detiene el movimiento al soltar las teclas
		}

	}
	public Nivel getNivelActual() {
		return nivelActual;
	}

	
	public String getNombreJugador() {
		return nombreUsuario;
	}
	public void agregarUsuario() { //crea el usuario y lo agrega a la lista con el top5.
		Usuario ingresado = new Usuario (nombreUsuario);
		ingresado.setPuntajeTotal(nivelActual.getJugador().getPuntaje());
		ranking.agregarJugador(ingresado);
		System.out.println("Ranking:  ");
		for (Usuario e:ranking.getLista())
			System.out.println("Usuario mostrado: "+e.getNombre());
	}
	public void guardarNombre(String nombre) {
		nombreUsuario = nombre;
	}

	public ControladorSonidos getControladorSonidos() {
		return controladorSonido;
	}
	public HiloSonido getHiloSonido() {
		return hiloSonido;
	}
	
	public HiloEnemigo getHiloEnemigo() {
		return hiloEnemigo;
	}

	/*public void musicaEstrella() {
		hiloSonido.detener();
		this.
		controladorSonido.reproducirSonidoAccion(TipoSonidos.agarroEstrella);
	}*/

}
