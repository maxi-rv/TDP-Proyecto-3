package Humano;

import Arma.ArmaSanitaria;
import ContenedorGrafico.ContenedorGraficoJugador;
import Visitor.Visitor;

public class Jugador extends Humano
{
	//CONSTRUCTOR
	public Jugador(ArmaSanitaria ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoJugador();
		this.velocidad = 10;
	}
	
	//METODOS
	public void aumentarCargaViral(int damage)
	{
		this.cargaViral = this.cargaViral + damage;
	}

	public void aceptar(Visitor v) 
	{
		
	}
	
	public void moverse()
	{
		actualizar(posX,posY);
	}
	
	/*
	 * Este metodo no deberia estar.
	 * Se deberia utilizar el metodo ActualizarEntidad() de Mapa.
	 */
	protected void actualizar(int posX,int posY)
	{
		this.contenedorGrafico.actualizar(posX,posY);
	}

}
