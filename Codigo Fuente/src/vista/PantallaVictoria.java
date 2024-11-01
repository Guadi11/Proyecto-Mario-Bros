package vista;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class PantallaVictoria extends JPanel {
		
	 private static final long serialVersionUID = 1L;
	 private JLabel imagenVictoria;
	 private JButton botonAtras;
	 private JButton botonRanking;
     private ControladorPantallas controlador;

     
     
	 public PantallaVictoria(ControladorPantallas controlador) {
		 this.controlador = controlador;
	     this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
	     this.setLayout(null);
	 
	     agregarImagenFondo();
	     agregarBotonAtras();
         agregarBotonRanking();
	  }

	 protected void agregarImagenFondo() {
		 ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenvictoria.png"));
	     Image imagen = icon.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
         imagenVictoria = new JLabel(new ImageIcon(imagen));
         imagenVictoria.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
         this.add(imagenVictoria);
         
	 }

     protected void agregarBotonAtras() {
        botonAtras = new JButton("Atras");
        botonAtras.setBounds(300, ConstantesPantalla.panelAlto - 150, 200, 50);
	    botonAtras.setBackground(Color.BLACK); 
	    decorarBotones(botonAtras);
	    botonAtras.addActionListener(e -> controlador.mostrarPantallaInicial());
	    this.add(botonAtras);
	 }

     protected void agregarBotonRanking() {
	     botonRanking = new JButton("Ranking");
	     botonRanking.setBounds(300, ConstantesPantalla.panelAlto - 80, 250, 50);
         botonRanking.setBackground(Color.BLACK);
         decorarBotones(botonRanking);
         botonRanking.addActionListener(e -> controlador.mostrarPantallaRanking());
	     this.add(botonRanking);
     }

	 protected void decorarBotones(JButton boton) {
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
}



