package proyectil;

public abstract class Particula extends Proyectil
{
	protected int rango;
	protected int recorrido;
	
	public boolean listoParaEliminar() 
	{
		return (posY+this.contenedorGrafico.getLabel().getHeight()==limiteY) || (recorrido>=rango) || (listoParaEliminar);
	}
}
