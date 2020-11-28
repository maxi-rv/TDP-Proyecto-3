package ContenedorGrafico;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContenedorGraficoInfectadoAlpha extends ContenedorGrafico
{
	public ContenedorGraficoInfectadoAlpha()
	{
		this.imagen = new JLabel();
		this.imagen.setIcon(new ImageIcon(this.getClass().getResource("/Sprites/RobotA.png")));
	}
}
