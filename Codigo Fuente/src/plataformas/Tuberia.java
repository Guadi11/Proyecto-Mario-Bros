package plataformas;

import archivos.Sprite;
import elementos.Enemigo;
import elementos.Plataforma;
import enemigos.Piranha;
import enemigos.Spiny;
import juego.ControladorPartida;
import parseo.GameFactory;

public class Tuberia extends Plataforma{
	protected Piranha piranha;
	private int estadoPiranha; // 0 = Descenso, 1 = Ascenso, 2 = Espera arriba
    private long tiempoCambioEstado;
    protected boolean poseePiranha;
    protected GameFactory fabrica;
    protected ControladorPartida controladorPartida;
    private final long DURACION_ESPERA = 2000;
	
    public Tuberia(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		poseePiranha = false;
		estadoPiranha = 0;
		tiempoCambioEstado = System.currentTimeMillis();		
	}
    
    public void poseePiranha(boolean posee) {
    	poseePiranha = posee;
    	if(poseePiranha) {
    		crearPiranha();
    	}
    }
    
	public void crearPiranha() {
		piranha = fabrica.crearPiranha(this.posicionX-1, this.posicionY); //editar, seria el bloque de arriba
		this.nivel.agregarEnemigo(piranha);
		controladorPartida.registrarObserverElementoIndividual(piranha);
	}
	
	//a esto se lo llamaria dentro del hilo?
	public void iniciarMovimientoPiranha() {
		long ahora = System.currentTimeMillis();
		switch (estadoPiranha) {
        case 0: 
            if (piranha.getPosY() > posicionY) { 
                piranha.descender(); 
            }else {
                estadoPiranha = 1; 
            }
            break;

        case 1: 
            if (piranha.getPosY() < posicionY + 4) { 
                piranha.comenzarAscenso(); 
            }else {
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
	
	//Set
    public void setFabrica(GameFactory factory) {
    	this.fabrica = factory;
    }
    
    public void setControlador(ControladorPartida controlador) {
    	this.controladorPartida = controlador;
    }
}
