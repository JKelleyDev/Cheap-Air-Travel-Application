package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePickerImpl;

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
* 
*
* <br><br>
* Responsibilities of class:<br>
* 
* Creates the mainpage view of the application. This page is responsible for setting the departure and return dates
* and the departure and destination cities. 
* 
*/

public class MainPage extends JFrame
{
	private static final long serialVersionUID = -8739778071928687178L;
	private JPanel mainPage; // The mainPage has a JPanel
	private Date departureDate; 
	private Date returnDate; 
 
	/** 
	 * Purpose: Constructor to create the mainpage
	 * @param frame
	 * @param route
	 * @param model
	 * @param c1
	 * @param contentPane
	 * @param departureFlightsPage
	 */
	public MainPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane, FlightsPage departureFlightsPage)
	{ 
		mainPage = new JPanel(); 	
		mainPage.setLayout(null);

		JLabel departureLabel = new JLabel("Departure Date:");
		departureLabel.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		departureLabel.setBounds(15,150, 100, 30);
		mainPage.add(departureLabel); 
		
		JLabel returnLabel = new JLabel("Return Date:");
		returnLabel.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		returnLabel.setBounds(15,200, 100, 30);
		mainPage.add(returnLabel);
		
		JCheckBox oneWayCheckBox = new JCheckBox("One Way Flight");
		oneWayCheckBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		oneWayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		oneWayCheckBox.setBounds(10,250, 145, 23);
		mainPage.add(oneWayCheckBox);
		
		JLabel lblNewLabel = new JLabel("Travel With Us: Affordable Air Travel");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0,0, 600, 80);
		lblNewLabel.setOpaque(true);
		mainPage.add(lblNewLabel);
				
		JDatePickerImpl departureDatePicker = DatePicker.createDatePicker();
		departureDatePicker.setBounds(120, 152, 145, 30);
		mainPage.add(departureDatePicker);
		departureDatePicker.addActionListener(e -> 
		{
            Object selectedDateObject = departureDatePicker.getModel().getValue();
            if (selectedDateObject != null) 
            {
                departureDate = (Date) selectedDateObject;
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String departureDateString = sdf.format(departureDate);
                
                // Perform the validation
                Date today = new Date();

                if (departureDate.compareTo(today) < 0) 
                {
                    JOptionPane.showMessageDialog(frame, "Selected date must be after today.", "Date Validation", JOptionPane.INFORMATION_MESSAGE);
                    
                } 
                
                model.setDepartDate(departureDateString);
            }
        });
		
		JDatePickerImpl returnDatePicker = DatePicker.createDatePicker();
		returnDatePicker.setBounds(120, 200, 145, 30);
		mainPage.add(returnDatePicker);
		returnDatePicker.addActionListener(e -> 
		{
            Object selectedDateObject = returnDatePicker.getModel().getValue();
            if (selectedDateObject != null) 
            {
                returnDate = (Date) selectedDateObject;
                
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String returnDateString = sdf.format(returnDate);
                
                // Perform the validation
                Date today = new Date();
               

                if (returnDate.compareTo(today) < 0 ||returnDate.compareTo(departureDate) < 0  || returnDate.compareTo(departureDate) == 0) 
                {
                    JOptionPane.showMessageDialog(frame, "Selected date must after departure date.", "Date Validation", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                model.setReturnDate(returnDateString);
            }
        });

		
		JLabel departureCityListLabel = new JLabel("Departure City");
		departureCityListLabel.setFont(new Font("Sans Serif", Font.BOLD, 12));
		departureCityListLabel.setBounds(345, 122, 100, 30);
		mainPage.add(departureCityListLabel);
		
		JList<String> departureCityList = new JList<String>(route.getDepartures());
		departureCityList.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		departureCityList.setLayoutOrientation(JList.VERTICAL);
		departureCityList.setVisibleRowCount(5);
		JScrollPane departureScroll = new JScrollPane(departureCityList); 
		departureScroll.setBounds(334, 150, 120, 150);
		mainPage.add(departureScroll);
		
		JLabel destinationCityListLabel = new JLabel("Desination City");
		destinationCityListLabel.setFont(new Font("Sans Serif", Font.BOLD, 12));
		destinationCityListLabel.setBounds(475, 122, 100, 30);
		mainPage.add(destinationCityListLabel);
		
		JList<String> destinationCityList = new JList<String>();
		destinationCityList.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		JScrollPane destinationScroll = new JScrollPane(destinationCityList); 
		destinationCityList.setVisibleRowCount(5);
		destinationScroll.setBounds(464, 150, 120, 150);
		mainPage.add(destinationScroll);
	
		JButton seeFlightButton = new JButton("See Flights");
		seeFlightButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seeFlightButton.setBackground(new Color(0, 0, 128));
		seeFlightButton.setBounds(495, 310, 95, 30);
		mainPage.add(seeFlightButton);
			
		//Action Listeners
		departureCityList.addListSelectionListener(new DepartureListSelectionHandler(departureCityList,destinationCityList, model)); //listener
		destinationCityList.addListSelectionListener(new  DestinationCityListSelectionHandler(destinationCityList, model) );
		oneWayCheckBox.addItemListener(new OneWayCheckBoxItemHandler(model,returnDatePicker, returnLabel));
		seeFlightButton.addActionListener(new SeeFlightButtonHandler( frame, c1, contentPane, departureFlightsPage, model, route));
 
	}
	
	
	
	public JPanel returnPanel()
	{ 
		return mainPage; 
	}
}
