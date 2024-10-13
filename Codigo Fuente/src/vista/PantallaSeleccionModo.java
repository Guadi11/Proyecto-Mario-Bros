package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaSeleccionModo extends JPanel{
   
        protected JButton botonModo1;
        protected JButton botonModo2;
        protected JLabel imagenFondo;
        protected ControladorPantallas controlador;
        
    
        public PantallaSeleccionModo(ControladorPantallas controlador){
            this.controlador = controlador;
            setLayout(null);
        }
    
        public void agregarImagenFondo(){
            ImageIcon icon = new ImageIcon("C:\\Users\\corte\\Desktop\\UNI\\TDP\\ventanaprueba\\imagenseleccionmodo.png");
            Image imagen = icon.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
            imagenFondo = new JLabel(new ImageIcon(imagen));
            imagenFondo.setBounds(0,0,600,400);
            setLayout(null);
            add(imagenFondo);
        }
    
        public void agregarBotonModoUno(){
            botonModo1 = new JButton(); //para ver la visibilidad agregar texto
            botonModo1.setBounds(220,200,150,30);
            botonModo1.setContentAreaFilled(false); 
            botonModo1.setBorderPainted(false); 
            botonModo1.setFocusPainted(false); 
            botonModo1.setOpaque(false);
            add(botonModo1);
            imagenFondo.add(botonModo1);
            //botonModo1.setVisible(false);
        }
    
        public void agregarBotonModoDos(){
            botonModo2 = new JButton();
            botonModo2.setBounds(220,260,150,30);
            botonModo2.setBackground(new Color(223,227,40));
            botonModo2.setContentAreaFilled(false); 
            botonModo2.setBorderPainted(false); 
            botonModo2.setFocusPainted(false); 
            botonModo2.setOpaque(false);
            add(botonModo2);
            imagenFondo.add(botonModo2);
            //botonModo2.setVisible(false);
        }

}
    


