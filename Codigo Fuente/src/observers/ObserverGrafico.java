package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoLogico;

public abstract class ObserverGrafico extends JLabel implements Observer{

	
	private static final long serialVersionUID = 1L;
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
		int x = AdaptadorPosicionPixel.transformarX(this.elemObservado.getPosX());
		int y = AdaptadorPosicionPixel.transformarY(this.elemObservado.getPosY());
		
		//int x = this.elemObservado.getPosX(); //falta adaptarlo
		//int y = this.elemObservado.getPosY(); //falta adaptarlo
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		this.setBounds(x, y, ancho, alto);
		
	}
	
	
	
}
