package juego;

public class InfoJugador {

	protected Jugador jugador;
	protected int monedas;
	protected int puntaje;
	protected int vida;
	protected Nivel nivel;
	
	public InfoJugador(Jugador jugador) {
		this.jugador = jugador;
		puntaje = 0;
		monedas = 0;
		vida = 3;
	}
	
	//Get
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public int getMonedas() {
		return this.monedas;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	
	//Set
	public void actualizarPuntaje(int puntos) {
		this.puntaje += puntos; 
	}
	
	public void aumentarMoneda() {
		this.monedas++;
	}
	
	public void sumarVida() {
		this.vida++;
	}
	
	public void setJugador(Jugador player) {
		this.jugador = player;
	}
	
	public void restarVida() {
		if (vida > 1) {
			vida--;
		}else {
			morir();
		}
	}

	private void morir() {
		// TODO Auto-generated method stub
		
	}
	
	
}
