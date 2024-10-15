package vista;


import java.awt.Color;
import java.awt.Dimension;
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
            this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
            setLayout(null);
            agregarImagenFondo();
            agregarBotonModoUno();
            agregarBotonModoDos();
           
        }
    
        private void agregarImagenFondo(){
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenseleccionmodo.png"));
            Image imagen = icon.getImage().getScaledInstance(ConstantesPantalla.panelAncho,ConstantesPantalla.panelAlto,Image.SCALE_SMOOTH);
            imagenFondo = new JLabel(new ImageIcon(imagen));
            imagenFondo.setBounds(0,-40,ConstantesPantalla.panelAncho,ConstantesPantalla.panelAlto);
       
            add(imagenFondo);
           
        }
    
        private void agregarBotonModoUno(){
            botonModo1 = new JButton(); //para ver la visibilidad agregar texto
            botonModo1.setBounds(280,300,200,50);
            botonModo1.setContentAreaFilled(false); 
            botonModo1.setBorderPainted(false); 
            botonModo1.setFocusPainted(false); 
            botonModo1.setOpaque(false);
            botonModo1.addActionListener(e -> controlador.mostrarPantallaJuego());
            
            add(botonModo1);
            imagenFondo.add(botonModo1);
            //botonModo1.setVisible(false);
           
        }
    
        private void agregarBotonModoDos(){
            botonModo2 = new JButton();
            botonModo2.setBounds(280,390,200,50);
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
    


