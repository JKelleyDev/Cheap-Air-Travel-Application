package application;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeeFlightButtonHandler implements ActionListener
{ 
	private JFrame frame;
	private CardLayout c1; 
	private JPanel contentPane; 
	private FlightsPage departureFlightsPage;
	private ApplicationModel model; 
	private Routes route; 

	public SeeFlightButtonHandler(JFrame frame, CardLayout c1, JPanel contentPane, FlightsPage departureFlightsPage, ApplicationModel model, Routes route) 
	{ 
		
		this.frame = frame; 
		this.c1 = c1; 
		this.contentPane = contentPane; 
		this.departureFlightsPage = departureFlightsPage; 
		this.model = model; 
		this.route = route; 
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {
		route.setDepartDate(model.getDepartureDate());
		System.out.println(model.getDepartureDate());
		System.out.println(route.getDepartDate());
		departureFlightsPage.setDepartureData();
		c1.show(contentPane, "departure flights");
		frame.setTitle("Flights");
		}
		catch(NullPointerException n)
		{
			JOptionPane.showMessageDialog(null, "No Flights available, please change selections.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
