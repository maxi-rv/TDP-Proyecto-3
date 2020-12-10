package premio;

import java.util.LinkedList;

import humano.Infectado;
import humano.Jugador;


public class PocionVida  implements Estrategia{


	public void efecto(Jugador jugador, LinkedList<Infectado> infectados) {
		recuperarVida(jugador);
		
	}
	
	private void recuperarVida(Jugador jugador){
		int cura;
		
		cura = -75;
		
		jugador.aumentarCargaViral(cura);		
	}



}
