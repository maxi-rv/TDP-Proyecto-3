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
		int posX,posY, limitX,limitY;
		
		posX = jugador.getPosX();
		posY = jugador.getPosY();
		
		limitX = jugador.getLimiteX();
		limitY = jugador.getLimiteY();
		
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_KP_LEFT){
			if(Math.abs(posX) < Math.abs(limitX))
				jugador.setPosX(posX-5);
		}

		if(e.getExtendedKeyCode() == KeyEvent.VK_KP_RIGHT){
			if(Math.abs(posY) < Math.abs(limitY))
				jugador.setPosY(posY-5);
		}
	}


	
	public void keyReleased(KeyEvent e) {}
}
