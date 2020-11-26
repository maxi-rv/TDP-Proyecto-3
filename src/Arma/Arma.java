package Arma;

import Proyectil.Proyectil;

public abstract class Arma
{
	//HOLA MUNDO!
	
	//ATRIBUTOS
	protected Proyectil proyectil;
	
	//METODOS
	public Proyectil disparar(int x, int y) 
	{
		Proyectil proy = proyectil.clone();
		proy.setPosX(x);
		proy.setPosY(y);
		return proy;
	}
}
