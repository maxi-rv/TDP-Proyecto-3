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
		if(this.posY==(this.limiteY - this.contenedorGrafico.getLabel().getHeight()))
			setPosY(0);
		else
			setPosY(posY+this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
	}
	
	public abstract int getDamage ();
}
