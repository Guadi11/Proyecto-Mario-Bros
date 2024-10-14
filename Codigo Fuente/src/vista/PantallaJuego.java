package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import elementos.ElementoJugador;
import elementos.ElementoLogico;
import observers.Observer;
import observers.ObserverElementos;
import observers.ObserverJugador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import juego.ControladorPartida;

public class PantallaJuego extends JPanel implements KeyListener{

	protected JPanel panelJuego;
	protected JPanel panelInformacion;
	protected JLabel imagenFondoJuego;
	protected JLabel imagenFondoInfo; //no sirve mas, es solo color negro
	protected JScrollPane panelScroll;
	protected JLabel labelPuntaje;
	protected JLabel labelMonedas;
	protected JLabel labelTiempo;
	protected JLabel labelVidas;
	protected JLabel labelNivelActual;
	protected ControladorPartida manager; //quizas cambiar nombre al atributo
	protected ControladorPantallas controlador;
	protected float timerNivel; //???
	
	public PantallaJuego(ControladorPantallas controladorPantalla, ControladorPartida manager) {
		this.manager = manager;
		this.controlador = controladorPantalla;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
		this.setLayout(new BorderLayout());;
		agregarPanelInformacion();
		agregarPanelJuego();
		 this.setFocusable(true);
	     this.addKeyListener(this);
		
	}

	private void agregarPanelJuego() {
		imagenFondoJuego = new JLabel();
		imagenFondoJuego.setLayout(null);
		imagenFondoJuego.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto);
		
		panelJuego = new JPanel(null);
		panelJuego.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto));
		panelJuego.add(imagenFondoJuego);
		
		panelScroll = new JScrollPane(panelJuego);
		panelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScroll.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto);
		
		this.add(panelScroll, BorderLayout.CENTER);
		
	}

	private void agregarPanelInformacion() {
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelInformacionAlto));
		panelInformacion.setBackground(Color.BLACK);
		panelInformacion.setOpaque(true);
		//agregarImagenFondoPanelInfo();
		agregarLabelsInfo();
		this.add(panelInformacion, BorderLayout.NORTH);
		
	}

	private void agregarLabelsInfo() {
		labelPuntaje = new JLabel("000000");
		labelMonedas = new JLabel("00");
		labelTiempo = new JLabel("400");
		labelVidas = new JLabel("3");
		labelNivelActual = new JLabel("1");
		
		decorarLabelsInfo();
		
		panelInformacion.add(labelPuntaje);
		panelInformacion.add(labelMonedas);
		panelInformacion.add(labelTiempo);
		panelInformacion.add(labelVidas);
		panelInformacion.add(labelNivelActual);
		
	}

	private void decorarLabelsInfo() {
		labelPuntaje.setBounds(5, 10, 150, 40);
		labelMonedas.setBounds(165, 10, 150, 40);
		labelTiempo.setBounds(325, 10, 150, 40);
		labelVidas.setBounds(485, 10, 150, 40);
		labelNivelActual.setBounds(645, 10, 150, 40);
		
		labelPuntaje.setForeground(Color.WHITE);
		labelMonedas.setForeground(Color.WHITE);
		labelTiempo.setForeground(Color.WHITE);
		labelVidas.setForeground(Color.WHITE);
		labelNivelActual.setForeground(Color.WHITE);
		
		labelPuntaje.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
		labelMonedas.setFont(new Font(labelMonedas.getFont().getName(), Font.BOLD, 24));
		labelTiempo.setFont(new Font(labelTiempo.getFont().getName(), Font.BOLD, 24));
		labelVidas.setFont(new Font(labelVidas.getFont().getName(), Font.BOLD, 24));
		labelNivelActual.setFont(new Font(labelNivelActual.getFont().getName(), Font.BOLD, 24));
	}
	
	//agregarImagenFondo o incorporarMapa si hacemos el fondo con observers y todo
	
	
	public Observer incorporarElemento(ElementoLogico elem) {
		ObserverElementos observerElemento = new ObserverElementos(elem);
		imagenFondoJuego.add(observerElemento);
		
		return observerElemento;
	}
	
	public Observer incorporarElementoJugador(ElementoJugador player) {
		ObserverJugador observerJugador = new ObserverJugador(this, player);
		imagenFondoJuego.add(observerJugador);
		actualizarInfoJugador(player);
		
		return observerJugador;
		
	}

	private void actualizarInfoJugador(ElementoJugador player) {
		actualizarLabelsJugador(player);
		actualizarScroll(player);
		
	}

	private void actualizarLabelsJugador(ElementoJugador player) {
		labelPuntaje.setText(textoConDigitos(player.getPuntaje(), 6));
		labelMonedas.setText(textoConDigitos(player.getMonedas(), 2));
		labelVidas.setText(textoConDigitos(player.getVida(), 1));
	}

	private String textoConDigitos(int num, int digitos) {
		String texto = Integer.toString(num);

	    // Calcula cuántos ceros hay que añadir
	    int cerosAAgregar = digitos - texto.length();
	   
	    if (cerosAAgregar > 0) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < cerosAAgregar; i++) {
	            sb.append('0');
	        }
	        sb.append(texto);
	        texto = sb.toString();
	    }

	    return texto;
	}
	
	public void actualizarScroll(ElementoJugador player) {
		// TODO
		panelScroll.getVerticalScrollBar().setValue(panelScroll.getVerticalScrollBar().getValue() + player.getVelocidad());
		
	}

	public void iniciarTimer() {
		//TODO
	}
	
	public void actualizarTimer() {
		//TODO
	}
	
	public void actualizarLabelsNivel() {
		//TODO
		
	}
	
    public void keyPressed(KeyEvent e) {
        manager.handleKeyPress(e);
    }

  
    public void keyReleased(KeyEvent e) {
        // Opcional: manejar la liberación de teclas
    }

    
    public void keyTyped(KeyEvent e) {
        // es para taclas especiales. generalmente no se usa para 
    }

	
	
	
	
}
