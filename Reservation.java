package airlines_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reservation extends Frame implements ActionListener 
{
	JButton checkava;
	JButton createpass;

	JLabel l1;
	JLabel l2;
	
	GridBagLayout gridbagl;
	GridBagConstraints gridbagc; 

	public Reservation()
	{
		JFrame frame = new JFrame();
		frame.pack();

		l1= new JLabel("");
        l2= new JLabel("");
		
		JPanel ipanel = new JPanel();
		ipanel.setLayout(new GridLayout());
		
		gridbagl=new GridBagLayout();
		gridbagc=new GridBagConstraints();
		setLayout(gridbagl);
		
		checkava=new JButton("Check Availability");
		createpass=new JButton("Create Passenger");
		
		gridbagc.gridx=0;
		gridbagc.gridy=0;
		gridbagl.setConstraints(checkava,gridbagc);
		add(checkava);

		gridbagc.gridx=0;
		gridbagc.gridy=4;
		gridbagl.setConstraints(l1,gridbagc);
		add(l1);

		gridbagc.gridx=0;
		gridbagc.gridy=8;
		gridbagl.setConstraints(createpass,gridbagc);
		add(createpass);

		checkava.addActionListener(this);
		createpass.addActionListener(this);
		addWindowListener(new Window());
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==checkava)
		{
			
			Check check = new Check();
			setVisible(false);
			check.setSize(500,500);
			check.setVisible(true);
			check.setTitle("Check Availability");
		}
		if(e.getSource()==createpass)
		{
			
			Create create = new Create();
			setVisible(false);
			create.setSize(500,500);
			create.setVisible(true);
			create.setTitle("Create Passenger");
		}
	}
	class Window extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();
			
		}
	}
}
