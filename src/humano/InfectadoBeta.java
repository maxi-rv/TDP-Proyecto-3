package humano;

import arma.ArmaViralBeta;
import contenedorGrafico.ContenedorGraficoInfectadoBeta;
import visitor.Visitor;
import visitor.VisitorInfectado;

public class InfectadoBeta extends Infectado
{
	//CONSTRUCTOR
	public InfectadoBeta(ArmaViralBeta ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoInfectadoBeta();
		this.velocidad = 1;
		this.closeDamage = 1;
		this.visitor = new VisitorInfectado(this);
		this.cargaViral = 4;
		
		this.tiempoInicial = System.currentTimeMillis();
	}	
	
	//METODOS
	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
}
