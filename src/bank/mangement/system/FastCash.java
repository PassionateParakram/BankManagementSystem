
package bank.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,ministatemt,pinchange,balance,exit;
    String pin;
    
    
        FastCash( String pin)
        {
            this.pin=pin;
            setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         label.setBounds(0,0,900,900);
         add(label);
         
        JLabel text=new JLabel("SELECT THE AMOUNT YOU WANT TO WITHDRAW");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,12));
        text.setBounds(200, 300, 700, 35);
        label.add(text);
        
        deposit=new JButton("RS 100");
        deposit .setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
         
        withdraw=new JButton("RS 200");
        withdraw .setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fastcash=new JButton("RS 500");
        fastcash .setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        ministatemt=new JButton("RS 1000");
        ministatemt .setBounds(355,450,150,30);
        ministatemt.addActionListener(this);
        label.add(ministatemt);
        
        pinchange=new JButton("RS 2000");
        pinchange .setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        balance=new JButton("RS 5000");
        balance .setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);
        
        exit=new JButton("BACK");
        exit .setBounds(355,520,150,30);
        exit.addActionListener(this);
        label.add(exit);
        
        
        
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
         
          getContentPane().setBackground(Color.white);
            
        }    
        
         public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
         setVisible(false);
            new Transaction(pin).setVisible(true);
         }
         else {
         String amount=((JButton)ae.getSource()).getText().substring(3);
         Conn conn=new Conn();
         try{
         ResultSet rs= conn.s.executeQuery("select * from bank where pin='"+pin+"'");
         int balance=0;
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
         if(ae.getSource() != exit && balance<Integer.parseInt(amount)){
          JOptionPane.showMessageDialog(null,"Insufficient Balance");
          return;
         }
         Date date = new Date();
         String query="insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs  "+amount+"  withdraw Succesfull");
             setVisible(false);
            new Transaction(pin).setVisible(true);
         
         }
         catch(Exception e)
         {
            System.out.println(e);
         }
         }
         
         
         }
    
    public static void main(String arg[])
    {
        new FastCash("");
    }
}
