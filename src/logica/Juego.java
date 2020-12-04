package logica;

import java.util.LinkedList;
import java.util.Random;

import fabrica.Fabrica;
import fabrica.FabricaInfectado;
import fabrica.FabricaJugador;
import humano.Jugador;


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
				
		jugador.ejecutarComportamiento();
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
		if(nivelActual.nivelCompletado() && entidades.isEmpty())
		{
			this.nivelActual.generarNuevoNivel();
			System.out.println("Nivel:"+nivelActual.getNumeroNivel());
		}
		
		if(nivelActual.quedanTandas() && entidades.isEmpty())
		{
			cargarTanda();
		}
		
		if(nivelActual.quedanTandas())
		{
			jugarTanda();
		}
	}
	
	protected void cargarTanda()
	{
		int cantInfectados = nivelActual.getInfectadosEnTandaActual();
			
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
		if(!entidades.isEmpty())
		{
			/*
			 * Este ciclo se encarga de recorrer todas las entidades, realizar 
			 * sus comportamientos correspondientes, chequear colisiones,
			 * y preparar las entidades necesarias para añadir o eliminar.
			 */
			for(Entidad entidad : entidades)
			{
				Entidad nuevaEnt = entidad.ejecutarComportamiento();
				
				if(nuevaEnt!=null)
					entidadesAgregar.addLast(nuevaEnt);
				
				chequearColisiones(entidad);
				
				if(entidad.listoParaEliminar())
					entidadesEliminar.addLast(entidad);
			}
			
			/*
			 * Este ciclo se encarga de eliminar todas las entidades correspondientes.
			 */
			for(Entidad entidad : entidadesEliminar)
			{
				mapaActual.eliminarEntidad(entidad);
				entidad.eliminar();
				entidades.remove(entidad);
			}
			entidadesEliminar.clear();
			
			/*
			 * Este ciclo se encarga de agregar todas las entidades correspondientes.
			 */
			for(Entidad entidad : entidadesAgregar)
			{
				entidades.addLast(entidad);
				mapaActual.insertarEntidad(entidad);
				entidad.getContenedorGrafico().actualizar(entidad.getPosX(),entidad.getPosY());
			}
			entidadesAgregar.clear();
		}
	}

	private void chequearColisiones(Entidad entidad) 
	{
		
	}
}
