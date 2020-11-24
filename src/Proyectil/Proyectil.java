package Proyectil;

import Juego.Entidad;

public abstract class Proyectil extends Entidad
{
	//ATRIBUTOS
	protected int damage;
	
	//METODOS
	public abstract Proyectil clonar();
	
	public int getDamage()
	{
		return damage;
	}
}
