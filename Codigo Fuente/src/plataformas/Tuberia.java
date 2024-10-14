package plataformas;

import archivos.Sprite;
import elementos.Enemigo;
import elementos.Plataforma;
import enemigos.Piranha;

public class Tuberia extends Plataforma{
	protected Piranha piranha;
	private int estadoPiranha; // 0 = Descenso, 1 = Ascenso, 2 = Espera arriba
    private long tiempoCambioEstado;
    private final long DURACION_ESPERA = 2000;
	public Tuberia(int x, int y, Sprite im) {
		super(x, y, im);
		crearPiranha();
		estadoPiranha=0;
		tiempoCambioEstado = System.currentTimeMillis();
	}

	public void crearPiranha() {
		piranha=new Piranha (posicionX, posicionY, imagen);
	}
	public void iniciarMovimientoPiranha() {
		long ahora = System.currentTimeMillis();
		switch (estadoPiranha) {
        case 0: 
            if (piranha.getPosY() > posicionY) { 
                piranha.descender(); 
            } else {
                estadoPiranha = 1; 
            }
            break;

        case 1: 
            if (piranha.getPosY() < posicionY + 4) { 
                piranha.comenzarAscenso(); 
            } else {
                estadoPiranha = 2; 
                tiempoCambioEstado = ahora; 
            }
            break;

        case 2: 
            if (ahora - tiempoCambioEstado >= DURACION_ESPERA) {
                estadoPiranha = 0; 
            }
            break;
    }
}
}
