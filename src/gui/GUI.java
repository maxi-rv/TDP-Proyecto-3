package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import logica.HiloJuego;
import logica.Juego;

public class GUI {

	protected JFrame frameVentana;
	protected JPanel panelMapa;
	protected Juego juego;
	protected HiloJuego hiloJuego;
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		limiteX = 640;
		limiteY = 640;
		
		frameVentana = new JFrame();
		frameVentana.setTitle("Robot vs Infectados");
		frameVentana.setResizable(false);
		frameVentana.setBounds(0, 0, limiteX, limiteY);
		frameVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVentana.setLocationRelativeTo(null);
		
		iniciarJuego();
		
		setearControlJugador();
		
		jugarJuego();
	}
	
	

	private void jugarJuego() 
	{
		hiloJuego = new HiloJuego(juego);
		hiloJuego.start();
	}

	/*
	 * 
	 */
	private void iniciarJuego() 
	{
		juego = Juego.obtenerInstancia(limiteX, limiteY);
		panelMapa = juego.getMapa().getPanel();
		panelMapa.setLocation(0, 0);
		frameVentana.getContentPane().add(panelMapa);
		frameVentana.pack();
	}
	
	private void setearControlJugador() 
	{
		KeyListener escucha = new EscuchaTeclado();
		panelMapa.addKeyListener(escucha);
		panelMapa.setFocusable(true);
	}
	
	//CLASE ANIDADA
	private class EscuchaTeclado implements KeyListener,ActionListener
    {

        Timer miTimer;

        public EscuchaTeclado() 
        {
            miTimer = new Timer(300, this);
        }
        
        public void keyPressed(KeyEvent e) 
        {
            actuar(e);
        }
        
        public void keyReleased(KeyEvent e) 
        {
            miTimer.stop();
            
            if(e.getExtendedKeyCode() == KeyEvent.VK_UP)
            {
                juego.disparaJugador();
            }
        }
        
        public void actionPerformed(ActionEvent e) 
        {
            juego.disparaJugador();
        }

		@Override
		public void keyTyped(KeyEvent arg0) 
		{
			
		}
        
        protected void actuar(KeyEvent e)
        {
            if(e.getExtendedKeyCode() == KeyEvent.VK_LEFT)
            {
                juego.moverJugador("Izquierda");
            }

            if(e.getExtendedKeyCode() == KeyEvent.VK_RIGHT)
            {
                juego.moverJugador("Derecha");
            }

            if(e.getExtendedKeyCode() == KeyEvent.VK_UP)
            {
                miTimer.start();
            }
        }

        
    }

}
