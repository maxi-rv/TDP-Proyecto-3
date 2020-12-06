package fabrica;

import java.util.Random;

import logica.Entidad;
import premio.CuarentenaObligatoria;
import premio.PocionVida;
import premio.Premio;
import premio.SuperArmaSanitaria;

public class FabricaPremio extends Fabrica
{
	public FabricaPremio(int limiteX, int limiteY)
	{
		this.limiteX = limiteX;
		this.limiteY = limiteY;
	}

	@Override
	public Entidad crearEntidad() 
	{
		Premio premio = null;
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(2);
		
		if(randomNumber==0)
			premio = new CuarentenaObligatoria();
		else if(randomNumber==1)
			premio = new SuperArmaSanitaria();
		else if(randomNumber==2)
			premio = new PocionVida();
		
		premio.setLimiteX(limiteX);
		premio.setLimiteY(limiteY);
		
		return premio;
	}
}
