package application;

import java.util.Random;

public class ApplicationModel
{
	private int month; 
	private int miles; 
	private double baseFare = 50.00; 
	@SuppressWarnings("unused")
	private String departureCity, destinationCity; 
	private Routes route; 
	private String departMonth; 
	private String departDay; 
	private String departYear; 
	private String returnMonth; 
	private String returnDay; 
	private String returnYear;
	
	
	public ApplicationModel(Routes route)
	{
		this.route = route; 
	}
	
	public void setMonth(int month)
	{ 
		this.month = month; 
	}
	
	public double getPrice()
	{ 
		return (baseFare*(getSeasonMultiplier() + getCapacity() + getMileageRate(route.getFlightMiles(departureCity, destinationCity))));
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
		
		double capacity = rand.nextDouble(.80);
		
		return capacity; 
	}
	
	public double getMileageRate(int miles) 
	{ 
		this.miles = miles; 
		
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
		else if ( miles <= 4000)
		{ 
			return 20; 
		}
		else 
			return 25;
	}
	
	public void setDepartureCity(String departureCity) 
	{ 
		this.departureCity = departureCity;  
	}
	
	public String getDepartureCity()
	{
		return departureCity; 
	}
	
	public void setDestinationCity(String destinationCity) 
	{ 
		this.destinationCity = destinationCity;  
	}
	public String getDestinationCity()
	{
		return destinationCity; 
	}
	
	public void setDepartMonth(String departMonth)
	{ 
		this.departMonth = departMonth; 
	}
	
	public void setDepartDay(String selectedValue)
	{ 
		this.departDay = selectedValue; 
	}
	
	public void setDepartYear(String departYear)
	{
		this.departYear = departYear; 
	}

	public void setReturnDay(String returnDay)
	{
		this.returnDay = returnDay; 
		
	}

	public void setReturnMonth(String returnMonth)
	{
		this.returnMonth = returnMonth; 
		
	}

	public void setReturnYear(String returnYear)
	{
		this.returnYear = returnYear;
		
	}
	

	
}
