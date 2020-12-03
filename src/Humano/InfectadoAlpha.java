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
		this.velocidad = 3;
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
