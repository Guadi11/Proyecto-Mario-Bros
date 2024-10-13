package vista;

import javax.swing.JFrame;

import elementos.ElementoJugador;
import elementos.ElementoLogico;
import juego.ControladorPartida;
import juego.GameFactory;
import observers.Observer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorPantallas implements ControladorDePantallas, ControladorEntreJuegoVista{

	protected JFrame ventana;
	protected PantallaInicio panelInicio;
	protected PantallaSeleccionModo panelSeleccion;
	protected PantallaRanking panelRanking;
	protected PantallaJuego panelJuego;
	protected PantallaGameOver panelGameOver;
	protected ControladorPartida partida;
	
	public ControladorPantallas(ControladorPartida controladorPartida) {
		this.partida = controladorPartida;
		panelInicio = new PantallaInicio();
		panelSeleccion = new PantallaSeleccionModo();
		panelRanking = new PantallaRanking();
		panelJuego = new PantallaJuego(this);
		panelGameOver = new PantallaGameOver();
		configurarVentana();
		//registrarOyenteVentana();
	}
	
	/* este lo hizo el profe no se si es necesario
	private void registrarOyenteVentana() {
		// TODO Auto-generated method stub
		
	}
	*/


	private void configurarVentana() {
		// TODO Auto-generated method stub
		ventana = new JFrame("Super Mario Bros");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesPantalla.ventanaAncho, ConstantesPantalla.ventanaAlto);
		ventana.setVisible(true);
	
	}

	public void mostrarPantallaInicial() {
		ventana.setContentPane(panelInicio);
		refrescar();
	}
	
	public ControladorPartida getControladorPartida() {
		return this.partida;
	}

	private void refrescar() {
		ventana.revalidate();
		ventana.repaint();
	}

	@Override
	public void mostrarPantallaJuego() {
		ventana.setContentPane(panelJuego);
		refrescar();
		
	}

	@Override
	public void mostrarPantallaSelecion() {
		ventana.setContentPane(panelSeleccion);
		refrescar();
		
	}

	public void registrarOyenteVentana(){
	        ventana.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent evento){
	                System.out.println("Se cerró la ventana");
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
		Observer observerJugador = this.panelJuego.incorporarElementoJugador(jugador);
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

}
