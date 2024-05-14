package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Year;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
	private JPanel mainPage;
 
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
			
		String[] months = {null,"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", 
				           "Sep", "Oct", "Nov", "Dec"};
					
		JComboBox<String> departMonthSelection = new JComboBox<String>(months);
		departMonthSelection.setBounds(119, 152, 75, 30);
		mainPage.add(departMonthSelection);
		
		departMonthSelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		  
		           model.setDepartMonth((String) e.getItem());      
		        }
		    }
		});
		
		JComboBox<Integer> departDaySelection = new JComboBox<Integer>();
		departDaySelection.setBounds(190, 152, 65, 30);
		departDaySelection.addItem(null);
		 for(int i = 1; i <= 31; i++) 
			{
				departDaySelection.addItem(i);
			}
		mainPage.add(departDaySelection);
		
		departDaySelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		           model.setDepartDay(String.valueOf(e.getItem())); 
		        }
		    }
		});
		
		JComboBox<Integer> departYearSelection = new JComboBox<Integer>(); 
		departYearSelection.setBounds(245, 152, 88, 30);
		departYearSelection.addItem(null); 
		departYearSelection.addItem(Year.now().getValue()); 
		departYearSelection.addItem(Year.now().getValue()+1);
		mainPage.add(departYearSelection);
		
		departYearSelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		           model.setDepartYear(String.valueOf(e.getItem())); 
		            
		        }
		    }
		});
		
		JComboBox<String> returnMonthSelection = new JComboBox<String>(months);
		returnMonthSelection.setBounds(109, 204, 75, 30);
		mainPage.add(returnMonthSelection);
		
		returnMonthSelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		           model.setReturnMonth((String) e.getItem()); 
		            
		        }
		    }
		});
		
		JComboBox<Integer> returnDaySelection = new JComboBox<Integer>();
		returnDaySelection.setBounds(180, 204, 70, 30);
		returnDaySelection.addItem(null);
		 for(int i = 1; i <= 31; i++) 
			{	
			 returnDaySelection.addItem(i);
			}
		mainPage.add(returnDaySelection);
		
		returnDaySelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		           model.setReturnDay(String.valueOf(e.getItem())); 
		        }
		    }
		});
	
		JComboBox<Integer> returnYearSelection = new JComboBox<Integer>(); 
		returnYearSelection.setBounds(245, 204, 88, 30);
		returnYearSelection.addItem(null); 
		returnYearSelection.addItem(Year.now().getValue()); 
		returnYearSelection.addItem(Year.now().getValue()+1);
		mainPage.add(returnYearSelection);
		
		returnYearSelection.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) 
		    {
		        if (e.getStateChange() == ItemEvent.SELECTED) 
		        {
		           model.setReturnYear(String.valueOf(e.getItem())); 
		            
		        }
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
		oneWayCheckBox.addItemListener(new OneWayCheckBoxItemHandler(model,returnMonthSelection, returnDaySelection, returnYearSelection, returnLabel));
		seeFlightButton.addActionListener(new SeeFlightButtonHandler( frame, c1, contentPane, departureFlightsPage, model, route));
 
	}
	
	public JPanel returnPanel()
	{ 
		return mainPage; 
	}
}
