package vista;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PantallaInicio extends JPanel{

        protected JButton botonStart;
        protected JButton botonRanking;
        protected JLabel imagenFondo;
        protected ControladorPantallas controlador;
    
        public PantallaInicio(ControladorPantallas controlador){
            this.controlador=controlador;
            setLayout(null);//para poder hacer los cambios manualmente
        }
    
        public void agregarImagenFondo(){
            ImageIcon icon = new ImageIcon("C:\\Users\\corte\\Desktop\\UNI\\TDP\\ventanaprueba\\imagenfondo2.png");
            Image imagen = icon.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
            imagenFondo = new JLabel(new ImageIcon(imagen));
            imagenFondo.setBounds(0,0,600,400);
            setLayout(null);
            add(imagenFondo);
        }
    
        public void agregarBotonStart(){
            botonStart = new JButton();
            botonStart.setBounds(210,220,150,30);
            botonStart.setContentAreaFilled(false); 
            botonStart.setBorderPainted(false); 
            botonStart.setFocusPainted(false); 
            botonStart.setOpaque(false);
            botonStart.addActionListener(e -> controlador.mostrarPantallaSeleccionModo());
            add(botonStart);
            imagenFondo.add(botonStart);
            //botonStart.setVisible(false);
        }
        
        public void agregarBotonRanking(){
            botonRanking = new JButton();
            botonRanking.setBounds(210,300,150,30);
            botonRanking.setContentAreaFilled(false); // Hace el fondo transparente
            botonRanking.setBorderPainted(false); // Elimina el borde
            botonRanking.setFocusPainted(false); // Elimina el borde cuando el botón está enfocado
            botonRanking.setOpaque(false);
            add(botonRanking);
            imagenFondo.add(botonRanking);
        }
}


