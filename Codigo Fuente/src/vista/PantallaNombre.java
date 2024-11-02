package vista;


import javax.swing.*;

import juego.ControladorPartida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaNombre extends JPanel{
	
	protected static final long serialversionUID = 1L;
	protected JTextField campoNombre;
	protected JButton botonGuardar;
	protected ControladorPantallas controlador;
	protected ControladorPartida controladorPartida;
	protected JLabel imagenNombre;

	public PantallaNombre(ControladorPantallas controlador, ControladorPartida controladorPartida) {
		this.controlador = controlador;
		this.controladorPartida = controladorPartida;
		
		setBackground(Color.BLACK);
		//agregarImagenFondo();
		inicializarComponentes();
		configurarPanel();
		crearEtiqueta();
		agregarEventos();
	}
	
	private void inicializarComponentes() {
		campoNombre = new JTextField(20);
		campoNombre.setFont(ConfigurarFuente.getFuenteMario(18f));
		campoNombre.setForeground(Color.WHITE); // Texto en blanco
	    campoNombre.setBackground(Color.BLACK);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setFont(ConfigurarFuente.getFuenteMario(18f));
		botonGuardar.setForeground(Color.WHITE); // Texto en blanco
	    botonGuardar.setBackground(Color.BLACK);
	}
	
	private void configurarPanel() {
		setLayout(new BorderLayout());
		JLabel label = crearEtiqueta();
		add(label, BorderLayout.NORTH);
        add(campoNombre, BorderLayout.CENTER);
        add(botonGuardar, BorderLayout.SOUTH);
	}
	
	private JLabel crearEtiqueta() {
        JLabel label = new JLabel("Ingresar nombre:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(ConfigurarFuente.getFuenteMario(20f));  
        label.setForeground(Color.WHITE);

        return label;
    }
	
	/*private void agregarImagenFondo() {
  	    ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenfondonombre.jpeg"));
        Image imagen = icon.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
        imagenNombre = new JLabel(new ImageIcon(imagen));
        imagenNombre.setBounds(0, -30, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
		
        add(imagenNombre);
        
        imagenNombre.setBounds(0, 0, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
        }*/

	
	 private void agregarEventos() {
	        botonGuardar.addActionListener(new ActionListener() {
	            @Override
	        public void actionPerformed(ActionEvent e) {
	             String nombreJugador = campoNombre.getText();
	             if (!nombreJugador.isEmpty()) {
                  controladorPartida.guardarNombre(nombreJugador);                   
                  controlador.mostrarPantallaSeleccion();//llama a un método en ControladorPartida para guardar el nombre
	              JOptionPane.showMessageDialog(null, "Nombre guardado: " + nombreJugador);
	             } else {
	                 JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre.");
	             }
	       }
           });
	 }
	
	
}
