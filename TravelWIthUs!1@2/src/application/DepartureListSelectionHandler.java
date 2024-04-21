package application;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DepartureListSelectionHandler implements ListSelectionListener
{

	private JList<String> departureCityList;
    private JList<String> destinationCityList;
    private ApplicationModel model; 

    public DepartureListSelectionHandler(JList<String> departureCityList, JList<String> destinationCityList, ApplicationModel model) 
    {

        this.departureCityList = departureCityList;
        this.destinationCityList = destinationCityList;
        this.model = model; 
    }

    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        if (!e.getValueIsAdjusting()) 
        {
            String selectedDeparture = departureCityList.getSelectedValue();
            
            if (selectedDeparture != null) 
            {
                // Set destinations based on the selected departure
                String[] destinations = new Routes().getDestinations(selectedDeparture);
                model.setDepartureCity(selectedDeparture);
                
                if (destinations != null) 
                {
                    // Update the destinationCityList
                    destinationCityList.setListData(destinations);
                } 
                else 
                {
                    // If destinations is null, clear the destinationCityList
                    destinationCityList.setListData(new String[0]);
                }
            }
        }
    }
}

