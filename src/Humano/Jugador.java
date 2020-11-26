package Humano;

import javax.swing.JLabel;

import Arma.ArmaSanitaria;
import Proyectil.Proyectil;
import Visitor.Visitor;

public class Jugador extends Humano
{
	//CONSTRUCTOR
	public Jugador(ArmaSanitaria ar)
	{
		this.arma = ar;
	}
	
	//METODOS
	public void aumentarCargaViral(int damage)
	{
		this.cargaViral = this.cargaViral + damage;
	}


	public void moverse(String direccion){
		mover(direccion);
		
	}

	public void aceptar(Visitor v) 
	{
		
		
	}	

	
	public Proyectil disparar()	{
		
		return null;
	}
	
	private void mover(String direccion){	
		
		
		if(direccion == "Izquierda"){
			if(Math.abs(posY) < Math.abs(limiteY))
				setPosY(posY-5);
		}

		if(direccion == "Derecha"){
			if(Math.abs(posY) < Math.abs(limiteY))
				setPosY(posY+5);
		}
		
		actualizar(posX,posY);
		
	}
	
	private void actualizar(int posX,int posY){
		this.contenedorGrafico.actualizar(posX,posY);
	}
	
	public void moverse() {}

}
