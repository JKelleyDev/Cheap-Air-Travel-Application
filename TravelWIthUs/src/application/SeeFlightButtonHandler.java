package application;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
* This class is a custom handler for when the see flight button it clicked. This will check to make sure dates are correctly choosen 
* and then if everything is selected correctly, it will change view to the flights page. 
* 
*/

public class SeeFlightButtonHandler implements ActionListener
{ 
	private JFrame frame;  // the custom handler has a reference to the frame 
	private CardLayout c1; // the custom handler has a reference to the card layout 
	private JPanel contentPane; // the custom handler has a reference to the contentPane
	private FlightsPage departureFlightsPage; // the custom handler has a reference to the flights page
	private ApplicationModel model; // the custom handler has a reference to the model
	private Routes route; // the custom handler has a refernce to the routes

	/** 
	 * Purpose: Constructor to setup the custom flight button handler
	 * @param frame
	 * @param c1
	 * @param contentPane
	 * @param departureFlightsPage
	 * @param model
	 * @param route
	 */
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
		String errorMessage = "Error";
		
		try {
			if(model.getDepartureDate().isBlank())
			{
				errorMessage = "Missing Departure Date";
				throw new Exception(errorMessage);
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
			JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
