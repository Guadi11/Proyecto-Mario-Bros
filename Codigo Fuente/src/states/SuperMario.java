package states;

import elementos.PowerUp;

public class SuperMario extends State{
	protected State volverANormal= new Normal();
	private long tiempoActivacion;
	private final long duracion =6500;
	public SuperMario() {
		//jugador.getSprite().cambiar(SuperMario);
	}
	public void recibirDaño() {
		jugador.setState(volverANormal);
	}
	/*public void actualizar() {
        long ahora = System.currentTimeMillis();
        if (ahora - tiempoActivacion >= duracion) {
            jugador.setState(volverANormal);
        }
	}*/
	@Override
	public void aumentarEstado(PowerUp p) {
		jugador.setState(this);
	}
}
