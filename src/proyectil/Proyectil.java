package proyectil;

import logica.Entidad;

public abstract class Proyectil extends Entidad
{
	//ATRIBUTOS
	protected int damage;
	protected boolean listoParaEliminar;
	
	//METODOS
	
	public void multiplicarDaño(){
		damage = damage*2;
	}
	
	public void normalizarDaño(){
		damage = damage/2;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void prepararParaEliminar()
	{
		listoParaEliminar = true;
	}
	
	public abstract Proyectil clone();
}
