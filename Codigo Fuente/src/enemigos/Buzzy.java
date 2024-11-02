package enemigos;

import archivos.Sprite;
import colisiones.VisitorAJugador;
import colisiones.VisitorBolaDeFuego;
import colisiones.VisitorPlataformas;
import elementos.Elemento;
import elementos.Enemigo;
import juego.Jugador;

public class Buzzy extends Enemigo{
	protected boolean escondido;

	public Buzzy(int x, int y, Sprite imagen) {
		super(x, y, imagen);
		escondido = false;
	}

	public void visitar(Jugador jugador) {
		//misma muerte que Koopa
		//si es de arriba, cambia de imagen y deja de moverse (algun boolean). Segundo golpe igual que Koopa (desde donde sea)
		//sino, mata a jugador

		if(jugador.getBoundsBottom().intersects(this.getBoundsTop())) {
			jugador.setPosY((int) (this.getPosY() + jugador.getHitbox().getHeight()));
			jugador.setVelY(0);
			jugador.setJumped(false);
			jugador.saltarAlMatar();
			if(escondido) {
				jugador.getInfo().actualizarPuntaje(this.puntosQueDa());
				System.out.println("entro a escondido");
				morir();			
			} else {
				System.out.println("entro a NO escondido");
				escondido = true;
				System.out.println("Se esconde");
			}
			//sigue bien la secuencia pero la colision se detecta tan rapido que se ve como si golpeara una vez sola
		} else {
			System.out.println("colision desde el costado");
			jugador.getInfo().actualizarPuntaje(-this.puntosQueResta());
			jugador.getState().recibirDaño();
		}
	}

	@Override
	public void visitar(Elemento elem) {
		//vacio
		
	}

	public int recibirDaño() {
		this.morir();
		int puntos=this.puntosQueDa();
		return puntos;
	}

	public int puntosQueResta() {
		return 15;
	}

	public int puntosQueDa() {
		return 30;
	}

	public void moverse() {
		/* cambiar cuando esten colisione/heapbox
		 int nuevaPosicionX=posicionX + velocidad*(1/60);
		 
		setPosX(nuevaPosicionX);
		if (velocidad<0) {
			//imagen.cambiarImagen("Goomba_a_izq.png");
		}else
			//imagen.cambiarImagen("Goomba_a_der.png");
		
		//imagen.actualizarPosicion(posicionX, posicionY);*/
	}
	

	@Override
	public void aceptarVisita(VisitorAJugador visitor) {
		// entra a este metodo cuando el visitor es enemigo, powerUp o vacio. Solo sucede con vacio
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorPlataformas visitor) {
		// entra a este metodo cuando el visitor sea plataforma (sin incluir vacio)
		visitor.visitar(this);
	}

	@Override
	public void aceptarVisita(VisitorBolaDeFuego visitor) {
		// entra a este metodo cuando el visitor sea una bola de fuego
		visitor.visitar(this);
	}

}
