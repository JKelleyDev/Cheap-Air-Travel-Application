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
		
		JLabel lblNewLabel = new JLabel("Travel With Us: Add-ons");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0,0, 600, 80);
		lblNewLabel.setOpaque(true);
		optionPage.add(lblNewLabel);
	
		/////////////////////////////////
		wifiBox = new JCheckBox("wi-fi");
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
		mealBox = new JCheckBox("Meal");
		mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		mealBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		mealBox.setBounds(10,150, 145, 23);
		mealBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(option != null) {
				option.setMeal(mealBox.isSelected());	
				}
				if(mealBox.isSelected()) 
				{
				JPopupMenu mealMenu = new JPopupMenu();
				JMenuItem Item1 = new JMenuItem("vegetarian");
				JMenuItem Item2= new JMenuItem("Non-vegetarian");
				Item1.setToolTipText("Roasted Vegetable Penne Pasta\", \"Price: $14.99");
				Item2.setToolTipText("Grilled Salmon with Lemon Butter Sauce\", \"Price: $15.99");
				mealMenu.add(Item1);
				mealMenu.add(Item2);
				mealMenu.show(mealBox, mealBox.getWidth(), mealBox.getHeight());

						}
					}
				});
				optionPage.add(mealBox);
						
			
		/////////////////////////////////////////////////////////
		assistanceBox = new JCheckBox("Assistance");
		assistanceBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		assistanceBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		assistanceBox.setBounds(10,200, 145, 23);
		assistanceBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

		
			if(option != null) {
			option.setMeal(assistanceBox.isSelected());	
			}
			if(assistanceBox.isSelected()) 
			{
			JPopupMenu assistanceMenu = new JPopupMenu();
			JMenuItem Item1 = new JMenuItem("Baggage");
			JMenuItem Item2= new JMenuItem("Fast Track bording pass");
			Item1.setToolTipText("Baggage Assistance: $10");
			Item2.setToolTipText("Fast Track Immigration: $10");
			assistanceMenu.add(Item1);
			assistanceMenu.add(Item2);
			assistanceMenu.show(assistanceBox, assistanceBox.getWidth(), assistanceBox.getHeight());

					}
				}
			});
			optionPage.add(assistanceBox);
		
	
		///////////////////////////////	
		JCheckBox seatBox = new JCheckBox("Choose your seats");
		seatBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		seatBox.setHorizontalTextPosition(SwingConstants.RIGHT);			
		seatBox.setBounds(255,100, 200, 20);
		optionPage.add(seatBox);

		JPanel seatSelectionPanel = new JPanel();
		seatSelectionPanel.setLayout(new GridLayout(5, 5)); 
		seatSelectionPanel.setBounds(50, 130, 300, 200);
		seatSelectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionPage.add(seatSelectionPanel);
		seatSelectionPanel.setVisible(false); 

		for (int i = 0; i < 25; i++) 
		{
		final int seatNumber = i + 1;
		JButton seatButton = new JButton("Seat " + seatNumber);
		seatButton.addActionListener(e -> {
				boolean isSelected = seatButton.getBackground() == Color.green;
				if (isSelected) {
					System.out.println("Seat " + seatNumber );

				}else {
					System.out.println("Seat " + seatNumber + " selected");

				}
			});
			    seatSelectionPanel.add(seatButton);
			}

			seatBox.addActionListener(e ->
			{
			    if (seatBox.isSelected()) 
			    {
			        seatSelectionPanel.setVisible(true); 
			    } else {
			        seatSelectionPanel.setVisible(false); 
			    }
			});
			
			optionPage.add(seatSelectionPanel);
			

			      
				
		///////////////////////////////
		bagsBox = new JCheckBox("Bags");
		bagsBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		bagsBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		bagsBox.setBounds(255,150, 145, 20);
		bagsBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

		
			if(option != null) {
			option.setMeal(bagsBox.isSelected());	
			}
			if(bagsBox.isSelected()) 
			{
			JPopupMenu bagsMenu = new JPopupMenu();
			JMenuItem Item1 = new JMenuItem("Carry-on");
			JMenuItem Item2= new JMenuItem("checked baggage");
			Item1.setToolTipText("$10");
			Item2.setToolTipText("$35");
			bagsMenu.add(Item1);
			bagsMenu.add(Item2);
			bagsMenu.show(bagsBox, bagsBox.getWidth(), bagsBox.getHeight());

					}
				}
			});
			optionPage.add(bagsBox);		
		///////////////////////////////
	    JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    backButton.setBackground(new Color(0, 0, 128));
		        backButton.setBounds(10, 310, 95, 30);
		        optionPage.add(backButton);

		        backButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Go back to the previous page (BookingPage)
		                c1.previous(contentPane);
		            }
		        });	
		        
		////////////////////////////////////////////////////////////////
		JButton anotherTravelerButton = new JButton("Next Traveler"); 
		anotherTravelerButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		anotherTravelerButton.setBackground(new Color(0, 0, 128));
		anotherTravelerButton.setBounds(495, 280, 95, 30);
		optionPage.add(anotherTravelerButton);
			
		anotherTravelerButton.addActionListener(new ActionListener() { 
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
		JButton seePaymentButton = new JButton("Payment");
		seePaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seePaymentButton.setBackground(new Color(0, 0, 128));
		seePaymentButton.setBounds(495, 310, 95, 30);
		optionPage.add(seePaymentButton);
	
		seePaymentButton.addActionListener(new ActionListener() { 
			@Override 
			public void actionPerformed(ActionEvent e)
			{
				model.getCurrentTraveler().setOptions(option);
				c1.show(contentPane, "Payment");
				frame.setTitle("Payment");
			}
		});
	
		
		////////////////////////////////////////////////////////////////////////////////////////
			    
	}
			
		public void clearPage()
		{
			wifiBox.setSelected(false);
			mealBox.setSelected(false);
			assistanceBox.setSelected(false);
			bagsBox.setSelected(false);
		}
		
		public JPanel returnPanel()
		{ 
			return optionPage; 
		}	
	
}
	
	


