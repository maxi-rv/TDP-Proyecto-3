package ContenedorGrafico;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContenedorGraficoJugador extends ContenedorGrafico
{
	public ContenedorGraficoJugador()
	{
		this.imagen = new JLabel();
		imagen.setBounds(220,240,200,200);
		this.imagen.setIcon(new ImageIcon(this.getClass().getResource("/Sprites/RobotMedico.png")));
	}
}
