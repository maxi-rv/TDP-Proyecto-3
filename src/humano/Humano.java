package humano;

import arma.Arma;
import logica.Entidad;
import proyectil.Proyectil;

public abstract class Humano extends Entidad
{
	//ATRIBUTOS
	protected int cargaViral;
	protected Arma arma;
	
	//METODOS
	public Proyectil disparar()	
	{
		Proyectil proyectil = arma.disparar();
		
		proyectil.setLimiteX(this.limiteX);
		proyectil.setLimiteY(this.limiteY);
		proyectil.setPosX(this.posX + (this.contenedorGrafico.getLabel().getWidth()/3));
		proyectil.setPosY(this.posY);
		
		return proyectil;
	}
	
	public int getCargaViral()
	{
		return cargaViral;
	}
}
