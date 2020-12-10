package humano;

import logica.Entidad;

public abstract class Infectado extends Humano
{
	protected int closeDamage;
	protected long tiempoInicial;
	protected int velocidadGuardada;
	
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
		
		return particula;
	}
	
	public void reducirCargaViral(int damage) 
	{
		this.cargaViral = this.cargaViral - damage;
	}
	
	public boolean listoParaEliminar() 
	{
		return this.cargaViral<=0;
	}
	
	public int getCloseDamage()
	{
		return this.closeDamage;
	}
	
	protected boolean listoParaDisparar() 
	{
		boolean toReturn = false;
		
		long tiempoActual = System.currentTimeMillis();
        int segundos = (int)((tiempoActual - this.tiempoInicial) / 1000);
        
        if(segundos == 3)
        {
        	this.tiempoInicial = System.currentTimeMillis();
        	toReturn = true;
        }
        
		
		return toReturn;
	}
	
	public void detener()
	{
		velocidad = 0;		
	}
	
	public void reanudar()
	{
		velocidad = velocidadGuardada;
	}
}
