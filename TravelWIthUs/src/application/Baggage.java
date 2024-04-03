package application;

public class Baggage
{
	private Traveler traveler;
	private Boolean carryOn; 
	private int numberOfCheckedBags;
	private double totalCheckedBagFee; 
	private double overweightBagFee = 25.0;
	private double baseCheckedBagFee = 35.0;
	public double oversizedBagFee = 50.0;
	private double maxBagWeight = 40.0;
	
	public Baggage(Traveler traveler)
	{
		this.traveler = traveler; 
	}
	
	public void setCarryOn(boolean value)
	{
		carryOn = value;
	}
	
	public boolean getCarryOnStatus() 
	{
		return carryOn;
	}
	
	public void addCheckedBag() 
	{
		numberOfCheckedBags++;
		updateCheckedBagFee();
	}

	public void removeCheckedBag() 
	{
		if (numberOfCheckedBags > 0) 
		{
			numberOfCheckedBags--;
			updateCheckedBagFee();
		}
	}
	
	private void updateCheckedBagFee() 
	{
		totalCheckedBagFee = numberOfCheckedBags * baseCheckedBagFee;
	}
	
	public double getTotalCheckedBagFee() 
	{
		return totalCheckedBagFee;
	}
	
	public void setBagWeight(double weight) 
	{
		if (weight > maxBagWeight) 
		{
			totalCheckedBagFee += overweightBagFee;
		}
	}
	
	public void setBagDimensions(double length, double width, double height) 
	{
		if (length > 60.0 || width > 40.0 || height > 30.0) 
		{
			totalCheckedBagFee += oversizedBagFee;
		}
	}
	

	
	
}
