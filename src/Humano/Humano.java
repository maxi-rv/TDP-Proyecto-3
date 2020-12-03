package Humano;

import Arma.Arma;
import Juego.Entidad;
import Proyectil.Proyectil;

public abstract class Humano extends Entidad
{
	//ATRIBUTOS
	protected int cargaViral;
	protected Arma arma;
	
	//METODOS
	public Proyectil disparar()	
	{
		return arma.disparar();
	}
	
	
}
