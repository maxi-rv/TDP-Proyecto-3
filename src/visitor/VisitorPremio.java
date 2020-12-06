package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorPremio implements Visitor
{

	public void visitar(Jugador jugador) {}

	
	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {}

	
	public void visitar(Particula particula) {}

	
	public void visitar(ProyectilSanitario proyectil) {}

}
