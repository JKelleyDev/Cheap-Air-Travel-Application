package application;

import javax.swing.JFrame;
import java.awt.CardLayout;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

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
*/

public class PaymentPage extends JFrame 
{
    private static final long serialVersionUID = 7179689988923288046L;
    private JPanel paymentPage;
    private JTextField nameField;
    private JFormattedTextField cardNumberField;
    private JTextField securityCodeField;
    private JTextField zipField;
    private JTextField cityField;
    private JFormattedTextField expirationDateField;
    private JComboBox<String> countryTerritorySelection;
    private JComboBox<String> stateSelection;
    private JLabel stateLabel;
    private JLabel cityLabel;
    private JLabel zipCode;

    public PaymentPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane, Payment payment) 
    {
        paymentPage = new JPanel();
        paymentPage.setLayout(null);

        JLabel headerLabel = new JLabel("Travel With Us: Payment Debit/Credit ");
        headerLabel.setForeground(new Color(240, 255, 255));
        headerLabel.setBackground(new Color(0, 0, 205));
        headerLabel.setFont(new Font("Sans Serif", Font.ITALIC, 17));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBounds(0, 0, 600, 50);
        headerLabel.setOpaque(true);
        paymentPage.add(headerLabel);

        JLabel nameLabel = new JLabel("Name on Card:");
        nameLabel.setBounds(30, 70, 100, 20);
        paymentPage.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(30, 90, 200, 25);
        paymentPage.add(nameField);

        JLabel cardNumberLabel = new JLabel("Card number:");
        cardNumberLabel.setBounds(30, 130, 150, 20);
        paymentPage.add(cardNumberLabel);
        try {
            MaskFormatter cardFormatter = new MaskFormatter("####-####-####-####");
            cardFormatter.setPlaceholderCharacter('0');
            cardNumberField = new JFormattedTextField(cardFormatter);
            cardNumberField.setBounds(30, 150, 200, 25);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paymentPage.add(cardNumberField);

        JLabel securityCodeLabel = new JLabel("Security code:");
        securityCodeLabel.setBounds(250, 130, 100, 20);
        paymentPage.add(securityCodeLabel);
        securityCodeField = new JTextField();
        securityCodeField.setBounds(250, 150, 150, 25);
        paymentPage.add(securityCodeField);

        JLabel expirationDate = new JLabel("Expiration date:");
        expirationDate.setBounds(250, 70, 150, 20);
        paymentPage.add(expirationDate);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/####");
            dateFormatter.setPlaceholderCharacter('_');
            expirationDateField = new JFormattedTextField(dateFormatter);
            expirationDateField.setBounds(250, 90, 150, 25);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paymentPage.add(expirationDateField);

        JLabel countryTerritoryLabel = new JLabel("Country/Territory:");
        countryTerritoryLabel.setBounds(420, 70, 150, 20);
        paymentPage.add(countryTerritoryLabel);

        String[] countries = {"", "United States", "London", "Tokyo", "Doha", "Paris", "Stockholm", "Singapore", "Hong Kong"};
        countryTerritorySelection = new JComboBox<>(countries);
        countryTerritorySelection.setBounds(420, 90, 150, 25);
        paymentPage.add(countryTerritorySelection);

        countryTerritorySelection.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String selectedCountry = (String) countryTerritorySelection.getSelectedItem();
                if (selectedCountry.equals("United States")) 
                {
                    stateSelection.setVisible(true);
                    stateLabel.setVisible(true);
                    cityLabel.setVisible(true);
                    cityField.setVisible(true);
                    zipCode.setVisible(true);
                    zipField.setVisible(true);
                } else {
                    stateSelection.setVisible(false);
                    stateLabel.setVisible(false);
                    cityLabel.setVisible(false);
                    cityField.setVisible(false);
                    zipCode.setVisible(false);
                    zipField.setVisible(false);
                }
            }
        });

        stateLabel = new JLabel("State:");
        stateLabel.setBounds(420, 130, 150, 20);
        paymentPage.add(stateLabel);

        String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
                "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
                "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
                "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        stateSelection = new JComboBox<>(states);
        stateSelection.setEditable(true);
        stateSelection.setBounds(420, 150, 150, 25);
        paymentPage.add(stateSelection);

        cityLabel = new JLabel("City:");
        cityLabel.setBounds(30, 190, 80, 20);
        paymentPage.add(cityLabel);
        cityField = new JTextField();
        cityField.setBounds(30, 210, 200, 25);
        paymentPage.add(cityField);

        zipCode = new JLabel("Zip code:");
        zipCode.setBounds(250, 190, 80, 20);
        paymentPage.add(zipCode);
        zipField = new JTextField();
        zipField.setBounds(250, 210, 150, 25);
        paymentPage.add(zipField);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        backButton.setBackground(new Color(0, 0, 128));
        backButton.setBounds(10, 310, 95, 30);
        paymentPage.add(backButton);
        backButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                c1.previous(contentPane);
            }
        });

        JButton bookingButton = new JButton("Continue");
        bookingButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bookingButton.setBounds(495, 310, 100, 30);
        paymentPage.add(bookingButton);
        bookingButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Payment payment = new Payment();
                try {
                    String name = nameField.getText().trim();
                    for (int i = 0; i < name.length(); i++) 
                    {
                        if (name.charAt(i) == ' ') 
                        {
                            name = name.substring(0, i) + name.substring(i);
                        }
                    }
                    payment.setCardHolderName(name);
                    
                    String expirationDate = expirationDateField.getText().trim();
                    expirationDateField.setBackground(Color.WHITE);

                    if (expirationDate.equals("__/____")) {
                        expirationDateField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Please enter a valid expiration date.");
                    }

                    // Split the expiration date and perform basic validation
                    String[] expDateParts = expirationDate.split("/");
                    int month = Integer.parseInt(expDateParts[0]);
                    int year = Integer.parseInt(expDateParts[1]);

                    if (month < 1 || month > 12) {
                        expirationDateField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Expiration month must be between 01 and 12.");
                    }

                    // Check if the expiration date is in the past
                    LocalDate currentDate = LocalDate.now();
                    LocalDate expDate = LocalDate.of(year, month, 1).withDayOfMonth(1);
                    if (expDate.isBefore(currentDate.withDayOfMonth(1))) {
                        expirationDateField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Expiration date must be in the future.");
                    }

                    payment.setExpiryDate(expirationDate);

                    String cardNumber = cardNumberField.getText().trim().replace("-", "");
                    cardNumberField.setBackground(Color.WHITE);

                    if (cardNumber.equals("0000000000000000")) 
                    {
                        cardNumberField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Please enter a valid card number, not the default value.");
                    }

                    if (cardNumber.length() != 16) 
                    {
                        cardNumberField.setBackground(Color.RED);
                        throw new IllegalArgumentException("Card number must be 16 digits long.");
                    }

                    for (int i = 0; i < cardNumber.length(); i++) 
                    {
                        if (!Character.isDigit(cardNumber.charAt(i))) 
                        {
                            cardNumberField.setBackground(Color.RED);
                            throw new IllegalArgumentException("Card Number must only contain digits 0 - 9!");
                        }
                    }
                    payment.setCardNumber(cardNumber);

                    String selectedCountry = (String) countryTerritorySelection.getSelectedItem();
                    if (selectedCountry.equalsIgnoreCase("")) 
                    {
                        throw new IllegalArgumentException("Please select a country");
                    }
                    payment.setCountry(selectedCountry);

                    String securityCode = securityCodeField.getText().trim();
                    if (securityCode.length() > 4) 
                    {
                        securityCodeField.setBackground(Color.RED);
                        throw new IllegalArgumentException("The security code should be 3 or 4 digits.");
                    }
                    for (int i = 0; i < securityCode.length(); i++) 
                    {
                        if (Character.isLetter(securityCode.charAt(i))) 
                        {      
                            securityCodeField.setBackground(Color.RED);
                            throw new IllegalArgumentException("Security code must only be digits 0 - 9!");
                        }
                    }
                    payment.setCVV(securityCode);

                    if (selectedCountry.equals("United States")) 
                    {
                        String state = (String) stateSelection.getSelectedItem();
                        payment.setState(state);

                        String city = cityField.getText().trim();
                        for (int i = 0; i < city.length(); i++) 
                        {
                            if (!Character.isLetter(city.charAt(i))) 
                            {
                                cityField.setBackground(Color.RED);
                                throw new IllegalArgumentException("City field cannot have numbers.");
                            }
                        }
                        payment.setCity(city);

                        String zipCode = zipField.getText().trim();
                        for (int i = 0; i < zipCode.length(); i++) 
                        {
                            if (Character.isLetter(zipCode.charAt(i))) 
                            {
                                zipField.setBackground(Color.RED);
                                throw new IllegalArgumentException("Zip code must only be digits 0 - 9.");
                            }
                        }
                        payment.setZipCode(zipCode);
                    }

                    model.setPayment(payment);
                    JPanel confirmationPage = (new ConfirmationPage(frame, route, model, c1, contentPane).returnPanel());
                    contentPane.add(confirmationPage, "Confirmation");
                    c1.show(contentPane, "Confirmation");

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel returnPanel() 
    {
        return paymentPage;
    }
}

