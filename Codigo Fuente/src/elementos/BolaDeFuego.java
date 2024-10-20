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
	
    public BolaDeFuego(int x, int y, Sprite imagen) {
		super(x, y, imagen);
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

        final int PISO_Y = 441; 
        if (posicionY >= PISO_Y) {
            posicionY = PISO_Y;
            velocidadY = (int) (-velocidadY * VELOCIDAD_REBOTE);
        }
        verificarEliminacion();
    }
	
	public void verificarEliminacion() {
		if (posicionY > LIMITE_INFERIOR || posicionY < LIMITE_SUPERIOR || posicionX < LIMITE_IZQUIERDO || posicionX > LIMITE_DERECHO) { 
           // imagen.eliminar();
		}
	}
	
	public void visitar (Enemigo enemigo) {
		int puntosPorMatar = enemigo.puntosQueDa();
		enemigo.morir();
		jugador.actualizarPuntaje(puntosPorMatar);
	}
       

}
