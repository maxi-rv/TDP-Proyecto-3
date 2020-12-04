package proyectil;

import contenedorGrafico.ContenedorGraficoParticula;
import logica.Entidad;
import visitor.Visitor;

public class ParticulaAlpha extends Particula
{
	/*
	 * Constructor.
	 */
	public ParticulaAlpha()
	{
		this.damage = 1;
		this.contenedorGrafico = new ContenedorGraficoParticula();
		this.velocidad = 7;
	}
	
	//METODOS
	@Override
	public Entidad ejecutarComportamiento() 
	{
		setPosX(posX);
		setPosY(posY+this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
		
		return null;
	}

	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
	
	public Proyectil clone()
	{
		return new ParticulaAlpha();
	}
}
