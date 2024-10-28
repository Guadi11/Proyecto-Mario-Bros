package states;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import archivos.Sprite;
import archivos.TipoSonidos;
import juego.Jugador;


public class Invulnerable extends State{
	
	protected long tiempoActivacion;
	protected final long duracion = 6500;
	protected State estadoAnterior;
	protected Sprite sprite;
	protected Timer timer;
	
	
	public Invulnerable(Jugador jugador) {
		super(jugador);
		this.estadoAnterior = jugador.getState();
	}
	
	public void activar() {
		//this.estadoAnterior = jugador.getState();
		jugador.setState(this);
        tiempoActivacion = System.currentTimeMillis();
        
        if (estadoAnterior.esGrande()) {
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerable.png");
            //jugador.actualizarPosicionHitbox(); //actualizar pos jugador, alto y ancho de hitbox en un metodo aparte
        } else {
            jugador.getSprite().setSprite("imagenes/modoUno/invulnerablemini.png");
        }
        iniciarTemporizador();
        //encontrar sonidoInvulnerable y activarlo, ademas de parar HiloSonido
    }
		//la posicion esta ajustada pero no se por qué cae abajo del piso*/
	
	public void setAnterior(State anterior) {
		this.estadoAnterior = anterior;
	}
	
	public void reproducirSonidoSalto() {
		estadoAnterior.reproducirSonidoSalto();
	}
	
	public Sprite getSprite() {
		return this.getSprite();
	}
	
	private void iniciarTemporizador() {
        timer = new Timer((int) duracion, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	estadoAnterior.activar();
                timer.stop(); // Detener el temporizador una vez que haya terminado
            }
        });
        timer.setRepeats(false); // Asegurarse de que solo se ejecute una vez
        timer.start();
    }
	
	@Override
	public void recibirSuperChampiñon() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosSChamp());
	}
	
	@Override
	public void recibirFlorDeFuego() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosFFuego());
	}
	
	public void recibirEstrella() {
		jugador.getInfo().actualizarPuntaje(this.obtenerPuntosEstrella());
	}
	
	public void actualizar() {
            long ahora = System.currentTimeMillis();
            if ((ahora - tiempoActivacion) >= duracion) {
                this.estadoAnterior.activar();
            }
    }
	
	public void recibirDaño() {
		this.estadoAnterior.activar();
		//en algun lugar se esta llamando erroneamente a jugador.getInfo().recibirDaño() y reinicia cuando no deberia
	}
	
	public int obtenerPuntosEstrella() {
		return 35;
	}
	
	public int obtenerPuntosSChamp() {
		return estadoAnterior.obtenerPuntosSChamp();
	}
	
	public int obtenerPuntosFFuego() {
		return estadoAnterior.obtenerPuntosFFuego();
	}
	
	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

	@Override
	public boolean esGrande() {
		return false;
	}

}
