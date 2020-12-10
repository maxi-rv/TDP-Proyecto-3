package visitor;

import humano.Infectado;
import humano.Jugador;
import logica.Juego;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorJugador implements Visitor
{
	public VisitorJugador () 
	{
		
	}

	public void visitar(Jugador jugador) {}

	public void visitar(Infectado infectado) {}



	public void visitar(Premio premio) {
		premio.efecto();
	}

	public void visitar(Particula particula) {}
	
	public void visitar(ProyectilSanitario proyectil) {}
	
	public void visitar(Juego juego) {}
	
	public void eliminar() {}
}
