package application;

import java.awt.CardLayout; 
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BookingPage extends JFrame
{
	private JFrame frame;
	private JPanel bookingPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	private Option option;
	private JLabel wifiLabel;
	private JCheckBox wifiCheckBox;
	private JCheckBox mealBox;
	private Traveler traveler;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField dobField;
	private JTextField phoneNumberField;
	private JComboBox<String> genderComboBox;
	
	BookingPage(JFrame frame, Routes route, ApplicationModel model, 
			CardLayout c1, JPanel contentPane, Option option, Traveler traveler)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.option = option;
		this.traveler = traveler;
		
		bookingPage = new JPanel(); 
	
		bookingPage.setLayout(null);
				 
		
		JLabel lblNewLabel = new JLabel("Travel With Us: Who's traveling");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0,0, 600, 80);
		lblNewLabel.setOpaque(true);
		bookingPage.add(lblNewLabel);
		
		///////////////////////////////////////////////////////
		JLabel lbNameLabel = new JLabel("First Name:");
		lbNameLabel.setBounds(105,80,80,20);
		bookingPage.add(lbNameLabel);
		firstNameField = new JTextField();
		firstNameField.setBounds(100,100,150,20);
		bookingPage.add(firstNameField);
		
		//////////////////////////////////////////
		JLabel lbMIddleNameLabel = new JLabel("MIddle Name:");
		lbMIddleNameLabel.setBounds(255,80,90,20);
		bookingPage.add(lbMIddleNameLabel);
	    middleNameField = new JTextField();
		middleNameField.setBounds(250,100,150,20);
		bookingPage.add(middleNameField);
		
		/////////////////////////////////////////
		JLabel lbLastNameLabel = new JLabel("Last Name:");
		lbLastNameLabel.setBounds(405,80,90,20);
		bookingPage.add(lbLastNameLabel);
	    lastNameField = new JTextField();
		lastNameField.setBounds(400,100,150,20);
		bookingPage.add(lastNameField);
		
		//////////////////////////////////////////////////
		JLabel lbEmailLabel = new JLabel("Email:");
		lbEmailLabel.setBounds(105, 130, 80 ,20);
		bookingPage.add(lbEmailLabel);
	    emailField = new JTextField();
		emailField.setBounds(100,150,150,20);
		bookingPage.add(emailField);
		
		////////////////////////////////////////////
		JLabel lbPhoneNumberLabel = new JLabel("Phone number:");
		lbPhoneNumberLabel.setBounds(255,130,100,20);
		bookingPage.add(lbPhoneNumberLabel);
	    phoneNumberField = new JTextField();
	    phoneNumberField.setBounds(250,150,150,20);
		bookingPage.add(phoneNumberField);
		
		/////////////////////////////////////////////////////////	
		JLabel lbGenderLabel = new JLabel("Gender:");
		lbGenderLabel.setBounds(405,130,100,20);
		bookingPage.add(lbGenderLabel);

		/////////////////////////////////////////////////////	
		String[] gender = {null,"Male", "Female"};
		
		JComboBox<String> genderSelection = new JComboBox<String>(gender);
		genderSelection.setBounds(405, 150, 150, 23);
		bookingPage.add(genderSelection);
		
		///////////////////////////////////	
		JLabel lbTravelerLabel = new JLabel("Traveler:");
		lbTravelerLabel.setBounds(255, 180, 80, 20);
		bookingPage.add(lbTravelerLabel);
		
		String[] Traveler = {null,"1", "2", "3", "4","5"};
		
		JComboBox<String> travelerSelection = new JComboBox<String>(Traveler);
		travelerSelection.setBounds(250,200,145,20);
		bookingPage.add(travelerSelection);
		
		///////////////////////////////////
		JLabel lbdobLabel = new JLabel("DOB:");
		lbdobLabel.setBounds(105, 180, 80, 20);
		bookingPage.add(lbdobLabel);
	    dobField = new JTextField();
	    dobField.setBounds(100,200,145,20);
		bookingPage.add(dobField);
		
        /////////////////////////////////////////////////	
		JButton seeOptionButton = new JButton("Option");
		seeOptionButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seeOptionButton.setBackground(new Color(0, 0, 128));
		seeOptionButton.setBounds(495, 310, 95, 30);
		bookingPage.add(seeOptionButton);
		
		///////////////////////////////////////////	
		seeOptionButton.addActionListener(new SeeOptionButtonHandler( frame, c1, contentPane));
		
		}
		
		public JPanel returnPanel()
		{ 
		return bookingPage; 
		}
	
}

