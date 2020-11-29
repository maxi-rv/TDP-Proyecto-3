package Fabrica;

import Arma.ArmaSanitaria;
import Humano.Jugador;
import Juego.Entidad;
import Proyectil.ProyectilSanitario;

public class FabricaJugador extends Fabrica
{
	public FabricaJugador(int limiteX, int limiteY)
	{
		this.limiteX = limiteX;
		this.limiteY = limiteY;
	}

	@Override
	public Entidad crearEntidad() 
	{
		ProyectilSanitario proyectil = new ProyectilSanitario();
		ArmaSanitaria arma = new ArmaSanitaria(proyectil);
		Jugador jugador = new Jugador(arma);
		
		jugador.setLimiteX(limiteX);
		jugador.setLimiteY(limiteY);
		
		return jugador;
	}
}
