package application;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;

public class OneWayCheckBoxItemHandler implements ItemListener
{
	private ApplicationModel model; 
	private JSpinner returnSpinner; 
	private JLabel returnLabel; 

	public OneWayCheckBoxItemHandler(ApplicationModel model, JSpinner returnSpinner, JLabel returnLabel)
	{ 
		this.model = model; 
		this.returnSpinner = returnSpinner; 
		this.returnLabel = returnLabel; 
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			returnSpinner.setVisible(false);
			returnLabel.setVisible(false);
			model.setOneWayFare(true);
		}
		else if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			returnSpinner.setVisible(true);
			returnLabel.setVisible(true);
			model.setOneWayFare(false);
		}
		
	
	}

}
