package logica;

public class Nivel 
{
	//ATRIBUTOS
	protected int numeroNivel;
	protected int tandaActual;
	protected int tandas[];
	protected int cantTandas;
	
	/*
	 * Crea una instancia de nivel.
	 * No genera un nivel para jugar.
	 */
	public Nivel()
	{
		cantTandas = 2;
		numeroNivel = 0;
		tandaActual = cantTandas;
		tandas = new int[cantTandas];
	}
	
	//METODOS
	public void generarNuevoNivel()
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

	public int getInfectadosEnTandaActual() 
	{
		int toReturn = tandas[tandaActual];
		
		this.tandaActual++;
		
		return toReturn;
	}

	public boolean quedanTandas()
	{
		return (tandaActual < tandas.length);
	}
	
	public boolean nivelCompletado() 
	{
		return (tandaActual == tandas.length);
	}
}