package airlines_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.text.*;
import java.awt.List;

import javax.swing.*;

public class Ticket extends Frame implements ActionListener
{
	ArrayList<String> coupon = new ArrayList<String>();
	JTextField econ, buisness, oap, totalprice;
	JTextArea tickets;
		
		JTextArea CurrAcc;
		int i = 0;
		
		 Ticket()
		{
			JFrame frame = new JFrame();
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//econ = new JTextField(10);
			//business = new JTextField(10);
			//totalprice = new JTextField(10);
			
			tickets = new JTextArea(20,20);
			tickets.setEditable(false);
			
			JPanel opanel = new JPanel();
			opanel.setLayout(new GridLayout(5,5));
			
			opanel.add(new JLabel ("Tickets"));
			opanel.add(tickets);
			frame.add(opanel, BorderLayout.CENTER);
			
		}
	 
		public void actionPerformed(ActionEvent e)
		{
			tickets.setText("\n\r" + coupon + econ.getText() + buisness.getText() + totalprice.getText());
		}
		class Window extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
				dispose();
			}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Ticket();
			Ticket ticke = new Ticket();
			ticke.setVisible(false);
			ticke.setSize(500,500);
			ticke.setVisible(false);
			ticke.setTitle("Ticket");
		}
		}
}
