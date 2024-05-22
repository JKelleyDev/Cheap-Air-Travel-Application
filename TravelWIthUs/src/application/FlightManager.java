package application;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
* <br><br>
*    TimeZones: {@link https://docs.oracle.com/middleware/12211/wcs/tag-ref/MISC/TimeZones.html}
* <br><br>
* Responsibilities of class:<br>
* 
* Creates flights assigning them uniuqe flightnumbers and has the ability to return formated departure and arrival times
*/

public class FlightManager 
{	
	private static int flightNumberCounter = 0; // flightManager has a static counter used to assign flight numbers in order of creation
	private String departureTime; // each flight has a departureTime 
	private String departureAirport; // each flight has a departure airport
	private String destinationAirport; // each flight has a destination airport
	private String flightNumberPrefix = "TU"; // each flight number has a TU prefix 
	private int flightDurationMinutes; // each flight has a flight duration 
	private Routes route; // the flightManager has a reference to the route
	private int flightNumber; // each flight has a flight number 
	
    // Create a hashmap for the timezones for each airport code
	private static final Map<String, ZoneId> timeZoneMap = new HashMap<>();
    static 
    {
    	
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
	
    /** 
     * Purpose: Constructor to create the flightManager
     * @param departureTime
     * @param departureAirport
     * @param destinationAirport
     * @param flightDurationMinutes
     * @param route
     */
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
	
	/** 
	 * Purpose: takes the date and time of the departure and formats it for the timezone of the departure airport
	 * @return formated departure date and time
	 */
	public String getDepartureTime()
	{ 
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
	
	/** 
	 * Purpose: returns a formated flight number to be of the proper length
	 * @return formated flight number
	 */
	public String getFlightNumber() 
	{ 
		if(flightNumber < 10)
			return flightNumberPrefix + "000" + flightNumber; 
		
		else if(flightNumber < 100)
			return flightNumberPrefix + "00" + flightNumber; 
		else 
			return flightNumberPrefix + "0" + flightNumber; 
	}
	
	/** 
	 * Purpose: takes the departure date and time, the flight time, and the time zone of the arrival airport to calculate arrival time
	 * @param takeOffDate
	 * @return arrival time of flight
	 */
	public String getArrivalTime(String takeOffDate) 
	{ 
		
		 ZoneId departureZone = timeZoneMap.get(departureAirport);
	     ZoneId destinationZone = timeZoneMap.get(destinationAirport);

	        // Parse the departure date
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate departureDate = LocalDate.parse(takeOffDate, dateFormatter);

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
