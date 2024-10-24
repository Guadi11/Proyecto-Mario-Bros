package colisiones;

public interface Visitable {
	
	public void aceptarVisita(VisitorAJugador visitor);
	public void aceptarVisita(VisitorPlataformas visitor);
	public void aceptarVisita(VisitorBolaDeFuego visitor);
}
