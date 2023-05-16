
package bank.mangement.system;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
public class MiniStatement extends JFrame {
    String pin;
    MiniStatement(String pin)
    {       
        this.pin=pin;
        setLayout(null);
         setTitle("MINI STATEMENT");
         setSize(400,600);
         setLocation(20,20);
         setUndecorated(true);
         setVisible(true);
           getContentPane().setBackground(Color.white);
         
         JLabel mini= new JLabel();
         add(mini);
         
         JLabel bank=new JLabel("PASSIONATE BOI");
         bank.setBounds(150,20,100,20);
         add(bank);
         
         JLabel card=new JLabel();
         card.setBounds(20,80,300,20);
         add(card);
         
         JLabel sbalance=new JLabel();
         sbalance.setBounds(20,400,300,20);
         add(sbalance);
         try
         {
             Conn conn = new Conn();
             ResultSet rs= conn.s.executeQuery("select * from login where spinnumber='"+pin+"'");
             while(rs.next())
             {
                 card.setText("Card Number = "+rs.getString("scardnumber").substring(0,4)+" "+"XXXX XXXX "+rs.getString("scardnumber").substring(8,12));
             }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         
         try
         {
             Conn conn = new Conn();
             ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
             while(rs.next())
             {
                 mini.setText(mini.getText()+"<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
             }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
          mini.setBounds(20,140,400,200);   
          
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
         sbalance.setText("Your balance is  : "+balance);
    }
    
    public static void main(String arg[])
    {
        new MiniStatement("");
    }
    
}
