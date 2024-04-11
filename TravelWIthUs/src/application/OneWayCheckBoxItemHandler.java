package application;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class OneWayCheckBoxItemHandler implements ItemListener
{
	private ApplicationModel model; 
	private JSpinner returnSpinner; 
	private JLabel returnLabel; 
	private JComboBox returnMonthSelection, returnDaySelection, returnYearSelection;

	public OneWayCheckBoxItemHandler(ApplicationModel model, JComboBox returnMonthSelection, 
			                         JComboBox returnDaySelection, JComboBox returnYearSelection, 
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
			returnDaySelection.setVisible(false);
			returnYearSelection.setVisible(false);
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
