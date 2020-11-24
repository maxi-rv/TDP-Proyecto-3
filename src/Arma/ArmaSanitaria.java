package Arma;

import Proyectil.Proyectil;
import Proyectil.ProyectilSanitario;

public class ArmaSanitaria extends Arma
{
	//CONSTRUCTOR
	public ArmaSanitaria(ProyectilSanitario pr)
	{
		this.proyectil = pr;
	}
	
	//METODOS
	@Override
	public Proyectil disparar(int x, int y) 
	{
		return proyectil;
	}

}
