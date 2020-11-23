package Premio;

import javax.swing.JLabel;

import Visitor.Visitor;

public class PocionVida  extends ObjetoPrecioso
{

	@Override
	public void efecto() 
	{
		// TODO Auto-generated method stub
		recuperarVida();
	}

	private void recuperarVida() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public JLabel getContenedorGrafico() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosX() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosX(int x) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosY(int y) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLimitePosX(int x) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLimitePosY(int y) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVelocidad() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
