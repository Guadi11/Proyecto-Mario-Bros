package archivos;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

	public class Sonido {
	    private Clip clip;
	    private boolean audioOn;

	    public Sonido(String ruta) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	        audioOn = false;
	    }

	    public void reproducirAudioFondo() {
	    	if (!audioOn) {
	        	clip.setFramePosition(0); // Reinicia el clip
	        	clip.start(); // Inicia la reproducción
	        	audioOn = true;
	    	}
	    }
	    public void reproducirSonido() {
	    	clip.setFramePosition(0); // Reinicia el clip
        	clip.start();
        	audioOn = true;
	    }

	    public void detener() {
	        clip.stop(); // Detiene el clip
	        audioOn = true;
	    }

	    public void cerrar() {
	        clip.close(); // Cierra el clip
	    }
	    public boolean EnReproduccion() {
	    	return audioOn;
	    }
	}

