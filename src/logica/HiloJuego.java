package logica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HiloJuego extends Thread 
{
	//ATRIBUTOS
	protected Juego elJuego;
	
	//CONSTRUCTOR
	public HiloJuego(Juego j) 
	{
		this.elJuego = j;
	}
	
	//METODOS
	public void run() 
	{
		while(true)
		{
			try 
			{
				/*
				 * Actualizaciones de juego cada 16 milisegundos para movimientos mas fluidos.
				 * Esto es aproximado a un poco mas de 60 actualizaciones por segundo, (16ms*60 = 960ms)
				 * lo cual hace un paralelo a 60 frames por segundo.
				 * 
				 */
				Thread.sleep(16);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			//AGREGAR 2 IFs y CERRAR JUEGO SI ALGUNO ES TRUE
			
			if(elJuego.juegoPerdido()) {
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f,"Game Over!");
				System.exit(1);				
			}
			
			if(elJuego.juegoGanado()) {
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f,"�Has ganado el juego!");
				System.exit(1);
			}	
			
			elJuego.ejecutarJuego();
			
			
		}
	}
}
