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

	public void setPosX(int posX) 
	{
		this.posX = posX;
		if(posX<0)
			posX = 0;
		else if(posX> limiteX){
				System.out.println("El limite de X en entidad es "+ limiteX);
				posX = limiteX;
				
		}
	}

	public int getPosY() 
	{
		return posY;
	}

	public void setPosY(int posY) 
	{
		this.posY = posY;
		
		if(posY<0)
			posY = 0;
		else if(posY> limiteY)
				posY = limiteY;
	}

	public int getLimiteX() 
	{
		return limiteX;
	}

	public void setLimiteX(int limiteX) 
	{
		this.limiteX = limiteX;
	}

	public int getLimiteY() {
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
