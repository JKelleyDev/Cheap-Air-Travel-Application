package application;

import java.awt.CardLayout;
import java.awt.Color;
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
		
	}
	
	public JPanel returnPanel() 
	{ 
		return flightsPage; 
	}
}