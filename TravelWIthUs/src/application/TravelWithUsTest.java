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
