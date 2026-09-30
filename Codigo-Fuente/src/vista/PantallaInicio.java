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
		this.controlador = controlador;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
		this.setLayout(null);
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
		decorarBoton(botonStart);
	
		botonStart.addActionListener(e -> controlador.mostrarPantallaNombre());

		add(botonStart);
		imagenFondo.add(botonStart);	
	}

	private void agregarBotonRanking(){
		botonRanking = new JButton();
		botonRanking.setBounds(295, 435, 200, 70);
		decorarBoton(botonRanking);
	
		botonRanking.addActionListener(e -> controlador.mostrarPantallaRanking());

		add(botonRanking);
		imagenFondo.add(botonRanking);		
	}
	
	private void decorarBoton(JButton botonStart2) {
		botonStart2.setContentAreaFilled(false); 
		botonStart2.setBorderPainted(false); 
		botonStart2.setFocusPainted(false); 
		botonStart2.setOpaque(false);
	}
}


