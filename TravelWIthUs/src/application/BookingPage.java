package application;

import java.awt.CardLayout; 
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Traveler traveler;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField dobField;
	private JTextField phoneNumberField;
	private JComboBox<String> genderSelection;

	
	BookingPage(JFrame frame, Routes route, ApplicationModel model, 
			CardLayout c1, JPanel contentPane)
	{ 
	
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		
		this.traveler = new Traveler();
		
		bookingPage = new JPanel(); 
	
		bookingPage.setLayout(null);
				 
		
		JLabel mainTitleLabel = new JLabel("Travel With Us: Who's traveling");
		mainTitleLabel.setForeground(new Color(240, 255, 255));
		mainTitleLabel.setBackground(new Color(0, 0, 205));
		mainTitleLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		mainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitleLabel.setBounds(0,0, 600, 80);
		mainTitleLabel.setOpaque(true);
		bookingPage.add(mainTitleLabel);
		
		///////////////////////////////////////////////////////
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(105,80,80,20);
		bookingPage.add(firstNameLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(100,100,150,20);
		bookingPage.add(firstNameField);
		
		
		//////////////////////////////////////////

		JLabel middleNameLabel = new JLabel("Middle Name:");
		middleNameLabel.setBounds(255,80,90,20);
		bookingPage.add(middleNameLabel);

	    middleNameField = new JTextField();
		middleNameField.setBounds(250,100,150,20);
		bookingPage.add(middleNameField);
		
		/////////////////////////////////////////
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(405,80,90,20);
		bookingPage.add(lastNameLabel);
		
	    lastNameField = new JTextField();
		lastNameField.setBounds(400,100,150,20);
		bookingPage.add(lastNameField);
		
		//////////////////////////////////////////////////
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(105, 130, 80 ,20);
		bookingPage.add(emailLabel);
		
	    emailField = new JTextField();
		emailField.setBounds(100,150,150,20);
		bookingPage.add(emailField);
		
		////////////////////////////////////////////
		JLabel phoneNumberLabel = new JLabel("Phone: xxx-xxx-xxxx");
		phoneNumberLabel.setBounds(255,130,140,20);
		bookingPage.add(phoneNumberLabel);
		
	    phoneNumberField = new JTextField();
	    phoneNumberField.setBounds(250,150,150,20);
		bookingPage.add(phoneNumberField);
		
		/////////////////////////////////////////////////////////	
		JLabel genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(405,130,100,20);
		bookingPage.add(genderLabel);

		/////////////////////////////////////////////////////	
		String[] gender = {"","Male", "Female"};
		
	    genderSelection = new JComboBox<String>(gender);
		genderSelection.setBounds(405, 150, 150, 23);
		bookingPage.add(genderSelection);	

		///////////////////////////////////
		JLabel dobLabel = new JLabel("DOB: mm/dd/yyyy");
		dobLabel.setBounds(105, 180, 120, 20);
		bookingPage.add(dobLabel);
		
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
		        try {
		            String firstName = firstNameField.getText().trim();
		            	firstNameField.setBackground(Color.WHITE);
		            String middleName = middleNameField.getText().trim();
		            	middleNameField.setBackground(Color.WHITE);
		            String lastName = lastNameField.getText().trim();
		            	lastNameField.setBackground(Color.WHITE);
		            String email = emailField.getText().trim(); 
		            	emailField.setBackground(Color.WHITE);
		            String phoneNumber = phoneNumberField.getText().trim();
		            	phoneNumberField.setBackground(Color.WHITE);
		            String dob = dobField.getText().trim();
		            	dobField.setBackground(Color.WHITE);
		            traveler.setGender(genderSelection.getSelectedItem().toString());
		            	
					////////////////////////////////////////////////////////////////////////////////
					// Check to see all fields are completed, no empty fields //

		            if(firstName.equals("") || middleName.equalsIgnoreCase("") || lastName.equalsIgnoreCase("") || email.equalsIgnoreCase("")
		            		|| phoneNumber.equals("") || dob.equals("") || genderSelection.getSelectedItem().toString().equals("") )
		            {
		            	throw new IllegalArgumentException("Error, fill in all blank fields!");
		            }
		            
					////////////////////////////////////////////////////////////////////////////////
					// Parse and validate first name format //

		            for (int i = 0; i < firstName.length(); i++) 
		            {
		                if (!Character.isLetter(firstName.charAt(i))) 
		                {
		                	firstNameField.setBackground(Color.RED);
		                    throw new IllegalArgumentException("First Name must only contain letters!");
		                }
		            }
		            	traveler.setFirstName(firstName);
		          
					////////////////////////////////////////////////////////////////////////////////
					// Parse and validate middle name format //

		            for (int i = 0; i < middleName.length(); i++) 
		            {
		                if (!Character.isLetter(middleName.charAt(i))) 
		                {
		                	middleNameField.setBackground(Color.RED);
		                    throw new IllegalArgumentException("Middle Name must only contain letters!");
		                }
		            }
		            	traveler.setMiddleName(middleName);
		            	
					////////////////////////////////////////////////////////////////////////////////
					// Parse and validate last name format //
		            
		            for (int i = 0; i < lastName.length(); i++) 
		            {
		                if (!Character.isLetter(lastName.charAt(i))) 
		                {
		                	lastNameField.setBackground(Color.RED);
		                    throw new IllegalArgumentException("Last Name must only contain letters!");
		                }
		            }
		            	traveler.setLastName(lastName);
		            
		            ////////////////////////////////////////////////////////////////////////////////
		            // Parse and validate email format //
		            	
		            final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		            final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
		            Matcher matcher = EMAIL_PATTERN.matcher(email);
		            
		            if(matcher.matches() == false)
		            {
		            	emailField.setBackground(Color.RED);
		            	throw new IllegalArgumentException("Please enter a valid email address!");
		            }
		            traveler.setEmail(email);
		            
					////////////////////////////////////////////////////////////////////////////////
					// Parse and validate phone number format //
		            
		            final String PHONE_REGEX = "^\\d{3}-\\d{3}-\\d{4}$";
		            final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
		            matcher = PHONE_PATTERN.matcher(phoneNumber); 
		            
		            if(matcher.matches() == false)
		            { 
		            	phoneNumberField.setBackground(Color.RED);
		            	throw new IllegalArgumentException("Please enter the phone number in the format: xxx-xxx-xxxx");
		            }
		            traveler.setPhoneNumber(phoneNumber);
		            
					////////////////////////////////////////////////////////////////////////////////
					// Parse and validate phone number format //
		            
		            final String DOB_REGEX = "^(0[1-9]|1[0-2])\\/(0[1-9]|[12][0-9]|3[01])\\/(19|20)\\d\\d$";
		            final Pattern DOB_PATTERN = Pattern.compile(DOB_REGEX);
		            matcher = DOB_PATTERN.matcher(dob);
		            		
		            if(matcher.matches() == false)
		            { 
		            	dobField.setBackground(Color.RED);
		            	throw new IllegalArgumentException("Please enter the DOB in the format: dd/mm/yyyy");
		            }
		            traveler.setDob(dob);
		            
		            
		            
		           
		            
		            model.addTraveler(traveler);
		            c1.show(contentPane, "Option");
		            frame.setTitle("Option");
		        } 
		        catch (IllegalArgumentException ex) 
		        	{
		            	JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
		        	} 
		        catch (Exception ex) 
		        	{
		            	JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        	}
		    }
		});	    
			       	   
	}
			
		public void clearDetails() 
		{ 
			traveler = new Traveler();
			firstNameField.setText("");
			middleNameField.setText("");
			lastNameField.setText("");
			emailField.setText("");
			phoneNumberField.setText("");
			dobField.setText("");
			genderSelection.setSelectedIndex(0);
			
		}

	
		public JPanel returnPanel()
		{ 
			return bookingPage; 
		}
	
}

