package Humano;

import Arma.ArmaSanitaria;

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

	@Override
	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}

}
