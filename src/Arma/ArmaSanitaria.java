package Arma;

import Proyectil.Proyectil;
import Proyectil.ProyectilSanitario;

public class ArmaSanitaria extends Arma
{
	/*
	 * Crea una instancia de ArmaSanitaria
	 */
	public ArmaSanitaria(ProyectilSanitario pr)
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
