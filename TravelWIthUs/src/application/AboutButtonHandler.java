package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AboutButtonHandler implements ActionListener
{
	private JDialog aboutBox;  
	private JFrame frame; 
	
	public AboutButtonHandler(JButton button, JFrame frame)
	{ 
		
		JDialog aboutBox = new JDialog(frame, "About Us");
		aboutBox.setSize(200, 200);
		this.frame = frame;
		this.aboutBox = aboutBox; 

	} 

	@Override
	public void actionPerformed(ActionEvent e)
	{
		aboutBox.setVisible(true);
	    aboutBox.setAlwaysOnTop(true);
		aboutBox.setLocationRelativeTo(frame);
	
	}

}
