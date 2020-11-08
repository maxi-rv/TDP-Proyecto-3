package Humano;

public abstract class Infectado extends Humano
{
	//METODOS
	public void reducirCargaViral(int daño) 
	{
		this.cargaViral = this.cargaViral - daño;
	}
}
