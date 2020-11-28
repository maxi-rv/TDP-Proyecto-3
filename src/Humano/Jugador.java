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
	}
	
	//METODOS
	public void aumentarCargaViral(int damage)
	{
		this.cargaViral = this.cargaViral + damage;
	}


	public void moverse(String direccion)
	{
		mover(direccion);
	}

	public void aceptar(Visitor v) 
	{
		
	}
	
	private void mover(String direccion)
	{	
		if(direccion == "Izquierda")
		{
			//if(Math.abs(posX) < Math.abs(limiteX))
			if(posX > 0)
				setPosX(posX-5);
		}

		if(direccion == "Derecha")
		{
			//if(Math.abs(posX) < Math.abs(limiteX))
			if(posX < limiteX)
				setPosX(posX+5);
		}
		
		actualizar(posX,posY);
	}
	
	private void actualizar(int posX,int posY)
	{
		this.contenedorGrafico.actualizar(posX,posY);
	}
	
	public void moverse()
	{
		
	}

}
