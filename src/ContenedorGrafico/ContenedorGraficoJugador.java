package ContenedorGrafico;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContenedorGraficoJugador extends ContenedorGrafico
{
	public ContenedorGraficoJugador()
	{
		this.imagen = new JLabel();
		this.imagen.setIcon(new ImageIcon(this.getClass().getResource("/Sprites/RobotMedico.png")));
	}
}
