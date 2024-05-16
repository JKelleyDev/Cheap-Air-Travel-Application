package application;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
 * This class represents the confirmation page where the user can review their booking details.
 */
public class ConfirmationPage 
{

    private JFrame frame; // ConfirmationPage has a frame to display the application
    private Routes route; // ConfirmationPage has a route object to get information about miles and times
    private ApplicationModel model;  // ConfirmationPage has a model, which stores all the important booking information
    private JPanel confirmationPage; // ConfirmationPage has a confirmationPage which is a panel to display components
    private FlightManager departureFlight; // ConfirmationPage has a departureFlight
    private String departureCity; // ConfirmationPage has a departureCity
    private String departureDateTime; // ConfirmationPage has a departure date and takeoff time
    private String departureFlightNumber; // ConfirmationPage has a departureFlightNumber
    private FlightManager returnFlight;   // ConfirmationPage has a returnFlight
    private String destinationCity; // ConfirmationPage has a destinationCity
    private String returnDateTime;  // ConfirmationPage has a return date and takeoff time
    private String returnFlightNumber; // ConfirmationPage has a returnFlightNumber
    private String destinationArrivalTime; // ConfirmationPage has a destinationArrivalTime, the first flights arrival time
    private String returnArrivalTime; // ConfirmationPage has a returnArrivalTime, the return flights arrival time

    private static int confirmationCounter;  // ConfirmationPage has a confirmationCounter 
    private static final String CONFIRMATION_PREFIX = "TWU000";  // ConfirmationPage has a final prefix for the confirmation

    private JPanel flightInformation;  // ConfirmationPage has a JPanel for the flight information
    private JPanel travelerInformation; // ConfirmationPage has a JPanel for the traveler information
    private JPanel costInformation;  // ConfirmationPage has a JPanel for the cost information
    private Traveler[] travelerArray;  // ConfirmationPage has an Array that holds all the travelers 
    private String baseRate;  // ConfirmationPage has a baseRate for each traveler, calculated from the model

    /**
     * Purpose: Constructs the confirmation page.
     * 
     * @param frame the main application frame
     * @param route the travel routes information
     * @param model the application model
     * @param c1 the CardLayout for switching panels
     * @param contentPane the main content panel
     */
    public ConfirmationPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane) 
    {
        this.frame = frame;
        this.route = route;
        this.model = model;
        this.travelerArray = model.getTravelerArray();
        this.baseRate = String.format("%.2f", model.getPrice());
        this.departureFlight = model.getDepartureFlight();
        this.departureFlightNumber = departureFlight.getFlightNumber();
        this.departureCity = model.getDepartureCity();
        this.destinationCity = model.getDestinationCity();
        this.departureDateTime = departureFlight.getDepartureTime();
        this.destinationArrivalTime = departureFlight.getArrivalTime(model.getDepartureDate());

        if (!model.getOneWayFareValue()) 
        {
            this.returnFlight = model.getReturnFlight();
            this.returnFlightNumber = returnFlight.getFlightNumber();
            this.returnDateTime = returnFlight.getDepartureTime();
            this.returnArrivalTime = returnFlight.getArrivalTime(model.getReturnDate());
        }

        confirmationPage = new JPanel();
        confirmationPage.setLayout(null);
        frame.setTitle("Confirmation Page");

        initializeFlightInformationPanel();
        initializeTravelerInformationPanel();
        initializeCostInformationPanel();

        JButton confirmButton = new JButton("Book");
        confirmButton.setBounds(445, 310, 95, 30);
        confirmationPage.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmButton.setVisible(false);
                flightInformation.setVisible(false);
                travelerInformation.setVisible(false);
                costInformation.setVisible(false);
                confirmationCounter++;
                writeFile();
            }
        });
    }

    /**
     * Purpose: Initializes the flight information panel.
     */
    private void initializeFlightInformationPanel() 
    {
        flightInformation = new JPanel();
        flightInformation.setLayout(null);
        flightInformation.setBounds(0, 0, 375, 145);

        JLabel flight1Label = new JLabel("Flight: " + departureFlightNumber);
        flight1Label.setBounds(2, 0, 120, 30);
        flight1Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        flightInformation.add(flight1Label);

        JLabel flightCities1 = new JLabel();
        flightCities1.setText(departureCity + " >>>> " + destinationCity);
        flightCities1.setBounds(3, 20, 400, 30);
        flightCities1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        flightInformation.add(flightCities1);

        JLabel flight1Times = new JLabel();
        flight1Times.setText(departureDateTime + " >>>> " + destinationArrivalTime);
        flight1Times.setBounds(3, 35, 400, 40);
        flight1Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
        flightInformation.add(flight1Times);

        if (!model.getOneWayFareValue()) 
        {
            JLabel flight2Label = new JLabel("Flight: " + returnFlightNumber);
            flight2Label.setBounds(2, 70, 120, 30);
            flight2Label.setFont(new Font("Tahoma", Font.BOLD, 12));
            flightInformation.add(flight2Label);

            JLabel flightCities2 = new JLabel();
            flightCities2.setText(destinationCity + " >>>> " + departureCity);
            flightCities2.setBounds(3, 90, 400, 30);
            flightCities2.setFont(new Font("Tahoma", Font.PLAIN, 12));
            flightInformation.add(flightCities2);

            JLabel flight2Times = new JLabel();
            flight2Times.setText(returnDateTime + " >>>> " + returnArrivalTime);
            flight2Times.setBounds(3, 105, 400, 40);
            flight2Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
            flightInformation.add(flight2Times);
        }

        confirmationPage.add(flightInformation);
    }

    /**
     * Purpose: Initializes the traveler information panel.
     */
    private void initializeTravelerInformationPanel() 
    {
        travelerInformation = new JPanel();
        travelerInformation.setLayout(null);
        travelerInformation.setBounds(0, 145, 375, 255);

        JLabel travelersLabel = new JLabel("Travelers");
        travelersLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        travelersLabel.setBounds(2, 0, 90, 30);
        travelerInformation.add(travelersLabel);

        try {
        	// Add all of the travelers onto the display
            for (int i = 0; i < travelerArray.length; i++) 
            {
                JLabel travelerLabel = new JLabel("Traveler " + (i + 1) + ": " + travelerArray[i].returnFullName());
                travelerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
                travelerLabel.setBounds(2, 30 + (i * 20), 375, 30);
                travelerInformation.add(travelerLabel);
            }
        } catch (Exception e) {
            // Do nothing, keeps the program running
        }

        confirmationPage.add(travelerInformation);
    }

    /**
     * Purpose: Initializes the cost information panel.
     */
    private void initializeCostInformationPanel() 
    {
        costInformation = new JPanel();
        costInformation.setLayout(null);
        costInformation.setBounds(375, 0, 275, 300);

        JLabel pricePerPassenger = new JLabel("Price per Passenger: $" + baseRate);
        pricePerPassenger.setBounds(5, 5, 250, 30);
        costInformation.add(pricePerPassenger);

        JLabel extraCostHeaderLabel = new JLabel("Extra Costs");
        extraCostHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        extraCostHeaderLabel.setBounds(5, 30, 100, 30);
        costInformation.add(extraCostHeaderLabel);

        int carryOnBagCount = model.getCarryOnBagCount();
        JLabel carryOnBagsLabel = new JLabel("Carry on (x " + carryOnBagCount + ") : $" + carryOnBagCount * model.getCarryOnCost());
        carryOnBagsLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        carryOnBagsLabel.setBounds(5, 60, 150, 30);
        costInformation.add(carryOnBagsLabel);

        int checkedBagCount = model.getCheckedBagCount();
        JLabel checkedBagLabel = new JLabel("Checked Bags (x " + checkedBagCount + ") : $" + checkedBagCount * model.getCheckedBagCost());
        checkedBagLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        checkedBagLabel.setBounds(5, 80, 150, 30);
        costInformation.add(checkedBagLabel);

        int wifiPackageCount = model.getWifiPackageCount();
        JLabel wifiPackageLabel = new JLabel("Wifi Packages (x " + wifiPackageCount + ") : $" + wifiPackageCount * model.getWifiCost());
        wifiPackageLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        wifiPackageLabel.setBounds(5, 100, 150, 30);
        costInformation.add(wifiPackageLabel);

        double assistanceCharges = model.getAssistanceCharge();
        JLabel assistanceChargeLabel = new JLabel("Assistance Charges: $" + assistanceCharges);
        assistanceChargeLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        assistanceChargeLabel.setBounds(5, 120, 150, 30);
        costInformation.add(assistanceChargeLabel);
        
        double mealCharges = model.getmealCount() * model.getMealCost(); 
        JLabel mealChargeLabel = new JLabel("Meals(x " + model.getmealCount() + ") : $" + mealCharges);
        mealChargeLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        mealChargeLabel.setBounds(5, 140, 150, 30);
        costInformation.add(mealChargeLabel);
        
        
        JLabel totalPriceLabel = new JLabel("Total Cost: $" + model.getTotalBookingPrice());
        totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        totalPriceLabel.setBounds(5, 270, 150, 30);
        costInformation.add(totalPriceLabel);

        confirmationPage.add(costInformation);
    }

    /**
     * Purpose: Returns the confirmation page panel.
     * 
     * @return the confirmation page panel
     */
    public JPanel returnPanel() 
    {
        return confirmationPage;
    }

    /**
     * Purpose: Writes the booking confirmation details to a file.
     */
    private void writeFile() 
    {
        JFileChooser dirChooser = new JFileChooser();
        dirChooser.setDialogTitle("Select a directory to save your file");
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int userSelection = dirChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File directoryToSave = dirChooser.getSelectedFile();
            // Define the file name
            String fileName = CONFIRMATION_PREFIX + confirmationCounter + ".txt"; // Name of the file
            File fileToSave = new File(directoryToSave, fileName);

            // Write to the file using PrintWriter
            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                writer.println("Thank you for choosing travel with us, a cheap air service!\n"
                        + "Booking Confirmation: " + CONFIRMATION_PREFIX + confirmationCounter
                        + "\n" +  new Date());
                

                writer.println("\nFlight details:"
                        + "\n---------------------------------");

                writer.println("Flight: " + departureFlightNumber
                        + "\n" + departureCity + " >>>>>> " + destinationCity
                        + "\n " + departureDateTime + " >>>>>> " + destinationArrivalTime
                        + "\n Flight Time: " + route.getFlightDuration(departureCity, destinationCity)
                        + "\n Total Miles: " + route.getFlightMiles(departureCity, destinationCity));

                if (!model.getOneWayFareValue()) {
                    writer.print(
                            "\nFlight: " + returnFlightNumber
                            + "\n" + destinationCity + " >>>>>> " + departureCity
                            + "\n " + returnDateTime + " >>>>>> " + returnArrivalTime
                            + "\n Flight Time: " + route.getFlightDuration(destinationCity, departureCity)
                            + "\n Total Miles: " + route.getFlightMiles(destinationCity, departureCity)
                            + "\n"
                    );
                }

                writer.println("\nTravelers:"
                        + "\n---------------------------------");

                for (Traveler traveler : travelerArray) 
                {
                    writer.println(traveler.toString());
                    writer.println();
                }

                writer.println("Cost Breakdown:"
                        + "\n---------------------------------");
                writer.println("Price per passenger: $" + baseRate);
                writer.println("Carry on (x " + model.getCarryOnBagCount() + ") : $" + model.getCarryOnBagCount() * model.getCarryOnCost());
                writer.println("Checked Bags(x " + model.getCheckedBagCount() + ") : $" + model.getCheckedBagCount() * model.getCheckedBagCost());
                writer.println("Wifi Packages(x " + model.getWifiPackageCount() + ") : $" + model.getWifiPackageCount() * model.getWifiCost());
                writer.println("Assistance Charges: $" + model.getAssistanceCharge());
                writer.println("Meals(x " + model.getmealCount() + ") : $" + model.getMealCost() * model.getmealCount());
                writer.println("\nTotal Cost: $" + model.getTotalBookingPrice());

                writer.println("\nPayment Information:"
                        + "\n---------------------------------");
                writer.println(model.getPayment().toString());

                writer.flush();
                writer.close();
                JOptionPane.showMessageDialog(frame, "File saved successfully at " + fileToSave.getAbsolutePath(), "File Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                writeFile(); // If there was a error, restart the selection process and retry
            }
            System.exit(0);
        }
    }
}
