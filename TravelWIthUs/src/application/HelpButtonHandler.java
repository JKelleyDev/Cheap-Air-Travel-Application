package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class HelpButtonHandler implements ActionListener
{
	private JDialog helpBox;  
	private JFrame frame; 
	
	public HelpButtonHandler(JButton button, JFrame frame)
	{ 
		
		JDialog helpBox = new JDialog(frame, "Help");
		helpBox.setSize(200, 200);
		this.frame = frame;
		this.helpBox = helpBox; 

	} 
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		helpBox.setVisible(true);
		helpBox.setAlwaysOnTop(true);
		helpBox.setLocationRelativeTo(frame);
		
	}
}
