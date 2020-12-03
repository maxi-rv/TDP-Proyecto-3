package Visitor;

import Humano.Infectado;
import Humano.Jugador;
import Premio.Premio;
import Proyectil.Particula;
import Proyectil.ProyectilSanitario;

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
		jugador.aumentarCargaViral(infectado.getDamage());
		//jugador.aumentarCargaViral(1);
	}

	
	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {}


	public void visitar(Particula particula) {}


	public void visitar(ProyectilSanitario proyectil) 
	{
		infectado.reducirCargaViral(proyectil.getDamage());
		//jugador.reducirCargaViral(1);
	}

}
