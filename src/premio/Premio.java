package premio;

import java.util.LinkedList;

import contenedorGrafico.ContenedorGrafico;
import humano.Jugador;
import logica.Entidad;
import visitor.Visitor;
import visitor.VisitorPremio;

public class Premio extends Entidad{

	protected Estrategia estrategia;
	protected Jugador jugador;
	protected LinkedList<Entidad> infectados;
	protected boolean listoParaEliminar;

	//------------
	
	public Premio(Jugador j)
	{
		this.jugador = j;
		this.velocidad = 2;
		this.visitor = new VisitorPremio(this);
		this.listoParaEliminar = false;
	}
	
	//METODOS
	public void aceptar(Visitor v) 
	{		
		v.visitar(this);
	}

	public Estrategia getEstrategia()
	{
		return this.estrategia;
	}
	
	public void setEstrategia(Estrategia e)
	{
		this.estrategia = e;		
	}

	public void efecto()
	{
		estrategia.efecto(jugador,infectados, this);
	}

	public Entidad ejecutarComportamiento() 
	{
		if(this.posY==(this.limiteY - this.contenedorGrafico.getLabel().getHeight()))
		{
			this.prepararParaEliminar();
		}
		else
			setPosY(posY+this.velocidad);
		
		this.contenedorGrafico.actualizar(posX,posY);
		
		return null;
	}
	
	public boolean listoParaEliminar()
	{
		return listoParaEliminar;
	}
	
	public void setContenedorGrafico(ContenedorGrafico cG)
	{
		contenedorGrafico = cG;
	}
	
	public void prepararParaEliminar()
	{
		listoParaEliminar = true;
	}
	
	public void eliminar()
	{
		contenedorGrafico.eliminar();
		contenedorGrafico = null;
		visitor.eliminar();
		visitor = null;
		estrategia = null;
	}
	
	public void setInfectados(LinkedList<Entidad> infectados)
	{
		this.infectados = infectados;
	}
}
