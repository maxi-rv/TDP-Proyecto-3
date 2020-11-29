package Juego;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import GUI.panelConImagen;

public class Mapa
{
	//ATRIBUTOS
	protected int limiteX;
	protected int limiteY;
	protected panelConImagen panelMapa;
	
	//CONSTRUCTOR
	public Mapa(int limX, int limY)
	{
		panelMapa = new panelConImagen(new ImageIcon("src/Sprites/Map.png").getImage());
		panelMapa.setLayout(null);
		panelMapa.setBounds(0, 0, limX, limY);
		
		limiteX = limX;
		limiteY = limY;
	}
	
	//METODOS
	public void cargarEntidades(LinkedList<Entidad> entidades)
	{
		
	}
	
	public void insertarEntidad(Entidad entidad)
	{
		entidad.setLimiteX(limiteX);
		entidad.setLimiteY(limiteY);
		panelMapa.add(entidad.getContenedorGrafico().getLabel());
	}
	
	public void actualizarEntidad(Entidad entidad)
	{
		
	}
	
	public void eliminarEntidad(Entidad entidad)
	{
		
	}
	
	public JPanel getPanel()
	{
		return panelMapa;
	}

	public int getLimiteX() 
	{
		return limiteX;
	}

	public int getLimiteY() 
	{
		return limiteY;
	}

	
	
	
}
