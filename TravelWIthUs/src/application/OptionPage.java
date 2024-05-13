package application;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPage extends JFrame
{
	private JFrame frame;
	private JPanel optionPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	private Option option;
	private JPanel seatDiagramPanel;
	private Option finalOption;
	private BookingPage bookingPage; 
	private JCheckBox wifiBox; 
	private JCheckBox mealBox; 
	private JCheckBox assistanceBox;
	private JCheckBox bagsBox; 

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
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.bookingPage = bookingPage; 
		this.option = new Option(model); 
	
		optionPage = new JPanel(); 
		optionPage.setLayout(null);	
		
		///////////////////////////
		/**
		 * 
		 */
		JLabel headerLabel = new JLabel("Travel With Us: Add-ons");
		headerLabel.setForeground(new Color(240, 255, 255));
		headerLabel.setBackground(new Color(0, 0, 205));
		headerLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(0,0, 600, 80);
		headerLabel.setOpaque(true);
		optionPage.add(headerLabel);
	
		/////////////////////////////////
		/**
		 * 
		 */
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

		////////////////////////////////////////////////////////
		/**
		 * 
		 */
//		mealBox = new JCheckBox("Meal");
//		mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
//		mealBox.setHorizontalTextPosition(SwingConstants.RIGHT);
//		mealBox.setBounds(10,150, 145, 23);
//		mealBox.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				if(option != null) 
//			{
//				//option.setMeal(mealBox.isSelected());	
//			}
//			/**
//			 * 
//			 */
//			if(mealBox.isSelected()) 
//			{
//				JPopupMenu mealMenu = new JPopupMenu();
//				JMenuItem Item1 = new JMenuItem("vegetarian");
//				JMenuItem Item2= new JMenuItem("Non-vegetarian");
//				Item1.setToolTipText("Roasted Vegetable Penne Pasta\", \"Price: $14.99");
//				Item2.setToolTipText("Grilled Salmon with Lemon Butter Sauce\", \"Price: $15.99");
//				mealMenu.add(Item1);
//				mealMenu.add(Item2);
//				mealMenu.show(mealBox, mealBox.getWidth(), mealBox.getHeight());
//			}
//		  }
//		});
//		optionPage.add(mealBox);
////		
		mealBox = new JCheckBox("Meal");
		mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		mealBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		mealBox.setBounds(10,150, 145, 23);
		mealBox.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        if(option != null) {
		            option.setMeal(mealBox.isSelected());
		        }
		        if(mealBox.isSelected()) 
		        {
		            JPopupMenu mealMenu = new JPopupMenu();
		            JMenuItem vegetarianItem = new JMenuItem("Vegetarian");
		            JMenuItem nonVegetarianItem = new JMenuItem("Non-Vegetarian");
		            vegetarianItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setMeal(true);  
		                }
		            });
		            nonVegetarianItem.addActionListener(new ActionListener() 
		            {
		                public void actionPerformed(ActionEvent e) 
		                {
		                    option.setMeal(true);  
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
		/**
		 * 
		 */
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
					
		///////////////////////////////
		/**
		 * 
		 */
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
		
		///////////////////////////////
		/**
		 * 
		 */
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
		
		////////////////////////////////////////////////////////////////
		/**
		 * 
		 */
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
				model.getCurrentTraveler().setOptions(option);
				bookingPage.clearDetails();
				clearPage();
				option = new Option(model); 
				c1.show(contentPane, "bookingDetails");
			}
		});
		
		//////////////////////////////	
		/**
		 * 
		 */
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
				model.getCurrentTraveler().setOptions(option);
				c1.show(contentPane, "Payment");
				frame.setTitle("Payment");
			}
		 });			    
	    }
	
		//////////////////////////////////////
		/**
		 * 
		 */
		public void clearPage()
		{
			wifiBox.setSelected(false);
			mealBox.setSelected(false);
			assistanceBox.setSelected(false);
			bagsBox.setSelected(false);
		}
		
		//////////////////////////////
		/**
		 * Returns the option panel.
		 * 
		 * @return the option panel as a JPanel object.
		 */
		public JPanel returnPanel()
		{ 
			return optionPage; 
		}	
	
}
	
	













