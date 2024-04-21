package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class FlightsPage extends JFrame
{
	private JFrame frame;
	private JPanel flightsPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	
	private JPanel flight_option1; 
	private JPanel flight_option2; 
	private JPanel flight_option3; 
	
	private JLabel departureCity1;
	private JLabel departureCity2;
	private JLabel departureCity3;
	
	private JLabel destinationCity1; 
	private JLabel destinationCity2; 
	private JLabel destinationCity3; 
	
	private JLabel flightDuration1; 
	private JLabel flightDuration2; 
	private JLabel flightDuration3; 
	
	private JLabel flightMileage1; 
	private JLabel flightMileage2; 
	private JLabel flightMileage3; 
	
	public FlightsPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
	
		// Set up the page and layout // 
		flightsPage = new JPanel(); 
		flightsPage.setLayout(null);
		
		/////////////////////////////////////////////////////////
	    // Create the first flight option box with all components
		flight_option1 = new JPanel();
		flight_option1.setLayout(null);
		flight_option1.setBounds(0,10,600, 100);
		flight_option1.setBackground(Color.GRAY);
		
		JButton chooseFlight_1 = new JButton("Select");
			chooseFlight_1.setBounds(500, 35, 95, 30);
			flight_option1.add(chooseFlight_1);
			
		JLabel departureCityLabel_1 = new JLabel("Departure City:");
			departureCityLabel_1.setBounds(3, 5, 95, 30);
			flight_option1.add(departureCityLabel_1);
			
			departureCity1 = new JLabel();
				departureCity1.setBounds(103, 5, 95, 30);
				flight_option1.add(departureCity1);
			
		JLabel destinationCityLabel_1 = new JLabel("Destination City:");
			destinationCityLabel_1.setBounds(3, 25, 115, 30);
			flight_option1.add(destinationCityLabel_1);
		
			destinationCity1 = new JLabel(); 
				destinationCity1.setBounds(113, 25, 95, 30);
				flight_option1.add(destinationCity1);
				
		JLabel flightDurationLabel_1 = new JLabel("Flight Duration:"); 
			flightDurationLabel_1.setBounds(3, 45, 100, 30);
			flight_option1.add(flightDurationLabel_1);
			
			flightDuration1 = new JLabel(); 
			flightDuration1.setBounds(103,45,135,30);
			flight_option1.add(flightDuration1);
				
		JLabel flightMileageLabel_1 = new JLabel("Flight Mileage:");
			flightMileageLabel_1.setBounds(3, 65, 100, 30);
			flight_option1.add(flightMileageLabel_1);
			
			flightMileage1 = new JLabel(); 
			flightMileage1.setBounds(103, 65, 100, 30);
			flight_option1.add(flightMileage1); 
			
		////////////////////////////////////////////////////	
			
		// Create the second flight option box with all components 
		flight_option2 = new JPanel();
		flight_option2.setLayout(null);
		flight_option2.setBounds(0,125, 600, 100);
		flight_option2.setBackground(Color.GRAY);
		
		JButton chooseFlight_2 = new JButton("Select");
			chooseFlight_2.setBounds(500, 35, 95, 30);
			flight_option2.add(chooseFlight_2);
	    
		JLabel departureCityLabel_2 = new JLabel("Departure City:");
			departureCityLabel_2.setBounds(3, 5, 95, 30);
			flight_option2.add(departureCityLabel_2);
				departureCity2 = new JLabel();
				departureCity2.setBounds(103, 5, 95, 30);
				flight_option2.add(departureCity2);
			
		JLabel destinationCityLabel_2 = new JLabel("Destination City:");
			destinationCityLabel_2.setBounds(3, 25, 115, 30);
			flight_option2.add(destinationCityLabel_2);
				destinationCity2 = new JLabel(); 
				destinationCity2.setBounds(113, 25, 95, 30);
				flight_option2.add(destinationCity2);
		    
		JLabel flightDurationLabel_2 = new JLabel("Flight Duration:"); 
			flightDurationLabel_2.setBounds(3, 45, 100, 30);
			flight_option2.add(flightDurationLabel_2);
				
			flightDuration2 = new JLabel(); 
				flightDuration2.setBounds(103,45,135,30);
				flight_option2.add(flightDuration2);
					
		JLabel flightMileageLabel_2 = new JLabel("Flight Mileage:");
				flightMileageLabel_2.setBounds(3, 65, 100, 30);
				flight_option2.add(flightMileageLabel_2);
				
				flightMileage2 = new JLabel(); 
				flightMileage2.setBounds(103, 65, 100, 30);
				flight_option2.add(flightMileage2);		
				
				
		///////////////////////////////////////////////////////////////////////////		
				
		// Create the third flight option box with all components 
		flight_option3 = new JPanel();
		flight_option3.setLayout(null);
		flight_option3.setBounds(0,240, 600, 100);
		flight_option3.setBackground(Color.GRAY);
		
		JButton chooseFlight_3 = new JButton("Select");
			chooseFlight_3.setBounds(500, 35, 95, 30);
			flight_option3.add(chooseFlight_3);
			
		JLabel departureCityLabel_3 = new JLabel("Departure City:");
			departureCityLabel_3.setBounds(3, 5, 95, 30);
			flight_option3.add(departureCityLabel_3);
			departureCity3 = new JLabel();
				departureCity3.setBounds(103, 5, 95, 30);
				flight_option3.add(departureCity3);
			
		JLabel destinationCityLabel_3 = new JLabel("Destination City:");
			destinationCityLabel_3.setBounds(3, 25, 115, 30);
			flight_option3.add(destinationCityLabel_3);
			destinationCity3 = new JLabel(); 
				destinationCity3.setBounds(113, 25, 95, 30);
				flight_option3.add(destinationCity3);
		    
		JLabel flightDurationLabel_3 = new JLabel("Flight Duration:"); 
			flightDurationLabel_3.setBounds(3, 45, 100, 30);
			flight_option3.add(flightDurationLabel_3);
					
				flightDuration3 = new JLabel(); 
					flightDuration3.setBounds(103,45,135,30);
					flight_option3.add(flightDuration3);
						
		JLabel flightMileageLabel_3 = new JLabel("Flight Mileage:");
			flightMileageLabel_3.setBounds(3, 65, 100, 30);
			flight_option3.add(flightMileageLabel_3);
					
				flightMileage3 = new JLabel(); 
					flightMileage3.setBounds(103, 65, 100, 30);
					flight_option3.add(flightMileage3);	
				
			flightsPage.add(flight_option1);
			flightsPage.add(flight_option2);
			flightsPage.add(flight_option3);
	}
	
	public void setDepartureData()
	{ 			
		departureCity1.setText(model.getDepartureCity());
		destinationCity1.setText(model.getDestinationCity());
		flightDuration1.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
		flightMileage1.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");
		
		departureCity2.setText(model.getDepartureCity());
		destinationCity2.setText(model.getDestinationCity());
		flightDuration2.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
		flightMileage2.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");
		
		departureCity3.setText(model.getDepartureCity());
		destinationCity3.setText(model.getDestinationCity());
		flightDuration3.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
		flightMileage3.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");	
	}
	
	public JPanel returnPanel() 
	{ 
		return flightsPage; 
	}
}