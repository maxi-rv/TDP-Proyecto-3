package Juego;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

import Fabrica.Fabrica;
import Fabrica.FabricaInfectado;
import Fabrica.FabricaJugador;

/**
 * Clase Juego.
 * @author Alexia Camila Hernandez, Mauro Pereyra, Maximiliano Riquelme Vera
 */
public class Juego 
{
	//ATRIBUTOS
	protected static Juego instancia;
	protected Nivel nivelActual;
	protected Mapa mapaActual;
	protected LinkedList<Entidad> entidades;
	protected Entidad jugador;
	
	//CONSTRUCTOR
	protected Juego()
	{
		mapaActual = new Mapa();
		entidades = new LinkedList<Entidad>();
		
		Fabrica fabricaJugador = new FabricaJugador(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		Fabrica fabricaInfectado = new FabricaInfectado(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		
		jugador = fabricaJugador.crearEntidad();
		jugador.setPosX(mapaActual.getLimiteX()/2);
		jugador.setPosY(mapaActual.getLimiteY());
		
		nivelActual = new Nivel();
		cargarNivel(fabricaInfectado);
	}

	private void cargarNivel(Fabrica fabricaInfectado)
	{
		while(nivelActual.quedanTandas())
		{
			int cantInfectados = nivelActual.getTandaActual();
			
			Random randomNumGen = new Random();
			
			for(int i=0; i<cantInfectados; i++)
			{
				Entidad infectado = fabricaInfectado.crearEntidad();
				
				infectado.setLimitePosX(randomNumGen.nextInt(mapaActual.getLimiteX())); //SETEA UNA POSICION RANDOM
				infectado.setLimitePosY(5);
				
				entidades.addLast(infectado);
				
			}
			
			mapaActual.cargarEntidades(entidades);
		}
	}

	//METODOS
	public static Juego obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new Juego();
		}
		
		return instancia;
	}
	
	public JPanel getMapa()
	{
		return mapaActual.getPanel();
	}
}
