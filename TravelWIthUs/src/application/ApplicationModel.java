package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ApplicationModel
{
	private int monthDepartInt; 
	private int monthReturnInt;
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
	private FlightManager departureFlight; 
	private FlightManager returnFlight; 
	private boolean oneWayFare;
	private Traveler currentTraveler; 
	private ArrayList<Traveler> travelerList = new ArrayList<Traveler>(); 
	
	static HashMap<String, Integer> monthToInt = new HashMap<String, Integer>();
	 {
	monthToInt.put("Jan", 1);
	monthToInt.put("Feb", 2);
	monthToInt.put("Mar", 3);
	monthToInt.put("Apr", 4);
	monthToInt.put("May", 5);
	monthToInt.put("Jun", 6);
	monthToInt.put("Jul", 7);
	monthToInt.put("Aug", 8);
	monthToInt.put("Sep", 9);
	monthToInt.put("Oct", 10);
	monthToInt.put("Nov", 11);
	monthToInt.put("Dec", 12);
	}
	public ApplicationModel(Routes route)
	{
		this.route = route; 	

	}
	

	public double getPrice()
	{ 
		return (baseFare*(getSeasonMultiplier() + getCapacity() + getMileageRate(route.getFlightMiles(departureCity, destinationCity))));
	}
	
	public double getSeasonMultiplier()
	{ 	
		if(1 <= monthDepartInt && monthDepartInt <= 4)
		{
			return 0.80;
		}
		else if( monthDepartInt <= 8)
		{ 
			return 1.60;  
		}
		else if( monthDepartInt <= 12)
		{ 
			return 1.20; 
		}
		return 0; 
		
	}
	
	public void setOneWayFare(boolean value)
	{ 
		oneWayFare = value;
		
		if(value == true) 
			baseFare = 25; 
		else
			baseFare = 50; 
	}
	
	public boolean getOneWayFareValue()
	{
		return oneWayFare; 
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
		this.monthDepartInt = monthToInt.get(departMonth);

	}
	
	public void setDepartDay(String departDay)
	{ 
		if(Integer.parseInt(departDay) < 10)
			this.departDay = "0" + departDay; 
		else 
			this.departDay = departDay;
		
	}
	
	public void setDepartYear(String departYear)
	{
		this.departYear = departYear; 
	}

	public void setReturnDay(String returnDay)
	{
		if(Integer.parseInt(returnDay) < 10)
			this.returnDay = "0" + returnDay; 
		else 
			this.returnDay = returnDay;
		
	}

	public void setReturnMonth(String returnMonth)
	{
		this.returnMonth = returnMonth; 
		this.monthReturnInt = monthToInt.get(returnMonth);
		
	}

	public void setReturnYear(String returnYear)
	{
		this.returnYear = returnYear;
		
	}
	public String getReturnDate()
	{ 
		if(monthReturnInt < 10)
			return "0" + monthReturnInt + "/" + returnDay + "/" + returnYear; 
		else 
			return monthReturnInt + "/" + returnDay + "/" + returnYear; 
	}
	
	public String getDepartureDate()
	{ 
		if(monthDepartInt < 10)
			return "0" + monthDepartInt + "/" + departDay + "/" + departYear; 
		else 
			return monthDepartInt + "/" + departDay + "/" + departYear; 
	}
	
	public void setDepartureFlight(FlightManager departureFlight) 
	{ 
		this.departureFlight = departureFlight; 
	}
	
	public FlightManager getDepartureFlight()
	{
		return departureFlight; 
	}
	public void setReturnFlight(FlightManager returnFlight) 
	{ 
		this.returnFlight = returnFlight; 
	}
	
	public FlightManager getReturnFlight()
	{
		return returnFlight; 
	}
	
	public void addTraveler(Traveler traveler)
	{ 
		travelerList.add(traveler);
		currentTraveler = traveler;
	}

	public Traveler getCurrentTraveler()
	{
		return currentTraveler;
	}
	
}
