package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Animacion{
	
	    private int index = 0, contadorImagenes = 0, frames;
	    private BufferedImage imagenActual;
	    private BufferedImage[] imagenesAnimacion;
	    public int velocidad;

	    public Animacion (BufferedImage...args) {
	    	this.velocidad = 5;
	    	imagenesAnimacion = new BufferedImage[args.length];
	    	for (int i = 0; i<args.length; i++) {
	    		imagenesAnimacion[i]=args[i];
	    	}
	    	frames = args.length;
	    }

	    public BufferedImage animar(){
	       index++;
	        if(index > velocidad){
	            nextFrame();
	            index = 0;
	        }

	        return imagenActual;
	    }

	    private void nextFrame() {
	        imagenActual = imagenesAnimacion[contadorImagenes];
	        contadorImagenes++;

	        if(contadorImagenes >= frames)
	            contadorImagenes = 0;
	    }
	    public void drawAnimation (Graphics g, int x, int y, int escalaX, int escalaY) {
	    	g.drawImage(imagenActual, x, y, escalaX, escalaY, null);
	    	
	    }
}