package application;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Option
{

	private Payment payment;
	private boolean wifi;
	private boolean meal;
	private boolean baggage;
	private boolean assistance;
	private String selectedBag;
	
	
	public Option(ApplicationModel model)
	{

		wifi = false;
		meal = false;
		assistance = false;
		baggage = false;
	}
	
	public boolean isBaggage() {
		return baggage;
	}
	
	public void setBaggage(boolean baggage) {
		this.baggage = baggage;
	}
	
	public String getSelectedBag() {
		return selectedBag;
	}
	 public void setSelectedBag(String selectedBag) {
		 this.selectedBag = selectedBag;
	 }

	///////////////////////////////////////////////
	public Payment getPaymentCard()
	{
		return payment;	
	}
	///////////////////////////////////////////////
	public void setWifi(boolean selected) 
	{
		wifi = selected;
		
	}

	public void setMeal(boolean selected) 
	{
		this.meal = selected;	
	}

	public void setAssistance(boolean selected) 
	{
		this.assistance = selected;
	}

	
}
