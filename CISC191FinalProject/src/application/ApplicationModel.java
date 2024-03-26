package application;

import java.util.Random;

public class ApplicationModel
{
	private int month; 
	private int miles; 
	private double baseFare = 50.00; 
	@SuppressWarnings("unused")
	private String departureCity, destinationCity; 
	
	
	public ApplicationModel()
	{
		
	}
	
	public void setMonth(int month)
	{ 
		this.month = month; 
	}
	
	public double getPrice()
	{ 
		return (baseFare*(getSeasonMultiplier() + getCapacity() + getMileageRate()));
	}
	
	public double getSeasonMultiplier()
	{ 	
		if(1 <= month && month <= 4)
		{
			return 0.80;
		}
		else if( month <= 8)
		{ 
			return 1.40;  
		}
		else if( month <= 12)
		{ 
			return 1.20; 
		}
		return 0; 
		
	}
	
	public void setOneWayFare(boolean value)
	{ 
		if(value == true) 
			baseFare = 25; 
		else
			baseFare = 50; 
	}
	
	public double getCapacity() 
	{ 
		Random rand = new Random(); 
		
		double capacity = rand.nextDouble(1.0);
		
		return capacity; 
	}
	
	public double getMileageRate() 
	{ 
		if( miles <= 500) 
		{ 
			return 5; 
		}
		else if( miles <= 1000) 
		{ 
			return 10; 
		}
		else if( miles <= 2000) 
		{ 
			return 15; 
		}
		else 
		{ 
			return 20; 
		}
	}
	
	public void setDepartureCity(String departureCity) 
	{ 
		this.departureCity = departureCity;  
	}
	
	public void setDestinationCity(String destinationCity) 
	{ 
		this.destinationCity = destinationCity;  
		
		System.out.println(destinationCity);
	}
	
	
}
