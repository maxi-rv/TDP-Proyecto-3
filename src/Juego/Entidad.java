package Juego;

import ContenedorGrafico.ContenedorGrafico;
import Visitor.Visitor;

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
	
	public abstract void moverse();
	
	public ContenedorGrafico getContenedorGrafico()
	{
		return contenedorGrafico;
	}

	public int getPosX() 
	{
		return posX;
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

	public int getPosY() 
	{
		return posY;
	}

	public void setPosY(int y) 
	{
		if(y<0)
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
