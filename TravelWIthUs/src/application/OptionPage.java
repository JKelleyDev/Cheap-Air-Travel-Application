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
	private Payment payment;
	private JTextField cardNumberField;
	private JPanel seatDiagramPanel;

	
	public OptionPage(JFrame frame, Routes route, ApplicationModel model,
						CardLayout c1, JPanel contentPane, Option option)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.option = option;
	
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
		JCheckBox wifiBox = new JCheckBox("wi-fi");
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
		JCheckBox mealBox = new JCheckBox("Meal");
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
				Item1.setToolTipText("rice and beans with veggies");
				Item2.setToolTipText("");
				mealMenu.add(Item1);
				mealMenu.add(Item2);
				mealMenu.show(mealBox, mealBox.getWidth(), mealBox.getHeight());

		//		option.setMeal(mealBox.isSelected());
						}
					}
				});
				optionPage.add(mealBox);
			
		/////////////////////////////////////////////////////////
		JCheckBox assistanceBox = new JCheckBox("assistance");
		assistanceBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		assistanceBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		assistanceBox.setBounds(10,200, 145, 23);
		optionPage.add(assistanceBox);
//		assistanceBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//			{
//				if(option != null) 
//				{
//				option.setAssistance(assistanceBox.isSelected());
//						}
//					}
//				});
//				optionPage.add(assistanceBox);
		
		assistanceBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(option != null) 
				{
				option.setBaggage(assistanceBox.isSelected());
				}
				if(assistanceBox.isSelected()) {
					String[] bagOption = {"Carri on bag", "Personal item"};
					String selectedBag = (String) JOptionPane.showInputDialog(
							optionPage,
							"Select the Type of bag:",
							"Bag Selected",
							JOptionPane.PLAIN_MESSAGE,
							null, 
							bagOption,
							bagOption[0]
					);
					if (selectedBag != null) {
						option.setSelectedBag(selectedBag);
					}else {
						assistanceBox.setSelected(false);
						option.setBaggage(false);
					}
				}
			}		
		});
	
		///////////////////////////////
		JCheckBox seatBox = new JCheckBox("Choose your seats*");
		seatBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		seatBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		seatBox.setBounds(255,100, 200, 20);
		optionPage.add(seatBox);
		seatBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
			{
				if(option != null) 
				{
				option.setAssistance(seatBox.isSelected());
				}
							}
				});
				optionPage.add(seatBox);
				
		JPanel seatDiagramPanel = new JPanel();
		seatDiagramPanel.setBounds(50,130,300,200);
		seatDiagramPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionPage.add(seatDiagramPanel);
		
		seatDiagramPanel.setLayout(new GridLayout(5,5));
		for(int i = 0; i < 25; i++) {
			final int seatNumber = i + 1;
			JButton seatButton = new JButton("Seat " + seatNumber);
			seatDiagramPanel.add(seatButton);
			
			seatButton.addActionListener(e ->{
				System.out.println("seat " + seatNumber + " selected");
			});
		}
		
		seatDiagramPanel.setVisible(false);
		optionPage.add(seatDiagramPanel);
		
		seatBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seatBox.isSelected()) {
					seatDiagramPanel.setVisible(true);
				}else {
					seatDiagramPanel.setVisible(false);
				}
			}
		});
				
		///////////////////////////////
		JCheckBox bagsBox = new JCheckBox("Bags:");
		bagsBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		bagsBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		bagsBox.setBounds(255,200, 80, 20);
		optionPage.add(bagsBox);
		bagsBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(option != null) 
				{
				option.setBaggage(bagsBox.isSelected());
				}
				if(bagsBox.isSelected()) {
					String[] bagOption = {"Carri on bag", "Personal item"};
					String selectedBag = (String) JOptionPane.showInputDialog(
							optionPage,
							"Select the Type of bag:",
							"Bag Selected",
							JOptionPane.PLAIN_MESSAGE,
							null, 
							bagOption,
							bagOption[0]
					);
					if (selectedBag != null) {
						option.setSelectedBag(selectedBag);
					}else {
						bagsBox.setSelected(false);
						option.setBaggage(false);
					}
				}
			}		
		});
			//optionPage.add(bagsBox);
		
		////////////////////////////////
		
		
		
		///////////////////////////////
		JButton seePaymentButton = new JButton("Payment");
		seePaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seePaymentButton.setBackground(new Color(0, 0, 128));
		seePaymentButton.setBounds(495, 310, 95, 30);
		optionPage.add(seePaymentButton);
	
		///////////////////////////////////////////
		
		
		
		
		seePaymentButton.addActionListener(new SeePaymentButtonHandler( frame, c1, contentPane));
		
		}	
		public JPanel returnPanel()
		{ 
		return optionPage; 
		}	
	
}
	
	


