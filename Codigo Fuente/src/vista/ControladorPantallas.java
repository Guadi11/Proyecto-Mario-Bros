package vista;


import javax.swing.JFrame;
import javax.swing.Timer;

import elementos.ElementoJugador;
import elementos.ElementoLogico;
import juego.ControladorPartida;
import parseo.GameFactory;
import parseo.ModoUnoFactory;
import observers.Observer;
import observers.ObserverGrafico;
import observers.ObserverJugador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ControladorPantallas implements ControladorDePantallas, ControladorEntreJuegoVista{

	protected JFrame ventana;
	protected PantallaInicio panelInicio;
	protected PantallaSeleccionModo panelSeleccion;
	protected PantallaRanking panelRanking;
	protected PantallaJuego panelJuego;
	protected PantallaFinal panelFinal;
	protected PantallaNombre panelNombre;
	protected ControladorPartida partida;

	
	public ControladorPantallas(ControladorPartida controladorPartida) {
		this.partida = controladorPartida;
		ConfigurarFuente.cargarFuente();
		panelInicio = new PantallaInicio(this);
		panelSeleccion = new PantallaSeleccionModo(this);
		panelRanking = new PantallaRanking(this, null);
		panelJuego = new PantallaJuego(this);
		panelFinal = new PantallaFinal(this);
		panelNombre = new PantallaNombre(this,partida);
		
		configurarVentana();
		registrarOyenteVentana();
	}

	private void configurarVentana() {
		ventana = new JFrame("Super Mario Bros");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesPantalla.ventanaAncho, ConstantesPantalla.ventanaAlto);
		ventana.setVisible(true);
	}

	
	public ControladorPartida getControladorPartida() {
		return this.partida;
	}

	private void refrescar() {
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void mostrarPantallaInicial() {
		ventana.setContentPane(panelInicio);
		refrescar();
	}
	
	@Override
	public void mostrarPantallaJuego() {
		ventana.setContentPane(panelJuego);
		GameFactory modoUno = new ModoUnoFactory(); //Editar luego cuando tengamos los dos modos funcionando
		accionarInicioJuego(modoUno);
		refrescar();
	}
	
	public void mostrarPantallaRanking() {
		ventana.setContentPane(panelRanking);
		refrescar();
	}
	
	public void mostrarPantallaNombre() {
		ventana.setContentPane(panelNombre);
		refrescar();
	}

	@Override
	public void mostrarPantallaSeleccion() {
		ventana.setContentPane(panelSeleccion);
		refrescar();
	}

	public void registrarOyenteVentana(){
	        ventana.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent evento){
	                
	            }
	        });
	}

	@Override
	public Observer registrarElemento(ElementoLogico elem) {
		Observer observerElemento = this.panelJuego.incorporarElemento(elem);
		refrescar();
		return observerElemento;
	}

	@Override
	public Observer registrarElemento(ElementoJugador jugador) {
		ObserverJugador observerJugador = this.panelJuego.incorporarElementoJugador(jugador);
		refrescar();
		return observerJugador;
	}

	@Override
	public void accionarPantallaRanking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionarPantallaSeleccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionarInicioJuego(GameFactory fabrica) {
		this.partida.iniciarPartida(fabrica);
	}

	@Override
	public void mostrarPantallaGameOver() {
		ventana.setContentPane(panelFinal);
		panelFinal.iniciarTemporizador();
		refrescar();
	}
	
	public void reiniciarNivel() {
		this.panelJuego = new PantallaJuego(this);
		ventana.setContentPane(panelJuego);
		refrescar();
	}
	
	public void removerObserver(ObserverGrafico observer) {
		this.panelJuego.removerElemento(observer);
	}
	public Timer getTimerNivel() {
		return panelJuego.timerNivel;
	}
}
