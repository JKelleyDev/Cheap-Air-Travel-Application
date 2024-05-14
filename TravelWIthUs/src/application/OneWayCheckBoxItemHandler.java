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
*/
public class OneWayCheckBoxItemHandler implements ItemListener
{
	private ApplicationModel model;  
	private JLabel returnLabel; 
	private JComboBox<String> returnMonthSelection;
	private JComboBox<Integer >returnDaySelection, returnYearSelection;

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
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			returnMonthSelection.setVisible(false);
				returnMonthSelection.setSelectedIndex(-1);
			returnDaySelection.setVisible(false);
				returnDaySelection.setSelectedIndex(-1);
			returnYearSelection.setVisible(false);
				returnYearSelection.setSelectedIndex(-1);
			returnLabel.setVisible(false);
			model.setOneWayFare(true);
		
			
		}
		else if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			returnMonthSelection.setVisible(true);
			returnDaySelection.setVisible(true);
			returnYearSelection.setVisible(true);
			returnLabel.setVisible(true);
			model.setOneWayFare(false);
		}
		
	
	}

}
