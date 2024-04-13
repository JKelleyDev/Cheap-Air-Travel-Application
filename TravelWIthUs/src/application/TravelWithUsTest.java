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
		
		model.setDepartureCity("New York");
		assertEquals("New York", model.getDepartureCity());
	  
	}

}
