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
	private Traveler traveler;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField dobField;
	private JTextField phoneNumberField;
	private JComboBox<String> genderComboBox;
	private JPanel optionPage; 
	
	BookingPage(JFrame frame, Routes route, ApplicationModel model, 
			CardLayout c1, JPanel contentPane, JPanel optionPage)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.optionPage = optionPage; 

		this.traveler = new Traveler();
		
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
		JLabel lbMiddleNameLabel = new JLabel("Middle Name:");
		lbMiddleNameLabel.setBounds(255,80,90,20);
		bookingPage.add(lbMiddleNameLabel);
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
		JLabel lbdobLabel = new JLabel("DOB:");
		lbdobLabel.setBounds(105, 180, 80, 20);
		bookingPage.add(lbdobLabel);
	    dobField = new JTextField();
	    dobField.setBounds(100,200,145,20);
		bookingPage.add(dobField);
		
        /////////////////////////////////////////////////	
		JButton seeOptionButton = new JButton("Select Options");
		seeOptionButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		seeOptionButton.setBackground(new Color(0, 0, 128));
		seeOptionButton.setBounds(475, 310, 120, 30);
		bookingPage.add(seeOptionButton);
		
		///////////////////////////////////////////	
		seeOptionButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	traveler.setFirstName(firstNameField.getText());
		    	traveler.setMiddleName(middleNameField.getText());
		    	traveler.setLastName(lastNameField.getText());
		    	model.addTraveler(traveler);
		    	c1.show(contentPane, "Option");
				frame.setTitle("Option");
		    }
		});
		    
			       	        
	}
			
		public void clearDetails() 
		{ 
			traveler = new Traveler();
			firstNameField.setText("");
			middleNameField.setText("");
			lastNameField.setText("");
		}

		public JPanel returnPanel()
		{ 
			return bookingPage; 
		}
	
}

