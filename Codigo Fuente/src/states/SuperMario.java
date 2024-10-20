package states;

import elementos.PowerUp;
import archivos.Sprite;
import powerUps.FlorDeFuego;
import powerUps.Estrella;


public class SuperMario extends State{
	
	protected State volverANormal= new Normal();
	protected Sprite sprite;
	protected long tiempoActivacion;
	protected final long duracion =6500;
	
	public SuperMario() {
		this.sprite = new Sprite("/imagenes/modoUno/supermario.png");
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void recibirDaño() {
		jugador.setState(volverANormal);
	}
	
	public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
            jugador.setState(volverANormal);
        }
	}
	
	@Override
	public void aumentarEstado(PowerUp p) {
		if (p instanceof FlorDeFuego) {
			jugador.setState(new Fuego());
			
		} else if (p instanceof Estrella){
			jugador.setState(new Invulnerable());
		
		}
		
	}
	
	public int obtenerPuntosEstrella() {
		return 30;
	}
	
	public int obtenerPuntosSChamp() {
		return 50;
	}
	
	public int obtenerPuntosFFuego() {
		return 30;
	}
}
