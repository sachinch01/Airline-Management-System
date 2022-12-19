package airlines_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;


public class MessageBox extends Dialog  implements ActionListener
{
	JLabel msg;
	
	GridBagLayout gridbagl;
	GridBagConstraints gridbagc; 
	
	MessageBox(Frame fm)
	{
		super(fm,true);
		
		JFrame frame = new JFrame();
		frame.pack();
	
		msg=new JLabel("  Incorrect Username or Password  ",JLabel.CENTER);
		
		gridbagl=new GridBagLayout();
		gridbagc=new GridBagConstraints();
		setLayout(gridbagl);
		
		gridbagc.gridx=0;
		gridbagc.gridy=0;
		gridbagl.setConstraints(msg,gridbagc);
		add(msg);
	
		setSize(300,200);
		setTitle("Message Box");
		
		addWindowListener(new Window());
		
	}
	public void actionPerformed(ActionEvent e)
	{
		/*if(e.getSource()==b1)
		{
			setVisible(false);
			dispose();
		}*/
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







