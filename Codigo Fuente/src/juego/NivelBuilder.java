package juego;

import java.io.File;

public class NivelBuilder {
	protected GameFactory fabrica;
	//protected File imagenMapa; ???? por qué estaba esto en el extendido?
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

	private void leerArchivo() {
		//bucle anidado
	}
	
	private void procesarCaracter() {
		//aca se dan los llamados a la fabrica
	}
	
	public Nivel getNivel() {
		return this.nivelCreado;
	}
	
	
}
