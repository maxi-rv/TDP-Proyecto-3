package visitor;

import humano.Infectado;
import humano.Jugador;
import logica.Juego;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorJugador implements Visitor
{


	public void visitar(Jugador jugador) {}

	@Override
	public void visitar(Infectado infectado) {
		// TODO Auto-generated method stub
		//ATACAR?
	}


	public void visitar(Premio premio) {
		premio.efecto();
	}

	
	public void visitar(Particula particula) {
		// TODO Auto-generated method stub
		
	}

	
	public void visitar(ProyectilSanitario proyectil) {}

	
	public void visitar(Juego juego) {}

}
