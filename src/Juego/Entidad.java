package Juego;

import javax.swing.JLabel;

import ContenedorGrafico.ContenedorGrafico;

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
	public abstract void moverse();
	
	public abstract JLabel getContenedorGrafico();
	
	public abstract int getPosX();
	
	public abstract int getPosY();
	
	public abstract void setPosX(int x);
	
	public abstract void setPosY(int y);
	
	public abstract void setLimitePosX(int x);
	
	public abstract void setLimitePosY(int y);
}
