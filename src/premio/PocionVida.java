package premio;

import java.util.LinkedList;

import humano.Jugador;
import logica.Entidad;


public class PocionVida  implements Estrategia{


	public void efecto(Jugador jugador, LinkedList<Entidad> infectados, Premio premio) 
	{
		recuperarVida(jugador, premio);
	}
	
	private void recuperarVida(Jugador jugador, Premio premio)
	{
		int cura;
		
		cura = -75;
		
		jugador.aumentarCargaViral(cura);
		
		premio.listoParaEliminar();
	}



}
