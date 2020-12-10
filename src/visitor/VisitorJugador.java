package visitor;

import humano.Infectado;
import humano.Jugador;
import logica.Juego;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorJugador implements Visitor
{
	private Jugador jugador;
	
	public VisitorJugador (Jugador j) {
		jugador=j;
	}

	public void visitar(Jugador jugador) {}

	@Override
	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {
		premio.getEstrategia().efecto();
	}

	
	public void visitar(Particula particula) {
		jugador.aumentarCargaViral(particula.clone().getDamage());
		
	}

	
	public void visitar(ProyectilSanitario proyectil) {}

	
	public void visitar(Juego juego) {}

}
