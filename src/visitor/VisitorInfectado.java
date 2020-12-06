package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorInfectado implements Visitor
{
	protected Infectado infectado;
	
	/*
	 * Crea un VisitorInfectado y recibe por parametro la instancia que lo origino.
	 */
	public VisitorInfectado(Infectado infectado)
	{
		this.infectado = infectado;
	}

	@Override
	public void visitar(Jugador jugador) 
	{
		jugador.aumentarCargaViral(infectado.getCloseDamage());
	}

	
	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {}


	public void visitar(Particula particula) {}


	public void visitar(ProyectilSanitario proyectil) 
	{
		infectado.reducirCargaViral(proyectil.getDamage());
	}

}
