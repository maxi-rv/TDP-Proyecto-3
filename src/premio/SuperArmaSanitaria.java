package premio;

import logica.Entidad;
import visitor.Visitor;

public class SuperArmaSanitaria  extends EfectoTemporal
{

	@Override
	public void efecto() 
	{
		// TODO Auto-generated method stub
		aumentarPoder();
	}

	private void aumentarPoder() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entidad ejecutarComportamiento() 
	{
		// TODO Auto-generated method stub
		return null;
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
