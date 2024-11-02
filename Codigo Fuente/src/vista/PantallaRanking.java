package vista;

import javax.swing.*;

import archivos.TopRanking;
import archivos.Usuario;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;



public class PantallaRanking extends JPanel{

	    private static final long serialVersionUID = 1L;
	    protected JLabel tituloRanking;
	    protected JButton botonAtras;
	    protected JLabel imagenRanking;
	    protected ControladorPantallas controlador;
	    protected TopRanking topCinco;

	    public PantallaRanking(ControladorPantallas controlador, TopRanking ranking) {
	    	this.controlador = controlador;
	        this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
	        this.setLayout(null);
	        topCinco = ranking;
	        agregarImagenFondo();
	        agregarTituloRanking();
	        mostrarRanking();
	        agregarBotonAtras(controlador);
	    }
	    
	    private void agregarImagenFondo() {
	    	  ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenfondoranking.png"));
	          Image imagen = icon.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
	          imagenRanking = new JLabel(new ImageIcon(imagen));
	          imagenRanking.setBounds(0, -30, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
			
	          add(imagenRanking);
	    }

	    private void agregarTituloRanking() {
	        tituloRanking = new JLabel("Ranking");
	        tituloRanking.setHorizontalAlignment(SwingConstants.CENTER);
	        tituloRanking.setBounds(0, 20, ConstantesPantalla.panelAncho, 50);
	        decorarLabelsRanking(tituloRanking, null);
	        add(tituloRanking);
	    }

	    private void mostrarRanking() {
	        int yPosition = 100; //Posición inicial en y
	        int posicion = 1;
	        
	        for (Usuario e : topCinco.getLista()) {
	            JLabel jugadorLabel = new JLabel(posicion + ". " + e.getNombre() + " - " + e.getPuntajeTotal());
	            jugadorLabel.setBounds(100, yPosition, ConstantesPantalla.panelAncho - 200, 30);
	            decorarLabelsRanking(null, jugadorLabel);
	            this.add(jugadorLabel);
	            
	            yPosition += 40; 
	            posicion++; 
	        }
	    }

	    private void agregarBotonAtras(ControladorPantallas controlador) {
	        botonAtras = new JButton("Atras");
	        botonAtras.setBounds(300, ConstantesPantalla.panelAlto - 100, 150, 50);
	        botonAtras.setBackground(Color.BLACK);
	        decorarBotonRanking(botonAtras);
	        botonAtras.addActionListener(e -> controlador.mostrarPantallaInicial());
	        this.add(botonAtras);
	    }
	    
	    private void decorarLabelsRanking(JLabel tituloRanking, JLabel labelJugador) {
	    		Font marioFont = null;
	    		try {
	    			InputStream is = getClass().getResourceAsStream("/archivos/mario-font.ttf");
	    			marioFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(20f);
	    		} catch (FontFormatException | IOException e) {
	    			e.printStackTrace();
	    			//por si la fuente personalizada no se puede cargar
	    			marioFont = new Font("Arial", Font.BOLD, 20);
	    		}
	    		if(tituloRanking != null) {
	    			tituloRanking.setFont(marioFont);
	    			tituloRanking.setForeground(Color.WHITE);
	    		}
	    		
	    		if(labelJugador != null) {
	    		labelJugador.setFont(marioFont);
	    		labelJugador.setForeground(Color.WHITE);
	    		}
	   }
	    
	   private void decorarBotonRanking(JButton boton) {
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
	



