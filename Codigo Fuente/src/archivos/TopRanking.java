package archivos;

import java.io.Serializable;
import java.util.*;

public class TopRanking implements Serializable {

	private ArrayList<Usuario> jugadores;
	private static final int MAX_JUGADORES = 5;
	
	
	public TopRanking() {
		jugadores = new ArrayList<>();
	}
	
	public void agregarJugador(Usuario nuevoJugador) {
        int index = 0;
        // Insertar el nuevo jugador en la posición correcta
        for (index = 0; index < jugadores.size(); index++) {
            if (nuevoJugador.getPuntajeTotal() > jugadores.get(index).getPuntajeTotal()) {
                break;    
            }
        }
        
        jugadores.add(index, nuevoJugador);

        // si hay más de 5 jugadores elimimo el ultimo
        eliminarUltimo();
     }

	public void eliminarUltimo() {
		if (jugadores.size()> MAX_JUGADORES)
			jugadores.remove(jugadores.size()-1);
		
	}
	public ArrayList<Usuario> getLista(){
		return jugadores;
	}
}

