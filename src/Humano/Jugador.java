package Humano;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

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
		
		//System.out.println("hola");
		mover(direccion);
	}

	public void aceptar(Visitor v) 
	{
		
	}
	
	private void mover(String direccion)
	{	
		if(direccion.equals("Izquierda"))
			
		{
			//if(Math.abs(posX) < Math.abs(limiteX))
			
			if(posX > 0){
				setPosX(posX-10);
				
			}
			
		}

		if(direccion.equals("Derecha"))				
			setPosX(posX+10);
				
			
		
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
