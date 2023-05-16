package bank.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener {
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    PinChange(String Pin)
    {
        pinnumber=Pin;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         label.setBounds(0,0,900,900);
         add(label);
         
           JLabel text=new JLabel("CHANGE YOUR PIN");
           text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        text.setBounds(260, 300, 700, 35);
        label.add(text);
        
        
        JLabel pintext=new JLabel("NEW PIN");
           pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD,16));
        pintext.setBounds(165, 340, 180, 25);
        label.add(pintext);
        
         pin =new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,16));
        pin.setBounds(330, 340, 180, 25);
         label.add(pin);
        
         JLabel repintext=new JLabel(" RE-ENTER NEW PIN");
           repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD,16));
        repintext.setBounds(165, 380, 200, 25);
        label.add(repintext);
        
         repin =new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,16));
        repin.setBounds(330, 380, 180, 25);
         label.add(repin);
         
         
           change = new JButton("Change");
        change .setBounds(355,485,150,30);
        change.addActionListener(this);
        label.add(change);
        
        back=new JButton(" Back");
        back .setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        
         setLayout(null);
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
         getContentPane().setBackground(Color.white);
    
    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==change)
         {
         try{
         String spin=pin.getText();
         String srepin=repin.getText();
         if(!spin.equals(srepin))
         {
                JOptionPane.showMessageDialog(null,"Entered pin does not match");
                repin.setText("");
                pin.setText("");
                return;  
         }
          if(spin.equals(""))
         {
                JOptionPane.showMessageDialog(null," Please Entere Pin ");
                repin.setText("");
                pin.setText("");
                return;  
         }
           if(srepin.equals(""))
         {
                JOptionPane.showMessageDialog(null,"Please Entere  Re-Pin");
                repin.setText("");
                pin.setText("");
                return;  
         }
           
           Conn conn = new Conn();
           String query="update bank set pin ='"+srepin+"' where pin='"+pinnumber+"'";
           String query1="update login set spinnumber ='"+srepin+"' where spinnumber='"+pinnumber+"'";
           String query2="update signupthree set pinnumber ='"+srepin+"' where pinnumber='"+pinnumber+"'";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            
             JOptionPane.showMessageDialog(null,"Pin Succesfully Change");
               
           setVisible(false);
            new Transaction(srepin).setVisible(true);
                   
         }
         catch(Exception e)
         {
         System.out.println(e);
         }
         }else
         {
           setVisible(false);
            new Transaction(pinnumber).setVisible(true);
                   
         
         }
     
     }
    public static void main(String args[])
    {
    new PinChange("").setVisible(true);
    }
    
}
