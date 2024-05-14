package application;
/**
 * Lead Author(s):
 * 
 * @author Jordan Kelley
 * @author Esteban Naranjo
 *       
 * Other contributors:
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 

 * Version/date: 2024.05.24.001
 * 
 * Responsibilities of class:
 *
 * 
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmationPage
{
	private JFrame frame; 
	private Routes route; 
	private ApplicationModel model; 
	private JPanel contentPane; 
	private CardLayout c1; 
	private JPanel confirmationPage; 
	private FlightManager departureFlight;
	private String departureCity; 
	private String departureDateTime;
	private String departureFlightNumber; 
	private FlightManager returnFlight; 
	private String destinationCity; 
	private String returnDateTime;
	private String returnFlightNumber; 
	private String destinationArrivalTime;
	private String returnArrivalTime; 
	
	private static int confirmationCounter;
	private static final String CONFIRMATION_PREFIX = "TWU000";
	
	private JPanel flightInformation; 
	private JPanel travelerInformation; 
	private JPanel costInformation; 
	private Traveler [] travelerArray;
	private String baseRate; 
	
	
	
	public ConfirmationPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.travelerArray = model.getTravelerArray();
		this.baseRate = model.getPrice();
		this.departureFlight = model.getDepartureFlight();
		this.departureFlightNumber = departureFlight.getFlightNumber();
		this.departureCity = model.getDepartureCity();
		this.destinationCity = model.getDestinationCity();
		this.departureDateTime = departureFlight.getDepartureTime(); 
		this.destinationArrivalTime = departureFlight.getArrivalTime(model.getDepartureDate());
		
		if(model.getOneWayFareValue() == false)
		{
			this.returnFlight = model.getReturnFlight(); 
			this.returnFlightNumber = returnFlight.getFlightNumber(); 
			this.returnDateTime = returnFlight.getDepartureTime();
			this.returnArrivalTime = returnFlight.getArrivalTime(model.getReturnDate());
		}
		
		confirmationPage = new JPanel(); 
		confirmationPage.setLayout(null);
		frame.setTitle("Confirmation Page");
		
		
		/////// Flight Information Panel ////////
		flightInformation = new JPanel(); 
			flightInformation.setLayout(null);
			flightInformation.setBounds(0, 0, 375, 145); 
			flightInformation.setBackground(Color.red);
			
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
			flight1Times.setBounds(3, 35, 400,40);
			flight1Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
			flightInformation.add(flight1Times);
			
			
		if(model.getOneWayFareValue() == false)
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
				flight2Times.setBounds(3, 105, 400,40);
				flight2Times.setFont(new Font("Tahoma", Font.ITALIC, 12));
				flightInformation.add(flight2Times);
		}
			
			confirmationPage.add(flightInformation); 
		
			
		////// Travler Information Panel /////////
		travelerInformation = new JPanel(); 
			travelerInformation.setLayout(null);
			travelerInformation.setBounds(0, 145, 375, 255); 
			travelerInformation.setBackground(Color.WHITE);
		
			JLabel travelersLabel = new JLabel("Travelers"); 
				travelersLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				travelersLabel.setBounds(2, 0, 90, 30);
				travelerInformation.add(travelersLabel);
			
			
		try 
		{
			
			JLabel traveler1Label = new JLabel(); 
			traveler1Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler1Label.setBounds(2, 30, 375, 30);
			traveler1Label.setText("Traveler 1: " + travelerArray[0].returnFullName());
			travelerInformation.add(traveler1Label);
			
			JLabel traveler2Label = new JLabel(); 
			traveler2Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler2Label.setBounds(2, 50, 375, 30);
			traveler2Label.setText("Traveler 2: " + travelerArray[1].returnFullName());
			travelerInformation.add(traveler2Label);
			
			JLabel traveler3Label = new JLabel(); 
			traveler3Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler3Label.setBounds(2, 70, 375, 30);
			traveler3Label.setText("Traveler 3: " + travelerArray[2].returnFullName());
			travelerInformation.add(traveler3Label);
			
			JLabel traveler4Label = new JLabel(); 
			traveler4Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler4Label.setBounds(2, 90, 375, 30);
			traveler4Label.setText("Traveler 4: " + travelerArray[3].returnFullName());
			travelerInformation.add(traveler4Label);
			
			JLabel traveler5Label = new JLabel(); 
			traveler5Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler5Label.setBounds(2, 110, 375, 30);
			traveler5Label.setText("Traveler 5: " + travelerArray[4].returnFullName());
			travelerInformation.add(traveler5Label);
			
			JLabel traveler6Label = new JLabel(); 
			traveler6Label.setFont(new Font("Tahoma", Font.BOLD, 12));
			traveler6Label.setBounds(2, 130, 375, 30);
			traveler6Label.setText("Traveler 6: " + travelerArray[5].returnFullName());
			travelerInformation.add(traveler6Label);
			
			
		}catch(Exception e )
		{
			
		}
			
		confirmationPage.add(travelerInformation);
		
		////// Cost Information Panel ///////////
		costInformation = new JPanel(); 
			costInformation.setLayout(null);
			costInformation.setBounds(375, 0, 275, 300); 
			costInformation.setBackground(Color.GRAY);

			
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
			
		confirmationPage.add(costInformation);
		
		JButton confirmButton = new JButton("Book"); 
			confirmButton.setBounds(445, 310, 95, 30);
			confirmationPage.add(confirmButton); 
			confirmButton.addActionListener(new ActionListener() 
			{
			    @Override
			    public void actionPerformed(ActionEvent e) 
			    {
			    	confirmButton.setVisible(false);
			    	flightInformation.setVisible(false);
			    	travelerInformation.setVisible(false);
			    	costInformation.setVisible(false); 
			    	confirmationCounter++;
			    	writeFile();
			    	
			    }
			});
		
	}
	
	public JPanel returnPanel()
	{ 
		return confirmationPage; 
	}
	
	private void writeFile()
	{
		 JFileChooser dirChooser = new JFileChooser();
	        dirChooser.setDialogTitle("Select a directory to save your file");
	        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

	        int userSelection = dirChooser.showSaveDialog(frame);

	        if (userSelection == JFileChooser.APPROVE_OPTION) 
	        {
	            File directoryToSave = dirChooser.getSelectedFile();
	            // Define the file name
	            String fileName = CONFIRMATION_PREFIX + confirmationCounter + ".txt"; // Name of the file
	            File fileToSave = new File(directoryToSave, fileName);
	            
	         // Write to the file using PrintWriter
	            try (PrintWriter writer = new PrintWriter(fileToSave)) 
	            {
	                writer.println("Thank you for choosing travel with us, a cheap air service!\n"
	                	           + "Booking Confirmation: " + CONFIRMATION_PREFIX + confirmationCounter);
	                
	                writer.println("\nFlight details:"
	                			 + "\n---------------------------------");
	                
	                writer.println("Flight: " + departureFlightNumber 
	                		    +"\n" + departureCity + " >>>>>> " + destinationCity
	                		    +"\n "+ departureDateTime + " >>>>>> " + destinationArrivalTime
	                		    +"\n Flight Time: " + route.getFlightDuration(departureCity, destinationCity)
	                		    +"\n Total Miles: " + route.getFlightMiles(departureCity, destinationCity));
	                
	                		    if(model.getOneWayFareValue() == false)
	                		    {
	                		    	writer.print(
		                		     "\nFlight: " + returnFlightNumber 
		                		    +"\n" + destinationCity + " >>>>>> " + departureCity
		                		    +"\n "+ returnDateTime + " >>>>>> " + returnArrivalTime
		                		    +"\n Flight Time: " + route.getFlightDuration(destinationCity, departureCity)
		                		    +"\n Total Miles: " + route.getFlightMiles(destinationCity, departureCity)
		                		    +"\n\n"
		                		    );
	                		    }

	                
	                writer.println("\nTravelers:"
	                		     + "\n---------------------------------"); 
	                
	                for(int i = 0; i < travelerArray.length; i++)
	                {
	                	writer.println(travelerArray[i].toString());
	                	writer.println();
	                }
	                
	                writer.println("Cost Breakdown:"
	                		    + "\n---------------------------------"); 
	                writer.println("Price per passenger: $" + baseRate);
	                writer.println("Carry on (x " + model.getCarryOnBagCount() + ") : $" + model.getCarryOnBagCount() * model.getCarryOnCost());
                    writer.println("Checked Bags(x " +  model.getCheckedBagCount() + ") : $" + model.getCheckedBagCount() * model.getCheckedBagCost());
                    writer.println("Wifi Packages(x " + model.getWifiPackageCount() + ") : $" + model.getWifiPackageCount() * model.getWifiCost());
                    writer.println("Assistance Charges: $" + model.getAssistanceCharge());
                    writer.println("Meals(x " + model.getmealCount() + ") : $" + model.getMealCost() * model.getmealCount());
                    
                    
                    
                    
                    writer.println("\nPayment Information:" 
                    		     + "\n---------------------------------"); 
                    writer.println(model.getPayment().toString());
               
	                writer.flush();
	                writer.close();
	                JOptionPane.showMessageDialog(frame, "File saved successfully at " + fileToSave.getAbsolutePath(), "File Saved", JOptionPane.INFORMATION_MESSAGE);
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                writeFile();
	            }
	        }
	}
	
}
