package Humano;

public abstract class Infectado extends Humano
{
	//METODOS
	public void reducirCargaViral(int da�o) 
	{
		this.cargaViral = this.cargaViral - da�o;
	}
}
