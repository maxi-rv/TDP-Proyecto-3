package Proyectil;

import Visitor.Visitor;

public class ParticulaAlpha extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaAlpha()
	{
		this.damage = 1;
	}
	
	//METODOS
	@Override
	public void moverse() 
	{
		
	}

	@Override
	public void aceptar(Visitor v) 
	{
		
	}
	
	public Proyectil clone()
	{
		return new ParticulaAlpha();
	}
}
