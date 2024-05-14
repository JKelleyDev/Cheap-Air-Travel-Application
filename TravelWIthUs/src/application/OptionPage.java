package application;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
* The class is responsible for managing the user interface (UI)
* for selecting various travel options within the travel booking application. 
* Moreover the class acts as an intermediary between the user interface and the underlying application logic, 
* facilitating the selection and management of travel options within the travel booking application.
* 
*/

public class OptionPage extends JFrame
{
	private static final long serialVersionUID = -4470953474727184028L;
	private JPanel optionPage; // An OptionPage has a 
	private Option option; // An OptionPage has an option object to store travelers options 
	private JCheckBox wifiBox; // An OptionPage has a wifi check box 
	private JCheckBox mealBox; // An OptionPage has a meals check box 
	private JCheckBox assistanceBox; // An OptionPage has an assistance check box
	private JCheckBox bagsBox; // An OptionPage has a bags check box

	/** 
	 * Purpose: Constructor that creates the page view for options
	 * 
	 * @param frame the JFrame object representing the main frame of the application.
	 * @param route the routes object representing the travel route. 
	 * @param model the applicationModel object representing the application model.
	 * @param c1 the cardLayout object for managing the content pane.
	 * @param contentPane the JPanel object representing the content pane of the main frame.
	 * @param bookingPage the bookingPage object representing the booking page.
	 */
	public OptionPage(JFrame frame, Routes route, ApplicationModel model,
						CardLayout c1, JPanel contentPane, BookingPage bookingPage)
	{ 
		this.option = new Option(model); 
		optionPage = new JPanel(); 
		optionPage.setLayout(null);	// uses a null layout so absolute positioning can be used on componenets 
		
		JLabel headerLabel = new JLabel("Travel With Us: Add-ons");
		headerLabel.setForeground(new Color(240, 255, 255));
		headerLabel.setBackground(new Color(0, 0, 205));
		headerLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(0,0, 600, 80);
		headerLabel.setOpaque(true);
		optionPage.add(headerLabel);
	
		/////////////////////////////////////////////////////////
		////////// Wi-Fi CheckBox ///////////////////////////////
		/////////////////////////////////////////////////////////
		wifiBox = new JCheckBox("Wi-Fi");
		wifiBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		wifiBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		wifiBox.setBounds(10,100, 145, 23);
		wifiBox.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e)
		{
				if(option != null) 
				{
					option.setWifi(wifiBox.isSelected());
				}
			}
		});
		optionPage.add(wifiBox);

		/////////////////////////////////////////////////////////
		////////// Meals CheckBox ///////////////////////////////
		/////////////////////////////////////////////////////////
		mealBox = new JCheckBox("Meal");
		mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		mealBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		mealBox.setBounds(10,150, 145, 23);
		mealBox.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        if(mealBox.isSelected()) 
		        {
		            JPopupMenu mealMenu = new JPopupMenu();
		            JMenuItem vegetarianItem = new JMenuItem("Vegetarian");
		            JMenuItem nonVegetarianItem = new JMenuItem("Non-Vegetarian");
		            vegetarianItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setMealVegetarian(true);  
		                }
		            });
		            nonVegetarianItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setStandardMeal(true);  
		                }
		            });
		            mealMenu.add(vegetarianItem);
		            mealMenu.add(nonVegetarianItem);
		            mealMenu.show(mealBox, mealBox.getWidth(), mealBox.getHeight());
		        }
		    }
		});
		optionPage.add(mealBox);
			
		/////////////////////////////////////////////////////////
		////////// Assistance CheckBox //////////////////////////
		/////////////////////////////////////////////////////////
		assistanceBox = new JCheckBox("Assistance");
		assistanceBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		assistanceBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		assistanceBox.setBounds(10,200, 145, 23);
		assistanceBox.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        if(option != null) {
		            option.setAssistance(assistanceBox.isSelected());
		        }
		        if(assistanceBox.isSelected()) 
		        {
		            JPopupMenu assistanceMenu = new JPopupMenu();
		            JMenuItem baggageItem = new JMenuItem("Baggage");
		            JMenuItem fastTrackItem = new JMenuItem("Fast Track boarding pass");
		            baggageItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setAssistance(true);  
		                }
		            });
		            fastTrackItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setAssistance(true);  
		                }
		            });
		            assistanceMenu.add(baggageItem);
		            assistanceMenu.add(fastTrackItem);
		            assistanceMenu.show(assistanceBox, assistanceBox.getWidth(), assistanceBox.getHeight());
		        }
		    }
		});
		optionPage.add(assistanceBox);
					
		/////////////////////////////////////////////////////////
		////////// Bags CheckBox ////////////////////////////////
		/////////////////////////////////////////////////////////
		bagsBox = new JCheckBox("Bags");
		bagsBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		bagsBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		bagsBox.setBounds(255,150, 145, 20);
		bagsBox.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        if(option != null) 
		        {
		            if(bagsBox.isSelected())
		            {
		                JPopupMenu bagsMenu = new JPopupMenu();
		                JMenuItem carryOnItem = new JMenuItem("Carry-on");
		                JMenuItem checkedBagItem = new JMenuItem("Checked baggage");
		                
		                carryOnItem.addActionListener(new ActionListener()
		                {
		                    public void actionPerformed(ActionEvent e) 
		                    {
		                        option.addCarryOnBag(); 		                         
		                    }
		                });
		                
		                checkedBagItem.addActionListener(new ActionListener() 
		                {
		                    public void actionPerformed(ActionEvent e) 
		                    {
		                        option.addCheckedBag(); 		                     
		                    }
		                });
		                
		                bagsMenu.add(carryOnItem);
		                bagsMenu.add(checkedBagItem);
		                bagsMenu.show(bagsBox, bagsBox.getWidth(), bagsBox.getHeight());
		            }
		        }
		    }
		});
		optionPage.add(bagsBox);
		
		/////////////////////////////////////////////////////////
		////////// Back Button //////////////////////////////////
		/////////////////////////////////////////////////////////
	    JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    backButton.setBackground(new Color(0, 0, 128));
		backButton.setBounds(10, 310, 95, 30);
		optionPage.add(backButton);
		
		backButton.addActionListener(new ActionListener() 
		{
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				// Go back to the previous page (BookingPage)
				c1.previous(contentPane);
		    }
		});	       
		
		/////////////////////////////////////////////////////////
		////////// Next Traveler Button /////////////////////////
		/////////////////////////////////////////////////////////
		JButton anotherTravelerButton = new JButton("Next Traveler"); 
		anotherTravelerButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		anotherTravelerButton.setBackground(new Color(0, 0, 128));
		anotherTravelerButton.setBounds(495, 280, 95, 30);
		optionPage.add(anotherTravelerButton);
			
		anotherTravelerButton.addActionListener(new ActionListener() 
		{ 
			@Override 
			public void actionPerformed(ActionEvent e)
			{
				model.getCurrentTraveler().setOptions(option); // Store the current set of options into the traveler who selected them 
				bookingPage.clearDetails(); // clear the input on the booking page of the previous traveler 
				clearPage();// clear the page of all selections so they are ready for the next traveler 
				option = new Option(model); // create a new option object for the next traveler 
				c1.show(contentPane, "bookingDetails"); // show the booking details page on the frame 
			}
		});
		
		/////////////////////////////////////////////////////////
		////////// Payment Button ///////////////////////////////
		/////////////////////////////////////////////////////////
		JButton seePaymentButton = new JButton("Payment");
		seePaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seePaymentButton.setBackground(new Color(0, 0, 128));
		seePaymentButton.setBounds(495, 310, 95, 30);
		optionPage.add(seePaymentButton);
	
		seePaymentButton.addActionListener(new ActionListener() 
		{ 
			@Override 
			public void actionPerformed(ActionEvent e)
			{
				model.getCurrentTraveler().setOptions(option);  // Store the current set of options into the traveler who selected them 
				c1.show(contentPane, "Payment"); // Display now the payment pane on the screen 
				frame.setTitle("Payment"); // Change the title of the frame to "Payment" 
			}
		 });			    
	    }
	
	
		/**
		 * Purpose: reset the check boxes.
		 * 
		 */
		public void clearPage()
		{
			wifiBox.setSelected(false);
			mealBox.setSelected(false);
			assistanceBox.setSelected(false);
			bagsBox.setSelected(false);
		}
		
		/**
		 * Purpose: Returns the option panel. 
		 * 
		 * @return the option panel as a JPanel object.
		 */
		public JPanel returnPanel()
		{ 
			return optionPage; 
		}	
	
}