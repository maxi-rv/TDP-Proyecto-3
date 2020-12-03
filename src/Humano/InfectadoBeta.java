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
		this.velocidad = 3;
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

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean listoParaEliminar() {
		// TODO Auto-generated method stub
		return false;
	}
}
