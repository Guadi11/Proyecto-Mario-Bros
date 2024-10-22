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
	
	public void restarVida() {
		if (vida >= 2) {
			vida--;
			reiniciarNivel();
		}else {
			morir();
		}
	}

	private void reiniciarNivel() {
		this.nivel.getControladorPartida().reiniciarNivel();
	}

	private void morir() {
		this.nivel.getControladorPartida().gameOver(puntaje);
	}
	
	//son para reiniciar nivel
	public void setVidas(int vida) {
		this.vida = vida;
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public void setPuntaje(int p) {
		puntaje = p;
	}
	
}
