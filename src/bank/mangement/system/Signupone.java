package bank.mangement.system;
import bank.mangement.system.Conn;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signupone extends JFrame implements ActionListener{
    long random;
     JTextField nametxt,fathernametxt,emailtxt,addresstxt,citytxt,pintxt,statetxt;
     JButton next;
     JRadioButton married,unmarried,other,male,female;
     JDateChooser dobtxt;
     
        

    Signupone (){
        
        setLayout(null);
        Random ran = new Random();
       random=Math.abs((ran.nextLong()%9000)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO : "+random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalinfo=new JLabel("Page 1 : Personal Details");
        personalinfo.setFont(new Font("Raleway", Font.BOLD,22));
        personalinfo.setBounds(290, 80, 400, 30);
        add(personalinfo);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100, 140, 100, 30);
        add(name);

         nametxt= new JTextField();
        nametxt.setFont(new Font("arial", Font.BOLD,14));
        nametxt.setBounds(300, 140, 200, 30);
        add(nametxt);

        JLabel Fathername=new JLabel("Father's Name : ");
        Fathername.setFont(new Font("Raleway", Font.BOLD,22));
        Fathername.setBounds(100, 190, 200, 30);
        add(Fathername);

         fathernametxt= new JTextField();
        fathernametxt.setFont(new Font("arial", Font.BOLD,14));
        fathernametxt.setBounds(300, 190, 200, 30);
        add(fathernametxt);

        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
         dobtxt=new JDateChooser() ;
        dobtxt.setBounds(300, 240, 200, 30);
        add(dobtxt);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
         male=new JRadioButton("MALE");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);
        
        
       female=new JRadioButton("FEMALE");
        female.setBounds(370, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);
       
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100, 350, 200, 30);
        add(email);
         emailtxt= new JTextField();
        emailtxt.setFont(new Font("arial", Font.BOLD,14));
        emailtxt.setBounds(300, 350, 200, 30);
        add(emailtxt);


        JLabel marital =new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD,22));
        marital.setBounds(100, 400, 200, 30);
        add(marital);
        
         married=new JRadioButton("MARRIED");
        married.setBounds(300, 400, 90, 30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(400, 400, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(500, 400, 100, 30);
        other.setBackground(Color.white);
        add(other);
       
        ButtonGroup marriedgroup=new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other);
        
        

        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100, 450, 200, 30);
        add(address);
         addresstxt= new JTextField();
        addresstxt.setFont(new Font("arial", Font.BOLD,14));
        addresstxt.setBounds(300, 450, 200, 30);
        add(addresstxt);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100, 500, 200, 30);
        add(city);
         citytxt= new JTextField();
        citytxt.setFont(new Font("arial", Font.BOLD,14));
        citytxt.setBounds(300, 500, 200, 30);
        add(citytxt);


        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100, 550, 200, 30);
        add(state);
        statetxt= new JTextField();
        statetxt.setFont(new Font("arial", Font.BOLD,14));
        statetxt.setBounds(300, 550, 200, 30);
        add(statetxt);

        JLabel pin=new JLabel("Pin Code : ");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100, 600, 200, 30);
        add(pin);
         pintxt= new JTextField();
        pintxt.setFont(new Font("arial", Font.BOLD,14));
        pintxt.setBounds(300, 600, 200, 30);
        add(pintxt);
         
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        


        getContentPane().setBackground(Color.white);

        setSize(800,750);
        setVisible(true);
        setLocation(350, 10);
    }
       public void actionPerformed(ActionEvent ae){
       String formno=""+ random;
       String name=nametxt.getText();
        String fathername=fathernametxt.getText();
         String dob= ((JTextField)dobtxt.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected())
         {
             gender="male";
         }
         else if(female.isSelected())
         {
             gender="female";
         }
         String email=emailtxt.getText();
           String marital=null;
         if(married.isSelected())
         {
             gender="married";
         }
         else if(unmarried.isSelected())
         {
             gender="unmarried";
         }
         else if(other.isSelected())
         {
             gender="other";
         }
         String city=citytxt.getText();
         String state=statetxt.getText();
         String pin=pintxt.getText();
         String address=addresstxt.getText();
         
         try{
         if(name.equals(""))
         {
             JOptionPane.showMessageDialog(null, "Name is Required");
         }
         else{
         Conn c= new Conn();
         String query="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+city+"','"+state+"','"+pin+"','"+address+"','"+gender+"','"+email+"','"+dob+"')";
         c.s.executeUpdate(query);
         setVisible(false);
         new Signuptwo(formno).setVisible(true);
         }
         }
         catch(Exception e){
         System.out.println(e);
         }
         
         
       }
       
    
    public static void main(String[] args) {
        new Signupone();
    }
    
}
