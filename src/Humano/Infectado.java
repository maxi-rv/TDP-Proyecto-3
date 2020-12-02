package Humano;

public abstract class Infectado extends Humano
{
	protected int damage;
	
	//METODOS
	public void reducirCargaViral(int damage) 
	{
		this.cargaViral = this.cargaViral - damage;
	}
	
	public void moverse()
	{
		setPosY(posY+this.velocidad);
		this.contenedorGrafico.actualizar(posX,posY);
	}
	
	public abstract int getDamage ();
}
