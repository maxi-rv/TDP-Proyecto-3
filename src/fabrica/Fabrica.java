package fabrica;

import logica.Entidad;

public abstract class Fabrica 
{
	//ATRIBUTOS
	protected int limiteX;
	protected int limiteY;
	
	//METODOS
	public abstract Entidad crearEntidad();
}
