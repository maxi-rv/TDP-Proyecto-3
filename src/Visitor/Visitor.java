package Visitor;

import Humano.Infectado;
import Humano.Jugador;
import Premio.Premio;
import Proyectil.Particula;
import Proyectil.ProyectilSanitario;

public interface Visitor 
{
	public abstract void visitar(Jugador jugador);
	
	public abstract void visitar(Infectado infectado);
	
	public abstract void visitar(Premio premio);
	
	public abstract void visitar(Particula particula);
	
	public abstract void visitar(ProyectilSanitario proyectil);
}
