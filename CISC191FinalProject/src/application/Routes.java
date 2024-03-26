package application;

import java.util.HashMap;

public class Routes 
{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private String departures [] = {"San Diego", "New York", "London", "Tokyo", "Doha", "Paris","Stockholm", "Singapore", "Hong Kong"};
	
	private String sanDiego[] = { "New York", "Tokyo", "Miami", "Singapore", "Paris" };
	private HashMap<String, Integer> sanDiegoMileage = new HashMap<String, Integer>(); 
	private	String newYork [] = { "London", "Doha", "Stockholm", "Tokyo", "Singapore", "Paris", "Hong Kong" };
	private String london [] = {"New York", "Tokyo", "Doha", "Stockholm", "Singapore", "Paris", "Hong Kong"};
	private String tokyo [] = {"New York", "London", "Singapore"};
	private String doha [] = {"New York", "London"};
    private String paris [] = {"New York", "London","Singapore", "San Diego"};
    private String stockholm [] = {"New York", "London"};
    private String singapore [] = {"San Diego", "New York", "Tokyo", "London", "Hong Kong"};
    private String hongKong [] = { "London", "New York", "Singapore" }; 

    
    // setup HashMaps 
    public Routes()
    {
    	sanDiegoMileage.put("New York", 1000); 
    	sanDiegoMileage.put("Tokyo", 1000); 
    	sanDiegoMileage.put("Miami", 1000); 
    	sanDiegoMileage.put("Singapore", 1000); 
    	sanDiegoMileage.put("Paris", 1000); 
    	
    	System.out.println(sanDiegoMileage.get("New York"));
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
		
	}
	
	
	
	
	
}