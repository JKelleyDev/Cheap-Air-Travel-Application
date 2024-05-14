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
* This class is a custom selection handler that will handle actions for the departure city
* 
*/

public class DepartureListSelectionHandler implements ListSelectionListener
{

	private JList<String> departureCityList; // the selection handler has-a JList for the departure cities 
    private JList<String> destinationCityList; // the selection handler has-a JList for the destination cities
    private ApplicationModel model; // the selection handler has a reference to the model 

    /** 
     * Purpose: Constructor that initializes the handler
     * @param departureCityList
     * @param destinationCityList
     * @param model
     */
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

