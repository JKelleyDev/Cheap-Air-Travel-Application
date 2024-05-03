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
	private JPanel travlerInformation; 
	private JPanel costInformation; 
	
	
	
	
	public ConfirmationPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		
		try { 
		this.departureFlight = model.getDepartureFlight(); 
		this.departureDateTime = departureFlight.getDepartureTime(); 
		this.departureFlightNumber = departureFlight.getFlightNumber(); 
		this.departureCity = model.getDepartureCity(); 
		
		
		if(model.getOneWayFareValue() == false)
		{ 
			this.returnFlight = model.getReturnFlight(); 
			this.returnDateTime = returnFlight.getDepartureTime(); 
			this.returnFlightNumber = returnFlight.getFlightNumber(); 
			this.destinationCity = model.getDestinationCity(); 
			
		}
		} 
		catch(NullPointerException e)
		{
			System.out.println("Waiting for model information input...");
		}
		confirmationPage = new JPanel(); 
		confirmationPage.setLayout(null);
		frame.setTitle("Confirmation Page");
		
		
		
		flightInformation = new JPanel(); 
			flightInformation.setBounds(0, 0, 425, 200); 
			flightInformation.setBackground(Color.red);
		
			confirmationPage.add(flightInformation); 
		
		
		travlerInformation = new JPanel(); 
			travlerInformation.setBounds(0, 200, 425, 200); 
			travlerInformation.setBackground(Color.BLUE);
		
			confirmationPage.add(travlerInformation);
		
		
		costInformation = new JPanel(); 
			costInformation.setBounds(430, 0, 165, 300); 
			costInformation.setBackground(Color.BLACK);
		
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
