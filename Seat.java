package airlines_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import java.awt.List;

public class Seat extends JFrame implements ActionListener {
    // Global Variables
    boolean lselected, rselected,r1selected, l1selected;
    double chargeDue;
    int a,a1,c,c1;
    static Ticket econticket, buisnessticket;
    JFrame frame = new JFrame(); // Creates JFrame
    JLabel title, lecon, lbuisness, loap, ltotalprice, time;
    JTextField econ, buisness, oap, totalprice;
    JButton submit;
    JRadioButton time1, time2, time3, time4, time5; // Radio Butons
    JToggleButton l1[][],l[][], m[][], r[][],r1[][]; // Names grid of JButtons
    JPanel panel1,panel11, panel2, panel3, panel4, panel5, panel6, panel13;
    ArrayList<String> seatsAvailable = new ArrayList<String>();
    ArrayList<String> coupon = new ArrayList<String>();

    // Constructor
    public Seat(){

          title = new JLabel("Seat Booking System");
            title.setFont(new Font("Helvetica", Font.BOLD, 30));
            title.setLocation(12,5);
            title.setSize(600, 60);

            //frame.setLayout(null); // Setting Grid Layout
            // panel1.setLayout(new GridLayout(seat,row));
            l1 = new JToggleButton[5][5]; // Allocating Size of Grid
            panel11 = new JPanel(new GridLayout(5,5));
            panel11.setBounds(20, 95, 200, 100);
            for(int y = 0; y <5 ; y++){
                    for(int x = 1; x < 3; x++){
                    int counter1 = y+1;
                    char letter  =  (char)(x+64);
                        l1[x][y] = new JToggleButton("" +counter1 + letter); // Creates New JButton
                        l1[x][y].addActionListener(this);
                        seatsAvailable.add("" +counter1 + letter);
                        panel11.add(l1[x][y]); //adds button to grid
                    }
            }
           l = new JToggleButton[32][32]; // Allocating Size of Grid
            panel1 = new JPanel(new GridLayout(32,32));
            panel1.setBounds(20, 185, 220, 440);
            for(int y = 0; y <32 ; y++){
                    for(int x = 1; x < 4; x++){
                    int counter1 = y+6;
                    char letter  =  (char)(x+64);
                        l[x][y] = new JToggleButton("" +counter1 + letter); // Creates New JButton
                        l[x][y].addActionListener(this);
                        seatsAvailable.add("" +counter1 + letter);
                        panel1.add(l[x][y]); //adds button to grid
                    }
            }
           


            r1 = new JToggleButton[5][5]; // Allocating Size of Grid
            panel13 = new JPanel(new GridLayout(5,5));
            panel13.setBounds(320, 95, 200, 100);
            for(int y = 0; y <5 ; y++){
                for(int x = 1; x < 3; x++){
                    int counter1 = y+1;
                    char letter  =  (char)(x+67);
                        r1[x][y] = new JToggleButton("" +counter1 + letter); // Creates New JButton
                        r1[x][y].addActionListener(this);
                        seatsAvailable.add("" +counter1 + letter);
                        panel13.add(r1[x][y]); //adds button to grid
                    }
            }
            r = new JToggleButton[32][32]; // Allocating Size of Grid
            panel3 = new JPanel(new GridLayout(32,32));
            panel3.setBounds(300, 185, 220, 440);
            for(int y = 0; y <32 ; y++){
                for(int x = 1; x < 4; x++){
                    int counter1 = y+6;
                    char letter  =  (char)(x+67);
                        r[x][y] = new JToggleButton("" +counter1 + letter); // Creates New JButton
                        r[x][y].addActionListener(this);
                        seatsAvailable.add("" +counter1 + letter);
                        panel3.add(r[x][y]); //adds button to grid
                    }
            }
           
            panel4 = new JPanel(new FlowLayout());
            panel4.setBounds(0, 650, 600, 70);

            lecon = new JLabel("ECON");
            econ = new JTextField("0", 2);
            econ.addActionListener(this);

            lbuisness = new JLabel("buisness");
            buisness = new JTextField("0", 2);
            buisness.addActionListener(this);


            submit = new JButton("Submit");
            submit.addActionListener(this);

            econticket = new Ticket(50);
            buisnessticket = new Ticket(75);    

            /*econ.addKeyListener(new MyKeyAdapter());
            oap.addKeyListener(new MyKeyAdapter());
            buisness.addKeyListener(new MyKeyAdapter());*/

            panel4.add(lecon);
            panel4.add(econ);
            panel4.add(lbuisness);
            panel4.add(buisness);
            panel4.add(submit);

            panel5 = new JPanel(new FlowLayout());
            panel5.setBounds(350, 650, 200, 70);

            ltotalprice = new JLabel("Charge Due ($): ");
            totalprice = new JTextField("$0.00", 5);
            totalprice.setEnabled(false);
            panel5.add(ltotalprice);
            panel5.add(totalprice);

            panel6 = new JPanel(new FlowLayout());
            panel6.setBounds(0, 55, 560, 130);


            ButtonGroup group = new ButtonGroup();
 
            frame.add(title);
            frame.add(panel11);
            frame.add(panel1);
            frame.add(panel13);
            frame.add(panel3);
            frame.add(panel4);
            frame.add(panel5);
            frame.add(panel6);

            frame.setPreferredSize(new Dimension(600, 750));
            frame.setTitle("Seat Booking");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); //sets appropriate size for frame
            frame.setVisible(true); //makes frame visible


    }

    // Calculates Charge Due for current transaction.
    public double calcChargeDue(){
        DecimalFormat df = new DecimalFormat("#.##");
        double chargeDue = 0.0;

        chargeDue = (a*econticket.price) + (c*buisnessticket.price);
        totalprice.setText("$"+df.format(chargeDue));
        return chargeDue;
    }

    // Method to check if the number of people matches the number of seats selected.
    public void check(){
        int check = coupon.size();
        int noTickets = a + c ;
        if (check != noTickets){
            submit.setEnabled(false);
        }
        else {
            submit.setEnabled(true);
        }

    }

    // Ticket Object
    public class Ticket {

        double price;

        // Constructor
        public Ticket(double cost) {
            price = cost;
        }

        public double getTicketPrice() {
            return price;
        }

    }

    public void actionPerformed(ActionEvent e)
    {

        a = Integer.parseInt(econ.getText());
       // b = Integer.parseInt(oap.getText());
        c = Integer.parseInt(buisness.getText());
        for(int y = 0; y <5 ; y++){
            for(int x = 1; x < 3; x++){
                r1selected = r1[x][y].isSelected();
            l1selected = l1[x][y].isSelected();
            if (e.getSource() == l1[x][y]) {
                    if(l1selected == true){
                        coupon.add(e.getActionCommand());
                        calcChargeDue();
                        check();
                    }
                    else {
                        coupon.remove(e.getActionCommand());
                        check();
                    }
                }
            if (e.getSource() == r1[x][y]) {
                    if(r1selected == true){
                        coupon.add(e.getActionCommand());
                        calcChargeDue();
                        check();
                    }
                    else {
                        coupon.remove(e.getActionCommand());
                        check();
                    }
                }
                if (e.getSource() == buisness){
                    calcChargeDue();
                    check();
                }

                if (e.getSource() == econ){
                    calcChargeDue();
                    check();
                }

           
            }
        }
       
       
        for(int y = 0; y < 32; y++){
            for(int x = 1; x < 4; x++){
             
                lselected = l[x][y].isSelected();
                rselected = r[x][y].isSelected();
                if (e.getSource() == l[x][y]) {
                    if(lselected == true){
                        coupon.add(e.getActionCommand());
                        calcChargeDue();
                        check();
                    }
                    else {
                        coupon.remove(e.getActionCommand());
                        check();
                    }
                }
               

                if (e.getSource() == r[x][y]) {
                    if(rselected == true){
                        coupon.add(e.getActionCommand());
                        calcChargeDue();
                        check();
                    }
                    else {
                        coupon.remove(e.getActionCommand());
                        check();
                    }
                }
                if (e.getSource() == buisness){
                    calcChargeDue();
                    check();
                }

                if (e.getSource() == econ){
                    calcChargeDue();
                    check();
                }

            }
        }


        if(submit == e.getSource()) {
            for(int y = 0; y <5 ; y++){
                for(int x = 1; x < 3; x++){
                l1selected = l1[x][y].isSelected();
                r1selected = r1[x][y].isSelected();
                    if (l1selected == true) {
                        l1[x][y].setEnabled(false);
                    }
                    if (r1selected == true) {
                        r1[x][y].setEnabled(false);
                    }
                }
            }
            for(int y = 0; y < 32; y++){
                for(int x = 1; x < 4; x++){                
                    lselected = l[x][y].isSelected();
                    rselected = r[x][y].isSelected();
                    if (lselected == true) {
                            l[x][y].setEnabled(false);
                    }
                    if (rselected == true) {
                            r[x][y].setEnabled(false);
                    }
                }
            }
            /*Collections.sort(coupon);
            Random r = new Random();
            int low = 100000;
            int high = 10000000;
            int result = r.nextInt(high-low) + low;
            System.out.println("Here's your ticket:");
            System.out.println(coupon);
            System.out.println("econ: " + econ.getText());
            System.out.println("buisness: " + buisness.getText());
            System.out.println("Total Price: " + totalprice.getText());
            System.out.println("Your PNR: " + result);
            System.out.println("Thank you.");
            System.out.println(" ");
            coupon.clear();
            econ.setText("0");
            buisness.setText("0");*/
        }
        
        if(e.getSource()==submit)
		{
        	//ArrayList<String> coupon = new ArrayList<String>();
        	//JTextField econ, buisness, oap, totalprice;
        	JTextArea tickets;
        		
        		JTextArea CurrAcc;
        		int i = 0;
        		
        		 Ticket();
        		{
        			JFrame frame = new JFrame();
        			frame.pack();
        			frame.setVisible(true);
        			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        			
        			/*econ = new JTextField(10);
        			buisness = new JTextField(10);
        			totalprice = new JTextField(10);*/
        			
        			tickets = new JTextArea(20,20);
        			tickets.setEditable(false);
        			
        			JPanel opanel = new JPanel();
        			opanel.setLayout(new GridLayout(5,5));
        			
        			opanel.add(new JLabel (" Here's Your Ticket!"));
        			opanel.add(tickets);
        			frame.add(opanel, BorderLayout.CENTER);
        			
        		}
        		{
        			Collections.sort(coupon);
                    Random r = new Random();
                    int low = 100000;
                    int high = 10000000;
                    int result = r.nextInt(high-low) + low;
        			tickets.setText(" Seat number: " + coupon + "\n\r" +" Economy: " + econ.getText() +"\n\r"+ " Business: " + buisness.getText() +"\n\r" + " Total Price: " + totalprice.getText() + "\n\r" + " Your PNR: " + result);
        			coupon.clear();
            
        		}
		}
    }
    private void Ticket() {
		// TODO Auto-generated method stub
		
	}
    
		
	class Window extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();
		}
	}
 
    // Main Class
    public static void main(String[] args) {
            new Seat(); //makes new ButtonGrid with 2 parameters
            
            //Ticket();
    }
}