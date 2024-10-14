package vista;

import elementos.ElementoJugador;
import elementos.ElementoLogico;
import observers.Observer;

public interface ControladorEntreJuegoVista {

	public void mostrarPantallaJuego();
	public void mostrarPantallaSeleccion();
	public Observer registrarElemento(ElementoLogico elem);
	public Observer registrarElemento(ElementoJugador jugador);
	public Observer registrarFondo(ElementoLogico fondo);
}
