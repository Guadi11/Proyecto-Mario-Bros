package vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class ConfigurarFuente {
    private static Font fuenteMario;

    // Carga la fuente Mario
    public static void cargarFuente() {
        if (fuenteMario == null) {
            try (InputStream is = ConfigurarFuente.class.getResourceAsStream("/archivos/mario-font.ttf")) {
                fuenteMario = Font.createFont(Font.TRUETYPE_FONT, is);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
                fuenteMario = new Font("Arial", Font.BOLD, 18); // Fuente alternativa en caso de error
            }
        }
    }

    // Método para obtener la fuente Mario en un tamaño específico
    public static Font getFuenteMario(float tamaño) {
        return fuenteMario.deriveFont(tamaño);
    }
}
