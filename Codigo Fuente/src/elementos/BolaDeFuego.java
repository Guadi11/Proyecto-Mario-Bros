		package elementos;

import archivos.Sprite;
import colisiones.Visitor;
import juego.InfoJugador;

public class BolaDeFuego extends Movible implements Visitor{
	protected InfoJugador jugador;
	private double velocidadX;
    private double velocidadY;
    private double gravedad;
    //private boolean activa; para ver si desactivar o no al momento de tirarlas?
    private int direccion;
    private final double VELOCIDAD_INICIAL = 10.0;
    private final double VELOCIDAD_REBOTE = 0.7;
    final int LIMITE_SUPERIOR = 0;
    final int LIMITE_INFERIOR = 600;
    final int LIMITE_IZQUIERDO = 0;
    final int LIMITE_DERECHO = 800;
	public BolaDeFuego(int x, int y, Sprite im) {
		super(x, y, im);
		establecerVelocidadX();
		establecerVelocidadY();
	}
	public void establecerVelocidadX() {
		velocidadX = VELOCIDAD_INICIAL * direccion;
	}
	public void establecerVelocidadY() {
		velocidadY = VELOCIDAD_INICIAL;
	}
	public Sprite getSprite() {
		return imagen;
	}
	public int getPosX() {
		return posicionX;
	}
	public int getPosY() {
		return posicionY;
	}
	public void moverse() {

        // Aplicar gravedad
        velocidadY += gravedad;

        // Actualizar posición
        posicionX += velocidadX;
        posicionY += velocidadY;

        // Detectar colisión con el piso (suponiendo que el piso está en y = PISO_Y)
        final int PISO_Y = 300; // Valor de ejemplo
        if (posicionY >= PISO_Y) {
            posicionY = PISO_Y;
            velocidadY = -velocidadY * VELOCIDAD_REBOTE;
        }
        verificarEliminacion();
        }
	public void verificarEliminacion() {
		if (y > LIMITE_INFERIOR || y < LIMITE_SUPERIOR || x < LIMITE_IZQUIERDO || x > LIMITE_DERECHO) 
           // imagen.eliminar();
	}
	public void visitar (Enemigo e) {
		int puntosPorMatar=e.morir();
		jugador.actualizarPuntaje(puntosPorMatar);
	}
       

}
