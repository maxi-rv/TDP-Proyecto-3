package humano;

import arma.ArmaViralAlpha;
import contenedorGrafico.ContenedorGraficoInfectadoAlpha;
import visitor.Visitor;
import visitor.VisitorInfectado;

public class InfectadoAlpha extends Infectado
{
	//CONSTRUCTOR
	public InfectadoAlpha(ArmaViralAlpha ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoInfectadoAlpha();
		this.velocidad = 1;
		this.closeDamage = 1;
		this.visitor = new VisitorInfectado(this);
		this.cargaViral = 2;
		
		this.tiempoInicial = System.currentTimeMillis();
	}
	
	//METODOS
	public void duplicarVelocidad()
	{
		velocidad=2*velocidad;
	}

	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
}
