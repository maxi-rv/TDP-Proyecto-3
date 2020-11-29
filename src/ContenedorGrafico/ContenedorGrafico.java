package ContenedorGrafico;

import javax.swing.JLabel;

public abstract class ContenedorGrafico
{
	//ATRIBUTOS
	protected JLabel imagen;
	
	//METODOS
	public JLabel getLabel()
	{
		return imagen;
	}
	
	public void actualizar(int posX, int posY)
	{
		imagen.setLocation(posX, posY);
	}	
}
