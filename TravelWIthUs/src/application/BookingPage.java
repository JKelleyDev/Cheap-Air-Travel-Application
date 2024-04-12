package application;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookingPage
{
	private JFrame frame;
	private JPanel bookingPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	
	public BookingPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		
		bookingPage = new JPanel(); 
	
		bookingPage.setLayout(null);
		
		// Layout size 600 wide 400 tall
		
		
		
	}
	

}
