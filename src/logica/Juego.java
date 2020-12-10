package logica;

import java.util.LinkedList;
import java.util.Random;

import fabrica.Fabrica;
import fabrica.FabricaInfectado;
import fabrica.FabricaJugador;
import fabrica.FabricaPremio;
import humano.Jugador;
import premio.Premio;
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
	protected LinkedList<Entidad> proyectiles;
	protected LinkedList<Entidad> proyectilesAgregar;
	protected LinkedList<Entidad> proyectilesEliminar;
	protected LinkedList<Entidad> premios;
	protected LinkedList<Entidad> premiosAgregar;
	protected LinkedList<Entidad> premiosEliminar;
	protected LinkedList<Entidad> premiosEnEspera;
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
		
		proyectiles = new LinkedList<Entidad>();
		proyectilesAgregar = new LinkedList<Entidad>();
		proyectilesEliminar = new LinkedList<Entidad>();
		
		premios = new LinkedList<Entidad>();
		premiosAgregar = new LinkedList<Entidad>();
		premiosEnEspera = new LinkedList<Entidad>();
		premiosEliminar = new LinkedList<Entidad>();
		
		infectados = new LinkedList<Entidad>();
		infectadosEliminar = new LinkedList<Entidad>();
		
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
		
		proyectilesAgregar.addLast(proyectil);
	}
	
	/*
	 * Esto deberia ejectuarse en un hilo.
	 */
	public void ejecutarJuego() throws GameOverException 
	{
		//GENERA UN NUEVO NIVEL
		if(nivelActual.nivelCompletado() && infectados.isEmpty())
		{
			this.nivelActual.generarNuevoNivel();
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
		
		for(int i=0; i<cantInfectados; i++)
		{
			Entidad infectado = fabricaInfectado.crearEntidad();
			
			infectado.setPosX(randomNumGen.nextInt(mapaActual.getLimiteX()));
			infectado.setPosY(0);
			
			mapaActual.insertarEntidad(infectado);
			infectado.getContenedorGrafico().actualizar(infectado.getPosX(), infectado.getPosY());
			
			infectados.addLast(infectado);
		}
	}

	protected void jugarRonda() throws GameOverException 
	{
		if(jugador.listoParaEliminar())
			throw new GameOverException("GAME OVER!");
		
		if(!infectados.isEmpty())
		{
			this.realizarComportamiento(proyectiles, proyectilesAgregar, proyectilesEliminar);
			this.realizarComportamiento(infectados, proyectilesAgregar, infectadosEliminar);
			this.realizarComportamiento(premios, premiosAgregar, premiosEnEspera);
			
			this.chequearColisionesCruzado(proyectiles, infectados, proyectilesAgregar, infectadosEliminar);
			this.chequearColisionesCruzado(infectados, proyectiles, proyectilesAgregar, proyectilesEliminar);
			this.chequearColisionJugador();
			
			this.eliminarEntidades(proyectiles, proyectilesEliminar);
			this.eliminarInfectados();
			this.eliminarPremios();
			
			this.agregarEntidades(proyectiles, proyectilesAgregar);
			this.agregarEntidades(premios, premiosAgregar);
		}
	}
	
	private void eliminarPremios() 
	{
		for(Entidad premio : premiosEnEspera)
		{
			premios.remove(premio);
			mapaActual.eliminarEntidad(premio);
			
			if(premio.listoParaEliminar())
			{
				premiosEliminar.addLast(premio);
			}	
		}
		
		for(Entidad premio : premiosEliminar)
		{
			premio.eliminar();
			premiosEnEspera.remove(premio);
		}
		premiosEliminar.clear();
	}

	private void eliminarInfectados() 
	{
		for(Entidad infectado : infectadosEliminar)
		{
			Random rand = new Random();
			int randomNumber = rand.nextInt(1);
			
			if(randomNumber == 0)
			{
				fabricaPremio = new FabricaPremio(mapaActual.getLimiteX(), mapaActual.getLimiteY(), jugador, infectados);
				Entidad premio = fabricaPremio.crearEntidad();
				
				premio.setPosX(infectado.getPosX());
				premio.setPosY(infectado.getPosY());
				premiosAgregar.addLast(premio);
			}
			
			mapaActual.eliminarEntidad(infectado);
			infectado.eliminar();
			infectados.remove(infectado);
		}
		infectadosEliminar.clear();
	}

	/*
	 * Recorre ambas listas de infectados y entidades para verificar si colisionan con Jugador
	 */
	protected void chequearColisionJugador() 
	{
		for(Entidad otraEntidad : proyectiles)
		{
			if(jugador.chequearColision(otraEntidad))
			{
				Visitor visitorJugador = jugador.getVisitor();
				otraEntidad.aceptar(visitorJugador);
				
				Visitor visitor = otraEntidad.getVisitor();
				jugador.aceptar(visitor);
			}
		}
		
		for(Entidad infectado : infectados)
		{
			if(jugador.chequearColision(infectado))
			{
				Visitor visitorJugador = jugador.getVisitor();
				infectado.aceptar(visitorJugador);
				
				Visitor visitor = infectado.getVisitor();
				jugador.aceptar(visitor);
			}
		}
		
		for(Entidad entidad : premios)
		{
			if(jugador.chequearColision(entidad))
			{
				Premio premio = (Premio) entidad;
				
				premio.setInfectados(infectados);
				
				Visitor visitorJugador = jugador.getVisitor();
				premio.aceptar(visitorJugador);
				
				Visitor visitor = premio.getVisitor();
				jugador.aceptar(visitor);
				
				this.premiosEnEspera.addLast(premio);
			}
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
				{
					entidadesEliminar2.addLast(entidad2);
				}
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
		for(Entidad entidad : entidadesAgregar)
		{
			entidades.addLast(entidad);
			mapaActual.insertarEntidad(entidad);
			entidad.getContenedorGrafico().actualizar(entidad.getPosX(),entidad.getPosY());
		}
		entidadesAgregar.clear();
	}
}
