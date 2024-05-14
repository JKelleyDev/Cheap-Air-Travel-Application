package application;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jordan Kelley
 * @author Esteban Naranjo
 * 
 * @version 2024.05.24.001
 * 
 * @see
 * 	References:
 * <br>
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
 * <br><br>
 * 		CardLayout: 
 * 	<br>	1.) {@link https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/layout/card.html}
 *  <br>    2.) {@link https://www.geeksforgeeks.org/java-awt-cardlayout-class/}
 *  <br>    3.) {@link https://youtu.be/ocb3x0TeoUw?si=I7B3eGt1_Ph4utEC}
 *
 * <br><br>
 * Responsibilities of class:<br>
 * This class represents the main view for the travel booking application.
 * It sets up the main frame, initializes the pages, and handles navigation
 * between different pages.
 * 
 */
public class ApplicationView extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane; // An applicationView has a contentPane to display current view 
	private JPanel mainPage;    // An applicationView has a mainPage which is the first page to be viewed
	private JPanel departureFlightsPage; // An applicationView has a departureFlightsPage where the user chooses flight options
	private JPanel bookingPage;// An applicationView has a bookingPage where the user enters traveler details 
    private JPanel paymentPage;// An applicationView has a paymentPage where the user enters payment information
	private JPanel optionPage; // An applicationView has an optionPage where the user selects extra options 
	private CardLayout c1;     // An applicationView has a cardLayout that organizes multiple JPanels to displayed by calling a keyword
	private Payment payment;   // An applicationView has a payment which stores payment information
	
	 /**
     * Purpose: Launches the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Routes route = new Routes();
                    ApplicationView frame = new ApplicationView(new ApplicationModel(route), route);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	 /**
     * Purpose: Creates the main frame of the application.
     *
     * @param model the application model
     * @param route the routes information
     */
	public ApplicationView(ApplicationModel model, Routes route)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600, 400));
		this.setResizable(false);
		this.setTitle("Travel With Us: An Afforadable Air Travel Service");
		this.pack();
		this.setLocationRelativeTo(null);
			
		// Use the cardlayout to display different views onto the frame, each page is it's own JPanel
		c1 = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(c1);
		this.add(contentPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Menu");
		JMenuItem homePage = new JMenuItem("Home Page"); 
		
		// Add Actionlistener to handle when a user clicks on the "Home Page" menu item
		homePage.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {  
				  dispose();  // Close the current application frame 
			      main(null); // Restart an instance of the application by calling the main method
			    }
		});
		menuBar.add(menu);
		menu.add(homePage); 
	
		// Create the panels for each page
		FlightsPage departureFlightsPageClass = new FlightsPage(this, route, model, c1, contentPane);
		departureFlightsPage = departureFlightsPageClass.returnPanel(); 
		contentPane.add(departureFlightsPage, "departure flights");
	
		mainPage = (new MainPage(this, route, model, c1, contentPane, departureFlightsPageClass).returnPanel()); 
		contentPane.add(mainPage, "main"); 
			
		BookingPage bookingPageClass = new BookingPage(this,route,model,c1,contentPane);
		bookingPage = (bookingPageClass.returnPanel()); 
		contentPane.add(bookingPage, "bookingDetails");
    
		optionPage = (new OptionPage(this,route,model,c1,contentPane, bookingPageClass).returnPanel()); 
		contentPane.add(optionPage, "Option");
		
		paymentPage = (new PaymentPage(this,route,model,c1,contentPane, payment).returnPanel()); 
		contentPane.add(paymentPage, "Payment");
	
		c1.show(contentPane, "main"); // Start on the main page		
	}
}
