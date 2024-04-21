package application;

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

