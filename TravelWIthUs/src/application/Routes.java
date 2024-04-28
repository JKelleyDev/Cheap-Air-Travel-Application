package application;

import java.util.HashMap;
import java.util.Hashtable;

/** 
 * 
 * 
 * 
 * Reference: 
 * https://www.airmilescalculator.com  // used to determine mileage and route of flights 
 */
public class Routes 
{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private String departDate; 
	
	
	private String departures [] = {"San Diego", "New York", "London", "Tokyo", "Doha", "Paris","Stockholm", "Singapore", "Hong Kong"};
	private Hashtable<String, String> airportCodes = new Hashtable<String, String>();
	
	
	private String sanDiego[] = { "New York", "Tokyo",  "Singapore", "Paris" };
	private HashMap<String, Integer> sanDiegoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> sanDiegoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> SanDiegoFlights = new HashMap<String, FlightManager[]>();
	private FlightManager [] SAN_LGA_Flights; 
	private FlightManager [] SAN_NRT_Flights;
	private FlightManager [] SAN_SIN_Flights;
	private FlightManager [] SAN_CDG_Flights;
	
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
	
	private String london [] = {"New York", "Tokyo", "Doha", "Stockholm", "Singapore", "Paris", "Hong Kong"};
	private HashMap<String, Integer> londonMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> londonFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> LondonFlights = new HashMap<String, FlightManager[]>();
	
	private String tokyo [] = {"New York", "London", "Singapore"};
	private HashMap<String, Integer> tokyoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> tokyoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> TokyoFlights = new HashMap<String, FlightManager[]>();
	
	private String doha [] = {"New York", "London"};
	private HashMap<String, Integer> dohaMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> dohaFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> DohaFlights = new HashMap<String, FlightManager[]>();
	
    private String paris [] = {"New York", "London","Singapore", "San Diego"};
    private HashMap<String, Integer> parisMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> parisFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> ParisFlights = new HashMap<String, FlightManager[]>();
	
    private String stockholm [] = {"New York", "London"};
    private HashMap<String, Integer> stockholmMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> stockholmFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> StockholmFlights = new HashMap<String, FlightManager[]>();
	
    private String singapore [] = {"San Diego", "New York", "Tokyo", "London", "Hong Kong"};
    private HashMap<String, Integer> singaporeMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> singaporeFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> SingaporeFlights = new HashMap<String, FlightManager[]>();
	
    private String hongKong [] = { "London", "New York", "Singapore" }; 
    private HashMap<String, Integer> hongKongMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> hongKongFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private HashMap<String, FlightManager[]> HongKongFlights = new HashMap<String, FlightManager[]>();
	
	
    // setup HashMaps 
    public Routes() 
    {
    	
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
      	FlightManager SAN_NRT_1 = new FlightManager("06:00", "SAN" , "NRT", sanDiegoFlightDuration.get("New York"), this); 
    	FlightManager SAN_NRT_2 = new FlightManager("20:00", "SAN" , "NRT", sanDiegoFlightDuration.get("New York"), this); 
    	SAN_NRT_Flights = new FlightManager [] {SAN_NRT_1, SAN_NRT_2};
    	SanDiegoFlights.put("Tokyo", SAN_NRT_Flights);
    	
    	sanDiegoMileage.put("Singapore", 8874); 
    	sanDiegoFlightDuration.put("Singapore", 1038); 
    	FlightManager SAN_SIN_1 = new FlightManager("07:25", "SAN" , "SIN", sanDiegoFlightDuration.get("Singapore"), this);
    	SAN_NRT_Flights = new FlightManager [] {SAN_SIN_1};
    	SanDiegoFlights.put("Singapore", SAN_SIN_Flights);
    	
    	sanDiegoMileage.put("Paris", 5698); 
    	sanDiegoFlightDuration.put("Paris", 677); 
    	FlightManager SAN_CDG_1 = new FlightManager("06:45", "SAN" , "CDG", sanDiegoFlightDuration.get("Paris"), this); 
    	FlightManager SAN_CDG_2 = new FlightManager("15:20", "SAN" , "CDG", sanDiegoFlightDuration.get("Paris"), this); 
    	SAN_CDG_Flights = new FlightManager [] {SAN_CDG_1, SAN_CDG_2};
    	SanDiegoFlights.put("Paris", SAN_CDG_Flights);
    	
    	
    	/////////////////////////////////////////
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
    	
    	newYorkMileage.put("Stockholm", 3920); 
    	newYorkFlightDuration.put("Stockholm", 475); 
    	
    	newYorkMileage.put("Tokyo", 6745); 
    	newYorkFlightDuration.put("Tokyo", 796); 
    	
    	newYorkMileage.put("Singapore", 9537); 
    	newYorkFlightDuration.put("Singapore", 1113); 
    	
    	newYorkMileage.put("Paris", 3635); 
    	newYorkFlightDuration.put("Paris", 442); 
    	
    	newYorkMileage.put("Hong Kong", 8072); 
    	newYorkFlightDuration.put("Hong Kong", 946); 
    	
    	newYorkMileage.put("San Diego", 2446); 
    	newYorkFlightDuration.put("San Diego", 307); 
    	FlightManager LGA_SAN_1 = new FlightManager("06:00", "LGA", "SAN" , newYorkFlightDuration.get("San Diego"), this); 
    	FlightManager LGA_SAN_2 = new FlightManager("12:00",  "LGA", "SAN", newYorkFlightDuration.get("San Diego"), this); 
    	FlightManager LGA_SAN_3 = new FlightManager("18:00",  "LGA", "SAN", newYorkFlightDuration.get("San Diego"), this);
    	LGA_SAN_Flights = new FlightManager [] {LGA_SAN_1, LGA_SAN_2, LGA_SAN_3};
    	NewYorkFlights.put("San Diego", LGA_SAN_Flights);
    
    	////////////////////////////////////////
    	airportCodes.put("London", "LHR");
    	londonMileage.put("New York", 3449); 
    	londonFlightDuration.put("New York", 421); 
    	
    	londonMileage.put("Tokyo", 5975); 
    	londonFlightDuration.put("Tokyo", 708); 
    	
    	londonMileage.put("Doha", 3261); 
    	londonFlightDuration.put("Doha", 400); 
    	
    	londonMileage.put("Stockholm", 911); 
    	londonFlightDuration.put("Stockholm", 133); 
    	
    	londonMileage.put("Singapore", 6765); 
    	londonFlightDuration.put("Singapore", 798); 
    	
    	londonMileage.put("Paris", 216); 
    	londonFlightDuration.put("Paris", 54); 
    	
    	londonMileage.put("Hong Kong", 5995); 
    	londonFlightDuration.put("Hong Kong", 711); 
    	
    	/////////////////////////////////////////////
    	airportCodes.put("Tokyo", "NRT");
    	tokyoMileage.put("New York", 6734); 
    	tokyoFlightDuration.put("New York", 794); 
    	
    	tokyoMileage.put("London", 5975); 
    	tokyoFlightDuration.put("London", 708); 
    	
    	tokyoMileage.put("Singapore", 3324); 
    	tokyoFlightDuration.put("Singapore", 407); 
    	/////////////////////////////////////////////
    	
    	airportCodes.put("Doha", "DOH");
    	
    	dohaMileage.put("New York", 6704);
    	dohaFlightDuration.put("New York", 791); 
    	
    	dohaMileage.put("London", 3261);
    	dohaFlightDuration.put("London", 400); 
    	
        /////////////////////////////////////////////
    	airportCodes.put("Paris", "CDG");
    	parisMileage.put("New York", 3633); 
    	parisFlightDuration.put("New York", 442); 
    	
    	parisMileage.put("London", 216); 
    	parisFlightDuration.put("London", 54); 
    	
    	parisMileage.put("Singapore", 6667); 
    	parisFlightDuration.put("Singapore",787); 
    	
    	parisMileage.put("San Diego", 5698); 
    	parisFlightDuration.put("San Diego", 677); 
    	//////////////////////////////////////////////
    	airportCodes.put("Stockholm", "ARN");
    	stockholmMileage.put("New York", 3916); 
    	stockholmFlightDuration.put("New York", 474);
    	
    	stockholmMileage.put("London", 911); 
    	stockholmFlightDuration.put("London", 133);
        /////////////////////////////////////////////
    	airportCodes.put("Singapore", "SIN");
    	singaporeMileage.put("San Diego", 8874);
    	singaporeFlightDuration.put("San Diego", 1038);
    	
    	singaporeMileage.put("New York", 9528);
    	singaporeFlightDuration.put("New York", 1112);
    	
    	singaporeMileage.put("London", 6765);
    	singaporeFlightDuration.put("London", 798);
    	
    	singaporeMileage.put("Tokyo", 3324);
    	singaporeFlightDuration.put("Tokyo", 407);
    	
    	singaporeMileage.put("Hong Kong", 1588);
    	singaporeFlightDuration.put("Hong Kong", 210);
    	//////////////////////////////////////////////
    	airportCodes.put("Hong Kong", "HKG");
    	hongKongMileage.put("London", 5995);
    	hongKongFlightDuration.put("London", 711);
    	
    	hongKongMileage.put("New York", 8062);
    	hongKongFlightDuration.put("New York", 945);
    	
    	hongKongMileage.put("Singapore", 1588);
    	hongKongFlightDuration.put("Singapore", 210);
    }
    
  
	public String[] getDepartures() 
	{ 
		return departures; 
	}
	
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
		
		return rawMinutes/60 + " Hours" + " " + rawMinutes % 60 + " Minutes";
	}
	
	public String getAirportCode(String city)
	{
		return airportCodes.get(city);
	}
	
	public FlightManager [] getListOfFlights(String departureCity, String destinationCity) 
	{ 
		switch(departureCity) 
		{ 
			case "San Diego": 
				return SanDiegoFlights.get(destinationCity); 
			case "New York": 
				return NewYorkFlights.get(destinationCity); 
//			case "London": 
//				return LondonFlights.get(destinationCity);
//			case "Tokyo": 
//				return TokyoFlights.get(destinationCity);
//			case "Doha": 
//				return DohaFlights.get(destinationCity);
//			case "Paris": 
//				return ParisFlights.get(destinationCity); 
//			case "Stockholm": 
//				return StockholmFlights.get(destinationCity);
//			case "Singapore": 
//				return SingaporeFlights.get(destinationCity); 
//			case "Hong Kong": 
//				return HongKongFlights.get(destinationCity); 
			default: 
				return null; 
		}
	}
	
	public void setDepartDate(String departDate)
	{
		this.departDate = departDate;
	}
	
	public String getDepartDate()
	{ 
		return departDate;
	}
	
	
}