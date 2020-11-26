package ContenedorGrafico;

import javax.swing.JLabel;

public abstract class ContenedorGrafico{
	
	private JLabel imagen;
	
	
	public JLabel getLabel(){
		return imagen;
	}
	
	public void actualizar(int posX, int posY){
		imagen.setLocation(posX, posY);
		
	}
	
	
}
