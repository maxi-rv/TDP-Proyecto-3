package Juego;

import java.util.LinkedList;
import java.util.Random;

import Fabrica.Fabrica;
import Fabrica.FabricaInfectado;
import Fabrica.FabricaJugador;
import Humano.Jugador;


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
	protected LinkedList<Entidad> entidadesAgregar;
	protected LinkedList<Entidad> entidadesEliminar;
	protected Jugador jugador;
	protected Fabrica fabricaJugador;
	protected Fabrica fabricaInfectado;
	
	//CONSTRUCTOR
	protected Juego(int limX, int limY)
	{
		mapaActual = new Mapa(limX, limY);
		entidades = new LinkedList<Entidad>();
		
		fabricaJugador = new FabricaJugador(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		fabricaInfectado = new FabricaInfectado(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		
		jugador = (Jugador) fabricaJugador.crearEntidad();
		mapaActual.insertarEntidad(jugador);
		jugador.setPosX(mapaActual.getLimiteX()/2);
		jugador.setPosY(mapaActual.getLimiteY());
		
		nivelActual = new Nivel();
		
		ejecutarJuego();
	}	

	//METODOS
	public static Juego obtenerInstancia(int limX, int limY)
	{
		if (instancia == null)
		{
			instancia = new Juego(limX, limY);
		}
		
		return instancia;
	}
	
	public Mapa getMapa()
	{
		return mapaActual;
	}

	public void moverJugador(String direccion) 
	{
		if(direccion.equals("Izquierda"))	
		{
			jugador.setPosX(jugador.getPosX()-jugador.getVelocidad());
		}

		if(direccion.equals("Derecha"))	
		{
			jugador.setPosX(jugador.getPosX()+jugador.getVelocidad());
		}
				
		jugador.moverse(); //Esto no deberia hacerse.
		//this.mapaActual.actualizarEntidad(jugador);
	}

	public void disparaJugador() 
	{
		
	}
	
	protected void ejecutarJuego() 
	{
		this.nivelActual.NuevoNivel();
		
		while(nivelActual.quedanTandas())
		{
			cargarTanda();
			jugarTanda();
		}
	}
	
	protected void cargarTanda()
	{
		int cantInfectados = nivelActual.getTandaActual();
			
		Random randomNumGen = new Random();
		
		for(int i=0; i<cantInfectados; i++)
		{
			Entidad infectado = fabricaInfectado.crearEntidad();
			
			infectado.setPosX(randomNumGen.nextInt(mapaActual.getLimiteX()-50));
			infectado.setPosY(0);
			
			entidades.addLast(infectado);
			
			mapaActual.insertarEntidad(infectado);
		}
		
		//mapaActual.cargarEntidades(entidades);
	}

	protected void jugarTanda() 
	{
		while(!entidades.isEmpty())
		{
			for(Entidad entidad : entidades)
			{
				entidad.moverse();
			}
		}
	}
}
