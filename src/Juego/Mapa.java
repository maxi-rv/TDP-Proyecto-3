package Juego;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Mapa
{
	//ATRIBUTOS
	protected int limiteX;
	protected int limiteY;
	protected JPanel panelMapa;
	
	//CONSTRUCTOR
	public Mapa()
	{
		panelMapa = new JPanel();
		panelMapa.setLayout(null);
		panelMapa.setBounds(0, 0, 640, 480);
		panelMapa.setBackground(Color.GRAY);
		
		limiteX = 640;
		limiteY = 480;
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
