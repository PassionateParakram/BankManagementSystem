
package bank.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,ministatemt,pinchange,balance,exit;
    String pin;
    
    
        Transaction( String pin)
        {
            this.pin=pin;
            setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         label.setBounds(0,0,900,900);
         add(label);
         
           JLabel text=new JLabel("Please select your Transaction");
           text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        text.setBounds(200, 300, 700, 35);
        label.add(text);
        
        deposit=new JButton("Deposit");
        deposit .setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
         
        withdraw=new JButton("Cash Withdrawl");
        withdraw .setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fastcash=new JButton("Fast Cash");
        fastcash .setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        ministatemt=new JButton("Mini-Statement");
        ministatemt .setBounds(355,450,150,30);
        ministatemt.addActionListener(this);
        label.add(ministatemt);
        
        pinchange=new JButton("Pin Change");
        pinchange .setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        balance=new JButton("Balance Enquiry");
        balance .setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);
        
        exit=new JButton(" Exit");
        exit .setBounds(170,520,150,30);
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
         System.exit(0);
         }
         else if(ae.getSource()==deposit){
         setVisible(true);
         new Deposit(pin).setVisible(true);
         } 
         else if(ae.getSource()==withdraw){
         setVisible(true);
         new Withdrawl(pin).setVisible(true);
         }
         else if(ae.getSource()==fastcash){
         setVisible(true);
         new FastCash(pin).setVisible(true);
         }
          else if(ae.getSource()==pinchange){
         setVisible(true);
         new PinChange(pin).setVisible(true);
         }
          else if(ae.getSource()==balance){
         setVisible(true);
         new BalanceEnquiry(pin).setVisible(true);
         }
           else if(ae.getSource()==ministatemt){
               
         new MiniStatement(pin).setVisible(true);
         }
         
         
         }
    
    public static void main(String arg[])
    {
        new Transaction("");
    }
}
