package Humano;

import javax.swing.JLabel;

import Arma.ArmaViralAlpha;

public class InfectadoAlpha extends Infectado
{
	//CONSTRUCTOR
	public InfectadoAlpha(ArmaViralAlpha ar)
	{
		this.arma = ar;
	}
	
	//METODOS
	public void duplicarVelocidad()
	{
		
	}

	@Override
	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public JLabel getContenedorGrafico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLimitePosX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLimitePosY(int y) {
		// TODO Auto-generated method stub
		
	}
}
