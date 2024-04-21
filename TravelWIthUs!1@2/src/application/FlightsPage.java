package application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class FlightsPage extends JFrame
{
	private JFrame frame;
	private JPanel flightsPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	
	public FlightsPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		flightsPage = new JPanel(); 
		flightsPage.setLayout(null);
		
		
		
		JPanel flight_option1 = new JPanel();
		flight_option1.setLayout(null);
		flight_option1.setBounds(0,10,600, 100);
		flight_option1.setBackground(Color.RED);
		JButton chooseFlight_1 = new JButton("Select");
			chooseFlight_1.setBounds(500, 35, 95, 30);
			flight_option1.add(chooseFlight_1);
			
		JPanel flight_option2 = new JPanel();
		flight_option2.setLayout(null);
		flight_option2.setBounds(0,125, 600, 100);
		flight_option2.setBackground(Color.BLUE);
		JButton chooseFlight_2 = new JButton("Select");
			chooseFlight_2.setBounds(500, 35, 95, 30);
			flight_option2.add(chooseFlight_2);
		
		JPanel flight_option3 = new JPanel();
		flight_option3.setLayout(null);
		flight_option3.setBounds(0,240, 600, 100);
		flight_option3.setBackground(Color.GREEN);
		JButton chooseFlight_3 = new JButton("Select");
			chooseFlight_3.setBounds(500, 35, 95, 30);
			flight_option3.add(chooseFlight_3);
		
		flightsPage.add(flight_option1);
		flightsPage.add(flight_option2);
		flightsPage.add(flight_option3);
		
		
	}
	
	public JPanel returnPanel() 
	{ 
		return flightsPage; 
	}
}