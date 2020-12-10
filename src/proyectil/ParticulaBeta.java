package proyectil;

import contenedorGrafico.ContenedorGraficoParticula;
import logica.Entidad;
import visitor.Visitor;
import visitor.VisitorParticula;

public class ParticulaBeta extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaBeta()
	{
		this.damage = 1;
		this.contenedorGrafico = new ContenedorGraficoParticula();
		this.velocidad = 7;
		this.rango = 350;
		this.recorrido = 0;
		this.listoParaEliminar = false;
		this.visitor = new VisitorParticula(this);
	}
	
	//METODOS
	@Override
	public Entidad ejecutarComportamiento() 
	{
		setPosX(posX);
		setPosY(posY+this.velocidad);
		recorrido = recorrido+velocidad;
		
		this.contenedorGrafico.actualizar(posX,posY);
		
		return null;
	}
	
	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
	
	public Proyectil clone()
	{
		return new ParticulaBeta();
	}
}
