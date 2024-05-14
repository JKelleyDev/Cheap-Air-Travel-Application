package application;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class SeeFlightButtonHandler implements ActionListener
{ 
	private JFrame frame;
	private CardLayout c1; 
	private JPanel contentPane; 
	private FlightsPage departureFlightsPage;
	private ApplicationModel model; 
	private Routes route; 

	public SeeFlightButtonHandler(JFrame frame, CardLayout c1, JPanel contentPane, FlightsPage departureFlightsPage, ApplicationModel model, Routes route) 
	{ 
		
		this.frame = frame; 
		this.c1 = c1; 
		this.contentPane = contentPane; 
		this.departureFlightsPage = departureFlightsPage; 
		this.model = model; 
		this.route = route; 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String errorDateMessage = "              Missing Information! \n Ensure you have completed all selections"; 
		
		try {
			 
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate currentDate = LocalDate.now();
			String departureDateString = model.getDepartureDate(); // Fetch the date from the model
		    LocalDate departureDate = LocalDate.parse(departureDateString, dateFormatter);
		    
		    if(model.getOneWayFareValue() != true)
		    {
		    	String returnDateString = model.getReturnDate(); // Fetch the return date from the model ]
		    	LocalDate returnDate = LocalDate.parse(returnDateString, dateFormatter);
		    	
			    // Compare the parsed return date with the current date
		    	if(returnDate.isBefore(departureDate) || returnDate.isEqual(departureDate))
				    {
				    	errorDateMessage = "The return date must be at least the day after departure."; 
				    	throw new Exception();
				    }
		    }
		    
		    // Compare the parsed departure date with the current date
		    if (departureDate.isBefore(currentDate)) 
		    {
		    	errorDateMessage = "The departure date cannot be before today.";
		    	throw new Exception(); 
		    }
		    
			route.setDepartDate(model.getDepartureDate());
			departureFlightsPage.setDepartureData();
			c1.show(contentPane, "departure flights");
			frame.setTitle("Departure Flights");
		}
		catch(NullPointerException n)
		{
			JOptionPane.showMessageDialog(null, "No Flights available, please change selections.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception f)
		{ 
			JOptionPane.showMessageDialog(null, errorDateMessage, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
