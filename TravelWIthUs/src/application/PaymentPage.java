package application;

import javax.swing.JFrame;

import java.awt.CardLayout;  
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PaymentPage extends JFrame
{
	private JFrame frame;
	private JPanel paymentPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	private Payment payment;
	private JPanel bookingPage;
	private Option option;
	private JLabel wifiLabel;
	private JCheckBox wifiCheckBox;
	private JCheckBox mealBox;
	private Traveler traveler;
	private JTextField firstNameField;
	private JTextField cardNumberField;
	private JTextField securityCodeField;
	private JTextField emailField;
	private JTextField zipField;
	private JTextField cityField;
	private JTextField expirationDateField;
	private JComboBox<String> contryTerritoryComboBox;
	

	public PaymentPage(ApplicationView applicationView, Routes route2, ApplicationModel model2, CardLayout c12,
			JPanel contentPane2, Payment payment2) 
	{
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.option = option;
		this.traveler = traveler;
		
		paymentPage = new JPanel(); 
	
		paymentPage.setLayout(null);
				 
		
		JLabel lblNewLabel = new JLabel("Travel With Us: Payment Debit/Credit ");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0,0, 600, 80);
		lblNewLabel.setOpaque(true);
		paymentPage .add(lblNewLabel);
		
		///////////////////////////////////////////////////////	
		JLabel lbNameLabel = new JLabel("Name on Card*:");
		lbNameLabel.setBounds(105,80,100,20);
		paymentPage .add(lbNameLabel);
		firstNameField = new JTextField();
		firstNameField.setBounds(100,100,150,20);
		paymentPage .add(firstNameField);
		
		//////////////////////////////////////////
		JLabel lbCardNumberLabel = new JLabel("Card number*:");
		lbCardNumberLabel.setBounds(255,80,150,20);
		paymentPage .add(lbCardNumberLabel);
		cardNumberField = new JTextField();
		cardNumberField.setBounds(250,100,150,20);
		paymentPage .add(cardNumberField);
		
		/////////////////////////////////////////
		JLabel lbSecurityCodeLabel = new JLabel("Security code*:");
		lbSecurityCodeLabel.setBounds(405,80,100,20);
		paymentPage.add(lbSecurityCodeLabel);
		securityCodeField = new JTextField();
		securityCodeField.setBounds(400,100,150,20);
		paymentPage.add(securityCodeField);
		
		//////////////////////////////////////////////////	
		JLabel lbEmailLabel = new JLabel("Email:");
		lbEmailLabel.setBounds(105, 130, 80 ,20);
		paymentPage .add(lbEmailLabel);
	    emailField = new JTextField();
		emailField.setBounds(100,150,150,20);
		paymentPage.add(emailField);
		
		////////////////////////////////////////////
		JLabel lbExpirationDateLabel = new JLabel("Expiration date*:");
		lbExpirationDateLabel.setBounds(255,130,150,20);
		paymentPage.add(lbExpirationDateLabel);
	    expirationDateField = new JTextField();
	    expirationDateField.setBounds(250,150,150,20);
	    paymentPage.add(expirationDateField);
		
		/////////////////////////////////////////////////////////
		JLabel lbContryTerritoryLabel = new JLabel("Contry/Territory:");
		lbContryTerritoryLabel.setBounds(405,130,150,20);
		paymentPage.add(lbContryTerritoryLabel);
				
		String[] gender = {null,"United States", "London", "Tokyo", "Doha", "Paris","Stockholm", "Singapore", "Hong Kong"};
		
		JComboBox<String> contryTerritorySelection = new JComboBox<String>(gender);
		contryTerritorySelection.setBounds(405, 150, 150, 20);
		paymentPage.add(contryTerritorySelection);
			
		///////////////////////////////////
		JLabel lbStateLabel = new JLabel("State:");
		lbStateLabel.setBounds(405, 180,150, 20);
		paymentPage.add(lbStateLabel);
		
		String[] Traveler = {null, "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
				"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", 
				"MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
				"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", 
				"TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY",};
		
		JComboBox<String> stateSelection = new JComboBox<String>(Traveler);
		stateSelection.setEditable(true);
		stateSelection.setBounds(405,200,150,20);
		paymentPage.add(stateSelection);
		
		///////////////////////////////////
		JLabel lbcityLabel = new JLabel("City:");
		lbcityLabel.setBounds(105, 180, 80, 20);
		paymentPage.add(lbcityLabel);
	    cityField = new JTextField();
	    cityField.setBounds(100,200,145,20);
	    paymentPage.add(cityField);
	    
		////////////////////////////////////////  
	    JLabel lbZipLabel = new JLabel("Zip code:");
		lbZipLabel.setBounds(255, 180, 80, 20);
		paymentPage.add(lbZipLabel);
	    zipField = new JTextField();
	    zipField.setBounds(250,200,145,20);
	    paymentPage.add(zipField);
	    
	}

	public JPanel returnPanel()
	{ 
		return paymentPage; 
	}

}
