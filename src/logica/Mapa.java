package logica;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import gui.panelConImagen;

public class Mapa
{
	//ATRIBUTOS
	protected int limiteX;
	protected int limiteY;
	protected panelConImagen panelMapa;
	
	//CONSTRUCTOR
	public Mapa(int limX, int limY)
	{
		//Creamos la imagen como una BufferedImage
		BufferedImage imagenOriginal = null;
		try 
		{
			imagenOriginal = ImageIO.read(new File("src/Sprites/Map.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//Redimensionamos la BufferedImage
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(limX, limY, Image.SCALE_SMOOTH);
		
		//Creamos el Panel y asignamos la ImageIcon
		panelMapa = new panelConImagen(imagenRedimensionada);		
		limiteX = limX;
		limiteY = limY;
	}
	
	//METODOS
	public void insertarEntidad(Entidad entidad)
	{
		panelMapa.add(entidad.getContenedorGrafico().getLabel());
		panelMapa.validate();
		panelMapa.repaint();
	}
	
	public void eliminarEntidad(Entidad entidad)
	{
		panelMapa.remove(entidad.getContenedorGrafico().getLabel());
		panelMapa.validate();
		panelMapa.repaint();
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
