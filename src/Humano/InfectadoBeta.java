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
		this.velocidad = 5;
	}	

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
