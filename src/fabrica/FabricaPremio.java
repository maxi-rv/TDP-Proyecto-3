package fabrica;

import java.util.Random;

import logica.Entidad;
import premio.CuarentenaObligatoria;
import premio.Estrategia;
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
		Premio premio = new Premio();
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(2);
		
		if(randomNumber==0)
			premio.setEstrategia(new CuarentenaObligatoria());
		else if(randomNumber==1)
			premio.setEstrategia(new SuperArmaSanitaria());
		else if(randomNumber==2)
			premio.setEstrategia(new PocionVida());
		
		premio.setLimiteX(limiteX); // Cuando verifique si el premio llego a tal sitio en realida hay que verificar si la estrategia llego?
		premio.setLimiteY(limiteY);
		
		return premio;
	}
}
