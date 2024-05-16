package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
*
* @author Jordan Kelley
* @author Esteban Naranjo
* 
* @version 2024.05.24.001
* 
* @see
* 	References:<br>
*         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
*         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
* 
*
* <br><br>
* Responsibilities of class:<br>
* Creates a centralized class for storing key information throughout the booking process. This will allow the application to access and modify 
* infromation as needed from a universal model, initialized during the start of the program. 
* 
*/
public class ApplicationModel
{
	private int departMonth; // the model has a numeric departure month value
	private String departureCity, destinationCity; // the model has a departure and destination city
	private Routes route;  // the model has a route object to get information about the route
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
	private Payment payment; // the model has a payment object to store payment information
	private String departDate; 
	private String returnDate; 
	private double baseFare = 50.00; // the model has a base fare value, initially 50.00 but will change to 25.00 if oneway fare is set
	private final double CARRY_ON_BAG_COST = 20.00; // the model has a final carry on bag cost
	private final double CHECKED_BAG_COST = 50.00;  // the model has a final checked bag cost
	private final double WIFI_CHARGE = 9.99; // the model has a final Wi-Fi charge
	private final double ASSISTANCE_FEE = 9.99; // the model has a final assistance fee
	private final double MEAL_CHARGE = 14.99;   // the model has a final meal charge
	
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
	public void setDepartMonth(String departDate)
	{ 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date = sdf.parse(departDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.departMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based
        } catch (ParseException e) {
            e.printStackTrace();
            
        }
	}

	
	/** 
	 * Purpose: Retrieve the return date as mm/dd/yyyy
	 * @return return date mm/dd/yyyy
	 */
	public String getReturnDate()
	{ 
		return returnDate;
	}
	
	/** 
	 * Purpose: Retrieve the departure date as mm/dd/yyyy
	 * @return departure date mm/dd/yyyy
	 */
	public String getDepartureDate()
	{ 
		return departDate;
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
	
	/** 
	 * Purpose: Stores the payment information as a payment object
	 * @param payment
	 */
	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	
	/** 
	 * Purpose: Retrieves the payment object 
	 * @return payment
	 */
	public Payment getPayment()
	{
		return payment;
	}
	
	/** 
	 * Purpose: sets the departure date of the booking
	 * @param departDate
	 */
	public void setDepartDate(String departDate)
	{
		this.departDate = departDate; 
		setDepartMonth(departDate);
	}
	
	/** 
	 * Purpose: sets the return date of the booking
	 * @param returnDate
	 */
	public void setReturnDate(String returnDate) 
	{ 
		this.returnDate = returnDate; 
	}
	/** 
	 * Purpose: removes a carry on bag from the total count
	 */
	public void removeCarryOnBag()
	{
		carryOnBagCount--; 	
	}

	/** 
	 * Purpose: removes a checked bag from the total count
	 */
	public void removeCheckedBag()
	{
		checkedBagCount--;	
	}

}
