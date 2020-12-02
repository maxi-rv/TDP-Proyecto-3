package Proyectil;

import ContenedorGrafico.ContenedorGraficoParticula;
import Visitor.Visitor;

public class ParticulaBeta extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaBeta()
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
		return new ParticulaBeta();
	}
}
