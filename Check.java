package airlines_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Check extends Frame implements ActionListener 
{
	JLabel tdate;
	JLabel fno;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;

	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	JTextField text5;
	
    JButton sb;
    JButton res;
	
    GridBagLayout gridbagl;
	GridBagConstraints gridbagc; 
    
    PreparedStatement prepstat;
	ResultSet resset;
	
    public Check()
	{	
    	JFrame frame = new JFrame();
		frame.pack();
		
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		text3 = new JTextField(20);
		text4 = new JTextField(20);
		text5 = new JTextField(20);

		JPanel ipanel = new JPanel();
		ipanel.setLayout(new GridLayout());
		
		label1 = new JLabel ("Flights available: ", Label.LEFT);
		label2 = new JLabel("Date     Flights");
		label3 = new JLabel("11/20/21  AA100",Label.LEFT);
		label4 = new JLabel("11/21/21  AA101",Label.LEFT);
		label5 = new JLabel("11/22/21  UA100",Label.LEFT);
		label6 = new JLabel("11/23/21  UA101",Label.LEFT);
		label7 = new JLabel("11/24/21  UA102",Label.LEFT);


		tdate = new JLabel("Travel Date ",Label.LEFT);
		fno = new JLabel("Flight No ",Label.LEFT);

		
		sb = new JButton("Submit");
		sb.addActionListener(this);
		
		res = new JButton("Reset");
		res.addActionListener(this);
		
		gridbagl=new GridBagLayout();
		gridbagc=new GridBagConstraints();
		setLayout(gridbagl);
		
		gridbagc.gridx=0;
		gridbagc.gridy=0;
		gridbagl.setConstraints(label1,gridbagc);
		add(label1);
		
		gridbagc.gridx=0;
		gridbagc.gridy=2;
		gridbagl.setConstraints(label2,gridbagc);
		add(label2);
		
		gridbagc.gridx=0;
		gridbagc.gridy=4;
		gridbagl.setConstraints(label3,gridbagc);
		add(label3);

		gridbagc.gridx=0;
		gridbagc.gridy=6;
		gridbagl.setConstraints(label4,gridbagc);
		add(label4);

		gridbagc.gridx=0;
		gridbagc.gridy=8;
		gridbagl.setConstraints(label5,gridbagc);
		add(label5);
	
		gridbagc.gridx=0;
		gridbagc.gridy=10;
		gridbagl.setConstraints(label6,gridbagc);
		add(label6);

		gridbagc.gridx=0;
		gridbagc.gridy=12;
		gridbagl.setConstraints(label7,gridbagc);
		add(label7);
	
		gridbagc.gridx=0;
		gridbagc.gridy=16;
		gridbagl.setConstraints(tdate,gridbagc);
		add(tdate);
		
		gridbagc.gridx=2;
		gridbagc.gridy=16;
		gridbagl.setConstraints(text1,gridbagc);
		add(text1);
        
		gridbagc.gridx=0;
		gridbagc.gridy=18;
		gridbagl.setConstraints(fno,gridbagc);
		add(fno);

		gridbagc.gridx=2;
		gridbagc.gridy=18;
		gridbagl.setConstraints(text2,gridbagc);
		add(text2);
        
		gridbagc.gridx=0;
		gridbagc.gridy=20;
		gridbagl.setConstraints(sb,gridbagc);
		add(sb);

		gridbagc.gridx=2;
		gridbagc.gridy=20;
		gridbagl.setConstraints(res,gridbagc);
		add(res);
		
	
		addWindowListener(new W());
	    }
    
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==sb)
		{

			try
			{   
				String dbURL = "jdbc:sqlite:C:\\Users\\Sachin Chavan\\Documents\\Airway.db";
				Connection con = DriverManager.getConnection(dbURL);
				prepstat=con.prepareStatement("SELECT * FROM Reservation WHERE TravelDate=? and FlightNo=?");
				prepstat.setString(1,text1.getText());
				prepstat.setString(2,text2.getText());
				
				
				text3.setText(Integer.toString(resset.getInt(3)));
				text4.setText(Integer.toString(resset.getInt(4)));
		        text5.setText(Integer.toString(resset.getInt(5)));
		       
		        resset=prepstat.executeQuery();
				resset.next();
                
				con.close();
			}
			catch(Exception exp)
			{
				System.out.println("2 Error : "+exp);
			}
		}

		if(e.getSource()==res)
	 {
        text1.setText("");
		text2.setText("");
	    text3.setText("");
		text4.setText("");
		text5.setText("");
       }
	}

    
class W extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();	
		}
	}
}
