package Proyectil;

import ContenedorGrafico.ContenedorGraficoProyectilSanitario;
import Visitor.Visitor;

public class ProyectilSanitario extends Proyectil
{
	/*
	 * Constructor.
	 */
	public ProyectilSanitario()
	{
		this.damage = 1;
		this.contenedorGrafico = new ContenedorGraficoProyectilSanitario();
		this.velocidad = 15;
	}
	
	//METODOS
	@Override
	public void moverse() 
	{
		setPosX(posX);
		setPosY(posY-this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
	}

	@Override
	public void aceptar(Visitor v) 
	{
		
	}
	
	public Proyectil clone()
	{
		return new ProyectilSanitario();
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
