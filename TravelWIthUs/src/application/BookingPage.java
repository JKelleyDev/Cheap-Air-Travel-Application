package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePickerImpl;


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
* This class represents the booking details page where user inputs their travel information.
*/

public class BookingPage extends JFrame
{
	private static final long serialVersionUID = 8767017731109118713L;

	private JPanel bookingPage; // A booking page has a JPanel to add components for the GUI
	private Traveler traveler; // A booking page has a traveler who is entering information
	private JTextField firstNameField;  // A booking page has a firstNameField where the traveler enters first name
	private JTextField middleNameField; // A booking page has a middleNameField where the traveler enters middle name
	private JTextField lastNameField;   // A booking page has a lastNameField where the traveler enters last name
	private JTextField emailField; // A booking page has an emailField where the traveler enters email address
	private JDatePickerImpl DOBdatePicker;  // A booking page has a DOB date picker where the traveler enters date of birth
	private JFormattedTextField phoneNumberField;  // A booking page has a phoneNumberField where the traveler enters their phone number
	private JComboBox<String> genderSelection;  // A booking page has a genederSelection box where the traveler selects their gender
    
	
   /**
     * Purpose: Constructs the booking page.
     * 
     * @param frame the main application frame
     * @param route the travel routes information
     * @param model the application model
     * @param c1 the CardLayout for switching panels
     * @param contentPane the main content panel
     */
    public BookingPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane) 
    {
        this.traveler = new Traveler();
        bookingPage = new JPanel();
        bookingPage.setLayout(null);
       		 
        // Main title Label
        JLabel mainTitleLabel = new JLabel("Travel With Us: Who's traveling");
        mainTitleLabel.setForeground(new Color(240, 255, 255));
        mainTitleLabel.setBackground(new Color(0, 0, 205));
        mainTitleLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
        mainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitleLabel.setBounds(0, 0, 600, 50);
        mainTitleLabel.setOpaque(true);
        bookingPage.add(mainTitleLabel);

        // First name label and text field
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 60, 80, 20);
        bookingPage.add(firstNameLabel);
        firstNameField = new JTextField();
        firstNameField.setBounds(30, 80, 150, 25);
        bookingPage.add(firstNameField);

        // Middle name label and text field
        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(220, 60, 90, 20);
        bookingPage.add(middleNameLabel);
        middleNameField = new JTextField();
        middleNameField.setBounds(220, 80, 150, 25);
        bookingPage.add(middleNameField);

        // Last name label and text field
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(410, 60, 90, 20);
        bookingPage.add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setBounds(410, 80, 150, 25);
        bookingPage.add(lastNameField);

        // Email label and text field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 120, 80, 20);
        bookingPage.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(30, 140, 150, 25);
        bookingPage.add(emailField);

        // Phone number label and text field
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(220, 120, 140, 20);
        bookingPage.add(phoneNumberLabel);

        // Create the formatted text field for the phone number
        phoneNumberField = null;
        try {
            MaskFormatter phoneFormatter = new MaskFormatter("###-###-####");
            phoneFormatter.setPlaceholderCharacter('0');
            phoneNumberField = new JFormattedTextField(phoneFormatter);
            phoneNumberField.setText("000-000-0000");
            phoneNumberField.setBounds(220, 140, 150, 25);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookingPage.add(phoneNumberField);

        // Gender label and combo box
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(410, 120, 100, 20);
        bookingPage.add(genderLabel);
        String[] gender = { "", "Male", "Female" };
        genderSelection = new JComboBox<>(gender);
        genderSelection.setBounds(410, 140, 150, 25);
        bookingPage.add(genderSelection);

        // DOB label and date picker
        JLabel DOBLabel = new JLabel("Date of Birth:");
        DOBLabel.setBounds(30, 180, 100, 20);
        bookingPage.add(DOBLabel);

        DOBdatePicker = DatePicker.createDatePicker();
        DOBdatePicker.setBounds(30, 200, 150, 25);
        bookingPage.add(DOBdatePicker);
        DOBdatePicker.addActionListener(e -> {
            Object selectedDateObject = DOBdatePicker.getModel().getValue();
            if (selectedDateObject != null) {
                Date selectedDate = (Date) selectedDateObject;
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String selectedDateString = sdf.format(selectedDate);

                Date maxDate = new Date();

                if (selectedDate.compareTo(maxDate) >= 0) {
                    JOptionPane.showMessageDialog(frame, "Selected date must be before today.", "Date Validation", JOptionPane.INFORMATION_MESSAGE);
                }

                traveler.setDob(selectedDateString);
            }
        });

        // Button to select options
        JButton seeOptionButton = new JButton("Select Options");
        seeOptionButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        seeOptionButton.setBackground(new Color(0, 0, 128));
        seeOptionButton.setBounds(230, 260, 140, 30);
        bookingPage.add(seeOptionButton);

        // Action listener for the select options button
        seeOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    traveler.setGender(genderSelection.getSelectedItem().toString());
                    DOBdatePicker.setBackground(Color.WHITE);

                    // Check to see all fields are completed, no empty fields
                    if (firstName.equals("") || middleName.equalsIgnoreCase("") || lastName.equalsIgnoreCase("") || email.equalsIgnoreCase("")
                            || phoneNumber.equals("000-000-0000")  || genderSelection.getSelectedItem().toString().equals("") ) 
                    {
                        throw new IllegalArgumentException("Error, fill in all blank fields!");
                    }

                    // Parse and validate first name format
                    for (int i = 0; i < firstName.length(); i++) 
                    {
                        if (!Character.isLetter(firstName.charAt(i))) 
                        {
                            firstNameField.setBackground(Color.RED);
                            throw new IllegalArgumentException("First Name must only contain letters!");
                        }
                    }
                    traveler.setFirstName(firstName);

                    // Parse and validate middle name format
                    for (int i = 0; i < middleName.length(); i++) 
                    {
                        if (!Character.isLetter(middleName.charAt(i))) 
                        {
                            middleNameField.setBackground(Color.RED);
                            throw new IllegalArgumentException("Middle Name must only contain letters!");
                        }
                    }
                    traveler.setMiddleName(middleName);

                    // Parse and validate last name format
                    for (int i = 0; i < lastName.length(); i++) 
                    {
                        if (!Character.isLetter(lastName.charAt(i))) 
                        {
                            lastNameField.setBackground(Color.RED);
                            throw new IllegalArgumentException("Last Name must only contain letters!");
                        }
                    }
                    traveler.setLastName(lastName);

                    // Parse and validate email format
                    final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
                    final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
                    Matcher matcher = EMAIL_PATTERN.matcher(email);

                    if (!matcher.matches()) 
                    {
                        emailField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Please enter a valid email address!");
                    }
                    traveler.setEmail(email);

                    // Parse and validate phone number format
                    final String PHONE_REGEX = "^\\d{3}-\\d{3}-\\d{4}$";
                    final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
                    matcher = PHONE_PATTERN.matcher(phoneNumber);

                    if (!matcher.matches()) 
                    {
                        phoneNumberField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Please enter the phone number in the format: xxx-xxx-xxxx");
                    }
                    traveler.setPhoneNumber(phoneNumber);

                    if(DOBdatePicker.getModel().getValue() == null)
                    {
                    	DOBdatePicker.setBackground(Color.RED);
                    	DOBdatePicker.repaint();
                    	throw new IllegalArgumentException("Please enter a DOB.");
                    }
                    
                    model.addTraveler(traveler);
                    c1.show(contentPane, "Option");
                    frame.setTitle("Option");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Purpose: Clears the traveler details fields.
     */
    public void clearDetails() 
    {
        traveler = new Traveler();
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        DOBdatePicker.getModel().setValue(null);
        genderSelection.setSelectedIndex(0);
    }

    /**
     * Purpose: Returns the booking page panel.
     * 
     * @return the booking page panel
     */
    public JPanel returnPanel() 
    {
        return bookingPage;
    }
}
