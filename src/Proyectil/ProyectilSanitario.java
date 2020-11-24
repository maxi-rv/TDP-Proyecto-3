package Proyectil;

import javax.swing.JLabel;

import Visitor.Visitor;

public class ProyectilSanitario extends Proyectil
{
	/*
	 * Constructor.
	 */
	public ProyectilSanitario()
	{
		this.damage = 1;
	}
	
	//METODOS
	@Override
	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proyectil clonar() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
