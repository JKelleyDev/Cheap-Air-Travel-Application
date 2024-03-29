package application;

import java.util.HashMap;

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
	
	private String departures [] = {"San Diego", "New York", "London", "Tokyo", "Doha", "Paris","Stockholm", "Singapore", "Hong Kong"};
	
	private String sanDiego[] = { "New York", "Tokyo", "Miami", "Singapore", "Paris" };
	private HashMap<String, Integer> sanDiegoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> sanDiegoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private	String newYork [] = { "London", "Doha", "Stockholm", "Tokyo", "Singapore", "Paris", "Hong Kong", "San Diego" };
	private HashMap<String, Integer> newYorkMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> newYorkFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private String london [] = {"New York", "Tokyo", "Doha", "Stockholm", "Singapore", "Paris", "Hong Kong"};
	private HashMap<String, Integer> londonMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> londonFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private String tokyo [] = {"New York", "London", "Singapore"};
	private HashMap<String, Integer> tokyoMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> tokyoFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
	private String doha [] = {"New York", "London"};
	private HashMap<String, Integer> dohaMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> dohaFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
    private String paris [] = {"New York", "London","Singapore", "San Diego"};
    private HashMap<String, Integer> parisMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> parisFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
    private String stockholm [] = {"New York", "London"};
    private HashMap<String, Integer> stockholmMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> stockholmFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
    private String singapore [] = {"San Diego", "New York", "Tokyo", "London", "Hong Kong"};
    private HashMap<String, Integer> singaporeMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> singaporeFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
    private String hongKong [] = { "London", "New York", "Singapore" }; 
    private HashMap<String, Integer> hongKongMileage = new HashMap<String, Integer>(); 
	private HashMap<String, Integer> hongKongFlightDuration = new HashMap<String, Integer>(); // Time in minutes
	
    
    // setup HashMaps 
    public Routes()
    {
    	sanDiegoMileage.put("New York", 2446);
    	sanDiegoFlightDuration.put("New York", 307); 
    	
    	sanDiegoMileage.put("Tokyo", 5557); 
    	sanDiegoFlightDuration.put("Tokyo", 661);
    	
    	sanDiegoMileage.put("Miami", 2267); 
    	sanDiegoFlightDuration.put("Miami", 287); 
    	
    	sanDiegoMileage.put("Singapore", 8874); 
    	sanDiegoFlightDuration.put("Singapore", 1038); 
    	
    	sanDiegoMileage.put("Paris", 5698); 
    	sanDiegoFlightDuration.put("Paris", 677);
    	
    	/////////////////////////////////////////
    	newYorkMileage.put("London", 3451); 
    	newYorkFlightDuration.put("London", 422); 
    	
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
    	
    	////////////////////////////////////////
    	londonMileage.put("New York", newYorkMileage.get("London")); 
    	londonFlightDuration.put("New York", newYorkFlightDuration.get("London")); 
    	
    	londonMileage.put("Tokyo", 5975); 
    	londonFlightDuration.put("Tokyo", 708); 
    	
    	londonMileage.put("Doha", 3261); 
    	londonFlightDuration.put("Doha", 400); 
    	
    	londonMileage.put("Stockholm", 911); 
    	londonFlightDuration.put("Stockholm", 133); 
    	
    	londonMileage.put("Singapore", null); 
    	londonFlightDuration.put("Singapore", null); 
    	
    	londonMileage.put("Paris", null); 
    	londonFlightDuration.put("Paris", null); 
    	
    	londonMileage.put("Hong Kong", null); 
    	londonFlightDuration.put("Hong Kong", null); 
    	
    	/////////////////////////////////////////////
    	tokyoMileage.put("New York", null); 
    	tokyoFlightDuration.put("New York", null); 
    	
    	tokyoMileage.put("London", null); 
    	tokyoFlightDuration.put("London", null); 
    	
    	tokyoMileage.put("Singapore", null); 
    	tokyoFlightDuration.put("Singapore", null); 
    	/////////////////////////////////////////////
    	dohaMileage.put("New York", newYorkMileage.get("Doha"));
    	dohaFlightDuration.put("New York", newYorkFlightDuration.get("Doha")); 
    	
    	dohaMileage.put("London", londonMileage.get("Doha"));
    	dohaFlightDuration.put("London", londonFlightDuration.get("Doha")); 
        /////////////////////////////////////////////
    	parisMileage.put("New York", newYorkMileage.get("Paris")); 
    	parisFlightDuration.put("New York", newYorkFlightDuration.get("Paris")); 
    	
    	parisMileage.put("London", londonMileage.get("Paris")); 
    	parisFlightDuration.put("London", londonFlightDuration.get("Paris")); 
    	
    	parisMileage.put("Singapore", 6667); 
    	parisFlightDuration.put("Singapore",787); 
    	
    	parisMileage.put("San Diego", sanDiegoMileage.get("Paris")); 
    	parisFlightDuration.put("San Diego", sanDiegoFlightDuration.get("Paris")); 
    	
       
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
	
	
	
	
	
}