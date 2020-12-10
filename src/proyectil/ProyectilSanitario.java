package proyectil;

import contenedorGrafico.ContenedorGraficoProyectilSanitario;
import logica.Entidad;
import visitor.Visitor;
import visitor.VisitorProyectilSanitario;

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
		this.listoParaEliminar = false;
		this.visitor = new VisitorProyectilSanitario(this);
	}
	
	//METODOS
	@Override
	public Entidad ejecutarComportamiento() 
	{
		setPosX(posX);
		setPosY(posY-this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
		
		return null;
	}

	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
	
	public Proyectil clone()
	{
		return new ProyectilSanitario();
	}
	
	@Override
	public boolean listoParaEliminar() 
	{
		return (posY==0) || listoParaEliminar;
	}
}
