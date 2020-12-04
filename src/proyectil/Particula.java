package proyectil;

public abstract class Particula extends Proyectil
{
	public boolean listoParaEliminar() 
	{
		return (posY+this.contenedorGrafico.getLabel().getHeight() == limiteY);
	}
}
