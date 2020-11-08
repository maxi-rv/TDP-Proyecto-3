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
	public void aumentarCargaViral(int daño)
	{
		this.cargaViral = this.cargaViral + daño;
	}
	
	@Override
	public void destruirse() 
	{
		// TODO Auto-generated method stub
		
	}

}
