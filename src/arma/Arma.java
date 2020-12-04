package arma;

import proyectil.Proyectil;

public abstract class Arma
{
	//HOLA MUNDO!
	
	//ATRIBUTOS
	protected Proyectil proyectil;
	
	//METODOS
	public Proyectil disparar() 
	{
		Proyectil proy = proyectil.clone();
		return proy;
	}
}
