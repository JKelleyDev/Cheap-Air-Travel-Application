package application;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Duration;
import java.time.format.DateTimeFormatter;


public class FlightManager
{
	private String departureTime; 
	private String flightNumberPrefix = "TU"; 
	private String arrivalTimeZone; 
	private Routes route; 
	
	private int flightNumberCounter = 0000; 
	
	public FlightManager(String departureTime, String arrivalTimeZone)
	{
		this.departureTime = departureTime;  
		this.arrivalTimeZone = arrivalTimeZone; 
		this.route = route; 
		flightNumberCounter++; 
	}
	
	public String getDepartureTime()
	{ 
		return departureTime.substring(0, 2) + ":" + departureTime.substring(2, 4); 
	}
	
	public String getFlightNumber() 
	{ 
		return flightNumberPrefix + flightNumberCounter; 
	}
	
//	public String getArrivalTime() 
//	{ 
//		ZoneId departureZone = ZoneId.of("America/Los_Angeles");
//        ZonedDateTime departureTime = ZonedDateTime.of(2023, 4, 23, 6, 0, 0, 0, departureZone);
//
//        // Define the flight duration
//        Duration flightDuration = Duration.ofHours(17);
//
//        // Calculate the arrival time in PST
//        ZonedDateTime arrivalTimeInPST = departureTime.plus(flightDuration);
//
//        // Convert to Tokyo time zone
//        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
//        ZonedDateTime arrivalTimeInTokyo = arrivalTimeInPST.withZoneSameInstant(tokyoZone);
//
//        // Format the output
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
//        System.out.println("Arrival time in Tokyo: " + arrivalTimeInTokyo.format(formatter));
//    
//
//	}
}
