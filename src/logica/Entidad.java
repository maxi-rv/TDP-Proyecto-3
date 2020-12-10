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
	protected Visitor visitor;
	
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
		visitor.eliminar();
		visitor = null;
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
	
	public void setVelocidad(int velocidad) 
	{
		this.velocidad = velocidad;
	}

	public int getVelocidad() 
	{
		return velocidad;
	}
	
	public Visitor getVisitor() 
	{
		return this.visitor;
	}
	
	public boolean chequearColision(Entidad otraEntidad)
	{
		boolean toReturn = false;
		
		int extremoAX = posX;
		int extremoBX = posX + this.contenedorGrafico.getLabel().getWidth();
		int extremoAY = posY;
		int extremoBY = posY + this.contenedorGrafico.getLabel().getHeight();
		
		int otroExtremoAX = otraEntidad.getPosX();
		int otroExtremoBX = otraEntidad.getPosX() + otraEntidad.contenedorGrafico.getLabel().getWidth();
		int otroExtremoAY = otraEntidad.getPosY();
		int otroExtremoBY = otraEntidad.getPosY() + otraEntidad.contenedorGrafico.getLabel().getHeight();
		
		if((extremoAX<=otroExtremoAX && otroExtremoAX<=extremoBX)||(extremoAX<=otroExtremoBX && otroExtremoBX<=extremoBX))
			if((extremoAY<=otroExtremoAY && otroExtremoAY<=extremoBY)||(extremoAY<=otroExtremoBY && otroExtremoBY<=extremoBY))
				toReturn = true;
		
		return toReturn;
	}
}
