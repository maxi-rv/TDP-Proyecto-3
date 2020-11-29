package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Juego.Juego;

public class GUI {

	protected JFrame frameVentana;
	protected JPanel panelMapa;
	protected Juego juego;
	protected int limiteX;
	protected int limiteY;
	
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
					window.frameVentana.setVisible(true);
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
		limiteX = 600;
		limiteY = 600;
		
		frameVentana = new JFrame();
		frameVentana.setTitle("Robot vs Infectados");
		frameVentana.setResizable(false);
		frameVentana.setBounds(0, 0, limiteX, limiteY);
		frameVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVentana.setLocationRelativeTo(null);
		//frameVentana.getContentPane().setLayout(null);
		
		iniciarJuego();
		
		frameVentana.getContentPane().add(panelMapa);
		panelMapa.setLocation(0, 0);
		
		KeyListener escucha = new EscuchaTeclado();
		
		//frameVentana.getContentPane().setFocusable(true);
		//frameVentana.getContentPane().addKeyListener(escucha);
		panelMapa.addKeyListener(escucha);
		panelMapa.setFocusable(true);
		
		
	}
	
	/*
	 * 
	 */
	private void iniciarJuego() 
	{
		juego = Juego.obtenerInstancia(limiteX-150, limiteY-247);
		panelMapa = juego.getMapa().getPanel();
		System.out.println("Limite Mapa:"+ juego.getMapa().getLimiteX());
		
		//QUE MAS???
	}
	
	
	
	public void mover(String direccion){
		
		
	}
	
	public void disparar(){
		
		
	}
	
	//CLASE ANIDADA
	private class EscuchaTeclado implements KeyListener
	{
		
		public void keyPressed(KeyEvent e) 
		{
			actuar(e);
			
		}

		public void keyTyped(KeyEvent e) 
		{
			actuar(e);
			
		}
		
		private void actuar(KeyEvent e)
		{  
			
			if(e.getExtendedKeyCode() == KeyEvent.VK_LEFT)
			{
				juego.moverJugador("Izquierda");
			}

			if(e.getExtendedKeyCode() == KeyEvent.VK_RIGHT)
			{
				
				juego.moverJugador("Derecha");
			}
			
			if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE)
			{
				juego.disparaJugador();
			}
		}
		
		public void keyReleased(KeyEvent e) 
		{
			
		}
	}

}
