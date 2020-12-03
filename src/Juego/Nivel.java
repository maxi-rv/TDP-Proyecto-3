package Juego;

public class Nivel 
{
	//ATRIBUTOS
	protected int numeroNivel;
	protected int tandaActual;
	protected int tandas[];
	
	//CONSTRUCTOR
	public Nivel()
	{
		numeroNivel = 0;
		tandaActual = 0;
		tandas = new int[2];
	}
	
	//METODOS
	public void NuevoNivel()
	{
		int cantInfectados;
		int cantInfectadosPorTanda;
		int auxResto = 0;
		
		numeroNivel++;
		tandaActual = 0;
		
		cantInfectados = 5 * numeroNivel;
		auxResto = cantInfectados % tandas.length;
		cantInfectadosPorTanda = cantInfectados/ tandas.length;
		
		for (int i=0; i < tandas.length; i++) 
		{
			tandas[i] = cantInfectadosPorTanda;
		}
		
		tandas[tandas.length - 1] = tandas[tandas.length -1] + auxResto;
	}
	
	public int getNumeroNivel() 
	{
		return numeroNivel;
	}

	public void setNumeroNivel(int numeroNivel) 
	{
		this.numeroNivel = numeroNivel;
	}

	public int getInfectadosEnTandaACtual() 
	{
		int toReturn = tandas[tandaActual];
		
		return toReturn;
	}

	public boolean quedanTandas()
	{
		return (tandaActual < tandas.length);
	}
	
	public boolean nivelCompletado() 
	{
		return (tandaActual==(tandas.length -1) && (tandas[tandaActual])==0);
	}
	
	public void restarInfectadoEnTanda() 
	{
		tandas[tandaActual]--;
		
		if(tandas[tandaActual]==0 && (tandaActual!=(tandas.length)-1))
			tandaActual++;
	}
}