package premio;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import humano.Infectado;
import humano.Jugador;


public class SuperArmaSanitaria  implements Estrategia
{

	
	public void efecto(Jugador jugador, LinkedList<Infectado> infectados) 
	{
		aumentarPoder(jugador);
	}

	private void aumentarPoder(Jugador jugador) 
	{
		Timer timer = new Timer();
		
		jugador.getArma().getProyectil().multiplicarDa�o();
		
		TimerTask tarea = new TimerTask(){

			
			public void run() {
				
				jugador.getArma().getProyectil().normalizarDa�o();
			}
			
			
			
		};
		
		timer.schedule(tarea,15000);
		
		
		
	}

	
}
