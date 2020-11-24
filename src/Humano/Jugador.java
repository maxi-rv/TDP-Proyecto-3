package Humano;

import javax.swing.JLabel;

import Arma.ArmaSanitaria;
import Proyectil.Proyectil;
import Visitor.Visitor;

public class Jugador extends Humano
{
	//CONSTRUCTOR
	public Jugador(ArmaSanitaria ar)
	{
		this.arma = ar;
	}
	
	//METODOS
	public void aumentarCargaViral(int damage)
	{
		this.cargaViral = this.cargaViral + damage;
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
