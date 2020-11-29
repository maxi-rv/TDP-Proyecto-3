package Juego;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

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
	protected Jugador jugador;
	
	//CONSTRUCTOR
	protected Juego(){
	
		mapaActual = new Mapa();
		entidades = new LinkedList<Entidad>();
		
		
		
		Fabrica fabricaJugador = new FabricaJugador(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		Fabrica fabricaInfectado = new FabricaInfectado(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		
		jugador = (Jugador) fabricaJugador.crearEntidad();
		jugador.setPosX(220);
		jugador.setPosY(240);
		mapaActual.insertarEntidad(jugador);
		
		nivelActual = new Nivel();
		cargarNivel(fabricaInfectado);
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
	
	public Mapa getMapa()
	{
		return mapaActual;
	}

	public void moverJugador(String direccion) 
	{
		System.out.println("Limitee "+ jugador.getLimiteX());
		jugador.moverse(direccion);
	}

	public void disparaJugador() 
	{
		
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
				
				infectado.setLimiteX(randomNumGen.nextInt(mapaActual.getLimiteX())); //SETEA UNA POSICION RANDOM
				infectado.setLimiteY(5);
				
				entidades.addLast(infectado);
				
			}
			
			mapaActual.cargarEntidades(entidades);
		}
	}
}
