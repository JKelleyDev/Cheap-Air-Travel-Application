package application;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Option
{
	private Traveler traveler;
	private PaymentCard paymentCard;
	private boolean wifi;
	private boolean meal;
	private boolean baggage;
	private boolean assistance;
	
	
	public Option(Traveler traveler, PaymentCard paymentCard)
	{
		this.traveler = traveler;
		this.paymentCard = paymentCard;	
		wifi = false;
		
	}
	
	public Traveler getTraveler() 
	{
		return traveler;
	}
	
	public void setTraveler(Traveler traveler) 
	{
		this.traveler = traveler;
	}
	
	public PaymentCard getPaymentCard()
	{
		return paymentCard;	
	}

	public void setWifi(boolean selected) 
	{
		wifi = selected;
		
	}

	public void setMeal(boolean selected) 
	{
		this.meal = selected;	
	}

	
}
