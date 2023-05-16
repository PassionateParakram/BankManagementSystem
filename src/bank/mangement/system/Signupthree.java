
package bank.mangement.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Signupthree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    ButtonGroup account;
    JCheckBox c1,c2,c3,c4,c5,c7,c6;
    JButton submit ,cancel;
    String formno;
    
    Signupthree(String formno){
        
        this.formno=formno;
        
        JLabel L1=new JLabel("Page 3 : Accounts Details");
        L1.setBounds(280,40,400,40);
        L1.setFont(new Font("Raleway",Font.BOLD,22));
        add(L1);
        
        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("Raleway",Font.BOLD,18));
        type.setBounds(100,140,200,30);
        add(type);
        r1=new JRadioButton("Saving Account");
         r1.setFont(new Font("Raleway",Font.BOLD,12));
        r1.setBounds(100,180,150,20);
        add(r1);
        r2=new JRadioButton("Fixed Deposit Account");
         r2.setFont(new Font("Raleway",Font.BOLD,12));
        r2.setBounds(350,180,200,20);
        add(r2);
        r3=new JRadioButton("Current Account");
         r3.setFont(new Font("Raleway",Font.BOLD,12));
        r3.setBounds(100,220,150,20);
        add(r3);
        r4=new JRadioButton("Recurring Deposit Accopunt");
         r4.setFont(new Font("Raleway",Font.BOLD,12));
        r4.setBounds(350,220,200,20);
        add(r4);
        account=new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);
        
         JLabel card = new JLabel("Card Number : ");
        card.setFont(new Font("Raleway",Font.BOLD,18));
        card.setBounds(100,300,200,30);
        add(card);
         JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,18));
        number.setBounds(350,300,250,30);
        add(number);
        JLabel carddetail = new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(100,370,200,30);
        add(pin);
         JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,18));
        pnumber.setBounds(350,370,200,30);
        add(pnumber);
             JLabel pindetail = new JLabel("Your 4 digit password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);
        
        JLabel service = new JLabel("Services Required ");
        service.setFont(new Font("Raleway",Font.BOLD,18));
        service.setBounds(100,450,200,30);
        add(service);
        
        c1=new JCheckBox("I hearby declare that the above details are corect to best of my knowldege!");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,610,630,30);
        add(c1);
        
        c2=new JCheckBox("ATM");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(100,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Internet Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(350,500,200,30);
        add(c3);
        
        c4=new JCheckBox("Mobile Banking");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,530,200,30);
        add(c4);
        
        c5=new JCheckBox("Email & SMS Alert");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(350,530,200,30);
        add(c5);
        
        c6=new JCheckBox("Cheque Book");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(100,560,200,30);
        add(c6);
        
        
        c7=new JCheckBox("E-Statement");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(350,560,200,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(200,650,100,30);
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(400,650,100,30);
        add(cancel);
       
         
               
  
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,750);
        setVisible(true);
        setLocation(350, 10);
    
    
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
             String accounttype=null;
             if(r1.isSelected()){
                 accounttype="Savings";
             }
             else if(r2.isSelected())
             {
                 accounttype="Fixed Deposit Account";
             }
             else if(r3.isSelected())
             {
                 accounttype="Current Account";
             }
             else if(r4.isSelected())
             {
                 accounttype="Recurring Deposit Accopunt";
             }
             
             Random random=new Random();
             String cardnumber=""+Math.abs(random.nextLong()%90000000L+5040936000000000L);
              String pinnumber=""+Math.abs(random.nextLong()%9000L+1000L);
              
              String  facility="";
              if(c2.isSelected())
              {
                  facility=facility+"ATM";
              }
              else if(c3.isSelected())
              {
                   facility=facility+"Internet Banking";
              }
               else if(c4.isSelected())
              {
                   facility=facility+"Mobile Banking";
              }
               else if(c5.isSelected())
              {
                  facility=facility+"Email & SMS Alert";
              }
               else if(c6.isSelected())
              {
                facility=facility+"Cheque Book";
              }
               else if(c7.isSelected())
              {
                  facility=facility+"E-Statement";
              }
              
              try{
                  if(accounttype.equals(""))
                  {
                      JOptionPane.showMessageDialog(null,"Account type is Required");
                  }
                  else
                  {
                      Conn conn=new Conn();
                      String query="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                      String query1 ="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                      conn.s.execute(query);
                      conn.s.execute(query1);
                      
                      JOptionPane.showMessageDialog(null,"Card Number :"+cardnumber+"\n Pin "+pinnumber);
                      setVisible(false);
                      new Deposit(pinnumber).setVisible(true);
                  }
              }
              catch(Exception e)
              {
                  System.out.println(e);
                  
              }
              
              
             
             
             
         }else if(ae.getSource()==cancel){
             setVisible(false);
             new Login().setVisible(true);
             
         }
         
     }
    
     
    public static void main(String[] args) {
        new Signupthree("");
    }

   
    
}
