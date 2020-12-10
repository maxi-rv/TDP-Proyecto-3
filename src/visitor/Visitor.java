package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public interface Visitor 
{
	public abstract void visitar(Jugador jugador);
	
	public abstract void visitar(Infectado infectado);
	
	public abstract void visitar(Premio premio);
	
	public abstract void visitar(Particula particula);
	
	public abstract void visitar(ProyectilSanitario proyectil);
	
	public abstract void eliminar();
}
