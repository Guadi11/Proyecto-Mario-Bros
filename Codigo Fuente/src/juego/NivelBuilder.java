package juego;

import java.io.File;

public class NivelBuilder {
	protected GameFactory fabrica;
	protected Nivel nivelCreado;
	protected int numNivel;
	
	public NivelBuilder(GameFactory factory, int nivelACrear) {
		this.fabrica = factory;
		this.numNivel = nivelACrear;
		this.nivelCreado = null; //almacenar el creado
		crearNivel();
		
	}
	
	private void crearNivel() {
		//gestiona segun el int
		
	}

	
	public Nivel getNivel() {
		return this.nivelCreado;
	}
	
	
}
