package application;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class FlightManager 
{	
	private static int flightNumberCounter = 0; 
	private String departureTime; 
	private String departureAirport; 
	private String destinationAirport; 
	private String flightNumberPrefix = "TU"; 
	private int flightDurationMinutes;
	private Routes route; 
	private int flightNumber; 
	

	private static final Map<String, ZoneId> timeZoneMap = new HashMap<>();
    static {
    	
    	timeZoneMap.put("LAX", ZoneId.of("America/Los_Angeles")); // Los Angeles Airport
        timeZoneMap.put("NRT", ZoneId.of("Asia/Tokyo")); // Narita, Tokyo
        timeZoneMap.put("JFK", ZoneId.of("America/New_York")); // JFK, New York
        timeZoneMap.put("LGA", ZoneId.of("America/New_York")); // LaGuardia, New York
        timeZoneMap.put("SAN", ZoneId.of("America/Los_Angeles")); // San Diego
        timeZoneMap.put("LHR", ZoneId.of("Europe/London")); // Heathrow, London
        timeZoneMap.put("DOH", ZoneId.of("Asia/Qatar")); // Doha, Qatar
        timeZoneMap.put("CDG", ZoneId.of("Europe/Paris")); // Charles de Gaulle, Paris
        timeZoneMap.put("ARN", ZoneId.of("Europe/Stockholm")); // Stockholm Arlanda
        timeZoneMap.put("SIN", ZoneId.of("Asia/Singapore")); // Singapore Changi
        timeZoneMap.put("HKG", ZoneId.of("Asia/Hong_Kong")); // Hong Kong International
    }
	
	public FlightManager(String departureTime, String departureAirport, String destinationAirport, int flightDurationMinutes, Routes route)
	{
		this.departureTime = departureTime;  
		this.departureAirport = departureAirport; 
		this.destinationAirport = destinationAirport; 
		this.flightDurationMinutes = flightDurationMinutes; 
		this.route = route; 

		
		flightNumberCounter++; 
		this.flightNumber = flightNumberCounter;
	}
	
	public String getDepartureTime()
	{ 
		//return departureTime; 
		
		    String departureDateString = route.getDepartDate(); 
		    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate departureDate = LocalDate.parse(departureDateString, dateFormatter);

	        // Parse the departure time using LocalTime
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime departureLocalTime = LocalTime.parse(departureTime, timeFormatter);
	        
	        ZonedDateTime departureTime = ZonedDateTime.of(departureDate, departureLocalTime, timeZoneMap.get(departureAirport));

	        
	        // Extended DateTimeFormatter to include date
	        DateTimeFormatter extendedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	        // Format the output to include date
	       
	        return departureTime.format(extendedFormatter);
	}
	
	public String getFlightNumber() 
	{ 
		if(flightNumber < 10)
			return flightNumberPrefix + "000" + flightNumber; 
		
		else if(flightNumber < 100)
			return flightNumberPrefix + "00" + flightNumber; 
		else 
			return flightNumberPrefix + "0" + flightNumber; 
	}
	
	public String getArrivalTime() 
	{ 
		 String departureDateString = route.getDepartDate();
		
		 ZoneId departureZone = timeZoneMap.get(departureAirport);
	     ZoneId destinationZone = timeZoneMap.get(destinationAirport);

	     // Parse the departure date
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate departureDate = LocalDate.parse(departureDateString, dateFormatter);

	        // Parse the departure time using LocalTime
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime departureLocalTime = LocalTime.parse(departureTime, timeFormatter);

	        // Create ZonedDateTime with parsed date and time
	        ZonedDateTime departureTime = ZonedDateTime.of(departureDate, departureLocalTime, departureZone);

	        // Define the flight duration
	        Duration flightDuration = Duration.ofMinutes(flightDurationMinutes);

	        // Calculate the arrival time in the destination time zone
	        ZonedDateTime arrivalTimeInDestinationZone = departureTime.plus(flightDuration)
	            .withZoneSameInstant(destinationZone);

	        // Extended DateTimeFormatter to include date
	        DateTimeFormatter extendedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	        // Format the output to include date
	        
	        return arrivalTimeInDestinationZone.format(extendedFormatter);

	}
}
