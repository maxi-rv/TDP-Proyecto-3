package humano;

import arma.ArmaSanitaria;
import contenedorGrafico.ContenedorGraficoJugador;
import logica.Entidad;
import visitor.Visitor;
import visitor.VisitorJugador;

public class Jugador extends Humano
{
	//CONSTRUCTOR
	public Jugador(ArmaSanitaria ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoJugador();
		this.velocidad = 15;
		this.visitor = new VisitorJugador(this);
	}
	
	//METODOS
	public void aumentarCargaViral(int damage)
	{
		this.cargaViral = this.cargaViral + damage;
	}

	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
	
	public Entidad ejecutarComportamiento()
	{
		this.contenedorGrafico.actualizar(posX,posY);
		
		return null;
	}

	@Override
	public boolean listoParaEliminar() 
	{
		return this.cargaViral==10;
	}

}
