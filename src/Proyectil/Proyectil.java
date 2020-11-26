package Proyectil;

import Juego.Entidad;

public abstract class Proyectil extends Entidad
{
	//ATRIBUTOS
	protected int damage;
	
	//METODOS
	public int getDamage()
	{
		return damage;
	}
	
	public abstract Proyectil clone();
}
