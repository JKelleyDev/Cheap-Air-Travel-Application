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
    	
    	londonMileage.put("Singapore", 6765); 
    	londonFlightDuration.put("Singapore", 798); 
    	
    	londonMileage.put("Paris", 216); 
    	londonFlightDuration.put("Paris", 54); 
    	
    	londonMileage.put("Hong Kong", 5995); 
    	londonFlightDuration.put("Hong Kong", 711); 
    	
    	/////////////////////////////////////////////
    	tokyoMileage.put("New York", 6734); 
    	tokyoFlightDuration.put("New York", 794); 
    	
    	tokyoMileage.put("London", 5975); 
    	tokyoFlightDuration.put("London", 708); 
    	
    	tokyoMileage.put("Singapore", 3324); 
    	tokyoFlightDuration.put("Singapore", 407); 
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
    	//////////////////////////////////////////////
    	stockholmMileage.put("New York", null); 
    	stockholmFlightDuration.put("New York", null);
    	
    	stockholmMileage.put("London", null); 
    	stockholmFlightDuration.put("London", null);
        /////////////////////////////////////////////
    	singaporeMileage.put("San Diego", null);
    	singaporeFlightDuration.put("San Diego", null);
    	
    	singaporeMileage.put("New York", null);
    	singaporeFlightDuration.put("New York", null);
    	
    	singaporeMileage.put("London", null);
    	singaporeFlightDuration.put("London", null);
    	
    	singaporeMileage.put("Tokyo", null);
    	singaporeFlightDuration.put("Tokyo", null);
    	
    	singaporeMileage.put("Hong Kong", null);
    	singaporeFlightDuration.put("Hong Kong", null);
    	//////////////////////////////////////////////
    	hongKongMileage.put("London", null);
    	hongKongFlightDuration.put("London", null);
    	
    	hongKongMileage.put("New York", null);
    	hongKongFlightDuration.put("New York", null);
    	
    	hongKongMileage.put("Singapore", null);
    	hongKongFlightDuration.put("Singapore", null);
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
//		case "New York":
//			rawMinutes = newYorkFlightDuration.get(destinationCity);
//		case "London":
//			rawMinutes = londonFlightDuration.get(destinationCity); 
//		case "Tokyo":
//			rawMinutes = tokyoFlightDuration.get(destinationCity); 
//		case "Doha":
//			rawMinutes = dohaFlightDuration.get(destinationCity); 
//		case "Paris":
//			rawMinutes = parisFlightDuration.get(destinationCity); 
//		case "Stockholm":
//			rawMinutes = stockholmFlightDuration.get(destinationCity); 
//		case "Singapore":
//			rawMinutes = singaporeFlightDuration.get(destinationCity); 
//		case "Hong Kong":
//			rawMinutes = hongKongFlightDuration.get(destinationCity); 
		default: 
				
			return rawMinutes/60 + " Hours" + " " + rawMinutes % 60 + " Minutes";
		}
	}
	
	
	
	
	
}