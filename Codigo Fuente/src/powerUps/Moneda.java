package powerUps;

import archivos.Sprite;
import archivos.TipoSonidos;
import elementos.Elemento;
import elementos.PowerUp;
import juego.Jugador;

public class Moneda extends PowerUp{

	public Moneda(int x, int y, Sprite imagen) {
		super(x, y, imagen);
	}
	
	public void visitar (Jugador jugador) {
		jugador.getInfo().actualizarPuntaje(puntosQueDa());
		jugador.getInfo().aumentarMoneda();
		morir();
	}
	public void morir() {
		this.nivel.removerElemento(this);
		this.nivel.getControladorPartida().getControladorSonidos().reproducirSonidoAccion(TipoSonidos.moneda);
		}
	@Override
	public void visitar(Elemento elem) {
		//vacio
	}
	
	public int puntosQueDa() {
		return 5;
	}
	
	public void moverse() {
		
	}
}
