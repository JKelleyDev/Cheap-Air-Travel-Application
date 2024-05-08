package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmationPage
{
	private JFrame frame; 
	private Routes route; 
	private ApplicationModel model; 
	private JPanel contentPane; 
	private CardLayout c1; 
	private JPanel confirmationPage; 
	private FlightManager departureFlight;
	private String departureCity; 
	private String departureDateTime;
	private String departureFlightNumber; 
	private FlightManager returnFlight; 
	private String destinationCity; 
	private String returnDateTime;
	private String returnFlightNumber; 
	
	private JPanel flightInformation; 
	private JPanel travelerInformation; 
	private JPanel costInformation; 
	
	
	
	
	public ConfirmationPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		
	
		confirmationPage = new JPanel(); 
		confirmationPage.setLayout(null);
		frame.setTitle("Confirmation Page");
		
		
		/////// Flight Information Panel ////////
		flightInformation = new JPanel(); 
			flightInformation.setLayout(null);
			flightInformation.setBounds(0, 0, 375, 145); 
			flightInformation.setBackground(Color.red);
			
		JLabel flight1Label = new JLabel("Flight: " + model.getDepartureFlight().getFlightNumber());
			flight1Label.setBounds(2, 0, 120, 30);
			flight1Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			flightInformation.add(flight1Label);
		
		JLabel flightCities1 = new JLabel();
			flightCities1.setText(model.getDepartureCity() + " >>>> " + model.getDestinationCity());
			flightCities1.setBounds(3, 20, 400, 30);
			flightCities1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			flightInformation.add(flightCities1);
			
		JLabel flight1Times = new JLabel(); 
			flight1Times.setText(model.getDepartureFlight().getDepartureTime() + " >>>> " + model.getDepartureFlight().getArrivalTime(model.getDepartureDate()));
			flight1Times.setBounds(3, 35, 400,40);
			flight1Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
			flightInformation.add(flight1Times);
			
			
		if(model.getOneWayFareValue() == false)
		{
			JLabel flight2Label = new JLabel("Flight: " + model.getReturnFlight().getFlightNumber());
				flight2Label.setBounds(2, 70, 120, 30);
				flight2Label.setFont(new Font("Tahoma", Font.BOLD, 12));
				flightInformation.add(flight2Label);
		
			JLabel flightCities2 = new JLabel();
				flightCities2.setText(model.getDestinationCity() + " >>>> " + model.getDepartureCity());
				flightCities2.setBounds(3, 90, 400, 30);
				flightCities2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				flightInformation.add(flightCities2);
				
			JLabel flight2Times = new JLabel(); 
				flight2Times.setText(model.getReturnFlight().getDepartureTime() + " >>>> " + model.getReturnFlight().getArrivalTime(model.getReturnDate()));
				flight2Times.setBounds(3, 105, 400,40);
				flight2Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
				flightInformation.add(flight2Times);
		}
			
			confirmationPage.add(flightInformation); 
		
			
		////// Travler Information Panel /////////
		travelerInformation = new JPanel(); 
			travelerInformation.setLayout(null);
			travelerInformation.setBounds(0, 145, 375, 255); 
			travelerInformation.setBackground(Color.BLUE);
		
			JLabel travelersLabel = new JLabel("Travelers"); 
				travelersLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				travelersLabel.setBounds(2, 0, 90, 30);
				travelerInformation.add(travelersLabel);
			
			
		try {
			
			JLabel traveler1Label = new JLabel(); 
			traveler1Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler1Label.setBounds(2, 30, 375, 30);
			traveler1Label.setText("Traveler 1: " + model.getTraveler(0).toString());
			travelerInformation.add(traveler1Label);
			
		}catch(NullPointerException e )
		{
			
		}
			
			
			
			
			
			
			
			
			
			confirmationPage.add(travelerInformation);
		
		////// Cost Information Panel ///////////
		costInformation = new JPanel(); 
			costInformation.setLayout(null);
			costInformation.setBounds(375, 0, 225, 300); 
			costInformation.setBackground(Color.GRAY);

			
		
		JLabel pricePerPassenger = new JLabel("Price per Passenger: $"); 
			pricePerPassenger.setBounds(5, 5, 145, 30);
			costInformation.add(pricePerPassenger);
		
		
		confirmationPage.add(costInformation);
		
		JButton confirmButton = new JButton("Book"); 
			confirmButton.setBounds(465, 310, 95, 30);
			confirmationPage.add(confirmButton); 
			confirmButton.addActionListener(new ActionListener() 
			{
			    @Override
			    public void actionPerformed(ActionEvent e) 
			    {
			    	confirmButton.setVisible(false);
			    
			    }
			});
		
		
	
	}
	
	public JPanel returnPanel()
	{ 
		return confirmationPage; 
	}
	
	
}
