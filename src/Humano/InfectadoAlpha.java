package Humano;

import javax.swing.JLabel;

import Arma.ArmaViralAlpha;
import Proyectil.Proyectil;
import Visitor.Visitor;

public class InfectadoAlpha extends Infectado
{
	//CONSTRUCTOR
	public InfectadoAlpha(ArmaViralAlpha ar)
	{
		this.arma = ar;
	}
	
	//METODOS
	public void duplicarVelocidad()
	{
		
	}

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
	public Proyectil disparar() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
