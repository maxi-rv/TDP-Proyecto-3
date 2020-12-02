package Juego;

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
			elJuego.ejecutarJuego();
		}
	}
}
