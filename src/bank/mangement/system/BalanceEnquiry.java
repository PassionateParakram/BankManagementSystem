
package bank.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pin;
    BalanceEnquiry(String pin){
            setLayout(null);
            this.pin=pin;
            
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         label.setBounds(0,0,900,900);
         add(label);
         
         back = new JButton("BACK");
         back.setBounds(355,520,150,30);
           back.addActionListener(this);
         label.add(back);
         
           Conn conn=new Conn();
           int balance=0;
         try{
         ResultSet rs= conn.s.executeQuery("select * from bank where pin='"+pin+"'");
         
         while(rs.next())
         {
         if(rs.getString("type").equals("Deposit"))
         {
          balance += Integer.parseInt(rs.getString("amount"));  
         } 
         else if(rs.getString("type").equals("Withdrawl"))
         {
          balance -= Integer.parseInt(rs.getString("amount"));  
         } 
         }
         
         }
         catch(Exception e)
         {
            System.out.println(e);
         }
         
          JLabel text=new JLabel("Your Current Balance is = "+balance);
          text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        text.setBounds(170, 300, 700, 30);
        label.add(text);
         
         
         
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
         getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pin).setVisible(true);
        
    }
    
    public static void main(String arg[])
    {
        new BalanceEnquiry("");
    }
    
}
