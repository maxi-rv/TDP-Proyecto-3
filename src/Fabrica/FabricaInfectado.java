package Fabrica;

import java.util.Random;

import Arma.ArmaViralAlpha;
import Arma.ArmaViralBeta;
import Humano.Infectado;
import Humano.InfectadoAlpha;
import Humano.InfectadoBeta;
import Juego.Entidad;
import Proyectil.ParticulaAlpha;
import Proyectil.ParticulaBeta;

public class FabricaInfectado extends Fabrica
{
	public FabricaInfectado(int limiteX, int limiteY)
	{
		this.limiteX = limiteX;
		this.limiteY = limiteY;
	}

	@Override
	public Entidad crearEntidad() 
	{
		Infectado infectado = null;
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(2);
		
		if(randomNumber==0)
			infectado = crearInfectadoAlpha();
		else
			infectado = crearInfectadoBeta();
		
		return infectado;
	}
	
	protected InfectadoAlpha crearInfectadoAlpha()
	{
		ParticulaAlpha proyectil = new ParticulaAlpha();
		ArmaViralAlpha arma = new ArmaViralAlpha(proyectil);
		InfectadoAlpha infectado = new InfectadoAlpha(arma);
		
		return infectado;
	}
	
	protected InfectadoBeta crearInfectadoBeta()
	{
		ParticulaBeta proyectil = new ParticulaBeta();
		ArmaViralBeta arma = new ArmaViralBeta(proyectil);
		InfectadoBeta infectado = new InfectadoBeta(arma);
		
		return infectado;
	}
}
