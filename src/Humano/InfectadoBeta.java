package Humano;

import Arma.ArmaViralBeta;
import ContenedorGrafico.ContenedorGraficoInfectadoBeta;
import Visitor.Visitor;

public class InfectadoBeta extends Infectado
{
	//CONSTRUCTOR
	public InfectadoBeta(ArmaViralBeta ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoInfectadoBeta();
	}

	public void moverse() 
	{
		// TODO Auto-generated method stub
	}	

	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
	}
}
