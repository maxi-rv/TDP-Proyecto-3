package Humano;

public abstract class Infectado extends Humano
{
	//METODOS
	public void reducirCargaViral(int damage) 
	{
		this.cargaViral = this.cargaViral - damage;
	}
	
	public void moverse()
	{
		setPosY(posY+this.velocidad);
	}
}
