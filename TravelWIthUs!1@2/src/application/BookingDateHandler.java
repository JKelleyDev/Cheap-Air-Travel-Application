package application;

import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


public class BookingDateHandler implements ItemListener
{
private String selectedValue;
private ApplicationModel model;
private String departOrReturn; 

public BookingDateHandler(JComboBox selectionBox, ApplicationModel model, String departOrReturn)
{
	this.model = model; 
	this.departOrReturn = departOrReturn; 
}

@Override
public void itemStateChanged(ItemEvent e) 
{
       // Check if the event is a selection event
       if (e.getStateChange() == ItemEvent.SELECTED) 
       {
    	  
            selectedValue = String.valueOf(e.getItem()); 
       }
       
       if(departOrReturn.equals("departure"))
       { 
    	   switch(selectedValue.length())
    	   { 
    		   case 2:  // length of day is 2
    			   model.setDepartDay(selectedValue);  
    		   
    		   case 3: // length of month is 3 
    			   model.setDepartMonth(selectedValue);
    		   
    		   case 4: // lenght of year is 4
    			   model.setDepartYear(selectedValue);
    	   }
       }
       
       if(departOrReturn.equals("return"))
       { 
    	   switch(selectedValue.length())
    	   { 
    		   case 2:  // length of day is 2
    			   model.setReturnDay(selectedValue);  
    		   
    		   case 3: // length of month is 3 
    			   model.setReturnMonth(selectedValue);
    		   
    		   case 4: // lenght of year is 4
    			   model.setReturnYear(selectedValue);
    	   }
       }
}


}