package fabrica;

import java.util.LinkedList;
import java.util.Random;

import contenedorGrafico.ContenedorGraficoCuarentenaObligatoria;
import contenedorGrafico.ContenedorGraficoPocionVida;
import contenedorGrafico.ContenedorGraficoSuperArmaSanitaria;
import humano.Jugador;
import logica.Entidad;
import premio.CuarentenaObligatoria;
import premio.PocionVida;
import premio.Premio;
import premio.SuperArmaSanitaria;

public class FabricaPremio extends Fabrica
{
	Jugador jugador;
	LinkedList<Entidad> infectados;
	
	public FabricaPremio(int limiteX, int limiteY, Jugador jugador, LinkedList<Entidad> infectados)
	{
		this.limiteX = limiteX;
		this.limiteY = limiteY;
		this.jugador = jugador;
		this.infectados = infectados;
	}

	@Override
	public Entidad crearEntidad() 
	{
		Premio premio = new Premio(jugador);
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(3);
		
		if(randomNumber==0)
		{
			premio.setEstrategia(new CuarentenaObligatoria());
			premio.setContenedorGrafico(new ContenedorGraficoCuarentenaObligatoria());
		}
		else if(randomNumber==1)
		{
			premio.setEstrategia(new SuperArmaSanitaria());
			premio.setContenedorGrafico(new ContenedorGraficoSuperArmaSanitaria());
		}
		else if(randomNumber==2)
		{
			premio.setEstrategia(new PocionVida());
			premio.setContenedorGrafico(new ContenedorGraficoPocionVida());
		}
		
		premio.setLimiteX(limiteX); // Cuando verifique si el premio llego a tal sitio en realida hay que verificar si la estrategia llego?
		premio.setLimiteY(limiteY);
		
		return premio;
	}
}
