package Visitor;

import Humano.Infectado;
import Humano.Jugador;
import Juego.Juego;
import Premio.Premio;
import Proyectil.Particula;
import Proyectil.ProyectilSanitario;

public class VisitorInfectado implements Visitor
{
	protected Infectado infectado;

	@Override
	public void visitar(Jugador jugador) {
		jugador.aumentarCargaViral(infectado.getDamage());
		
	}

	
	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {}


	public void visitar(Particula particula) {}


	public void visitar(ProyectilSanitario proyectil) {}

	
	public void visitar(Juego juego) {}

}
