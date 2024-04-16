package application;

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

public class OptionPage extends JFrame
{
	private JFrame frame;
	private JPanel optionPage;
	private Routes route; 
	private ApplicationModel model;
	private CardLayout c1; 
	private JPanel contentPane; 
	private Option option;
	
	public OptionPage(JFrame frame, Routes route, ApplicationModel model, CardLayout c1, JPanel contentPane, Option option)
	{ 
		this.frame = frame; 
		this.route = route; 
		this.model = model; 
		this.c1 = c1; 
		this.contentPane = contentPane;
		this.option = option;
	
		optionPage = new JPanel(); 
		
		optionPage.setLayout(null);
	
	/////////////////////////////////////
	
		JCheckBox wifiBox = new JCheckBox("wi-fi");
		wifiBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		wifiBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		wifiBox.setBounds(10,100, 145, 23);
		wifiBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					option.setWifi(true);
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED)
				{ 
					option.setWifi(false);
				}
				//option.setWifi(wifiBox.isSelected());
			}
		});
		optionPage.add(wifiBox);
		////////////////////////////////////////////////////////
		JCheckBox mealBox = new JCheckBox("Meal");
		mealBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		mealBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		mealBox.setBounds(10,150, 145, 23);
		optionPage.add(mealBox);
		mealBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			option.setMeal(mealBox.isSelected());
		}
	});
		optionPage.add(mealBox);
		/////////////////////////////////////////////////////////
	JCheckBox assistanceBox = new JCheckBox("assistance");
	assistanceBox.setFont(new Font("Sans Serif", Font.PLAIN, 13));
	assistanceBox.setHorizontalTextPosition(SwingConstants.RIGHT);
	assistanceBox.setBounds(10,200, 145, 23);
	optionPage.add(assistanceBox);
	assistanceBox.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		option.setMeal(assistanceBox.isSelected());
	}
});
	optionPage.add(assistanceBox);
	

		
	}	
	public JPanel returnPanel()
	{ 
		return optionPage; 
	}
	
	
	
}
	
	

