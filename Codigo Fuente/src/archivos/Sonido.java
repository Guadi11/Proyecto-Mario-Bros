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
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    audioOn = false; // Actualiza el estado al finalizar el audio
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        audioOn = false;
    }

    public void reproducirAudioFondo() {
        if (!audioOn) {
            clip.setFramePosition(0); // Reinicia el clip
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Configura el loop en lugar de llamar a start
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
        }
        audioOn = false;
    }

    public void renaudar() {
        if (!audioOn) {
            clip.start(); // Reanuda desde la posición actual
            audioOn = true;
        }
    }

    public void detener() {
        if (clip.isRunning()) {
            clip.stop(); 
            audioOn = false;
        }
    }

    public void cerrar() {
        clip.close(); 
    }

    public boolean enReproduccion() {
        return audioOn;
    }
}
