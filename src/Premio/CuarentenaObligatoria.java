package Premio;

import Visitor.Visitor;

public class CuarentenaObligatoria extends EfectoTemporal
{

	@Override
	public void efecto() 
	{
		// TODO Auto-generated method stub
		detenerInfectados();
	}

	private void detenerInfectados() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverse() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
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
