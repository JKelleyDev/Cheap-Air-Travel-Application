package application;
/**
 * Lead Author(s):
 * 
 * @author Jordan Kelley
 * @author Esteban Naranjo
 *       
 * Other contributors:
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 

 * Version/date: 2024.05.24.001
 * 
 * Responsibilities of class:
 * Creates a centralized class for storing key information throughout the booking process. This will allow the application to access and modify 
 * infromation as needed from a universal model, initialized during the start of the program. 
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ApplicationModel
{
	private int departMonth; // the model has a numeric departure month value
	private int returnMonth; // the model has a numeric return month value
	private String departureCity, destinationCity; // the model has a departure and destination city
	private Routes route;  // the model has a route object to get information about the route
	private String departDay;  // the model has a depart day
	private String departYear; // the model has a depart year
	private String returnDay;  // the model has a return day
	private String returnYear; // the model has a return year
	private FlightManager departureFlight; // the model has a departure flight 
	private FlightManager returnFlight; // the model has a return flight
	private boolean oneWayFare; // the model has an onewayfare truth value
	private Traveler currentTraveler; // the model has a current traveler object
	private ArrayList<Traveler> travelerList = new ArrayList<Traveler>(); // the model has an array list of traveler objects
	private int carryOnBagCount;  // the model has a total number of carry on bags 
	private int checkedBagCount;  // the model has a total number of checked bags 
	private int wifiPackageCount; // the model has a total number of Wi-Fi packages 
	private int assistanceTotal;  // the model has a total number of asssitance packages
	private int mealsOrderedTotal; // the model has a total number of meals ordered
	
	private double baseFare = 50.00; // the model has a base fare value, initially 50.00 but will change to 25.00 if oneway fare is set
	private final double CARRY_ON_BAG_COST = 20.00; // the model has a final carry on bag cost
	private final double CHECKED_BAG_COST = 50.00;  // the model has a final checked bag cost
	private final double WIFI_CHARGE = 9.99; // the model has a final Wi-Fi charge
	private final double ASSISTANCE_FEE = 9.99; // the model has a final assistance fee
	private final double MEAL_CHARGE = 14.99;   // the model has a final meal charge
	
	/** 
	 * Purpose: Creates a hasmap to access integer value of a shortned string month (key)
	 */
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
	
	/** 
	 * Purpose: Constructor to create the model, with a reference to the routes 
	 * @param route
	 */
	public ApplicationModel(Routes route)
	{
		this.route = route; 	

	}
	
	/** 
	 * Purpose: Calculates a flight price based on base fare, season multiplier, capicity multiplier, and a mileage rate
	 * @return total flight price 
	 */
	public String getPrice()
	{ 
	    double price = baseFare * (getSeasonMultiplier() + getCapacity() + getMileageRate(route.getFlightMiles(departureCity, destinationCity)));
	    return String.format("%.2f", price); // format return as .00 
	}

	/** 
	 * Purpose: Sets a seasonal multiplier based on the month the flight departs 
	 * @return (double) seasonal multiplier
	 */
	public double getSeasonMultiplier()
	{ 	
		if(1 <= departMonth && departMonth <= 4)
		{
			return 0.80;
		}
		else if( departMonth <= 8)
		{ 
			return 1.60;  
		}
		else if( departMonth <= 12)
		{ 
			return 1.20; 
		}
		return 0; 	
	}
	
	/** 
	 * Purpose: Updates the base fair value to 25.00 if the flight is a one way flight
	 * @param true or false
	 */
	public void setOneWayFare(boolean value)
	{ 
		oneWayFare = value;
		
		if(value == true) 
			baseFare = 25; 
		else
			baseFare = 50; 
	}
	
	/** 
	 * Purpose: Accessor method to checked if the flight is a one way flight
	 * @return true or false, onewayFare
	 */
	public boolean getOneWayFareValue()
	{
		return oneWayFare; 
	}
	
	/** 
	 * Purpose: Creates a random capacity between the values of 0 and .80, used as a multiplier in luie of the ability to have live capacities in real world
	 * @return capacity multiplier value
	 */
	public double getCapacity() 
	{ 
		Random rand = new Random(); 
		
		double capacity = rand.nextDouble(.80);
		
		return capacity; 
	}
	
	/**
	 * Purpose: Returns a multiplier for the price rate based on the amount of miles the flight is
	 * @param miles
	 * @return mileage multiplier
	 */
	public double getMileageRate(int miles) 
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
		else if ( miles <= 4000)
		{ 
			return 20; 
		}
		else 
			return 25;
	}
	
	/** 
	 * Purpose: Stores the departure city in the model 
	 * @param departureCity
	 */
	public void setDepartureCity(String departureCity) 
	{ 
		this.departureCity = departureCity;  
	}
	
	/** 
	 * Purpose: Retrieves the departure city from the model
	 * @return departureCity
	 */
	public String getDepartureCity()
	{
		return departureCity; 
	}
	
	/** 
	 * Purpose: Stores the destination city in the model
	 * @param destinationCity
	 */
	public void setDestinationCity(String destinationCity) 
	{ 
		this.destinationCity = destinationCity;  
	}
	
	/** 
	 * Purpose: Retrieves the destination city from the model
	 * @return destinationCity
	 */
	public String getDestinationCity()
	{
		return destinationCity; 
	}
	
	/** 
	 * Purpose: Stores the departure month in the model as an integer
	 * @param departMonth
	 */
	public void setDepartMonth(String departMonth)
	{ 
		this.departMonth = monthToInt.get(departMonth); // Use the month to int hashmap to get the integer value for the string month, then store
	}
	
	/** 
	 * Purpose: Stores the departure day in the model, formated as two digits 
	 * @param departDay
	 */
	public void setDepartDay(String departDay)
	{ 
		if(Integer.parseInt(departDay) < 10) // Parse the integer value of the string day, if less than 10, append a 0 at beginning 
			this.departDay = "0" + departDay; 
		else 
			this.departDay = departDay;	
	}
	
	/** 
	 * Purpose: Stores the departure year in the model
	 * @param departYear
	 */
	public void setDepartYear(String departYear)
	{
		this.departYear = departYear; 
	}
	
	/** 
	 * Purpose: Stores the return day in the model
	 * @param returnDay
	 */
	public void setReturnDay(String returnDay)
	{
		if(Integer.parseInt(returnDay) < 10) // Parse the integer value of the string day, if less than 10, append a 0 at beginning 
			this.returnDay = "0" + returnDay; 
		else 
			this.returnDay = returnDay;
	}

	/** 
	 * Purpose: Store the return month in the model
	 * @param returnMonth
	 */
	public void setReturnMonth(String returnMonth)
	{
		this.returnMonth = monthToInt.get(returnMonth);	
	}

	/** 
	 * Store the return year in the model
	 * @param returnYear
	 */
	public void setReturnYear(String returnYear)
	{
		this.returnYear = returnYear;
		
	}
	
	/** 
	 * Purpose: Retrieve the return date as mm/dd/yyyy
	 * @return return date mm/dd/yyyy
	 */
	public String getReturnDate()
	{ 
		if(returnMonth < 10)
			return "0" + returnMonth + "/" + returnDay + "/" + returnYear; // correctly returns the string month with two digits so format is mm/dd/yyyy
		else 
			return returnMonth + "/" + returnDay + "/" + returnYear; 
	}
	
	/** 
	 * Purpose: Retrieve the departure date as mm/dd/yyyy
	 * @return departure date mm/dd/yyyy
	 */
	public String getDepartureDate()
	{ 
		if(departMonth < 10)
			return "0" + departMonth + "/" + departDay + "/" + departYear; // correctly returns the string month with two digits so format is mm/dd/yyyy
		else 
			return departMonth + "/" + departDay + "/" + departYear; 
	}
	
	/** 
	 * Purpose: Stores the departure flight in the model
	 * @param departureFlight
	 */
	public void setDepartureFlight(FlightManager departureFlight) 
	{ 
		this.departureFlight = departureFlight; 
	}
	
	/** 
	 * Purpose: Retrieves the departure flight from the model
	 * @return departureFlight
	 */
	public FlightManager getDepartureFlight()
	{
		return departureFlight; 
	}
	
	/** 
	 * Purpose: Stores the return flight in the model
	 * @param returnFlight
	 */
	public void setReturnFlight(FlightManager returnFlight) 
	{ 
		this.returnFlight = returnFlight; 
	}
	
	/** 
	 * Purpose: Retrieves the return flight from the model
	 * @return returnFlight
	 */
	public FlightManager getReturnFlight()
	{
		return returnFlight; 
	}
	
	/** 
	 * Purpose: Stores a new traveler into the traveler array list
	 * @param traveler
	 */
	public void addTraveler(Traveler traveler)
	{ 
		travelerList.add(traveler); // add the traveler into the arraylist
		currentTraveler = traveler; // update the current traveler the application is working with
	}

	/** 
	 * Purpose: Retrieves the current traveler the application is working with
	 * @return currentTraveler
	 */
	public Traveler getCurrentTraveler()
	{
		return currentTraveler;
	}
	
	/** 
	 * Purpose: Retrieves the array list of the travelers, as an Array
	 * @return Traveler []
	 */
	public Traveler [] getTravelerArray()
	{ 
		Traveler [] travelerArray = new Traveler [travelerList.size()]; // Create a temp array the size of the array list
		travelerArray = travelerList.toArray(travelerArray); // copy the elements of the arraylist into the new array
		return travelerArray; // return the new array, returning as an array is mindful of storage space
	}
	
	/** 
	 * Purpose: Increment the total count of carry on bags
	 */
	public void addCarryOnBag() 
	{ 
		carryOnBagCount++; 
	}
	
	/** 
	 * Purpose: Retrieve the total count of carry on bags
	 * @return carryOnBagCount
	 */
	public int getCarryOnBagCount()
	{ 
		return carryOnBagCount; 
	}
	
	/** 
	 * Purpose: Retrive the cost per carry on bag
	 * @return CARRY_ON_BAG_COST
	 */
	public double getCarryOnCost()
	{
		return CARRY_ON_BAG_COST;
	}
	
	/** 
	 * Purpose: Increment the total count of checked bags 
	 */
	public void addCheckedBag() 
	{ 
		checkedBagCount++; 
	}
	
	/** 
	 * Purpose: Retrieve the total count of checked bags
	 * @return checkedBagCount
	 */
	public int getCheckedBagCount()
	{ 
		return checkedBagCount; 
	}
	
	/** 
	 * Purpose: Retrieve the cost per checked bag
	 * @return CHECKED_BAG_COST
	 */
	public double getCheckedBagCost()
	{
		return CHECKED_BAG_COST;
	}
	
	/** 
	 * Purpose: Increment the total count of wifi packages 
	 */
	public void addWifiPackage() 
	{ 
		wifiPackageCount++; 
	}
	
	/** 
	 * Purpose: Retrieve the total count of wifi packages 
	 * @return wifiPackageCount
	 */
	public int getWifiPackageCount()
	{
		return wifiPackageCount; 
	}
	
	/** 
	 * Purpose: Retrieve the cost per wifi package
	 * @return WIFI_CHARGE
	 */
	public double getWifiCost()
	{
		return WIFI_CHARGE;
	}
	
	/** 
	 * Purpose: Increment the total amount of assistance packages needed
	 */
	public void addAssistance()
	{ 
		assistanceTotal++;
	}
	
	/** 
	 * Purpose: Retrieve the total charge for all assistance packages needed
	 * @return ASSISTANCE_FEE * assistanceTotal
	 */
	public double getAssistanceCharge()
	{
		return ASSISTANCE_FEE * assistanceTotal; 
	}
	
	/**
	 * Purpose: Increments the total amount of meals ordered
	 */
	public void addMealCharge() 
	{ 
		mealsOrderedTotal++; 
	}

	/** 
	 * Purpose: Retrieves the total amount of meals ordered
	 * @return mealsOrderedTotal
	 */
	public int getmealCount() 
	{
		return  mealsOrderedTotal; 
	}

	/** 
	 * Purpose: Retrieves the charge per meal
	 * @return MEAL_CHARGE
	 */
	public double getMealCost() 
	{ 
		return MEAL_CHARGE; 
	}

}
