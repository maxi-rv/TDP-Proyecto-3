package Proyectil;

import ContenedorGrafico.ContenedorGraficoProyectil;
import Visitor.Visitor;

public class ProyectilSanitario extends Proyectil
{
	/*
	 * Constructor.
	 */
	public ProyectilSanitario()
	{
		this.damage = 1;
		this.contenedorGrafico = new ContenedorGraficoProyectil();
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
		return new ProyectilSanitario();
	}
}
