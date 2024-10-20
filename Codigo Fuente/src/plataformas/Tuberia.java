package plataformas;

import archivos.Sprite;
import elementos.Plataforma;
import enemigos.Piranha;
import juego.ControladorPartida;
import parseo.GameFactory;

public class Tuberia extends Plataforma{
	protected Piranha piranha;
    protected boolean poseePiranha;
    protected GameFactory fabrica;
    protected ControladorPartida controladorPartida;
	
    public Tuberia(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		poseePiranha = false;		
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
	//Set
    public void setFabrica(GameFactory factory) {
    	this.fabrica = factory;
    }
    
    public void setControlador(ControladorPartida controlador) {
    	this.controladorPartida = controlador;
    }
}
