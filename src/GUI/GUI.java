package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Juego.Juego;

public class GUI {

	private JFrame frameVentana;
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
		frameVentana = new JFrame();
		frameVentana.setTitle("Robot vs Infectados");
		frameVentana.setResizable(false);
		frameVentana.setBounds(100, 100, 640, 480);
		frameVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVentana.setLocationRelativeTo(null);
	//	frameVentana.getContentPane().setLayout(null);
		
		
		iniciarJuego();
		
		frameVentana.getContentPane().add(panelMapa);
		
		KeyListener escucha = new EscuchaTeclado();
		
	   // frameVentana.getContentPane().setFocusable(true);
       // frameVentana.getContentPane().addKeyListener(escucha);
		panelMapa.addKeyListener(escucha);
		panelMapa.setFocusable(true);
		
		
	}
	
	/*
	 * 
	 */
	private void iniciarJuego() 
	{
		juego = Juego.obtenerInstancia();
		panelMapa = juego.getMapa().getPanel();
		System.out.println("Limite "+ juego.getMapa().getLimiteX());
		
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
