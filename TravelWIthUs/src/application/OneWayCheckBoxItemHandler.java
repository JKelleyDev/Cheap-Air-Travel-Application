package application;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
* This is a custom handler for when the one way flight is checked off on the main page 
* 
*/

public class OneWayCheckBoxItemHandler implements ItemListener
{
	private ApplicationModel model; // the custom handler has a reference to the model 
	private JLabel returnLabel; // the custom handler has a reference to the return label 
	private JComboBox<String> returnMonthSelection; // the custom handler has a reference to the returnMonthSelction box 
	private JComboBox<Integer >returnDaySelection, returnYearSelection; // the custom handler has a reference to the day and year boxes 

	/** 
	 * Purpose: Constructor creates the custom check box handler 
	 * @param model
	 * @param returnMonthSelection
	 * @param returnDaySelection
	 * @param returnYearSelection
	 * @param returnLabel
	 */
	public OneWayCheckBoxItemHandler(ApplicationModel model, JComboBox<String> returnMonthSelection, 
			                         JComboBox<Integer> returnDaySelection, JComboBox<Integer> returnYearSelection, 
			                         JLabel returnLabel)
	{ 
		this.model = model; 
		this.returnMonthSelection = returnMonthSelection; 
		this.returnDaySelection = returnDaySelection; 
		this.returnYearSelection = returnYearSelection; 
		this.returnLabel = returnLabel;   
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// if the flight is a one way flight, hide the options for return information
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			returnMonthSelection.setVisible(false);
				returnMonthSelection.setSelectedIndex(-1);
			returnDaySelection.setVisible(false);
				returnDaySelection.setSelectedIndex(-1);
			returnYearSelection.setVisible(false);
				returnYearSelection.setSelectedIndex(-1);
			returnLabel.setVisible(false);
			model.setOneWayFare(true); // update the one way values in the model 	
		}
	    // if the fight is returned to a roundtrip flight, reshow the return information 
		else if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			returnMonthSelection.setVisible(true);
			returnDaySelection.setVisible(true);
			returnYearSelection.setVisible(true);
			returnLabel.setVisible(true);
			model.setOneWayFare(false); // update the one way values in the model 
		}
	}

}
