package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Juego.Juego;

public class GUI {

	private JFrame frmRobotVsInfectados;
	private JPanel panelMapa;
	private Juego juego;
	
	//HOLA!
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
					window.frmRobotVsInfectados.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		initialize();
		iniciarJuego();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmRobotVsInfectados = new JFrame();
		frmRobotVsInfectados.setTitle("Robot vs Infectados");
		frmRobotVsInfectados.setResizable(false);
		frmRobotVsInfectados.setBounds(100, 100, 640, 480);
		frmRobotVsInfectados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyListener escucha = new EscuchaTeclado();
		panelMapa.addKeyListener(escucha);
		
	}
	
	/*
	 * 
	 */
	private void iniciarJuego() 
	{
		juego = Juego.obtenerInstancia();
		panelMapa = juego.getMapa();
		
		//QUE MAS???
	}
	
	
	
	public void mover(String direccion){
		
		
	}
	
	public void disparar(){
		
		
	}
	
	private class EscuchaTeclado implements KeyListener{
		
		public void keyPressed(KeyEvent e) {
			actuar(e);
		}

		public void keyTyped(KeyEvent e) {
			actuar(e);
			
		}
		
		private void actuar(KeyEvent e){			
			
			if(e.getExtendedKeyCode() == KeyEvent.VK_KP_LEFT){
				juego.moverJugador("Izquierda");
			}

			if(e.getExtendedKeyCode() == KeyEvent.VK_KP_RIGHT){
				juego.moverJugador("Derecha");
			}
			
			if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
				juego.disparaJugador();
			}
		}


		
		public void keyReleased(KeyEvent e) {}
		
		
	}

}
