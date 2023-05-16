package bank.mangement.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
     
    JButton Clear,Signin,login;
    JTextField cardtxt;
    JPasswordField pintxt;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        setSize(800,480);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3 );
         add(label);
         getContentPane().setBackground(Color.white);
         label.setBounds(70, 10, 100, 100);


         JLabel text=new JLabel("Welcome To ATM");
         text.setFont(new Font("Osward", Font.BOLD,38));
         text.setBounds(200, 40, 400, 40);
         add(text);

         JLabel CardNo=new JLabel("Card No:");
         CardNo.setFont(new Font("Raleway", Font.BOLD,28));
         CardNo.setBounds(120, 150, 150, 30);
         add(CardNo);

        cardtxt=new JTextField();
         cardtxt.setBounds(300, 150, 250, 30);
         add(cardtxt);



         JLabel Pin=new JLabel("Pin:");
         Pin.setFont(new Font("Raleway", Font.BOLD,28));
         Pin.setBounds(120, 200, 400, 30);
         add(Pin);

        pintxt=new  JPasswordField();
        pintxt.setBounds(300, 200, 250, 30);
         add(pintxt);

         login =new JButton("Sign In");
         login.setBounds(300, 300, 100, 30);
         login.addActionListener(this);
         add(login);

         Clear =new JButton("Clear");
         Clear.setBounds(410, 300, 100, 30);
         Clear.addActionListener(this);
         add(Clear);

         Signin =new JButton("Sign Up");
         Signin.setBounds(300, 340, 210, 30);
         Signin.addActionListener(this);
         add(Signin);

        setVisible(true);
        setLocation(350, 200);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Clear){
            cardtxt.setText("");
            pintxt.setText("");

        }else if(ae.getSource()==Signin){
            setVisible(false);
            new Signupone().setVisible(true);
        }
        else if(ae.getSource()==login){
            
            Conn conn =new Conn();
            String Cardnumber=cardtxt.getText();
            String pin=pintxt.getText();
            String query = "select * from login where scardnumber='"+Cardnumber+"' and spinnumber ='"+pin+"'";
            try{
            ResultSet rs =conn.s.executeQuery(query);
            if(rs.next()){
            setVisible(false);
            new Transaction(pin).setVisible(true);
            
            }else{
                JOptionPane.showMessageDialog(null,"Incorrect Cardnuumber or Pin");
            }
            
            }catch(Exception e){
            System.out.println(e);
            }
            

        }

    }
    public static void main(String[] args) {
       new Login();
    }
}