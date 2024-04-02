package application;

public class Baggage
{
	private Traveler traveler;
	private Boolean carryOn; 
	
	public Baggage(Traveler traveler)
	{
		this.traveler = traveler; 
	}

	// Create baggage paramaters, think price, chekced bag, carry on bag
	
	// Carryon will be a true or false, since it is already included in the fair
	
	// However, checked bags will cost money, have oversized charges, weight restrictions, and will cost 
	// differetn charges based on how many you have 
	// for instacne Checked bag 1: $35 Weight: 40 lbs max ( Check if over weight - > charge extra if over ) 
	
	
	// Example
	
	public void setCarryOn(Boolean value)
	{ 
		if (value == true)
		{ 
			carryOn = true; 
		}
		else
		{
			carryOn = false; 
		}
	}
	
	public Boolean getCarryOnStatus()
	{
		return carryOn; 
	}
}
