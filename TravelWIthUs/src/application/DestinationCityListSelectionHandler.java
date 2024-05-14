package application;
/**
 * Lead Author(s):
 * 
 * @author Jordan Kelley
 * @author Esteban Naranjo
 *       
 * Other contributors:
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 

 * Version/date: 2024.05.24.001
 * 
 * Responsibilities of class:
 *
 * 
 */
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DestinationCityListSelectionHandler implements ListSelectionListener
{
	private JList<String> destinationList; 
	private ApplicationModel model; 
	
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
	                // Set destinations based on the selected departur
	                model.setDestinationCity(selectedDestination);
	               
	            }
	        }
		
	}
}

