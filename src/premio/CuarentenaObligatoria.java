package premio;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import humano.Infectado;
import humano.Jugador;
import logica.Entidad;

public class CuarentenaObligatoria implements Estrategia
{
	
	
	public void efecto(Jugador jugador, LinkedList<Entidad> infectados, Premio premio)
	{
		detenerInfectados(infectados, premio);
	}

	private void detenerInfectados(LinkedList<Entidad> infectados, Premio premio) 
	{
		Timer timer = new Timer();		
		
		for(Entidad i : infectados)
		{
			Infectado inf = (Infectado)i;
			inf.detener();
		}
		
		TimerTask tarea = new TimerTask() {
			public void run() 
			{
				for(Entidad i : infectados)
				{
					Infectado inf = (Infectado)i;
					inf.reanudar();
					premio.prepararParaEliminar();
				}				
			}
		};
		
		timer.schedule(tarea,8000);
		
	}
	
	
}
