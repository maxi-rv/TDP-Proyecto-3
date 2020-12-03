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
		this.velocidad = 15;
	}
	
	//METODOS
	@Override
	public void moverse() 
	{
		setPosX(posX);
		setPosY(posY+this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
	}

	@Override
	public void aceptar(Visitor v) 
	{
		
	}
	
	public Proyectil clone()
	{
		return new ParticulaAlpha();
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
