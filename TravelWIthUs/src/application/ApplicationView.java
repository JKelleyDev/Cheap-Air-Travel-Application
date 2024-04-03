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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(c1);
		this.add(contentPane);
		
		mainPage = new JPanel(); 
			contentPane.add(mainPage, "1"); 
		flightsPage = new JPanel(); 
			contentPane.add(flightsPage, "2");
		bookingPage = new JPanel(); 
			contentPane.add(bookingPage, "3");
		
		
		c1.show(contentPane, "1"); // Start on the main page
	    
		
		
		JButton aboutButton = new JButton("About");
		aboutButton.setBackground(new Color(0, 0, 128));
		aboutButton.setForeground(new Color(255, 255, 255));
		aboutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		aboutButton.setBounds(358, 6, 86, 29);
		aboutButton.setBorderPainted(false);
		aboutButton.setOpaque(true);
		mainPage.add(aboutButton);
		
		JButton routeButton = new JButton("Routes");
		routeButton.setForeground(new Color(255, 255, 255));
		routeButton.setBackground(new Color(0, 0, 128));
		routeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		routeButton.setBounds(173, 6, 86, 29);
		routeButton.setBorderPainted(false);
		routeButton.setOpaque(true);
		mainPage.add(routeButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		helpButton.setBackground(new Color(0, 0, 128));
		helpButton.setForeground(new Color(255, 255, 255));
		helpButton.setBounds(271, 6, 75, 29);
		helpButton.setBorderPainted(false);
		helpButton.setOpaque(true);
		mainPage.add(helpButton);
		
		JLabel departureLabel = new JLabel("Departure:");
		departureLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departureLabel.setBounds(6, 79, 61, 16);
		mainPage.add(departureLabel);
		
		JLabel returnLabel = new JLabel("Return:");
		returnLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		returnLabel.setBounds(6, 112, 61, 16);
		mainPage.add(returnLabel);
		
		JCheckBox oneWayCheckBox = new JCheckBox("One Way Flight");
		oneWayCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		oneWayCheckBox.setBounds(6, 135, 128, 23);
		mainPage.add(oneWayCheckBox);
		
		JLabel lblNewLabel = new JLabel("Affordable \nAir \nTravel");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 155, 61);
		lblNewLabel.setOpaque(true);
		mainPage.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(68, 74, 93, 26);
		mainPage.add(spinner);
		
		JSpinner returnSpinner = new JSpinner();
		returnSpinner.setBounds(68, 107, 93, 26);
		mainPage.add(returnSpinner);
		
		JList<String> departureCityList = new JList<String>(route.getDepartures());
		departureCityList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departureCityList.setLayoutOrientation(JList.VERTICAL);
		departureCityList.setVisibleRowCount(5);
		JScrollPane departureScroll = new JScrollPane(departureCityList); 
		departureScroll.setBounds(173, 145, 119, 85);
		mainPage.add(departureScroll);
		
		JList<String> destinationCityList = new JList<String>();
		destinationCityList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane destinationScroll = new JScrollPane(destinationCityList); 
		destinationCityList.setVisibleRowCount(5);
		destinationScroll.setBounds(317, 145, 123, 85);
		mainPage.add(destinationScroll);
	
		JLabel destinationCityListLabel = new JLabel("Desination City");
		destinationCityListLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		destinationCityListLabel.setBounds(342, 123, 75, 16);
		mainPage.add(destinationCityListLabel);
		
		JLabel departureCityListLabel = new JLabel("Departure City");
		departureCityListLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		departureCityListLabel.setBounds(196, 123, 75, 16);
		mainPage.add(departureCityListLabel);
		
	
		JButton seeFlightButton = new JButton("See Flights");
		seeFlightButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seeFlightButton.setBackground(new Color(0, 0, 128));
		seeFlightButton.setBounds(327, 237, 117, 29);
		mainPage.add(seeFlightButton);
		
		
		//Action Listeners
		departureCityList.addListSelectionListener(new DepartureListSelectionHandler(departureCityList,destinationCityList, model)); //listener
		destinationCityList.addListSelectionListener(new  DestinationCityListSelectionHandler(destinationCityList, model) );
		oneWayCheckBox.addItemListener(new OneWayCheckBoxItemHandler(model,returnSpinner, returnLabel));
		helpButton.addActionListener(new HelpButtonHandler(helpButton, this));
		aboutButton.addActionListener(new AboutButtonHandler(aboutButton, this));
		seeFlightButton.addActionListener(new SeeFlightButtonHandler(seeFlightButton, this,c1, contentPane));
		

	}

	

	
	
}
