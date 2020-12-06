package visitor;

import humano.Infectado;
import humano.Jugador;
import premio.Premio;
import proyectil.Particula;
import proyectil.ProyectilSanitario;

public class VisitorParticula implements Visitor
{
	Particula particula;
	
	public VisitorParticula (Particula p) {
		particula=p;
	}

	
	public void visitar(Jugador jugador) {
		jugador.aumentarCargaViral(particula.clone().getDamage());
	}


	public void visitar(Infectado infectado) {}


	public void visitar(Premio premio) {}

	
	public void visitar(Particula particula) {}

	
	public void visitar(ProyectilSanitario proyectil) {}

}
