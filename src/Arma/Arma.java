package Arma;

import Proyectil.Proyectil;

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
