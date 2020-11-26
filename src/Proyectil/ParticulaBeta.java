package Proyectil;

import Visitor.Visitor;

public class ParticulaBeta extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaBeta()
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
		return new ParticulaBeta();
	}
}
