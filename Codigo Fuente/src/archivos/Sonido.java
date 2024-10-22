package archivos;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

	public class Sonido {
	    private Clip clip;

	    public Sonido(String ruta) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }

	    public void reproducir() {
	        clip.setFramePosition(0); // Reinicia el clip
	        clip.start(); // Inicia la reproducción
	    }

	    public void detener() {
	        clip.stop(); // Detiene el clip
	    }

	    public void cerrar() {
	        clip.close(); // Cierra el clip
	    }
	}
}
