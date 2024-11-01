package vista;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class PantallaGameOver extends JPanel{
	

	private static final long serialVersionUID = 1L;
	protected JLabel imagenGameOver;
	protected JLabel imagenTimeUp;
	protected ControladorPantallas controlador;
	protected JButton botonRanking;
	private Timer timer;
	
	
	public PantallaGameOver(ControladorPantallas controlador) {
		this.controlador = controlador;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
        this.setLayout(null);
   
        agregarImagenGameOver();
        agregarBotonRanking();
		
	}
	
	public void iniciarTemporizador() {
		 //mostrar pantalla por 5 segundos
		iniciarTemporizador(5000);
	}
	
	protected void agregarImagenGameOver() {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/imagenes/imagenfondogameover.png"));
		Image imagen1 = icon1.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
        imagenGameOver = new JLabel(new ImageIcon(imagen1));
        imagenGameOver.setBounds(0, -40, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
 
        add(imagenGameOver);
  
	}
	
	
	 protected void agregarBotonRanking() {
	        botonRanking = new JButton("Ranking");
	        botonRanking.setBounds(300, ConstantesPantalla.panelAlto - 100, 200, 50);
	        botonRanking.setBackground(Color.BLACK);
	        botonRanking.setFocusPainted(false);      
	        botonRanking.setOpaque(true);             
	        botonRanking.setBorderPainted(false); 
	        decorarBotonRanking(botonRanking);
	        botonRanking.addActionListener(e -> {
	            detenerTemporizador(); //detener el temporizador al hacer clic en ranking
	            controlador.mostrarPantallaRanking();
	        });
	        add(botonRanking);
	 }
	
	
	 protected void decorarBotonRanking(JButton boton) {
	        Font marioFont = null;
	        try {
	            InputStream is = getClass().getResourceAsStream("/archivos/mario-font.ttf");
	            marioFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(20f);
	        } catch (FontFormatException | IOException e) {
	            e.printStackTrace();
	            marioFont = new Font("Arial", Font.BOLD, 20);
	        }

	        boton.setFont(marioFont);
	        boton.setForeground(Color.WHITE);
	 }
	 
	 protected void iniciarTemporizador(int delay) {
         timer = new Timer(delay, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 finalizarPantalla();
                 timer.stop(); 
             }
         });
         timer.setRepeats(false); 
         timer.start();
     }
	 
	 protected void detenerTemporizador() {
	        if (timer != null) {
	            timer.stop();
	        }
	 }
	
	 protected void finalizarPantalla() {
	 	controlador.mostrarPantallaInicial();
	 }

}
