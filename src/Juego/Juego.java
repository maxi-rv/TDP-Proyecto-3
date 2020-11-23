package Juego;

import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * Clase Juego.
 * @author Alexia Camila Hernandez, Mauro Pereyra, Maximiliano Riquelme Vera
 */
public class Juego 
{
	//ATRIBUTOS
	protected static Juego instancia;
	protected Nivel nivelActual;
	protected Mapa mapaActual;
	protected LinkedList<Entidad> entidades;
	
	//CONSTRUCTOR
	protected Juego()
	{
		
	}
	
	//METODOS
	public static Juego obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new Juego();
		}
		
		return instancia;
	}
	
	public JPanel getMapa()
	{
		return mapaActual.getPanel();
	}
}
