package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelConImagen extends JPanel
{
	protected Image imagenFondo;
	
	/*
	 * Constructor. Crea una instancia de JPanel con una imagen de fondo.
	 * @param rutaImagen La direccion de la imagen a colocar de fondo.
	 */
	public panelConImagen(String rutaImagen) 
	{
		this(new ImageIcon(rutaImagen).getImage());
	}
	
	/*
	 * Metodo auxiliar para la creacion de una instancia de la clase.
	 */
	public panelConImagen(Image img) 
	{
		this.imagenFondo = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) 
	{
		g.drawImage(imagenFondo, 0, 0, null);
	}
}
