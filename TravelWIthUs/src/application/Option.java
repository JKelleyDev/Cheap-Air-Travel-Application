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
	private boolean vegeterianMeal; 
	private int mealTotal;
	
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
		carryOnBag = 0;
		checkedBag = 0;
		mealTotal = 0;
	}
	///////////////////////////
	public void addCheckedBag() 
	{ 
		checkedBag++;  // if adding a checked bag, increase the amount of checked bags by 1
		model.addCheckedBag(); 
	}
	
	/////////////////////////////
	public void addCarryOnBag() 
	{ 
		carryOnBag++; 
		model.addCarryOnBag();  // For each travel, want to keep a total amount of carry on bag counts so we can add the cost later for all bags
	}
	
	///////////////////////////////////////////////
	public void setWifi(boolean selected) 
	{
		wifi = selected;
		model.addWifiPackage(); // For each travel, want to keep a total amount of wifi charges 
		
	}
	/////////////////////////////////////
	public void setMeal(boolean selected) 
	{
		meal = selected;
		if(selected) 
		{
			model.addMealCharge();
		}
	}
	///////////////////////////////////////
	public void setMealVegeterian(boolean selected) 
	{
		this.vegeterianMeal = selected;	
		if(selected)
		{
		model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
	    }
	}
	
	////////////////////////////////////
	public void setMealNonVegeterian(boolean selected) 
	{
		this.meal = selected;	
		if (selected) 
		{
		model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
		}
	}
	/////////////////////////
	public void setAssistance(boolean selected) 
	{
		this.assistance = selected;
		if (selected) 
		{
		model.addAssistance(); // For each travel, want to keep a total amount of assistance charges 
		}
	}
	
	/////////////////////////////
	public int getCarryOnStatus() 
	{ 
		return carryOnBag; 
	}
	
	////////////////////////////////
	public int getCheckedBagStatus()
	{ 
		return checkedBag; 
	}
	
	//////////////////////////////
	public String getWifiStatus() 
	{ 
		if(wifi == true) 
			return "Yes"; 
		else 
			return "No";
	}
	
	////////////////////////
	public String getMeal() 
	{ 
		if(vegeterianMeal == true) 
			return " " ;
		else if( meal == true) 
			return " "; 
		else 
			return "No meal added"; 
	}
	
	
	//////////////////////////////////
	public String getAssistanceStatus() 
	{ 
		if(assistance == true) 
			return "Assistance required"; 
		else 
			return "No Assistance required";
	}
	
	
}
