package Juego;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Humano.Jugador;

public class ControlJugador implements KeyListener 
{
	//ATRIBUTOS
	protected Jugador jugador;
	
	//CONSTRUCTOR
	public ControlJugador(Jugador jugador)
	{
		this.jugador = jugador;
	}	
	
	public void keyPressed(KeyEvent e) {
		move(e);
	}

	public void keyTyped(KeyEvent e) {
		move(e);
		
	}
	
	private void move(KeyEvent e){
		
		int limitX, posX;
		
		posX = jugador.getPosX();	
		
		limitX = jugador.getLimiteX();
	
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_KP_LEFT){
			if(posX > 0)
				jugador.setPosX(posX-5);
		}

		if(e.getExtendedKeyCode() == KeyEvent.VK_KP_RIGHT){
			if(posX < limitX)
				jugador.setPosX(posX+5);
		}
	}


	
	public void keyReleased(KeyEvent e) {}
}
