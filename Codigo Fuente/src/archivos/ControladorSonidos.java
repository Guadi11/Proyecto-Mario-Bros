package archivos;

public class ControladorSonidos {
	protected ControladorSonidosAcciones controladorSonidosAcciones;
	protected ControladorSonidosJuego controladorSonidosJuego;

	public ControladorSonidos() {
		this.controladorSonidosAcciones= new ControladorSonidosAcciones();
		this.controladorSonidosJuego= new ControladorSonidosJuego();
	}
	
	public void reproducirSonidoAccion (TipoSonidos tipo) {
		controladorSonidosAcciones.reproducirSonido (tipo);
	}
	
	public void reproducirSonidoJuego (TipoSonidos tipo) {
		controladorSonidosJuego.reproducirSonido (tipo);
	}
	
	public void detenerSonidoAccion(TipoSonidos tipo) {
		this.controladorSonidosAcciones.detenerSonido(tipo);
	}
	
	public void detenerSonidoJuego (TipoSonidos tipo) {
		controladorSonidosJuego.detenerSonido(tipo);
	}
}
