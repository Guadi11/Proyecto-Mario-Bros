		package elementos;

import archivos.Sprite;
import colisiones.Visitor;
import juego.InfoJugador;

public class BolaDeFuego extends Movible implements Visitor{
	protected InfoJugador jugador;
	private int velocidadX;
    private int velocidadY;
    private int gravedad;
    //private boolean activa; para ver si desactivar o no al momento de tirarlas?
    private int direccion;
    private final int VELOCIDAD_INICIAL = 10;
    private final float VELOCIDAD_REBOTE = 0.7f;
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
	public void moverse() {
        velocidadY += gravedad;
        
        setPosX(posicionX + velocidadX);
        setPosY(posicionY + velocidadY);

        // Detectar colisión con el piso (suponiendo que el piso está en y = PISO_Y)
        final int PISO_Y = 300; // Valor de ejemplo
        if (posicionY >= PISO_Y) {
            posicionY = PISO_Y;
            velocidadY = (int) (-velocidadY * VELOCIDAD_REBOTE);
        }
        verificarEliminacion();
        }
	public void verificarEliminacion() {
	if (posicionY>LIMITE_INFERIOR ||posicionY<LIMITE_SUPERIOR ||posicionX<LIMITE_IZQUIERDO ||posicionX>LIMITE_DERECHO) 
           // imagen.eliminar();
	}
	public void visitar (Enemigo e) {
		int puntosPorMatar=e.puntosQueDa();
		e.morir();
		jugador.actualizarPuntaje(puntosPorMatar);
	}
       

}
