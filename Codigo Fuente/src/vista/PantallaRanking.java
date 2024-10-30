package vista;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import juego.Jugador;



public class PantallaRanking extends JPanel{

	    private static final long serialVersionUID = 1L;
	    protected JLabel tituloRanking;
	    protected JButton botonAtras;
	    protected List<Jugador> jugadores;
	    protected JLabel imagenRanking;
	    protected ControladorPantallas controlador;

	    public PantallaRanking(ControladorPantallas controlador, List<Jugador> jugadores) {
	    	this.controlador = controlador;
	        this.jugadores = new ArrayList<>(); 
	        this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
	        this.setLayout(null);
	        
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
	    	if (jugadores == null || jugadores.isEmpty()) {
	            System.out.println("No hay jugadores en el ranking.");
	            return;
	        }
	    	
	        int yPosition = 100; //Posición inicial en y
	        int ranking = 1;
	        
	        for (Jugador jugador : jugadores) {
	            JLabel jugadorLabel = new JLabel(ranking + ". " + jugador.getName() + " - " + jugador.getPuntaje());
	            jugadorLabel.setBounds(100, yPosition, ConstantesPantalla.panelAncho - 200, 30);
	            decorarLabelsRanking(null, jugadorLabel);
	            this.add(jugadorLabel);
	            
	            yPosition += 40; 
	            ranking++;
	            
	            if (ranking>5)
	            	break; 
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
	



