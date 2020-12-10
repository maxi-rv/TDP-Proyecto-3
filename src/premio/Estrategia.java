package premio;

import java.util.LinkedList;

import humano.Jugador;
import logica.Entidad;

public interface Estrategia 
{
	public void efecto(Jugador jugador, LinkedList<Entidad> infectados, Premio premio);
}
