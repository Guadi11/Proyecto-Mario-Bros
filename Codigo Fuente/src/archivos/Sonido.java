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
	    public void configurarLoop() {
		    clip.setLoopPoints(0, -1); // Desde el inicio hasta el final del archivo
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	            audioOn = true;
		    }
	    public void stopLoop() {
		    if (clip != null && clip.isRunning()) {
		           clip.stop();
		           clip.close();
		        }
		}
	    public void renaudar() {
	        if (!audioOn) {
	            clip.start(); // Reanuda desde la posición actual
	            audioOn = true;
	        }
	    }
	    public void detener() {
	    	if (clip.isRunning()) {
	    	clip.stop(); // Detiene el clip
	        audioOn = false;
	    	}
	    }

	    public void cerrar() {
	        clip.close(); // Cierra el clip
	    }
	    public boolean enReproduccion() {
	    	return audioOn;
	    }
	}

