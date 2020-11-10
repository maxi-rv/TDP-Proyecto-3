package Juego;

public class Nivel 
{
	//ATRIBUTOS
	protected int numeroNivel;
	protected int tandaActual;
	protected int Tandas[];
	
	//CONSTRUCTOR
	public Nivel()
	{
		
	}
	
	//METODOS
	public void NuevoNivel()
	{
		
	}
	
	public int getNumeroNivel() 
	{
		return numeroNivel;
	}

	public void setNumeroNivel(int numeroNivel) 
	{
		this.numeroNivel = numeroNivel;
	}

	public int getTandaActual() 
	{
		return tandaActual;
	}

	public void setTandaActual(int tandaActual) 
	{
		this.tandaActual = tandaActual;
	}

	public int[] getTandas() 
	{
		return Tandas;
	}

	public void setTandas(int[] tandas) 
	{
		Tandas = tandas;
	}
}
