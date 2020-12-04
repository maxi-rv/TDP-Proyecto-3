package logica;

import contenedorGrafico.ContenedorGrafico;
import visitor.Visitor;

public abstract class Entidad 
{
	//ATRIBUTOS
	protected int posX;
	protected int posY;
	protected int limiteX;
	protected int limiteY;
	protected int velocidad;
	protected ContenedorGrafico contenedorGrafico;
	
	//METODOS
	public abstract void aceptar(Visitor v);
	
	/*
	 * Este metodo se encarga de realizar todas las operaciones necesarias para el
	 * correcto comportamiento de la Entidad, ya sea moverse, disparar, crear entidades, etc.
	 * Es posible que la Entidad retornada sea nula, por lo que es responsabilidad del cliente
	 * chequear este caso.
	 * @return Una entidad nueva, es posible que sea nula.
	 */
	public abstract Entidad ejecutarComportamiento();
	
	public void eliminar()
	{
		contenedorGrafico.eliminar();
		contenedorGrafico = null;
	}
	
	public abstract boolean listoParaEliminar();
	
	public ContenedorGrafico getContenedorGrafico()
	{
		return contenedorGrafico;
	}

	public int getPosX() 
	{
		return posX;
	}
	
	public int getPosY() 
	{
		return posY;
	}

	public void setPosX(int x) 
	{
		if(x <= 0)
		{
			this.posX = 0;
		}
		else if(x + (this.contenedorGrafico.getLabel().getWidth()) >= limiteX)
		{
			this.posX = limiteX - this.contenedorGrafico.getLabel().getWidth();
		}
		else
		{
			this.posX = x;
		}
	}

	public void setPosY(int y) 
	{
		if(y<=0)
		{
			this.posY = 0;
		}
		else if(y + (this.contenedorGrafico.getLabel().getHeight())  >= limiteY)
		{
			this.posY = limiteY - this.contenedorGrafico.getLabel().getHeight();
		}
		else
		{
			this.posY = y;
		}
	}

	public int getLimiteX() 
	{
		return limiteX;
	}

	public void setLimiteX(int limiteX) 
	{
		this.limiteX = limiteX;
	}

	public int getLimiteY() 
	{
		return limiteY;
	}

	public void setLimiteY(int limiteY) 
	{
		this.limiteY = limiteY;
	}

	public int getVelocidad() 
	{
		return velocidad;
	}
}
