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
	public void aumentarCargaViral(int da�o)
	{
		this.cargaViral = this.cargaViral + da�o;
	}
	
	@Override
	public void destruirse() 
	{
		// TODO Auto-generated method stub
		
	}

}
