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
		int cura; int cargaViral;
		
		cura = 75;
		cargaViral = jugador.getCargaViral();
		
		if((cargaViral - cura) < 0)
			jugador.aumentarCargaViral(-(cargaViral));
		else 
			jugador.aumentarCargaViral(-(cura));
		
		premio.listoParaEliminar();
	}



}
