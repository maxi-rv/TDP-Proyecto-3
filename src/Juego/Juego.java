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
		entidadesAgregar = new LinkedList<Entidad>();
		entidadesEliminar = new LinkedList<Entidad>();
		
		fabricaJugador = new FabricaJugador(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		fabricaInfectado = new FabricaInfectado(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		
		jugador = (Jugador) fabricaJugador.crearEntidad();
		mapaActual.insertarEntidad(jugador);
		jugador.setPosX(mapaActual.getLimiteX()/2);
		jugador.setPosY(mapaActual.getLimiteY());
		jugador.getContenedorGrafico().actualizar(jugador.getPosX(),jugador.getPosY());
		
		nivelActual = new Nivel();
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
	}

	public void disparaJugador() 
	{
		Entidad proyectil = jugador.disparar();
		entidadesAgregar.addLast(proyectil);
	}
	
	/*
	 * Esto deberia ejectuarse en un hilo.
	 */
	public void ejecutarJuego() 
	{
		this.nivelActual.NuevoNivel();
		System.out.println("Nivel:"+nivelActual.getNumeroNivel());
		
		while(nivelActual.quedanTandas())
		{
			cargarTanda();
			jugarTanda();
		}
	}
	
	protected void cargarTanda()
	{
		int cantInfectados = nivelActual.getInfectadosEnTandaACtual();
			
		Random randomNumGen = new Random();
		
		System.out.println("Cant Infectados:"+cantInfectados);
		for(int i=0; i<cantInfectados; i++)
		{
			Entidad infectado = fabricaInfectado.crearEntidad();
			
			infectado.setPosX(randomNumGen.nextInt(mapaActual.getLimiteX()));
			infectado.setPosY(0);
			
			mapaActual.insertarEntidad(infectado);
			infectado.getContenedorGrafico().actualizar(infectado.getPosX(), infectado.getPosY());
			
			entidades.addLast(infectado);
			
			System.out.println(i);
		}
	}

	protected void jugarTanda() 
	{
		while(!entidades.isEmpty())
		{
			try 
			{
				Thread.sleep(200);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			for(Entidad entidad : entidades)
			{
				entidad.moverse();
			}
			
			for(Entidad entidad : entidadesEliminar)
			{
				entidades.remove(entidad);
			}
			entidadesEliminar.clear();
			
			for(Entidad entidad : entidadesAgregar)
			{
				entidades.addLast(entidad);
			}
			entidadesAgregar.clear();
		}
	}
}
