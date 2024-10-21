package vista;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import vista.ConstantesPantalla;


public class PantallaFinal extends JPanel{
	
	protected JLabel imagenGameOver;
	protected JLabel imagenTimeUp;
	protected ControladorPantallas controlador;
	private Timer timer;
	
	public PantallaFinal(ControladorPantallas controlador) {
		this.controlador = controlador;
		this.setPreferredSize(new Dimension(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto));
        this.setLayout(null);
        //agregarmetodos
        agregarImagenGameOver();
		
	}
	
	public void iniciarTemporizador() {
		 //mostrar pantalla por 3 segundos
		iniciarTemporizador(3000);
	}
	
	protected void agregarImagenGameOver() {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/imagenes/imagengameover.png"));
		Image imagen1 = icon1.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
        imagenGameOver = new JLabel(new ImageIcon(imagen1));
        imagenGameOver.setBounds(0, -40, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
        
        add(imagenGameOver);
		
	}
	
	protected void agregarImagenTimeUp() {
		ImageIcon icon2 = new ImageIcon(getClass().getResource("imagenes/imagentimeup"));
		Image imagen2 = icon2.getImage().getScaledInstance(ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto, Image.SCALE_SMOOTH);
		imagenTimeUp = new JLabel(new ImageIcon(imagen2));
		imagenTimeUp.setBounds(0, -40, ConstantesPantalla.panelAncho, ConstantesPantalla.panelAlto);
		
		add(imagenTimeUp);
		//mostrar pantalla por 3 segundps
		iniciarTemporizador(3000);
		
	}
	
	private void iniciarTemporizador(int delay) {
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarPantalla();
                timer.stop(); // Detener el temporizador una vez que haya terminado
            }
        });
        timer.setRepeats(false); // Asegurarse de que solo se ejecute una vez
        timer.start();
    }
    
	
	protected void finalizarPantalla() {
		controlador.mostrarPantallaInicial();
	}

}
