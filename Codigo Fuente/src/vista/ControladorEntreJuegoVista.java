package vista;

import elementos.ElementoJugador;
import elementos.ElementoLogico;
import observers.Observer;
import observers.ObserverGrafico;

public interface ControladorEntreJuegoVista {

	public void mostrarPantallaJuego();
	public void mostrarPantallaSeleccion();
	public void mostrarPantallaGameOver();
	public Observer registrarElemento(ElementoLogico elem);
	public Observer registrarElemento(ElementoJugador jugador);
	public void reiniciarNivel();
	public void removerObserver(ObserverGrafico observer);
}
