package ContenedorGrafico;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContenedorGraficoJugador extends ContenedorGrafico
{
	public ContenedorGraficoJugador()
	{
		this.imagen = new JLabel();
		imagen.setSize(39, 62);
		
		//Creamos la imagen como una BufferedImage
		BufferedImage imagenOriginal = null;
		try 
		{
			imagenOriginal = ImageIO.read(new File("src/Sprites/RobotMedico.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//Redimensionamos la BufferedImage
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
		
		//Create una ImageIcon de la imagenRedimensionada
		ImageIcon imageIcon = new ImageIcon(imagenRedimensionada);
		
		//Asignamos la ImageIcon
		this.imagen.setIcon(imageIcon);
	}
}
