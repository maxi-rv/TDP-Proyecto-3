package premio;

import java.util.LinkedList;

import humano.Infectado;
import humano.Jugador;
import logica.Entidad;
import visitor.Visitor;

public class Premio extends Entidad{

	protected Estrategia estrategia;
	protected Jugador jugador;
	protected LinkedList<Infectado> infectados;

	//------------
	
	public Premio(Jugador j,LinkedList<Infectado> l ){
		jugador = j;
		infectados = l;
	}
	
	//METODOS
	
	public void aceptar(Visitor v) {		
		
	}

	public Estrategia getEstrategia(){
		return this.estrategia;
	}
	
	public void setEstrategia(Estrategia e){
		this.estrategia = e;		
	}

	public void efecto(){
		estrategia.efecto(jugador,infectados);
	}

	public Entidad ejecutarComportamiento() {
		
		return null;
	}



	
	public boolean listoParaEliminar() {
	
		return false;
	}
}
