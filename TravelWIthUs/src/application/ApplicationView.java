package application;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;


public class ApplicationView extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPage; 
	private JPanel flightsPage; 
	private JPanel bookingPage; 
	private Routes route ;
	@SuppressWarnings("unused")
	private ApplicationModel model; 
	private CardLayout c1;
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
					Routes route = new Routes();
					ApplicationView frame = new ApplicationView(new ApplicationModel(route), route);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicationView(ApplicationModel model, Routes route)
	{
		this.model = model; 
		this.route = route; 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Travel With Us: An Afforadable Air Travel Service");
		
		c1 = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(c1);
		this.add(contentPane);
		
		// Create our panels for each page
		mainPage = (new MainPage(this, route, model, c1, contentPane).returnPanel()); 
			contentPane.add(mainPage, "main"); 
			
		flightsPage = new JPanel(); 
			contentPane.add(flightsPage, "flights");
			
		bookingPage = new JPanel(); 
			contentPane.add(bookingPage, "bookingDetails");
		
		c1.show(contentPane, "main"); // Start on the main page
	    
		
		


	}

	

	
	
}
