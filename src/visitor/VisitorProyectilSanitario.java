package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorProyectilSanitario implements Visitor
{
	private ProyectilSanitario proyectilSanitario;
	
	public VisitorProyectilSanitario(ProyectilSanitario ps) 
	{
		proyectilSanitario=ps;
	}

	public void visitar(Jugador jugador) {}
	
	public void visitar(Infectado infectado) 
	{
		infectado.reducirCargaViral(proyectilSanitario.clone().getDamage());
		proyectilSanitario.prepararParaEliminar();
	}
	
	public void visitar(Premio premio) {}
	
	public void visitar(Particula particula) 
	{
		proyectilSanitario.prepararParaEliminar();
	}
	
	public void visitar(ProyectilSanitario proyectil) {}
	
	public void eliminar() 
	{
		proyectilSanitario = null;
	}
}
