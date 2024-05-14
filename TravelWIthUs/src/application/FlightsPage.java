package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author Jordan Kelley
* @author Esteban Naranjo
* 
* @version 2024.05.24.001
* 
* @see
* 	References:<br>
*         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
*         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
* 
*
* <br><br>
* Responsibilities of class:<br>
* 
*/

public class FlightsPage extends JFrame
{
	private static final long serialVersionUID = 2279549375098327669L;
	private JFrame frame;
	private JPanel flightsPage;
	private Routes route; 
	private ApplicationModel model;

	private FlightManager flight1; 
	private FlightManager flight2; 
	private FlightManager flight3; 
	
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
	
	private JLabel flightDeparture1; 
	private JLabel flightDeparture2; 
	private JLabel flightDeparture3; 
	
	private JLabel flightArrival1; 
	private JLabel flightArrival2; 
	private JLabel flightArrival3; 
	
	public FlightsPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
	
		// Set up the page and layout // 
		flightsPage = new JPanel(); 
		flightsPage.setLayout(null);
		Color backgroundColor = new Color(236, 240, 241);
		
		
		
		
		
		/////////////////////////////////////////////////////////
	    // Create the first flight option box with all components
		flight_option1 = new JPanel();
		flight_option1.setLayout(null);
		flight_option1.setBounds(0,10,600, 100);
		flight_option1.setBackground(backgroundColor);
		
		JButton chooseFlight_1 = new JButton("Select");
			chooseFlight_1.setBounds(500, 35, 95, 30);
			flight_option1.add(chooseFlight_1);
			
			chooseFlight_1.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) 
			    {
			   
			    	
			        if(model.getDepartureFlight() == null)
			        { 
			        	model.setDepartureFlight(flight1);
			        	
			        	if(model.getOneWayFareValue() == true)
			        	{
			        		c1.show(contentPane, "bookingDetails");
			        		
			        	}
			        	else
			        	{
			        		setReturnData();
			        	}
			        }
			        else if(model.getDepartureFlight() != null && model.getReturnFlight() == null)
			        { 
			        	model.setReturnFlight(flight1);
			        	c1.show(contentPane, "bookingDetails");
			        }
			    }
			});
		
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
			
		JLabel flightDepartureTimeLabel_1 = new JLabel("Departure Time:"); 
			flightDepartureTimeLabel_1.setBounds(275, 5, 120, 30);
			flight_option1.add(flightDepartureTimeLabel_1);
			
			flightDeparture1 = new JLabel(); 
			flightDeparture1.setBounds(380, 5, 120, 30);
			flight_option1.add(flightDeparture1);
			
		JLabel flightArrivalTimeLabel_1 = new JLabel("Arrival Time: "); 
			flightArrivalTimeLabel_1.setBounds(275, 35, 120, 30); 
			flight_option1.add(flightArrivalTimeLabel_1);
			
			flightArrival1 = new JLabel(); 
			flightArrival1.setBounds(380, 35, 120, 30);
			flight_option1.add(flightArrival1); 
		////////////////////////////////////////////////////	
			
		// Create the second flight option box with all components 
		flight_option2 = new JPanel();
		flight_option2.setLayout(null);
		flight_option2.setBounds(0,125, 600, 100);
		flight_option2.setBackground(backgroundColor);
		
		JButton chooseFlight_2 = new JButton("Select");
			chooseFlight_2.setBounds(500, 35, 95, 30);
			flight_option2.add(chooseFlight_2);
			
			chooseFlight_2.addActionListener(new ActionListener() 
			{
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        // Code to execute when the button is clickd
			        
			        if(model.getDepartureFlight() == null)
			        { 
			        	model.setDepartureFlight(flight1);
			        	
			        	if(model.getOneWayFareValue() == true)
			        	{
			        		c1.show(contentPane, "bookingDetails");
			        		
			        	}
			        	else
			        	{
			        	setReturnData();
			        	}
			        }
			        else if(model.getDepartureFlight() != null && model.getReturnFlight() == null)
			        { 
			        	model.setReturnFlight(flight1);
			        	c1.show(contentPane, "bookingDetails");
			        }
			    }
			});
			
			
			
			
	    
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
				
		JLabel flightDepartureTimeLabel_2 = new JLabel("Departure Time:"); 
				flightDepartureTimeLabel_2.setBounds(275, 5, 120, 30);
				flight_option2.add(flightDepartureTimeLabel_2);
				
				flightDeparture2 = new JLabel(); 
				flightDeparture2.setBounds(380, 5, 120, 30);
				flight_option2.add(flightDeparture2);
				
		JLabel flightArrivalTimeLabel_2 = new JLabel("Arrival Time: "); 
				flightArrivalTimeLabel_2.setBounds(275, 35, 120, 30); 
				flight_option2.add(flightArrivalTimeLabel_2);
				
				flightArrival2 = new JLabel(); 
				flightArrival2.setBounds(380, 35, 120, 30);
				flight_option2.add(flightArrival2); 
		///////////////////////////////////////////////////////////////////////////		
				
		// Create the third flight option box with all components 
		flight_option3 = new JPanel();
		flight_option3.setLayout(null);
		flight_option3.setBounds(0,240, 600, 100);
		flight_option3.setBackground(backgroundColor);
		
		JButton chooseFlight_3 = new JButton("Select");
			chooseFlight_3.setBounds(500, 35, 95, 30);
			flight_option3.add(chooseFlight_3);
			
			chooseFlight_3.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        // Code to execute when the button is clickd
			        
			        if(model.getDepartureFlight() == null)
			        { 
			        	model.setDepartureFlight(flight1);
			        	
			        	if(model.getOneWayFareValue() == true)
			        	{
			        		c1.show(contentPane, "bookingDetails");
			        		
			        	}
			        	else
			        	{
			        	setReturnData();
			        	}
			        }
			        else if(model.getDepartureFlight() != null && model.getReturnFlight() == null)
			        { 
			        	model.setReturnFlight(flight1);
			        	c1.show(contentPane, "bookingDetails");
			        }
			    }
			});
			
			
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
					
		JLabel flightDepartureTimeLabel_3 = new JLabel("Departure Time:"); 
				flightDepartureTimeLabel_3.setBounds(275, 5, 120, 30);
				flight_option3.add(flightDepartureTimeLabel_3);
					
				flightDeparture3 = new JLabel(); 
				flightDeparture3.setBounds(380, 5, 120, 30);
				flight_option3.add(flightDeparture3);
			
		JLabel flightArrivalTimeLabel_3 = new JLabel("Arrival Time: "); 
				flightArrivalTimeLabel_3.setBounds(275, 35, 120, 30); 
				flight_option2.add(flightArrivalTimeLabel_3);
				
				flightArrival3 = new JLabel(); 
				flightArrival3.setBounds(380, 35, 120, 30);
				flight_option3.add(flightArrival3); 		
				
				
				flightsPage.add(flight_option1);
				flightsPage.add(flight_option2);
				flightsPage.add(flight_option3);
	}
	
	public void setDepartureData()
	{ 		
		FlightManager [] flightOptions = route.getListOfFlights(model.getDepartureCity(), model.getDestinationCity());
		
		try { 
			flight1 = flightOptions[0];
			departureCity1.setText(model.getDepartureCity());
			destinationCity1.setText(model.getDestinationCity());
			flightDuration1.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
			flightMileage1.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");
			flightDeparture1.setText(flight1.getDepartureTime());
			flightArrival1.setText(flight1.getArrivalTime(model.getDepartureDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option1.setVisible(false);
		}
		try { 
			flight2 = flightOptions[1];
			departureCity2.setText(model.getDepartureCity());
			destinationCity2.setText(model.getDestinationCity());
			flightDuration2.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
			flightMileage2.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");
			flightDeparture2.setText(flight2.getDepartureTime());
			flightArrival2.setText(flight2.getArrivalTime(model.getDepartureDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option2.setVisible(false);
		}
		try { 
			flight3 = flightOptions[2];
			departureCity3.setText(model.getDepartureCity());
			destinationCity3.setText(model.getDestinationCity());
			flightDuration3.setText(route.getFlightDuration(model.getDepartureCity(), model.getDestinationCity()));
			flightMileage3.setText(route.getFlightMiles(model.getDepartureCity(), model.getDestinationCity()) + " Miles");	
			flightDeparture3.setText(flight3.getDepartureTime());
			flightArrival3.setText(flight3.getArrivalTime(model.getDepartureDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option3.setVisible(false);
		}

	}
	
	public void setReturnData()
	{ 		
		FlightManager [] flightOptions = route.getListOfFlights(model.getDestinationCity(), model.getDepartureCity());
		route.setDepartDate(model.getReturnDate());
		frame.setTitle("Return Flights");
		
		try { 
			flight1 = flightOptions[0];
			departureCity1.setText(model.getDestinationCity());
			destinationCity1.setText(model.getDepartureCity());
			flightDuration1.setText(route.getFlightDuration(model.getDestinationCity(), model.getDepartureCity()));
			flightMileage1.setText(route.getFlightMiles(model.getDestinationCity(), model.getDepartureCity()) + " Miles");
			flightDeparture1.setText(flight1.getDepartureTime());
			flightArrival1.setText(flight1.getArrivalTime(model.getReturnDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option1.setVisible(false);
		}
		try { 
			flight2 = flightOptions[1];
			departureCity2.setText(model.getDestinationCity());
			destinationCity2.setText(model.getDepartureCity());
			flightDuration2.setText(route.getFlightDuration(model.getDestinationCity(), model.getDepartureCity()));
			flightMileage2.setText(route.getFlightMiles(model.getDestinationCity(), model.getDepartureCity()) + " Miles");
			flightDeparture2.setText(flight2.getDepartureTime());
			flightArrival2.setText(flight2.getArrivalTime(model.getReturnDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option2.setVisible(false);
		}
		try { 
			flight3 = flightOptions[2];
			departureCity3.setText(model.getDestinationCity());
			destinationCity3.setText(model.getDepartureCity());
			flightDuration3.setText(route.getFlightDuration(model.getDestinationCity(), model.getDepartureCity()));
			flightMileage3.setText(route.getFlightMiles(model.getDestinationCity(), model.getDepartureCity()) + " Miles");	
			flightDeparture3.setText(flight3.getDepartureTime());
			flightArrival3.setText(flight3.getArrivalTime(model.getReturnDate()));
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			flight_option3.setVisible(false);
		}

	}
	
	public JPanel returnPanel() 
	{ 
		return flightsPage; 
	}
}