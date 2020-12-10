package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorPremio implements Visitor
{
	protected Premio premio;
	
	public VisitorPremio(Premio p)
	{
		premio = p;
	}
	
	public void visitar(Jugador jugador) {}
	
	public void visitar(Infectado infectado) {}

	public void visitar(Premio premio) {}
	
	public void visitar(Particula particula) {}
	
	public void visitar(ProyectilSanitario proyectil) {}
	
	public void eliminar() 
	{
		premio = null;
	}

}
