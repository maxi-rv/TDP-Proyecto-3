package Humano;

import javax.swing.JLabel;

import Arma.ArmaViralBeta;
import Proyectil.Proyectil;
import Visitor.Visitor;

public class InfectadoBeta extends Infectado
{
	//CONSTRUCTOR
	public InfectadoBeta(ArmaViralBeta ar)
	{
		this.arma = ar;
	}

	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}	

	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		
	}

	public Proyectil disparar() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
