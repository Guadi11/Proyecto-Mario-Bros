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


public class PantallaTimeUp extends JPanel{
	

	private static final long serialVersionUID = 1L;
	protected JLabel imagenGameOver;
	protected JLabel imagenTimeUp;
	protected ControladorPantallas controlador;
	protected JButton botonRanking;
	protected Timer timer;
	
	
	public PantallaTimeUp(ControladorPantallas controlador) {
		this.controlador = controlador;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
        this.setLayout(null);
        
        agregarImagenTimeUp();
        agregarBotonRanking();
		
	}
	
	public void iniciarTemporizador() {
		 //mostrar pantalla por 5 segundos
		iniciarTemporizador(5000);
	}
	
	protected void agregarImagenTimeUp() {
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/imagentimeup.png"));
		Image imagen2 = icon2.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
		imagenTimeUp = new JLabel(new ImageIcon(imagen2));
		imagenTimeUp.setBounds(0, -40, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
		
		add(imagenTimeUp);

	}
	
	 protected void agregarBotonRanking() {
	     botonRanking = new JButton("Ranking");
	     botonRanking.setBounds(300, ConstantesPantalla.panelAlto - 100, 200, 50);
         botonRanking.setBackground(Color.BLACK);
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
                 timer.stop(); // Detener el temporizador una vez que haya terminado
             }
         });
         timer.setRepeats(false); // Asegurarse de que solo se ejecute una vez
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
