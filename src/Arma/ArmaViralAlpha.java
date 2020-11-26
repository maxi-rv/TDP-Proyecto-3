package Arma;

import Proyectil.ParticulaAlpha;
import Proyectil.Proyectil;

public class ArmaViralAlpha extends ArmaViral
{
	//CONSTRUCTOR
	public ArmaViralAlpha(ParticulaAlpha pr)
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
