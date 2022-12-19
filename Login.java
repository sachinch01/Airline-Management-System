package airlines_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Login extends Frame implements ActionListener
{
	JTextField text1;
	JTextField text2;
	
	JLabel uid;
	JLabel pwd;
	
	JButton rs;
	JButton sb;
	JButton cl;
	
	String userid = "meetami";
	String password = "sachin";

	GridBagLayout gridbagl;
	GridBagConstraints gridbagc; 
	
	public Login()
	{
		JFrame frame = new JFrame();
		frame.pack();
		
		text1 = new JTextField(10);
		text2 = new JPasswordField(10);

		JPanel ipanel = new JPanel();
		ipanel.setLayout(new GridLayout());
				
		uid = new JLabel("User ID ",Label.LEFT);
		pwd = new JLabel("Password ",Label.LEFT);
		
		rs = new JButton("Reset");
        rs.addActionListener(this);
		
        sb = new JButton("Submit");
        sb.addActionListener(this);
  
		gridbagl=new GridBagLayout();
		setLayout(gridbagl);
		gridbagc=new GridBagConstraints();
	
		gridbagc.gridx=0;
		gridbagc.gridy=0;
		gridbagl.setConstraints(uid,gridbagc);
		add(uid);
		
		gridbagc.gridx=0;
		gridbagc.gridy=2;
		gridbagl.setConstraints(pwd,gridbagc);
		add(pwd);

		gridbagc.gridx=2;
		gridbagc.gridy=0;
		gridbagl.setConstraints(text1,gridbagc);
		add(text1);

		gridbagc.gridx=2;
		gridbagc.gridy=2;
		gridbagl.setConstraints(text2,gridbagc);
		add(text2);
			
		gridbagc.gridx=0;
		gridbagc.gridy=6;
		gridbagl.setConstraints(sb,gridbagc);
		add(sb);

		gridbagc.gridx=2;
		gridbagc.gridy=6;
		gridbagl.setConstraints(rs,gridbagc);
		add(rs);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==rs)
		{
			text1.setText("");
			text2.setText("");
		}
		
		if(e.getSource()==sb)
		{
			if((text1.getText().equals(userid))&&(text2.getText().equals(password)))
			{
				Reservation resr = new Reservation();
				setVisible(false);
				resr.setSize(400,200);
				resr.setVisible(true);
				resr.setTitle("Reservation");
			}
			else
			{
				MessageBox message = new MessageBox(this);
				message.setLocation(200,200);
				message.setVisible(true);
            }
		}
	}
}