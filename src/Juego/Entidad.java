package Juego;

import javax.swing.JLabel;

public abstract class Entidad 
{
	//ATRIBUTOS
	protected int posX;
	protected int posY;
	protected int limiteX;
	protected int limiteY;
	protected int velocidad;
	protected JLabel label; 
	
	//METODOS
	public abstract void moverse();
}
