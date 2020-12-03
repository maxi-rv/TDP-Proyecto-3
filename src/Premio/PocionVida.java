package Premio;

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

	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean listoParaEliminar() {
		// TODO Auto-generated method stub
		return false;
	}

}
