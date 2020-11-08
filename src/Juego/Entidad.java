package Juego;

import javax.swing.ImageIcon;

public abstract class Entidad 
{
	//ATRIBUTOS
	protected int posX;
	protected int posY;
	protected int velocidad;
	protected ImageIcon grafico; 
	
	//METODOS
	public abstract void destruirse();
}
