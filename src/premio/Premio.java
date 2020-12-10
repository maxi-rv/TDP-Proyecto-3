package premio;

import logica.Entidad;
import visitor.Visitor;

public class Premio extends Entidad{

	protected Estrategia estrategia;

	
	
	//METODOS



	
	public void aceptar(Visitor v) {
		
		
	}

	public Estrategia getEstrategia(){
		return this.estrategia;
	}
	
	public void setEstrategia(Estrategia e){
		this.estrategia = e;		
	}


	public Entidad ejecutarComportamiento() {
		
		return null;
	}



	
	public boolean listoParaEliminar() {
	
		return false;
	}
}
