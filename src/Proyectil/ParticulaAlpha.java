package Proyectil;

import ContenedorGrafico.ContenedorGraficoParticula;
import Visitor.Visitor;

public class ParticulaAlpha extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaAlpha()
	{
		this.damage = 1;
		this.contenedorGrafico = new ContenedorGraficoParticula();
		this.velocidad = 20;
	}
	
	//METODOS
	@Override
	public void moverse() 
	{
		
	}

	@Override
	public void aceptar(Visitor v) 
	{
		
	}
	
	public Proyectil clone()
	{
		return new ParticulaAlpha();
	}
}
