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
		this.contenedorGrafico.actualizar(posX,posY);
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean listoParaEliminar() {
		// TODO Auto-generated method stub
		return false;
	}

}
