package premio;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import humano.Jugador;
import logica.Entidad;


public class SuperArmaSanitaria  implements Estrategia
{

	
	public void efecto(Jugador jugador, LinkedList<Entidad> infectados, Premio premio) 
	{
		aumentarPoder(jugador, premio);
	}

	private void aumentarPoder(Jugador jugador, Premio premio) 
	{
		Timer timer = new Timer();
		
		jugador.getArma().getProyectil().multiplicarDaño();
		
		TimerTask tarea = new TimerTask(){

			
			public void run() {
				
				jugador.getArma().getProyectil().normalizarDaño();
				premio.prepararParaEliminar();
			}
		};
		
		timer.schedule(tarea,15000);
	}

	
}
