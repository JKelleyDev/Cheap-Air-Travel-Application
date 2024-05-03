package application;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;


public class ApplicationView extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPage; 
	private JPanel departureFlightsPage; 
	private JPanel returnFlightsPage;
	private JPanel bookingPage; 
	private JPanel confirmationPage; 
	private Routes route ;
    private JPanel paymentPage;
	private JPanel optionPage;
	@SuppressWarnings("unused")
	private ApplicationModel model; 
	private CardLayout c1;
	private Option option; 
	private Traveler traveler;
	private Payment payment;
	
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
		this.setPreferredSize(new Dimension(600, 400));
		this.setResizable(false);
		this.setTitle("Travel With Us: An Afforadable Air Travel Service");
		this.pack();
		this.setLocationRelativeTo(null);
			
		c1 = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(c1);
		this.add(contentPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Options");
			JMenuItem homePage = new JMenuItem("Home Page"); 
			homePage.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) 
			    {
			      c1.show(contentPane, "main");
			      resetModel();
			    }
			});
			
		JMenu printOption = new JMenu("Print Confirmation");

			
		menuBar.add(menu);
			menu.add(homePage); 
			menu.add(printOption);
		
			
		// Create the panels for each page
		FlightsPage departureFlightsPageClass = new FlightsPage(this, route, model, c1, contentPane);
		departureFlightsPage = departureFlightsPageClass.returnPanel(); 
		contentPane.add(departureFlightsPage, "departure flights");
	
		mainPage = (new MainPage(this, route, model, c1, contentPane, departureFlightsPageClass).returnPanel()); 
			contentPane.add(mainPage, "main"); 
			
		bookingPage = (new BookingPage(this,route,model,c1,contentPane, option, traveler).returnPanel()); 
		contentPane.add(bookingPage, "bookingDetails");
    
		optionPage = (new OptionPage(this,route,model,c1,contentPane, option).returnPanel()); 
			contentPane.add(optionPage, "Option");
		
		paymentPage = (new PaymentPage(this,route,model,c1,contentPane, payment).returnPanel()); 

			contentPane.add(paymentPage, "Payment");
			
		confirmationPage = (new ConfirmationPage(this, route, model, c1, contentPane).returnPanel());
			contentPane.add(confirmationPage, "Confirmation");
			
		c1.show(contentPane, "main"); // Start on the main page		


		c1.show(contentPane, "bookingDetails"); 

		c1.show(contentPane, "Confirmation"); 

	}

	public void resetModel() 
	{ 
		main(null); 
	}
	
	
}
