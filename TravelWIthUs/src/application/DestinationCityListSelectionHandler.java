package application;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
* This is a custom selection handler that sets the destination list according to what the departure city was set to in the model
* 
*/

public class DestinationCityListSelectionHandler implements ListSelectionListener
{
	private JList<String> destinationList; // the selection handler has a JList of the destinations
	private ApplicationModel model; // the selection handler has a reference to the model
	
	/** 
	 * Purpose: Constructor that creates the custom selection handler
	 * @param destinationList
	 * @param model
	 */
	public  DestinationCityListSelectionHandler(JList<String> destinationList, ApplicationModel model)
	{ 
		this.destinationList = destinationList; 
		this.model = model; 
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		 if (!e.getValueIsAdjusting()) 
	        {
	            String selectedDestination = destinationList.getSelectedValue();
	            
	            if (selectedDestination != null) 
	            {
	                // Set destinations based on the selected departure
	                model.setDestinationCity(selectedDestination); 
	            }
	        }
		
	}
}

