package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import elementos.ElementoJugador;
import elementos.ElementoLogico;
import observers.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PantallaJuego extends JPanel implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panelJuego;
	protected JPanel panelInformacion;
	protected JLabel imagenFondoJuego;
	protected JLabel imagenFondoInfo; //de momento es solo color negro
	protected JScrollPane panelScroll;
	protected JLabel labelPuntaje;
	protected JLabel labelMonedas;
	protected JLabel labelTiempo;
	protected JLabel labelVidas;
	protected JLabel labelNivelActual;
	protected ControladorPantallas controladorPantalla;
	protected float timerNivel; //???
	
	public PantallaJuego(ControladorPantallas controladorPantalla) {
		this.controladorPantalla = controladorPantalla;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
		this.setLayout(new BorderLayout());
		agregarPanelInformacion();
		agregarPanelJuego();
		 this.setFocusable(true);
		 this.addKeyListener(this);
		 this.requestFocusInWindow();  // Asegura que el panel recibe el foco
	}
	
	@Override
	public void addNotify() {
	    super.addNotify();
	    requestFocusInWindow();  // Asegura que el panel recibe el foco cuando es mostrado
	}

	private void agregarPanelJuego() {
		imagenFondoJuego = new JLabel();
		imagenFondoJuego.setLayout(null);
		imagenFondoJuego.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto);
		
		panelJuego = new JPanel(null);
		panelJuego.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto));
		
		agregarImagenFondo();
		panelJuego.add(imagenFondoJuego);
		
		panelJuego.setPreferredSize(new Dimension(imagenFondoJuego.getWidth(), imagenFondoJuego.getHeight()));
		
		panelScroll = new JScrollPane(panelJuego);
		panelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScroll.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelJuegoAlto);
		
		this.add(panelScroll, BorderLayout.CENTER);
	}
	
	private void agregarImagenFondo() {
		imagenFondoJuego = new JLabel();
		ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/imagenes/background.png"));
		
		Image imagenOriginal = iconoImagen.getImage();
		int anchoOriginal = imagenOriginal.getWidth(null);
		int altoOriginal = imagenOriginal.getHeight(null);
		int nuevoAlto = ConstantesPantalla.panelJuegoAlto;
		int nuevoAncho = (int) ((anchoOriginal / (double) altoOriginal) * nuevoAlto);
		
		Image imagenEscalada = iconoImagen.getImage().getScaledInstance(nuevoAncho, ConstantesPantalla.panelJuegoAlto,  Image.SCALE_SMOOTH);
		Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenFondoJuego.setIcon(iconoImagenEscalado);
		imagenFondoJuego.setBounds(0, 0, nuevoAncho, nuevoAlto);
		
	}
	 
	private void agregarPanelInformacion() {
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelInformacionAlto));
		panelInformacion.setBackground(Color.BLACK);
		panelInformacion.setOpaque(true);
		
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
	
	public Observer incorporarElemento(ElementoLogico elem) {
		ObserverElementos observerElemento = new ObserverElementos(elem);
		imagenFondoJuego.add(observerElemento);
		
		return observerElemento;
	}
	
	public ObserverJugador incorporarElementoJugador(ElementoJugador player) {
		ObserverJugador observerJugador = new ObserverJugador(this, player);
		imagenFondoJuego.add(observerJugador);
		actualizarInfoJugador(player);
		
		return observerJugador;
	}
	
	public void removerElemento(ObserverGrafico observer) {
	    imagenFondoJuego.remove(observer); // Remover el observer del JLabel
	    imagenFondoJuego.repaint(); // Asegurarse de actualizar la pantalla
	}

	public void actualizarInfoJugador(ElementoJugador player) {
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
	    int jugadorX = player.getPosX();

	    // Calcula el valor deseado del scroll para centrar al jugador
	    int nuevaPosScroll = jugadorX - (panelScroll.getViewport().getWidth() / 2);

	    // Se asegura de que el scroll no se mueva más allá de los límites
	    if (nuevaPosScroll < 0) {
	        nuevaPosScroll = 0;
	    } else if (nuevaPosScroll > panelJuego.getWidth() - panelScroll.getViewport().getWidth()) {
	        nuevaPosScroll = panelJuego.getWidth() - panelScroll.getViewport().getWidth();
	    }

	    panelScroll.getHorizontalScrollBar().setValue(nuevaPosScroll);
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
        controladorPantalla.getControladorPartida().activeMovement(e);
   
    }

  
    public void keyReleased(KeyEvent e) {
        controladorPantalla.getControladorPartida().desactiveMovement(e);
      
    }

    
    public void keyTyped(KeyEvent e) {
        // es para taclas especiales. Generalmente no se usa para juegos.
    }
    
   

	
	
	
	
}
