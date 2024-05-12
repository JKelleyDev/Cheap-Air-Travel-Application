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
	private int checkedBag;
	private int carryOnBag; 
	private ApplicationModel model;
	private boolean vegiterianMeal; 
	
//	A travler is made -> that travler has a set options 
//
//	When you set the option based on selection, it stores it for that traveler inside option (each traveler has their own option) 
//
//	Then, the model.add### functions, accumulate a total count for all the travelers 

	
	public Option(ApplicationModel model)
	{

		wifi = false;
		meal = false;
		assistance = false;
		baggage = false;
		this.model = model; 
	}
	
	public void addCheckedBag() 
	{ 
		checkedBag++;  // if adding a checked bag, increase the amount of checked bags by 1
		// model.addCheckedBag(); 
	}
	
	public void addCarryOnBag() 
	{ 
		carryOnBag++; 
		model.addCarryOnBag();  // For each travel, want to keep a total amount of carry on bag counts so we can add the cost later for all bags
	}
	
	///////////////////////////////////////////////
	public void setWifi(boolean selected) 
	{
		wifi = selected;
		// model.addWifiCharge(); // For each travel, want to keep a total amount of wifi charges 
		
	}

	public void setMealVegiterian(boolean selected) 
	{
		this.vegiterianMeal = selected;	
		// model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
	}
	public void setMealNonVegiterian(boolean selected) 
	{
		this.meal = selected;	
		// model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
	}

	public void setAssistance(boolean selected) 
	{
		this.assistance = selected;
		// model.addAssistanceFee(); // For each travel, want to keep a total amount of assistance charges 
	}

	
}
