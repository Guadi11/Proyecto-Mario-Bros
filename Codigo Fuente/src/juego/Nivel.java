package juego;

import java.util.LinkedList;
import java.util.List;

import elementos.*;
import observers.ObserverGrafico;

public class Nivel {

		protected List<Plataforma> plataformas;
		protected List<Enemigo> enemigos;
		protected List<PowerUp> powerUps;
		protected List<BolaDeFuego> bolasDeFuego;
		protected Fondo fondo;
		protected Jugador jugador;
		protected float tiempoPartida; //ojo si quedo obsoleto esto
		protected ControladorPartida controladorPartida;
		
		public Nivel(){
			plataformas = new LinkedList<Plataforma>();
			enemigos = new LinkedList<Enemigo>();
			powerUps = new LinkedList<PowerUp>();
			bolasDeFuego = new LinkedList<BolaDeFuego>();
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
		public List<Plataforma> getPlataformas(){
			return plataformas;
		}
		
		public List<Enemigo> getEnemigos(){
			return enemigos;
		}
		
		public List<PowerUp> getPowerUps(){
			return powerUps;
		}
		
		public List<BolaDeFuego> getBolasDeFuego(){
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
		
		//Remover, juntarlos todos
		public void removerElemento(Plataforma plat){
			this.controladorPartida.removerObserver((ObserverGrafico) plat.getObserver());
		}
		
		public void removerElemento(Enemigo enem){
			this.controladorPartida.removerObserver((ObserverGrafico) enem.getObserver());
		}
		
		public void removerElemento(PowerUp power){
			this.controladorPartida.removerObserver((ObserverGrafico) power.getObserver());
		}
		
		public void actualizarMovibles() {
			
		}
		
		public void setControladorPartida(ControladorPartida partida) {
			this.controladorPartida = partida;
		}
				
	
	
	
	
}
