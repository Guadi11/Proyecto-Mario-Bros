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
		inicializarComponentes();
		configurarPanel();
		crearEtiqueta();
		agregarEventos();
	}
	
	protected void inicializarComponentes() {
		campoNombre = new JTextField(20);
		campoNombre.setFont(ConfigurarFuente.getFuenteMario(18f));
		campoNombre.setForeground(Color.WHITE); // Texto en blanco
	    campoNombre.setBackground(Color.BLACK);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setFont(ConfigurarFuente.getFuenteMario(18f));
		botonGuardar.setForeground(Color.WHITE); // Texto en blanco
	    botonGuardar.setBackground(Color.BLACK);
	}
	
	protected void configurarPanel() {
		setLayout(new BorderLayout());
		JLabel labelNombre = crearEtiqueta();
		add(labelNombre, BorderLayout.NORTH);
        add(campoNombre, BorderLayout.CENTER);
        add(botonGuardar, BorderLayout.SOUTH);
	}
	
	protected JLabel crearEtiqueta() {
        JLabel labelNombre = new JLabel("Ingresar nombre:");
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setFont(ConfigurarFuente.getFuenteMario(20f));  
        labelNombre.setForeground(Color.WHITE);

        return labelNombre;
    }
	
	protected void agregarEventos() {
        botonGuardar.addActionListener(new ActionListener() {
        @Override
	    public void actionPerformed(ActionEvent e) {
             String nombreJugador = campoNombre.getText();
             if (!nombreJugador.isEmpty()) {
                 controladorPartida.guardarNombre(nombreJugador);                   
                 controlador.mostrarPantallaSeleccion();//llama a un método en ControladorPartida para guardar el nombre
	             //JOptionPane.showMessageDialog(null, "Nombre guardado: " + nombreJugador);
	         } else {
	        	 JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre.");
	           }
	    }
        });
	}
		
}
