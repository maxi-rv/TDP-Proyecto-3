package GUI;

import java.awt.EventQueue;

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

}
