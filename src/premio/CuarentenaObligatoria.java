package premio;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import humano.Infectado;
import humano.Jugador;
import logica.Entidad;
import visitor.Visitor;

public class CuarentenaObligatoria implements Estrategia
{

	
	public void efecto(Jugador jugador, LinkedList<Infectado> infectados) 	{
	
		detenerInfectados(infectados);
	}

	private void detenerInfectados( LinkedList<Infectado> infectados) 
	{
		Timer timer = new Timer();		
		
		
		for(Infectado i : infectados){
			i.detener();
		}
		
		TimerTask tarea = new TimerTask(){

			
			public void run() {
				for(Infectado i : infectados){
					i.reanudar();
				}				
			}
			
			
			
		};
		
		timer.schedule(tarea,8000);
		
	}
	
	
}
