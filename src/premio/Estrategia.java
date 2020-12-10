package premio;

import java.util.LinkedList;

import humano.Infectado;
import humano.Jugador;
import logica.Entidad;

public interface Estrategia {

	public void efecto(Jugador jugador, LinkedList<Infectado> infectados);
	
}
