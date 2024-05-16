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
	private JCheckBox carryOnBox; // An OptionPage has a carry on check box 
   private JCheckBox checkedBagBox; // An OptionPage has a checked bag check box 

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
		headerLabel.setBounds(0, 0, 600, 50);
		headerLabel.setOpaque(true);
		optionPage.add(headerLabel);
	
		wifiBox = new JCheckBox("Wi-Fi");
        wifiBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        wifiBox.setBounds(30, 70, 200, 30);
        wifiBox.addActionListener(e -> {
            if (option != null) {
                option.setWifi(wifiBox.isSelected());
            }
        });
        optionPage.add(wifiBox);

        mealBox = new JCheckBox("Meal");
        mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        mealBox.setBounds(30, 110, 200, 30);
        mealBox.addActionListener(e -> {
            if (mealBox.isSelected()) {
                JPopupMenu mealMenu = new JPopupMenu();
                JMenuItem vegetarianItem = new JMenuItem("Vegetarian");
                JMenuItem nonVegetarianItem = new JMenuItem("Non-Vegetarian");
                vegetarianItem.addActionListener(evt -> option.setMealVegetarian(true));
                nonVegetarianItem.addActionListener(evt -> option.setStandardMeal(true));
                mealMenu.add(vegetarianItem);
                mealMenu.add(nonVegetarianItem);
                mealMenu.show(mealBox, mealBox.getWidth(), mealBox.getHeight());
            }
        });
        optionPage.add(mealBox);
			
        assistanceBox = new JCheckBox("Assistance");
        assistanceBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        assistanceBox.setBounds(30, 150, 200, 30);
        assistanceBox.addActionListener(e -> {
            if (option != null) {
                option.setAssistance(assistanceBox.isSelected());
            }
            if (assistanceBox.isSelected()) {
                JPopupMenu assistanceMenu = new JPopupMenu();
                JMenuItem baggageItem = new JMenuItem("Baggage");
                JMenuItem fastTrackItem = new JMenuItem("Fast Track boarding pass");
                baggageItem.addActionListener(evt -> option.setAssistance(true));
                fastTrackItem.addActionListener(evt -> option.setAssistance(true));
                assistanceMenu.add(baggageItem);
                assistanceMenu.add(fastTrackItem);
                assistanceMenu.show(assistanceBox, assistanceBox.getWidth(), assistanceBox.getHeight());
            }
        });
        optionPage.add(assistanceBox);

        JLabel bagsLabel = new JLabel("Bags:");
        bagsLabel.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        bagsLabel.setBounds(30, 190, 200, 30);
        optionPage.add(bagsLabel);

        carryOnBox = new JCheckBox("Carry-on");
        carryOnBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        carryOnBox.setBounds(30, 220, 200, 30);
        carryOnBox.addActionListener(e -> {
            if (option != null) {
                if (carryOnBox.isSelected()) {
                    option.addCarryOnBag();
                } else {
                    option.removeCarryOnBag();
                }
            }
        });
        optionPage.add(carryOnBox);

        checkedBagBox = new JCheckBox("Checked Bag");
        checkedBagBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        checkedBagBox.setBounds(30, 250, 200, 30);
        checkedBagBox.addActionListener(e -> {
            if (option != null) {
                if (checkedBagBox.isSelected()) {
                    option.addCheckedBag();
                } else {
                    option.removeCheckedBag();
                }
            }
        });
        optionPage.add(checkedBagBox);

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
		
		JButton anotherTravelerButton = new JButton("Next Traveler");
	    anotherTravelerButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		anotherTravelerButton.setBackground(new Color(0, 0, 128));
		anotherTravelerButton.setBounds(250, 310, 150, 30);
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
		
	    JButton seePaymentButton = new JButton("Payment");
	    seePaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    seePaymentButton.setBackground(new Color(0, 0, 128));
	    seePaymentButton.setBounds(475, 310, 95, 30);
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
			carryOnBox.setSelected(false);
	        checkedBagBox.setSelected(false);
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