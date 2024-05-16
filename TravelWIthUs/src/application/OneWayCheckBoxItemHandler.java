package application;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JLabel;

import org.jdatepicker.impl.JDatePickerImpl;

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
	private JDatePickerImpl returnDatePicker;

	/** 
	 * Purpose: Constructor creates the custom check box handler 
	 * @param model
	 * @param returnMonthSelection
	 * @param returnDaySelection
	 * @param returnYearSelection
	 * @param returnLabel
	 */
	public OneWayCheckBoxItemHandler(ApplicationModel model, JDatePickerImpl returnDatePicker,
			                         JLabel returnLabel)
	{ 
		this.model = model; 
		this.returnDatePicker = returnDatePicker;
		this.returnLabel = returnLabel;   
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// if the flight is a one way flight, hide the options for return information
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			returnDatePicker.setVisible(false);
			returnLabel.setVisible(false);
			model.setOneWayFare(true); // update the one way values in the model 	
		}
	    // if the fight is returned to a roundtrip flight, reshow the return information 
		else if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			returnDatePicker.setVisible(true);
			returnLabel.setVisible(true);
			model.setOneWayFare(false); // update the one way values in the model 
		}
	}

}
