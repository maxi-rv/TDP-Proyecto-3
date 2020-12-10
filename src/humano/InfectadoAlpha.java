package humano;

import arma.ArmaViralAlpha;
import contenedorGrafico.ContenedorGraficoInfectadoAlpha;
import logica.Entidad;
import visitor.Visitor;
import visitor.VisitorInfectado;

public class InfectadoAlpha extends Infectado
{
	protected boolean velocidadDuplicada;
	
	//CONSTRUCTOR
	public InfectadoAlpha(ArmaViralAlpha ar)
	{
		this.arma = ar;
		this.contenedorGrafico = new ContenedorGraficoInfectadoAlpha();
		this.velocidad = 1;
		this.velocidadGuardada = velocidad;
		this.closeDamage = 1;
		this.visitor = new VisitorInfectado(this);
		this.cargaViral = 3;
		this.velocidadDuplicada = false;
		this.tiempoInicial = System.currentTimeMillis();
	}
	
	//METODOS
	public Entidad ejecutarComportamiento()
	{
		Entidad particula = null;
		
		if(this.posY==(this.limiteY - this.contenedorGrafico.getLabel().getHeight()))
			setPosY(0);
		else
			setPosY(posY+this.velocidad);
		
		if(listoParaDisparar())
		{
			particula = this.disparar();
		}
		
		this.contenedorGrafico.actualizar(posX,posY);
		
		if(cargaViral<=2)
		{
			this.duplicarVelocidad();
		}
		
		return particula;
	}
	
	public void duplicarVelocidad()
	{
		if (!velocidadDuplicada) 
		{
			if(velocidad==0)
			{
				velocidadGuardada = 2 * velocidadGuardada;
			}
			else
			{
				velocidad = 2 * velocidadGuardada;
				velocidadGuardada = velocidad;
			}
			
			
			velocidadDuplicada = true;
		}
	}

	public void aceptar(Visitor v) 
	{
		v.visitar(this);
	}
}
