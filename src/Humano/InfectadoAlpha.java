package Humano;

import Arma.ArmaViralAlpha;
import ContenedorGrafico.ContenedorGraficoInfectadoAlpha;
import Visitor.Visitor;

public class InfectadoAlpha extends Infectado
{
	//CONSTRUCTOR
	public InfectadoAlpha(ArmaViralAlpha ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoInfectadoAlpha();
		this.velocidad = 5;
	}
	
	//METODOS
	public void duplicarVelocidad()
	{
		velocidad=2*velocidad;
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
