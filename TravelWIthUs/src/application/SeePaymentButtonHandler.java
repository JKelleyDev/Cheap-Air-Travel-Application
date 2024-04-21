package application;

import java.awt.CardLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeePaymentButtonHandler implements ActionListener
{
	private JFrame frame;
	private CardLayout c1; 
	private JPanel contentPane; 

	public SeePaymentButtonHandler(JFrame frame, CardLayout c1, JPanel contentPane) 
	{ 
		
		this.frame = frame; 
		this.c1 = c1; 
		this.contentPane = contentPane; 
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		c1.show(contentPane, "Payment");
		frame.setTitle("Payment");
	}
}
