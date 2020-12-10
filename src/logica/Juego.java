package logica;

import java.util.LinkedList;
import java.util.Random;

import fabrica.Fabrica;
import fabrica.FabricaInfectado;
import fabrica.FabricaJugador;
import fabrica.FabricaPremio;
import humano.Jugador;
import visitor.Visitor;


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
	protected LinkedList<Entidad> entidadesOtras;
	protected LinkedList<Entidad> entidadesOtrasAgregar;
	protected LinkedList<Entidad> entidadesOtrasEliminar;
	protected LinkedList<Entidad> infectados;
	protected LinkedList<Entidad> infectadosEliminar;
	protected Jugador jugador;
	protected Fabrica fabricaJugador;
	protected Fabrica fabricaInfectado;
	protected Fabrica fabricaPremio;
	
	//CONSTRUCTOR
	protected Juego(int limX, int limY)
	{
		mapaActual = new Mapa(limX, limY);
		
		entidadesOtras = new LinkedList<Entidad>();
		entidadesOtrasAgregar = new LinkedList<Entidad>();
		entidadesOtrasEliminar = new LinkedList<Entidad>();
		
		infectados = new LinkedList<Entidad>();
		infectadosEliminar = new LinkedList<Entidad>();
		
		fabricaJugador = new FabricaJugador(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		fabricaInfectado = new FabricaInfectado(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		fabricaPremio = new FabricaPremio(mapaActual.getLimiteX(), mapaActual.getLimiteY());
		
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
		
		entidadesOtrasAgregar.addLast(proyectil);
	}
	
	/*
	 * Esto deberia ejectuarse en un hilo.
	 */
	public void ejecutarJuego() 
	{
		//GENERA UN NUEVO NIVEL
		if(nivelActual.nivelCompletado() && infectados.isEmpty())
		{
			this.nivelActual.generarNuevoNivel();
			System.out.println("Nivel:"+nivelActual.getNumeroNivel());
		}
		
		//CARGA UNA TANDA
		if(nivelActual.quedanTandas() && infectados.isEmpty())
		{
			cargarTanda();
		}
		
		//JUEGA RONDAS
		jugarRonda();
	}
	
	protected void cargarTanda()
	{
		int cantInfectados = nivelActual.getInfectadosEnTandaActual();
			
		Random randomNumGen = new Random();
		
		System.out.println("Cant. Infectados en Tanda:"+cantInfectados);
		
		for(int i=0; i<cantInfectados; i++)
		{
			Entidad infectado = fabricaInfectado.crearEntidad();
			
			infectado.setPosX(randomNumGen.nextInt(mapaActual.getLimiteX()));
			infectado.setPosY(0);
			
			mapaActual.insertarEntidad(infectado);
			infectado.getContenedorGrafico().actualizar(infectado.getPosX(), infectado.getPosY());
			
			infectados.addLast(infectado);
			
			System.out.println(i);
		}
	}

	protected void jugarRonda() 
	{
		if(!infectados.isEmpty())
		{
			
			this.realizarComportamiento(entidadesOtras, entidadesOtrasAgregar, entidadesOtrasEliminar);
			this.realizarComportamiento(infectados, entidadesOtrasAgregar, infectadosEliminar);
			
			this.chequearColisionesCruzado(entidadesOtras, infectados, entidadesOtrasAgregar, infectadosEliminar);
			this.chequearColisionesCruzado(infectados, entidadesOtras, entidadesOtrasAgregar, entidadesOtrasEliminar);
			
			this.eliminarEntidades(entidadesOtras, entidadesOtrasEliminar);
			this.eliminarEntidades(infectados, infectadosEliminar);
			
			this.agregarEntidades(entidadesOtras, entidadesOtrasAgregar);
		}
	}

	/*
	 * Este metodo se encarga de recorrer todas las entidades, realizar 
	 * sus comportamientos correspondientes, chequear colisiones,
	 * y preparar las entidades necesarias para añadir o eliminar.
	 */
	protected void realizarComportamiento(LinkedList<Entidad> entidades, LinkedList<Entidad> entidadesAgregar, LinkedList<Entidad> entidadesEliminar)
	{
		for(Entidad entidad : entidades)
		{
			Entidad nuevaEnt = entidad.ejecutarComportamiento();
			
			if(nuevaEnt!=null)
				entidadesAgregar.addLast(nuevaEnt);
			
			chequearColisiones(entidad, entidades);
			
			if(entidad.listoParaEliminar())
				entidadesEliminar.addLast(entidad);
		}
	}
	
	/*
	 * Chequea colisiones entre 2 listas de entidades distintas
	 */
	protected void chequearColisionesCruzado(LinkedList<Entidad> entidades1, LinkedList<Entidad> entidades2, LinkedList<Entidad> entidadesAgregar1, LinkedList<Entidad> entidadesEliminar2)
	{
		for(Entidad entidad1 : entidades1)
		{
			for(Entidad entidad2 : entidades2)
			{
				if(entidad1.chequearColision(entidad2))
				{
					Visitor visitor = entidad2.getVisitor();
					entidad1.aceptar(visitor);
				}
				
				if(entidad2.listoParaEliminar() && !entidadesEliminar2.contains(entidad2))
					entidadesEliminar2.addLast(entidad2);
			}
		}
	}
	
	/*
	 * Recibe una entidad y chequea si ha colisionado con las entidades en la lista pasada por parametro.
	 */
	protected void chequearColisiones(Entidad entidad, LinkedList<Entidad> entidades) 
	{
		for(Entidad otraEntidad : entidades)
		{
			if(entidad != otraEntidad)
			{
				if(entidad.chequearColision(otraEntidad))
				{
					Visitor visitor = entidad.getVisitor();
					otraEntidad.aceptar(visitor);
				}
			}
		}
	}
	
	/*
	 * Este metodo se encarga de eliminar todas las entidades correspondientes.
	 */
	protected void eliminarEntidades(LinkedList<Entidad> entidades, LinkedList<Entidad> entidadesEliminar)
	{
		for(Entidad entidad : entidadesEliminar)
		{
			mapaActual.eliminarEntidad(entidad);
			entidad.eliminar();
			entidades.remove(entidad);
		}
		entidadesEliminar.clear();
	}
	
	/*
	 * Este ciclo se encarga de agregar todas las entidades correspondientes.
	 */
	protected void agregarEntidades(LinkedList<Entidad> entidades, LinkedList<Entidad> entidadesAgregar)
	{
		for(Entidad entidad : entidadesOtrasAgregar)
		{
			entidadesOtras.addLast(entidad);
			mapaActual.insertarEntidad(entidad);
			entidad.getContenedorGrafico().actualizar(entidad.getPosX(),entidad.getPosY());
		}
		entidadesOtrasAgregar.clear();
	}
}
