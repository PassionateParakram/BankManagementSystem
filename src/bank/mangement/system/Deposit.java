
package bank.mangement.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;


public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    
    JButton deposit,back;
    String pin;
   
    Deposit(String pin){ 
        
        this.pin=pin;
        setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         label.setBounds(0,0,900,900);
         add(label);
         
         JLabel text=new JLabel("Enter the Amount you Want to Deposit");
          text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        text.setBounds(180, 300, 700, 35);
        label.add(text);
        
      amount =new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,380,320,40);
        label.add(amount);
        
        deposit = new JButton("Deposit");
        deposit .setBounds(355,485,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        back=new JButton(" Back");
        back .setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
         
          getContentPane().setBackground(Color.white);}
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== deposit){
         String number=amount.getText();
         Date date= new Date();
         if(number.equals(""))
         {
             JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
         }
         else{
             try{
                    Conn conn =new Conn();
                    String query="insert into bank values('"+pin+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs  "+number+"  Deposit Succesfull");
               setVisible(false);
            new Transaction(pin).setVisible(true);
                   
             
             
             }
             catch(Exception e)
             {
             System.out.print(e);
             }
         
         }
         
         }
         else if(ae.getSource()== back)
         {
             setVisible(true);
             new Transaction("").setVisible(true);
         }
     
     
     }
    
    
    
    public static void main(String ar[])
    {
    new Deposit("");
    }
}
