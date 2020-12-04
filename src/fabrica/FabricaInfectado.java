package fabrica;

import java.util.Random;

import arma.ArmaViralAlpha;
import arma.ArmaViralBeta;
import humano.Infectado;
import humano.InfectadoAlpha;
import humano.InfectadoBeta;
import logica.Entidad;
import proyectil.ParticulaAlpha;
import proyectil.ParticulaBeta;

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
		
		infectado.setLimiteX(limiteX);
		infectado.setLimiteY(limiteY);
		
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
