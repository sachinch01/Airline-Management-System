package airlines_management_system;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Create extends Frame implements ActionListener  
{   
	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	JTextField text5;
	JTextField text6;
	JTextField text7;
	JTextField text8;
	JTextField text9;
	JTextField text10;
	
	JLabel tdate;
	JLabel fname;
	JLabel lname;
	JLabel age;
	JLabel gender;
	JLabel addr;
	JLabel ph;
	JLabel fno;
	JLabel cl;
	JLabel st;
	
	
	JButton sb;
	JButton rset;
	JButton scheck;
	
	GridBagLayout gridbagl;
	GridBagConstraints gridbagc; 
	
	public Create()
	{
		JFrame frame = new JFrame();
		frame.pack();
		
		JPanel ipanel = new JPanel();
		ipanel.setLayout(new GridLayout());
		
		fname = new JLabel("FirstName",Label.LEFT);
		lname = new JLabel("LastName",Label.LEFT);
		age = new JLabel("Age",Label.LEFT);
		gender = new JLabel("Gender",Label.LEFT);
		addr = new JLabel("Address",Label.LEFT);
		ph = new JLabel("Phone",Label.LEFT);
		fno = new JLabel("Flight No",Label.LEFT);
		cl= new JLabel("Class",Label.LEFT);
		tdate = new JLabel("Travel Date",Label.LEFT);
		st= new JLabel("Status",Label.LEFT);
		
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		text3 = new JTextField(10);
		text4 = new JTextField(10);
		text5 = new JTextField(10);
		text6 = new JTextField(10);
		text7 = new JTextField(10);
		text8 = new JTextField(10);
		text9 = new JTextField(10);
		text10 = new JTextField(10);
		
		sb = new JButton("Submit");
		sb.addActionListener(this);
		
		rset = new JButton("Reset");
		rset.addActionListener(this);
        
		scheck = new JButton("Seat Checker");
        scheck.addActionListener(this);
            
        gridbagl=new GridBagLayout();
		gridbagc=new GridBagConstraints();
		setLayout(gridbagl);
		
		gridbagc.gridx=0;
		gridbagc.gridy=0;
		gridbagl.setConstraints(fname,gridbagc);
		add(fname);

		gridbagc.gridx=2;
		gridbagc.gridy=0;
		gridbagl.setConstraints(text1,gridbagc);
		add(text1);


		gridbagc.gridx=0;
		gridbagc.gridy=2;
		gridbagl.setConstraints(lname,gridbagc);
		add(lname);
 
		gridbagc.gridx=2;
		gridbagc.gridy=2;
		gridbagl.setConstraints(text2,gridbagc);
		add(text2);

		gridbagc.gridx=0;
		gridbagc.gridy=3;
		gridbagl.setConstraints(age,gridbagc);
		add(age);
		
		gridbagc.gridx=2;
		gridbagc.gridy=3;
		gridbagl.setConstraints(text3,gridbagc);
		add(text3);

		gridbagc.gridx=0;
		gridbagc.gridy=4;
		gridbagl.setConstraints(gender,gridbagc);
		add(gender);

		gridbagc.gridx=2;
		gridbagc.gridy=4;
		gridbagl.setConstraints(text4,gridbagc);
		add(text4);

		gridbagc.gridx=0;
		gridbagc.gridy=6;
		gridbagl.setConstraints(addr,gridbagc);
		add(addr);

		gridbagc.gridx=2;
		gridbagc.gridy=6;
		gridbagl.setConstraints(text5,gridbagc);
		add(text5);
		
		gridbagc.gridx=0;
		gridbagc.gridy=8;
		gridbagl.setConstraints(ph,gridbagc);
		add(ph);

		gridbagc.gridx=2;
		gridbagc.gridy=8;
		gridbagl.setConstraints(text6,gridbagc);
		add(text6);

		gridbagc.gridx=0;
		gridbagc.gridy=10;
		gridbagl.setConstraints(fno,gridbagc);
		add(fno);

		gridbagc.gridx=2;
		gridbagc.gridy=10;
		gridbagl.setConstraints(text7,gridbagc);
		add(text7);

		gridbagc.gridx=0;
		gridbagc.gridy=12;
		gridbagl.setConstraints(cl,gridbagc);
		add(cl);

		gridbagc.gridx=2;
		gridbagc.gridy=12;
		gridbagl.setConstraints(text8,gridbagc);
		add(text8);

		gridbagc.gridx=0;
		gridbagc.gridy=14;
		gridbagl.setConstraints(tdate,gridbagc);
		add(tdate);

		gridbagc.gridx=2;
		gridbagc.gridy=14;
		gridbagl.setConstraints(text9,gridbagc);
		add(text9);

		gridbagc.gridx=0;
		gridbagc.gridy=16;
		gridbagl.setConstraints(st,gridbagc);
		add(st);

		gridbagc.gridx=2;
		gridbagc.gridy=16;
		gridbagl.setConstraints(text10,gridbagc);
		add(text10);

		gridbagc.gridx=0;
		gridbagc.gridy=18;
		gridbagl.setConstraints(sb,gridbagc);
		add(sb);

		gridbagc.gridx=2;
		gridbagc.gridy=18;
		gridbagl.setConstraints(rset,gridbagc);
		add(rset);
                         
		//addWindowListener(new Window());   
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==sb)
		{
			try
			{  
				String dbURL = "jdbc:sqlite:C:\\Users\\Sachin Chavan\\Documents\\Airway.db";
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement ps=con.prepareStatement("INSERT INTO Passengers(FirstName,LastName,Age,Gender,Address,Phone,FlightNo,Class,TravelDate,Status)VALUES(?,?,?,?,?,?,?,?,?,?)");
				
				String age = text3.getText();
				ps.setString(1,text1.getText());
				ps.setString(2,text2.getText());
				ps.setInt(3,Integer.parseInt(age));
				ps.setString(4,text4.getText());
				ps.setString(5,text5.getText());
				ps.setString(6,text6.getText());
				ps.setString(7,text7.getText());
				ps.setString(8,text8.getText());
				ps.setString(9,text9.getText());
				ps.setString(10,text10.getText());
				ps.executeUpdate();		
                                
          if(text8.getText().equals(String.valueOf('F')))
          {   
           String str = "UPDATE Reservation SET FSeats=FSeats-1 WHERE FlightNo=? and TravelDate = ?";
           PreparedStatement ps1 = con.prepareStatement(str);
           ps1.setString(1,text7.getText());
           ps1.setString(2,text9.getText());   
           int rowcount = ps.executeUpdate();
          }
          
          if(text8.getText().equals(String.valueOf('B')))
       	  {
    	   String str = "UPDATE Reservation SET BSeats=BSeats-1 WHERE FlightNo=? and TravelDate = ?";
    	   PreparedStatement ps1 = con.prepareStatement(str);
    	   ps1.setString(1,text7.getText());
    	   ps1.setString(2,text9.getText());   
    	   int rowcount = ps.executeUpdate();
       	  }
          
          if(text8.getText().equals(String.valueOf('E')))
		  {
           String str = "UPDATE Reservation SET ESeats=ESeats-1 where FlightNo=? and TravelDate = ?";
           PreparedStatement ps1 = con.prepareStatement(str);
		   ps1.setString(1,text7.getText());
		   ps1.setString(2,text9.getText());   
		   int rowcount = ps.executeUpdate();
		  }
          con.close();
   
			}

			catch(SQLException exp)
			{
				System.out.println("Error 2: "+exp);
			}
			catch(Exception exp2)
			{
				System.out.println("Error 1:"+exp2);
			}
		}
		if(e.getSource()==sb)
		{
			Seat seat = new Seat();
			seat.setSize(500,500);
			seat.setVisible(false);
			seat.setTitle("Choose Seat");
		}
    if(e.getSource()==rset)
   {			
                	text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    text6.setText("");
                    text7.setText("");
                    text8.setText("");
                    text9.setText("");
                    text10.setText("");
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


	
	public static void main(String args[])
	{
	
	}
 }


