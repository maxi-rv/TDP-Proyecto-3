package Arma;

import Proyectil.ParticulaBeta;
import Proyectil.Proyectil;

public class ArmaViralBeta extends ArmaViral
{
	//CONSTRUCTOR
	public ArmaViralBeta(ParticulaBeta pr)
	{
		this.proyectil = pr;
	}
	
	//METODOS
	@Override
	public Proyectil disparar(int x, int y) 
	{
		return proyectil.clone();
	}
	
	
}
