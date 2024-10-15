package vista;


import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PantallaInicio extends JPanel{

	private static final long serialVersionUID = 1L;
	protected JButton botonStart;
        protected JButton botonRanking;
        protected JLabel imagenFondo;
        protected ControladorPantallas controlador;
	
    
        public PantallaInicio(ControladorPantallas controlador){
            this.controlador=controlador;
            this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
            this.setLayout(null);//para poder hacer los cambios manualmente
            agregarImagenFondo();
            agregarBotonStart();
            agregarBotonRanking();
		
        }
    
        private void agregarImagenFondo(){
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imageninicio.png"));
            Image imagen = icon.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
            imagenFondo = new JLabel(new ImageIcon(imagen));
            imagenFondo.setBounds(0, -40, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
		
            add(imagenFondo);
		
        }
    
        private void agregarBotonStart(){
            botonStart = new JButton();
            botonStart.setBounds(310, 325, 150, 70);
            botonStart.setContentAreaFilled(false); 
            botonStart.setBorderPainted(false); 
            botonStart.setFocusPainted(false); 
            botonStart.setOpaque(false);
            botonStart.addActionListener(e -> controlador.mostrarPantallaSeleccion());
		
            add(botonStart);
            imagenFondo.add(botonStart);
            //botonStart.setVisible(false);
		
        }
        
        private void agregarBotonRanking(){
            botonRanking = new JButton();
            botonRanking.setBounds(295, 435, 200, 70);
            botonRanking.setContentAreaFilled(false); // Hace el fondo transparente
            botonRanking.setBorderPainted(false); // Elimina el borde
            botonRanking.setFocusPainted(false); // Elimina el borde cuando el botón está enfocado
            botonRanking.setOpaque(false);
            
            add(botonRanking);
            imagenFondo.add(botonRanking);
		
        }
	
}


