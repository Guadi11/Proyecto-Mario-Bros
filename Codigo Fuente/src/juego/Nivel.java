package juego;

import java.util.LinkedList;
import java.util.List;

import elementos.BolaDeFuego;
import elementos.Elemento;
import elementos.Enemigo;
import elementos.Fondo;
import elementos.Plataforma;
import elementos.PowerUp;

public class Nivel {

		protected List<Elemento> plataformas;
		protected List<Elemento> enemigos;
		protected List<Elemento> powerUps;
		protected List<Elemento> bolasDeFuego;
		protected Fondo fondo;
		protected Jugador jugador;
		protected float tiempoPartida; //ojo si quedo obsoleto esto
		protected ControladorPartida controladorPartida;
		
		public Nivel(){
			plataformas = new LinkedList<Elemento>();
			enemigos = new LinkedList<Elemento>();
			powerUps = new LinkedList<Elemento>();
			bolasDeFuego = new LinkedList<Elemento>();
		}
		
		//Agregar
		public void agregarPlataforma(Plataforma plat){
			this.plataformas.add(plat);
		}
		
		public void agregarEnemigo(Enemigo enem){
			this.enemigos.add(enem);
		}
		
		public void agregarPowerUp(PowerUp power){
			this.powerUps.add(power);
		}
		
		public void agregarBolaDeFuego(BolaDeFuego bola){
			this.bolasDeFuego.add(bola);
		}
		
		public void agregarJugador(Jugador player){
			this.jugador = player;
		}
		
		public void agregarFondo(Fondo fondo) {
			this.fondo = fondo;
		}
	
		//Getters
		public List<Elemento> getPlataformas(){
			return plataformas;
		}
		
		public List<Elemento> getEnemigos(){
			return enemigos;
		}
		
		public List<Elemento> getPowerUps(){
			return powerUps;
		}
		
		public List<Elemento> getBolasDeFuego(){
			return bolasDeFuego;
		}
		
		public Jugador getJugador(){
			return this.jugador;
		}
		
		public Fondo getFondo() {
			return this.fondo;
		}
		
		public ControladorPartida getControladorPartida() {
			return this.controladorPartida;
		}
		
		//Remover
		//completar los remove
		public void removerElemento(Plataforma plat){
			this.plataformas.remove(plat);
		}
		
		public void removerElemento(Enemigo enem){
			this.enemigos.remove(enem);
		}
		
		public void removerElemento(PowerUp power){
			this.powerUps.remove(power);
		}
		
		public void removerElemento(Jugador player){
			jugador = null;
			//hay que hacer mas cosas aca
		}
		
		public void actualizarMovibles() {
			
		}
	
	
	
	
}
