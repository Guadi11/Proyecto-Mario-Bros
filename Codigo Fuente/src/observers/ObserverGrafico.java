package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoLogico;

public abstract class ObserverGrafico extends JLabel implements Observer{

	protected ElementoLogico elemObservado;
	
	protected ObserverGrafico(ElementoLogico observado) {
		super();
		this.elemObservado = observado;
	}
	
	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamaño();
	}
	
	protected void actualizarImagen() {
		String rutaImagen = elemObservado.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(rutaImagen));
		setIcon(icono);
	}
	
	protected void actualizarPosicionTamaño() {
		//TODO
	}
	
	
	
}
