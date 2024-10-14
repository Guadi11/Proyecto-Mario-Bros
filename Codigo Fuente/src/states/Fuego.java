package states;

import java.util.ArrayList;
import java.util.List;

import elementos.BolaDeFuego;
import elementos.PowerUp;

public class Fuego extends SuperMario{
	private List<BolaDeFuego> bolasDeFuego= new ArrayList<>();
	public Fuego() {
		//jugador.getSprite().cambiar(distintoColorTraje);
	}
	public void activar() {
        super.actualizar(); 
        lanzarBolaDeFuego();
    }
    public void lanzarBolaDeFuego() {
        BolaDeFuego nuevaBola = new BolaDeFuego(jugador.getPosX(), jugador.getPosY(),null);
        bolasDeFuego.add(nuevaBola);
    }
    public void aumentarEstado(PowerUp p) {
		jugador.setState(this);
	}
}
