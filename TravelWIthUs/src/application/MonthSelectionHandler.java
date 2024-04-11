package application;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JComboBox;

public class MonthSelectionHandler implements ItemListener
{
 
	private JComboBox monthBox; 
	private ApplicationModel model; 
	private String selectedMonth;


	public MonthSelectionHandler(JComboBox monthBox, ApplicationModel model)
	{ 
		this.model = model;  
		this.monthBox = monthBox; 
	}
	 @Override
	 public void itemStateChanged(ItemEvent e) 
	 {
	        // Check if the event is a selection event
	        if (e.getStateChange() == ItemEvent.SELECTED) 
	        {
	             selectedMonth = (String) e.getItem(); 
	        }
	        model.setDepartMonth(selectedMonth);
	 }
	

}
