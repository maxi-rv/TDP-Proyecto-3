package ContenedorGrafico;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContenedorGraficoInfectadoBeta extends ContenedorGrafico 
{
	public ContenedorGraficoInfectadoBeta()
	{
		this.imagen = new JLabel();
		this.imagen.setIcon(new ImageIcon(this.getClass().getResource("/Sprites/RobotB.png")));
	}
}
