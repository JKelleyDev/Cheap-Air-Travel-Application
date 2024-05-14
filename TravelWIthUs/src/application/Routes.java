package application;

import java.util.HashMap;
import java.util.Hashtable;

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
*         <br> <br>
*         Flight Mileage: {@link https://www.airmilescalculator.com}
*
* <br><br>
* Responsibilities of class:<br>
* 
* This class creates multiple hashmaps to store mileage between destinations, flight time in minutes between destinations. 
* 
*/

public class Routes 
{
	private String departDate; // routes has a departDate, used for some classes who can't access the model
	
	// Setup the list of departures and the airport codes table 
	private String departures [] = {"San Diego", "New York", "London", "Tokyo", "Doha", "Paris","Stockholm", "Singapore", "Hong Kong"};
	private Hashtable<String, String> airportCodes = new Hashtable<String, String>();
	
	///////////////////////////////////
	////// San Diego Flight Data //////
	///////////////////////////////////
	private String sanDiego[] = { "New York", "Tokyo",  "Singapore", "Paris" };
	private HashMap<String, Integer> sanDiegoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> sanDiegoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> SanDiegoFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] SAN_LGA_Flights; 
	private FlightManager [] SAN_NRT_Flights;
	private FlightManager [] SAN_SIN_Flights;
	private FlightManager [] SAN_CDG_Flights;
	
	///////////////////////////////////
	////// New York Flight Data  //////
	///////////////////////////////////
	private	String newYork [] = { "London", "Doha", "Stockholm", "Tokyo", "Singapore", "Paris", "Hong Kong", "San Diego" };
	private HashMap<String, Integer> newYorkMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> newYorkFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> NewYorkFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] LGA_LHR_Flights;
	private FlightManager [] LGA_DOH_Flights;
	private FlightManager [] LGA_ARN_Flights;
	private FlightManager [] LGA_NRT_Flights;
	private FlightManager [] LGA_SIN_Flights;
	private FlightManager [] LGA_CDG_Flights;
	private FlightManager [] LGA_HKG_Flights;
	private FlightManager [] LGA_SAN_Flights;
	
	/////////////////////////////////////
	////// London(LHR) Flight Data //////
	/////////////////////////////////////
	private String london [] = {"New York", "Tokyo", "Doha", "Stockholm", "Singapore", "Paris", "Hong Kong"};
	private HashMap<String, Integer> londonMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> londonFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> LondonFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] LHR_LGA_Flights;
	private FlightManager [] LHR_NRT_Flights;
	private FlightManager [] LHR_DOH_Flights;
	private FlightManager [] LHR_ARN_Flights;
	private FlightManager [] LHR_SIN_Flights;
	private FlightManager [] LHR_CDG_Flights;
	private FlightManager [] LHR_HKG_Flights;
	
	////////////////////////////////////
	////// Tokyo(NRT) Flight Data //////
	////////////////////////////////////
	private String tokyo [] = {"New York", "London", "Singapore"};
	private HashMap<String, Integer> tokyoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> tokyoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> TokyoFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] NRT_LGA_Flights;
	private FlightManager [] NRT_LHR_Flights;
	private FlightManager [] NRT_SIN_Flights;
	private FlightManager [] NRT_SAN_Flights;
	
	////////////////////////////////////
	////// Doha(DOH) Flight Data  //////
	////////////////////////////////////
	private String doha [] = {"New York", "London"};
	private HashMap<String, Integer> dohaMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> dohaFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> DohaFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] DOH_LGA_Flights;
	private FlightManager [] DOH_LHR_Flights;
	
	/////////////////////////////////////
	////// Paris (CDG) Flight Data //////
	/////////////////////////////////////
    private String paris [] = {"New York", "London","Singapore", "San Diego"};
    private HashMap<String, Integer> parisMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> parisFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> ParisFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] CDG_LGA_Flights;
	private FlightManager [] CDG_LHR_Flights;
	private FlightManager [] CDG_SIN_Flights;
	private FlightManager [] CDG_SAN_Flights;
	
	//////////////////////////////////////
	//// Stockhom (ARN) Flight Data //////
	/////////////////////////////////////
    private String stockholm [] = {"New York", "London"};
    private HashMap<String, Integer> stockholmMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> stockholmFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> StockholmFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] ARN_LGA_Flights;
	private FlightManager [] ARN_LHR_Flights;
	
	//////////////////////////////////////
	/// Singapore (SIN) Flight Data //////
	/////////////////////////////////////
    private String singapore [] = {"San Diego", "New York", "Tokyo", "London", "Hong Kong"};
    private HashMap<String, Integer> singaporeMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> singaporeFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> SingaporeFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] SIN_SAN_Flights;
	private FlightManager [] SIN_LGA_Flights;
	private FlightManager [] SIN_NRT_Flights;
	private FlightManager [] SIN_LHR_Flights;
	private FlightManager [] SIN_HKG_Flights;
	
	//////////////////////////////////////
	//// Hong Kong (HKG) Flight Data /////
	/////////////////////////////////////
    private String hongKong [] = { "London", "New York", "Singapore" }; 
    private HashMap<String, Integer> hongKongMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> hongKongFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> HongKongFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] HKG_LHR_Flights;
	private FlightManager [] HKG_LGA_Flights;
	private FlightManager [] HKG_SIN_Flights;
	
	
    /** 
     * Purpose: Initializes and sets up all of the hashmaps of the routes 
     */
    public Routes() 
    {
    	///////////////////////////////////
    	////// San Diego Flight Data //////
    	///////////////////////////////////
    	airportCodes.put("San Diego", "SAN");
    	sanDiegoMileage.put("New York", 2446);
    	sanDiegoFlightDuration.put("New York", 307); 
    	FlightManager SAN_LGA_1 = new FlightManager("06:00", "SAN", "LGA" , sanDiegoFlightDuration.get("New York"), this); 
    	FlightManager SAN_LGA_2 = new FlightManager("12:00",  "SAN", "LGA", sanDiegoFlightDuration.get("New York"), this); 
    	FlightManager SAN_LGA_3 = new FlightManager("18:00",  "SAN", "LGA", sanDiegoFlightDuration.get("New York"), this); 
    	SAN_LGA_Flights = new FlightManager [] {SAN_LGA_1, SAN_LGA_2, SAN_LGA_3};
    	SanDiegoFlights.put("New York", SAN_LGA_Flights);
    		
    	sanDiegoMileage.put("Tokyo", 5557); 
    	sanDiegoFlightDuration.put("Tokyo", 661);
      	FlightManager SAN_NRT_1 = new FlightManager("06:00", "SAN" , "NRT", sanDiegoFlightDuration.get("Tokyo"), this); 
    	FlightManager SAN_NRT_2 = new FlightManager("20:00", "SAN" , "NRT", sanDiegoFlightDuration.get("Tokyo"), this); 
    	SAN_NRT_Flights = new FlightManager [] {SAN_NRT_1, SAN_NRT_2};
    	SanDiegoFlights.put("Tokyo", SAN_NRT_Flights);
    	
    	sanDiegoMileage.put("Singapore", 8874); 
    	sanDiegoFlightDuration.put("Singapore", 1038); 
    	FlightManager SAN_SIN_1 = new FlightManager("07:25", "SAN" , "SIN", sanDiegoFlightDuration.get("Singapore"), this);
    	SAN_SIN_Flights = new FlightManager [] {SAN_SIN_1};
    	SanDiegoFlights.put("Singapore", SAN_SIN_Flights);
    	
    	sanDiegoMileage.put("Paris", 5698); 
    	sanDiegoFlightDuration.put("Paris", 677); 
    	FlightManager SAN_CDG_1 = new FlightManager("06:45", "SAN" , "CDG", sanDiegoFlightDuration.get("Paris"), this); 
    	FlightManager SAN_CDG_2 = new FlightManager("15:20", "SAN" , "CDG", sanDiegoFlightDuration.get("Paris"), this); 
    	SAN_CDG_Flights = new FlightManager [] {SAN_CDG_1, SAN_CDG_2};
    	SanDiegoFlights.put("Paris", SAN_CDG_Flights);
    	
    	
    	///////////////////////////////////
    	////// New York Flight Data  //////
    	///////////////////////////////////
    	airportCodes.put("New York", "LGA");
    	newYorkMileage.put("London", 3451); 
    	newYorkFlightDuration.put("London", 422); 
    	FlightManager LGA_LHR_1 = new FlightManager("05:00", "LGA", "LHR" , newYorkFlightDuration.get("London"), this); 
    	FlightManager LGA_LHR_2 = new FlightManager("09:00",  "LGA", "LHR", newYorkFlightDuration.get("London"), this); 
    	FlightManager LGA_LHR_3 = new FlightManager("19:30",  "LGA", "LHR", newYorkFlightDuration.get("London"), this);
    	LGA_LHR_Flights = new FlightManager [] {LGA_LHR_1, LGA_LHR_2, LGA_LHR_3};
    	NewYorkFlights.put("London", LGA_LHR_Flights);
    	
    	newYorkMileage.put("Doha", 6704); 
    	newYorkFlightDuration.put("Doha", 791); 
    	FlightManager LGA_DOH_1 = new FlightManager("06:35", "LGA",  "DOH" , newYorkFlightDuration.get("Doha"), this); 
    	FlightManager LGA_DOH_2 = new FlightManager("11:20",  "LGA", "DOH", newYorkFlightDuration.get("Doha"), this); 
    	FlightManager LGA_DOH_3 = new FlightManager("21:30",  "LGA", "DOH", newYorkFlightDuration.get("Doha"), this);
    	LGA_DOH_Flights = new FlightManager [] {LGA_DOH_1, LGA_DOH_2, LGA_DOH_3};
    	NewYorkFlights.put("Doha", LGA_DOH_Flights);
    	
    	newYorkMileage.put("Stockholm", 3920); 
    	newYorkFlightDuration.put("Stockholm", 475); 
    	FlightManager LGA_ARN_1 = new FlightManager("07:55", "LGA",  "ARN" , newYorkFlightDuration.get("Stockholm"), this); 
    	LGA_ARN_Flights = new FlightManager [] {LGA_ARN_1};
    	NewYorkFlights.put("Stockholm", LGA_ARN_Flights);
    	
    	newYorkMileage.put("Tokyo", 6745); 
    	newYorkFlightDuration.put("Tokyo", 796); 
    	FlightManager LGA_NRT_1 = new FlightManager("05:35", "LGA",  "NRT" , newYorkFlightDuration.get("Tokyo"), this); 
    	FlightManager LGA_NRT_2 = new FlightManager("14:20",  "LGA", "NRT", newYorkFlightDuration.get("Tokyo"), this); 
    	FlightManager LGA_NRT_3 = new FlightManager("18:30",  "LGA", "NRT", newYorkFlightDuration.get("Tokyo"), this);
    	LGA_NRT_Flights = new FlightManager [] {LGA_NRT_1, LGA_NRT_2, LGA_NRT_3};
    	NewYorkFlights.put("Tokyo", LGA_NRT_Flights);
    	
    	newYorkMileage.put("Singapore", 9537); 
    	newYorkFlightDuration.put("Singapore", 1113); 
    	FlightManager LGA_SIN_1 = new FlightManager("05:35", "LGA",  "SIN" , newYorkFlightDuration.get("Singapore"), this); 
    	FlightManager LGA_SIN_2 = new FlightManager("13:20",  "LGA", "SIN", newYorkFlightDuration.get("Singapore"), this); 
    	FlightManager LGA_SIN_3 = new FlightManager("16:30",  "LGA", "SIN", newYorkFlightDuration.get("Singapore"), this);
    	LGA_SIN_Flights = new FlightManager [] {LGA_SIN_1, LGA_SIN_2, LGA_SIN_3};
    	NewYorkFlights.put("Singapore", LGA_SIN_Flights);
    	
    	newYorkMileage.put("Paris", 3635); 
    	newYorkFlightDuration.put("Paris", 442); 
    	FlightManager LGA_CDG_1 = new FlightManager("05:55", "LGA",  "CDG" , newYorkFlightDuration.get("Paris"), this); 
    	FlightManager LGA_CDG_2 = new FlightManager("10:20",  "LGA", "CDG", newYorkFlightDuration.get("Paris"), this); 
    	FlightManager LGA_CDG_3 = new FlightManager("17:10",  "LGA", "CDG", newYorkFlightDuration.get("Paris"), this);
    	LGA_CDG_Flights = new FlightManager [] {LGA_CDG_1, LGA_CDG_2, LGA_CDG_3};
    	NewYorkFlights.put("Paris", LGA_CDG_Flights);
    	
    	
    	newYorkMileage.put("Hong Kong", 8072); 
    	newYorkFlightDuration.put("Hong Kong", 946); 
    	FlightManager LGA_HKG_1 = new FlightManager("06:55", "LGA",  "HKG" , newYorkFlightDuration.get("Hong Kong"), this); 
    	FlightManager LGA_HKG_2 = new FlightManager("17:20",  "LGA", "HKG", newYorkFlightDuration.get("Hong Kong"), this); 
    	LGA_HKG_Flights = new FlightManager [] {LGA_HKG_1, LGA_HKG_2};
    	NewYorkFlights.put("Hong Kong", LGA_HKG_Flights);
    	
    	newYorkMileage.put("San Diego", 2446); 
    	newYorkFlightDuration.put("San Diego", 307); 
    	FlightManager LGA_SAN_1 = new FlightManager("06:00", "LGA", "SAN" , newYorkFlightDuration.get("San Diego"), this); 
    	FlightManager LGA_SAN_2 = new FlightManager("12:00",  "LGA", "SAN", newYorkFlightDuration.get("San Diego"), this); 
    	FlightManager LGA_SAN_3 = new FlightManager("18:00",  "LGA", "SAN", newYorkFlightDuration.get("San Diego"), this);
    	LGA_SAN_Flights = new FlightManager [] {LGA_SAN_1, LGA_SAN_2, LGA_SAN_3};
    	NewYorkFlights.put("San Diego", LGA_SAN_Flights);
    
    	/////////////////////////////////////
    	////// London(LHR) Flight Data //////
    	/////////////////////////////////////
    	airportCodes.put("London", "LHR");
    	londonMileage.put("New York", 3449); 
    	londonFlightDuration.put("New York", 421); 
    	FlightManager LHR_LGA_1 = new FlightManager("06:00", "LHR", "LGA" , londonFlightDuration.get("New York"), this); 
    	FlightManager LHR_LGA_2 = new FlightManager("12:00",  "LHR", "LGA", londonFlightDuration.get("New York"), this); 
    	FlightManager LHR_LGA_3 = new FlightManager("18:00",  "LHR", "LGA", londonFlightDuration.get("New York"), this);
    	LHR_LGA_Flights = new FlightManager [] {LHR_LGA_1, LHR_LGA_2, LHR_LGA_3};
    	LondonFlights.put("New York", LHR_LGA_Flights);
    	
    	londonMileage.put("Tokyo", 5975); 
    	londonFlightDuration.put("Tokyo", 708); 
    	FlightManager LHR_NRT_1 = new FlightManager("05:00", "LHR",  "NRT" , londonFlightDuration.get("Tokyo"), this); 
    	FlightManager LHR_NRT_2 = new FlightManager("13:23",  "LHR", "NRT", londonFlightDuration.get("Tokyo"), this); 
    	FlightManager LHR_NRT_3 = new FlightManager("19:00",  "LHR", "NRT", londonFlightDuration.get("Tokyo"), this);
    	LHR_NRT_Flights = new FlightManager [] {LHR_NRT_1, LHR_NRT_2, LHR_NRT_3};
    	LondonFlights.put("Tokyo", LHR_NRT_Flights);
    	
    	londonMileage.put("Doha", 3261); 
    	londonFlightDuration.put("Doha", 400); 
     	FlightManager LHR_DOH_1 = new FlightManager("07:00", "LHR",  "DOH" , londonFlightDuration.get("Doha"), this); 
    	FlightManager LHR_DOH_2 = new FlightManager("18:10",  "LHR", "DOH", londonFlightDuration.get("Doha"), this); 
    	LHR_DOH_Flights = new FlightManager [] {LHR_DOH_1, LHR_DOH_2};
    	LondonFlights.put("Doha", LHR_DOH_Flights);
    	
    	londonMileage.put("Stockholm", 911); 
    	londonFlightDuration.put("Stockholm", 133); 
     	FlightManager LHR_ARN_1 = new FlightManager("08:20", "LHR",  "ARN" , londonFlightDuration.get("Stockholm"), this);
    	LHR_ARN_Flights = new FlightManager [] {LHR_ARN_1};
    	LondonFlights.put("Stockholm", LHR_ARN_Flights);
    	
    	londonMileage.put("Singapore", 6765); 
    	londonFlightDuration.put("Singapore", 798); 
     	FlightManager LHR_SIN_1 = new FlightManager("10:20", "LHR", "SIN", londonFlightDuration.get("Singapore"), this); 
    	FlightManager LHR_SIN_2 = new FlightManager("14:40", "LHR", "SIN", londonFlightDuration.get("Singapore"), this); 
    	LHR_SIN_Flights = new FlightManager [] {LHR_SIN_1, LHR_SIN_2};
    	LondonFlights.put("Singapore", LHR_SIN_Flights);
    	
    	londonMileage.put("Paris", 216); 
    	londonFlightDuration.put("Paris", 54); 
     	FlightManager LHR_CDG_1 = new FlightManager("08:00", "LHR",  "CDG" , londonFlightDuration.get("Paris"), this); 
    	FlightManager LHR_CDG_2 = new FlightManager("12:00",  "LHR", "CDG", londonFlightDuration.get("Paris"), this); 
    	FlightManager LHR_CDG_3 = new FlightManager("19:00",  "LHR", "CDG", londonFlightDuration.get("Paris"), this);
    	LHR_CDG_Flights = new FlightManager [] {LHR_CDG_1, LHR_CDG_2, LHR_CDG_3};
    	LondonFlights.put("Paris", LHR_CDG_Flights);
    	
    	londonMileage.put("Hong Kong", 5995); 
    	londonFlightDuration.put("Hong Kong", 711); 
    	FlightManager LHR_HKG_1 = new FlightManager("08:00", "LHR",  "HKG" , londonFlightDuration.get("Hong Kong"), this); 
    	LHR_HKG_Flights = new FlightManager [] {LHR_HKG_1};
    	LondonFlights.put("Hong Kong", LHR_HKG_Flights);
    	
    	////////////////////////////////////
    	////// Tokyo(NRT) Flight Data //////
    	////////////////////////////////////
    	airportCodes.put("Tokyo", "NRT");
    	tokyoMileage.put("New York", 6734); 
    	tokyoFlightDuration.put("New York", 794); 
    	FlightManager NRT_LGA_1 = new FlightManager("06:30", "NRT", "LGA", tokyoFlightDuration.get("New York"), this);
    	FlightManager NRT_LGA_2 = new FlightManager("17:45", "NRT", "LGA", tokyoFlightDuration.get("New York"), this);
    	NRT_LGA_Flights = new FlightManager[] {NRT_LGA_1, NRT_LGA_2};
    	TokyoFlights.put("New York", NRT_LGA_Flights);
    	
    	tokyoMileage.put("London", 5975); 
    	tokyoFlightDuration.put("London", 708); 
    	FlightManager NRT_LHR_1 = new FlightManager("08:00", "NRT", "LHR", tokyoFlightDuration.get("London"), this);
    	FlightManager NRT_LHR_2 = new FlightManager("21:15", "NRT", "LHR", tokyoFlightDuration.get("London"), this);
        NRT_LHR_Flights = new FlightManager[] {NRT_LHR_1, NRT_LHR_2};
    	TokyoFlights.put("London", NRT_LHR_Flights);
    	
    	tokyoMileage.put("Singapore", 3324); 
    	tokyoFlightDuration.put("Singapore", 407); 
    	FlightManager NRT_SIN_1 = new FlightManager("10:00", "NRT", "SIN", tokyoFlightDuration.get("Singapore"), this);
    	NRT_SIN_Flights = new FlightManager[] {NRT_SIN_1};
    	TokyoFlights.put("Singapore", NRT_SIN_Flights);
    	
    	tokyoMileage.put("San Diego", 5557); 
    	tokyoFlightDuration.put("San Diego", 661); 
    	FlightManager NRT_SAN_1 = new FlightManager("08:00", "NRT", "SAN", tokyoFlightDuration.get("San Diego"), this);
    	FlightManager NRT_SAN_2 = new FlightManager("21:15", "NRT", "SAN", tokyoFlightDuration.get("San Diego"), this);
        NRT_SAN_Flights = new FlightManager[] {NRT_SAN_1, NRT_SAN_2};
    	TokyoFlights.put("San Diego", NRT_SAN_Flights);
    	
    	////////////////////////////////////
    	////// Doha(DOH) Flight Data  //////
    	////////////////////////////////////
    	airportCodes.put("Doha", "DOH");
    	
    	dohaMileage.put("New York", 6704);
    	dohaFlightDuration.put("New York", 791); 
    	FlightManager DOH_LGA_1 = new FlightManager("07:30", "DOH", "LGA", dohaFlightDuration.get("New York"), this);
    	FlightManager DOH_LGA_2 = new FlightManager("18:50", "DOH", "LGA", dohaFlightDuration.get("New York"), this);
    	DOH_LGA_Flights = new FlightManager[] {DOH_LGA_1, DOH_LGA_2};
    	DohaFlights.put("New York", DOH_LGA_Flights);
    	
    	dohaMileage.put("London", 3261);
    	dohaFlightDuration.put("London", 400); 
    	FlightManager DOH_LHR_1 = new FlightManager("09:00", "DOH", "LHR", dohaFlightDuration.get("London"), this);
    	FlightManager DOH_LHR_2 = new FlightManager("20:30", "DOH", "LHR", dohaFlightDuration.get("London"), this);
    	DOH_LHR_Flights = new FlightManager[] {DOH_LHR_1, DOH_LHR_2};
    	DohaFlights.put("London", DOH_LHR_Flights);
    	
    	/////////////////////////////////////
    	////// Paris (CDG) Flight Data //////
    	/////////////////////////////////////
    	airportCodes.put("Paris", "CDG");
    	parisMileage.put("New York", 3633); 
    	parisFlightDuration.put("New York", 442); 
    	FlightManager CDG_LGA_1 = new FlightManager("07:30", "CDG", "LGA", parisFlightDuration.get("New York"), this);
    	FlightManager CDG_LGA_2 = new FlightManager("13:45", "CDG", "LGA", parisFlightDuration.get("New York"), this);
    	CDG_LGA_Flights = new FlightManager[] {CDG_LGA_1, CDG_LGA_2};
    	ParisFlights.put("New York", CDG_LGA_Flights);
    	
    	parisMileage.put("London", 216); 
    	parisFlightDuration.put("London", 54);
    	FlightManager CDG_LHR_1 = new FlightManager("09:00", "CDG", "LHR", parisFlightDuration.get("London"), this);
    	FlightManager CDG_LHR_2 = new FlightManager("16:00", "CDG", "LHR", parisFlightDuration.get("London"), this);
    	CDG_LHR_Flights = new FlightManager[] {CDG_LHR_1, CDG_LHR_2};
    	ParisFlights.put("London", CDG_LHR_Flights);
    	
    	parisMileage.put("Singapore", 6667); 
    	parisFlightDuration.put("Singapore",787); 
    	FlightManager CDG_SIN_1 = new FlightManager("11:00", "CDG", "SIN", parisFlightDuration.get("Singapore"), this);
    	FlightManager CDG_SIN_2 = new FlightManager("23:00", "CDG", "SIN", parisFlightDuration.get("Singapore"), this);
    	CDG_SIN_Flights = new FlightManager[] {CDG_SIN_1, CDG_SIN_2};
    	ParisFlights.put("Singapore", CDG_SIN_Flights);
    	
    	parisMileage.put("San Diego", 5698); 
    	parisFlightDuration.put("San Diego", 677); 
    	FlightManager CDG_SAN_1 = new FlightManager("12:30", "CDG", "SAN", parisFlightDuration.get("San Diego"), this);
    	CDG_SAN_Flights = new FlightManager[] {CDG_SAN_1};
    	ParisFlights.put("San Diego", CDG_SAN_Flights);
    	
    	//////////////////////////////////////
    	//// Stockhom (ARN) Flight Data //////
    	/////////////////////////////////////
    	airportCodes.put("Stockholm", "ARN");
    	stockholmMileage.put("New York", 3916); 
    	stockholmFlightDuration.put("New York", 474);
    	FlightManager ARN_LGA_1 = new FlightManager("14:00", "ARN", "LGA", stockholmFlightDuration.get("New York"), this);
    	FlightManager ARN_LGA_2 = new FlightManager("21:00", "ARN", "LGA", stockholmFlightDuration.get("New York"), this);
        ARN_LGA_Flights = new FlightManager[] {ARN_LGA_1, ARN_LGA_2};
    	StockholmFlights.put("New York", ARN_LGA_Flights);
    	
    	stockholmMileage.put("London", 911); 
    	stockholmFlightDuration.put("London", 133);
    	FlightManager ARN_LHR_1 = new FlightManager("10:15", "ARN", "LHR", stockholmFlightDuration.get("London"), this);
    	ARN_LHR_Flights = new FlightManager[] {ARN_LHR_1};
    	StockholmFlights.put("London", ARN_LHR_Flights);
    	
    	//////////////////////////////////////
    	/// Singapore (SIN) Flight Data //////
    	/////////////////////////////////////
    	airportCodes.put("Singapore", "SIN");
    	singaporeMileage.put("San Diego", 8874);
    	singaporeFlightDuration.put("San Diego", 1038);
    	FlightManager SIN_SAN_1 = new FlightManager("18:00", "SIN", "SAN", singaporeFlightDuration.get("San Diego"), this);
    	SIN_SAN_Flights = new FlightManager[] {SIN_SAN_1};
    	SingaporeFlights.put("San Diego", SIN_SAN_Flights);
    	
    	singaporeMileage.put("New York", 9528);
    	singaporeFlightDuration.put("New York", 1112);
    	FlightManager SIN_LGA_1 = new FlightManager("17:00", "SIN", "LGA", singaporeFlightDuration.get("New York"), this);
    	FlightManager SIN_LGA_2 = new FlightManager("23:50", "SIN", "LGA", singaporeFlightDuration.get("New York"), this);
    	SIN_LGA_Flights = new FlightManager[] {SIN_LGA_1, SIN_LGA_2};
    	SingaporeFlights.put("New York", SIN_LGA_Flights);
    	
    	singaporeMileage.put("London", 6765);
    	singaporeFlightDuration.put("London", 798);
    	FlightManager SIN_LHR_1 = new FlightManager("09:00", "SIN", "LHR", singaporeFlightDuration.get("London"), this);
    	FlightManager SIN_LHR_2 = new FlightManager("21:30", "SIN", "LHR", singaporeFlightDuration.get("London"), this);
    	SIN_LHR_Flights = new FlightManager[] {SIN_LHR_1, SIN_LHR_2};
    	SingaporeFlights.put("London", SIN_LHR_Flights);
    	
    	singaporeMileage.put("Tokyo", 3324);
    	singaporeFlightDuration.put("Tokyo", 407);
    	FlightManager SIN_NRT_1 = new FlightManager("13:30", "SIN", "NRT", singaporeFlightDuration.get("Tokyo"), this);
    	SIN_NRT_Flights = new FlightManager[] {SIN_NRT_1};
    	SingaporeFlights.put("Tokyo", SIN_NRT_Flights);
    	
    	singaporeMileage.put("Hong Kong", 1588);
    	singaporeFlightDuration.put("Hong Kong", 210);
    	FlightManager SIN_HKG_1 = new FlightManager("08:00", "SIN", "HKG", singaporeFlightDuration.get("Hong Kong"), this);
    	SIN_HKG_Flights = new FlightManager[] {SIN_HKG_1};
    	SingaporeFlights.put("Hong Kong", SIN_HKG_Flights);
    		
    	//////////////////////////////////////
    	//// Hong Kong (HKG) Flight Data /////
    	/////////////////////////////////////
    	airportCodes.put("Hong Kong", "HKG");
    	hongKongMileage.put("London", 5995);
    	hongKongFlightDuration.put("London", 711);
    	FlightManager HKG_LHR_1 = new FlightManager("23:30", "HKG", "LHR", hongKongFlightDuration.get("London"), this);
    	HKG_LHR_Flights = new FlightManager[] {HKG_LHR_1};
    	HongKongFlights.put("London", HKG_LHR_Flights);
    	
    	hongKongMileage.put("New York", 8062);
    	hongKongFlightDuration.put("New York", 945);
    	FlightManager HKG_LGA_1 = new FlightManager("15:00", "HKG", "LGA", hongKongFlightDuration.get("New York"), this);
    	FlightManager HKG_LGA_2 = new FlightManager("22:00", "HKG", "LGA", hongKongFlightDuration.get("New York"), this);
    	HKG_LGA_Flights = new FlightManager[] {HKG_LGA_1, HKG_LGA_2};
    	HongKongFlights.put("New York", HKG_LGA_Flights);
    	
    	hongKongMileage.put("Singapore", 1588);
    	hongKongFlightDuration.put("Singapore", 210);
    	FlightManager HKG_SIN_1 = new FlightManager("09:45", "HKG", "SIN", hongKongFlightDuration.get("Singapore"), this);
    	HKG_SIN_Flights = new FlightManager[] {HKG_SIN_1};
    	HongKongFlights.put("Singapore", HKG_SIN_Flights);
    }
    
    /** 
     * Purpose: retrieves the array of departures
     * @return departures
     */
	public String[] getDepartures() 
	{ 
		return departures; 
	}
	
	/** 
	 * Purpose: gets the destinations of the city the flight is departing from 
	 * @param departCity
	 * @return array of destination cities 
	 */
	public String[] getDestinations(String departCity)
	{ 
		if("San Diego".equals(departCity))
		 	return  sanDiego; 
		else if("New York".equals(departCity))
		 	return  newYork; 
		else if("London".equals(departCity))
		 	return london; 
		else if("Tokyo".equals(departCity)) 
			return tokyo; 
		else if("Doha".equals(departCity)) 
			return doha; 
		else if("Paris".equals(departCity)) 
			return paris; 
		else if("Stockholm".equals(departCity)) 
			return stockholm; 
		else if("Singapore".equals(departCity)) 
			return singapore;
		else if("Hong Kong".equals(departCity)) 
			return hongKong;
		return null; 
	} 
	
	/** 
	 * Purpose: gets the mileage for a flight between two cities 
	 * @param departureCity
	 * @param destinationCity
	 * @return mileage of flight 
	 */
	public int getFlightMiles(String departureCity, String destinationCity) 
	{ 
		switch(departureCity)
		{
		case "San Diego": 
			return sanDiegoMileage.get(destinationCity);
		case "New York":
			return newYorkMileage.get(destinationCity);
		case "London":
			return londonMileage.get(destinationCity); 
		case "Tokyo":
			return tokyoMileage.get(destinationCity); 
		case "Doha":
			return dohaMileage.get(destinationCity); 
		case "Paris":
			return parisMileage.get(destinationCity); 
		case "Stockholm":
			return stockholmMileage.get(destinationCity); 
		case "Singapore":
			return singaporeMileage.get(destinationCity); 
		case "Hong Kong":
			return hongKongMileage.get(destinationCity); 
		default: 
			return 0;
			
		}
	}
	
	/** 
	 * Purpose: Retrieves the time to fly between two cities 
	 * @param departureCity
	 * @param destinationCity
	 * @return formated flight time in hours and minutes 
	 */
	public String getFlightDuration(String departureCity, String destinationCity)
	{
		int rawMinutes = 0; 
		
		switch(departureCity)
		{
		case "San Diego": 
			rawMinutes = sanDiegoFlightDuration.get(destinationCity);
			break;
		case "New York":
			rawMinutes = newYorkFlightDuration.get(destinationCity);
			break;
		case "London":
			rawMinutes = londonFlightDuration.get(destinationCity); 
			break;
		case "Tokyo":
			rawMinutes = tokyoFlightDuration.get(destinationCity); 
			break;
		case "Doha":
			rawMinutes = dohaFlightDuration.get(destinationCity); 
			break;
		case "Paris":
			rawMinutes = parisFlightDuration.get(destinationCity); 
			break;
		case "Stockholm":
			rawMinutes = stockholmFlightDuration.get(destinationCity); 
			break;
		case "Singapore":
			rawMinutes = singaporeFlightDuration.get(destinationCity); 
			break;
		case "Hong Kong":
			rawMinutes = hongKongFlightDuration.get(destinationCity); 
			break;
		}
		// Use modular math to convert total minutes into hours:minutes
		return rawMinutes/60 + " Hours" + " " + rawMinutes % 60 + " Minutes";
	}
	
	/** 
	 * Purpose: retrieves the airport code for a given city
	 * @param city
	 * @return airport code from airport code map
	 */
	public String getAirportCode(String city)
	{
		return airportCodes.get(city);
	}
	
	/** 
	 * Purpose: gets a list of flights avaiable between two cities 
	 * @param departureCity
	 * @param destinationCity
	 * @return array of flights
	 */
	public FlightManager [] getListOfFlights(String departureCity, String destinationCity) 
	{ 
		switch(departureCity) 
		{ 
			case "San Diego": 
				return SanDiegoFlights.get(destinationCity); 
			case "New York": 
				return NewYorkFlights.get(destinationCity); 
			case "London": 
				return LondonFlights.get(destinationCity);
			case "Tokyo": 
				return TokyoFlights.get(destinationCity);
			case "Doha": 
				return DohaFlights.get(destinationCity);
			case "Paris": 
				return ParisFlights.get(destinationCity); 
			case "Stockholm": 
				return StockholmFlights.get(destinationCity);
			case "Singapore": 
				return SingaporeFlights.get(destinationCity); 
			case "Hong Kong": 
				return HongKongFlights.get(destinationCity); 
			default: 
				return null; 
		}
	}
	
	/** 
	 * Purpose: sets the departure date into the route
	 * @param departDate
	 */
	public void setDepartDate(String departDate)
	{
		this.departDate = departDate;
	}
	
	/** 
	 * Purpose: retrieves the stored departdate
	 * @return departDate
	 */
	public String getDepartDate()
	{ 
		return departDate;
	}
}