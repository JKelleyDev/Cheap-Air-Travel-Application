package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TravelWithUsTest
{
	private Routes routes = new Routes();
	private ApplicationModel model = new ApplicationModel(routes);
	
	@Test
	void testRoutes() 
	{
		assertEquals(2267,routes.getFlightMiles("San Diego", "Miami")); 
		assertEquals(3261,routes.getFlightMiles("London", "Doha"));
		assertEquals(6704,routes.getFlightMiles("Doha", "New York"));
		assertEquals("17 Hours 18 Minutes", routes.getFlightDuration("San Diego","Singapore"));
		assertEquals("11 Hours 17 Minutes", routes.getFlightDuration("Paris","San Diego"));
		assertEquals("7 Hours 2 Minutes", routes.getFlightDuration("New York","London"));
		
		// Test the airport codes 
		
		assertEquals("SAN", routes.getAirportCode("San Diego"));
		assertEquals("CDG", routes.getAirportCode("Paris"));
		assertEquals("SIN", routes.getAirportCode("Singapore"));
		assertEquals("LHR", routes.getAirportCode("London"));
		
		// Test Flight times and Timezone adjustments 
		FlightManager [] SAN_Array = routes.getListOfFlights("San Diego", "New York");
    	FlightManager TestFlight1 = SAN_Array [0];	
    	FlightManager TestFlight2 = SAN_Array [1]; 
		assertEquals(SAN_Array, routes.getListOfFlights("San Diego", "New York"));
		assertEquals("06:00", TestFlight1.getDepartureTime());
	
		
	}
	
	@Test 
	void testModelRates()
	{ 
		model.setDepartMonth("Feb");
		model.setDepartureCity("San Diego");
		model.setDestinationCity("New York");
		assertEquals("San Diego", model.getDepartureCity());
		assertEquals("New York", model.getDestinationCity());
		assertEquals(0.80, model.getSeasonMultiplier());
		
		model.setDepartMonth("Jun");
		model.setDepartureCity("Paris");
		model.setDestinationCity("London");
		assertEquals("Paris", model.getDepartureCity());
		assertEquals("London", model.getDestinationCity());
		assertEquals(1.60, model.getSeasonMultiplier());
		
		model.setDepartMonth("Nov");
		model.setDepartureCity("Singapore");
		model.setDestinationCity("Hong Kong");
		assertEquals("Singapore", model.getDepartureCity());
		assertEquals("Hong Kong", model.getDestinationCity());
		assertEquals(1.20, model.getSeasonMultiplier());
	}

	@Test 
	void testDepartureDates() 
	{ 
		model.setDepartMonth("Jan");
		model.setDepartDay("20");
		model.setDepartYear("2024");
		assertEquals("01/20/2024", model.getDepartureDate());
		
	}
}
