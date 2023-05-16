package bank.mangement.system;
import bank.mangement.system.Conn;
import bank.mangement.system.Signupthree;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signuptwo extends JFrame implements ActionListener{
   
     JTextField edutxt,aadtxt,occutxt,pantxt;
     JButton next;
     JRadioButton Cno,cyes,eyes,eno;
      JComboBox religiolist,categorylist,incomelist;
      String formno;

    Signuptwo (String formno){
        
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM 2");
        
        JLabel additionalinfo=new JLabel("Page 2 : Additional Details");
        additionalinfo.setFont(new Font("Raleway", Font.BOLD,22));
        additionalinfo.setBounds(290, 80, 400, 30);
        add(additionalinfo);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD,22));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String rel[]={"Hindu","Muslim","Christian","Sikh","Other"};
         religiolist = new JComboBox(rel);
        religiolist.setFont(new Font("arial", Font.BOLD,14));
        religiolist.setBounds(300, 140, 200, 30);
        add(religiolist);

        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD,22));
        category.setBounds(100, 190, 200, 30);
        add(category);

         String cat[]={"General","SC","ST","OBC","Other"};
      categorylist = new JComboBox(cat);
        
        categorylist.setFont(new Font("arial", Font.BOLD,14));
        categorylist.setBounds(300, 190, 200, 30);
        add(categorylist);

        JLabel inc=new JLabel("Income : ");
        inc.setFont(new Font("Raleway", Font.BOLD,22));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        
        String income[]={"<1,50,000","2,50,000","<5,00,000","<7,50,000","More than 7,50,000"};
        incomelist = new JComboBox(income);
        incomelist.setFont(new Font("Raleway", Font.BOLD,22));
        incomelist.setBounds(300, 240, 200, 30);
        add(incomelist);

        JLabel gender=new JLabel("Education");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100, 295, 200, 30);
        add(gender);
         edutxt= new JTextField();
        edutxt.setFont(new Font("arial", Font.BOLD,14));
        edutxt.setBounds(300, 295, 200, 30);
        add(edutxt);
     
        JLabel email=new JLabel("Occupation");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100, 350, 200, 30);
        add(email);
         occutxt= new JTextField();
        occutxt.setFont(new Font("arial", Font.BOLD,14));
        occutxt.setBounds(300, 350, 200, 30);
        add(occutxt);


        
        JLabel city=new JLabel("Senior Citizen: ");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100, 400, 200, 30);
        add(city);
        
         cyes=new JRadioButton("YES");
        cyes.setBounds(300, 400, 90, 30);
        cyes.setBackground(Color.white);
        add(cyes);
        
      Cno=new JRadioButton("NO");
        Cno.setBounds(400, 400, 100, 30);
        Cno.setBackground(Color.white);
        add(Cno);
        
     
       
        ButtonGroup marriedgroup=new ButtonGroup();
        marriedgroup.add(Cno);
        marriedgroup.add(cyes);
       
        

        JLabel address=new JLabel("Aadhar Number ");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100, 450, 200, 30);
        add(address);
         aadtxt= new JTextField();
        aadtxt.setFont(new Font("arial", Font.BOLD,14));
        aadtxt.setBounds(300, 450, 200, 30);
        add(aadtxt);

        JLabel marital =new JLabel("PAN Number : ");
        marital.setFont(new Font("Raleway", Font.BOLD,22));
        marital.setBounds(100, 500, 200, 30);
        add(marital);
         pantxt= new JTextField();
        pantxt.setFont(new Font("arial", Font.BOLD,14));
        pantxt.setBounds(300, 500, 200, 30);
        add(pantxt);


        JLabel state=new JLabel("Existing Account: ");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100, 550, 200, 30);
        add(state);
         eyes=new JRadioButton("YES");
        eyes.setBounds(300, 550, 90, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("NO");
        eno.setBounds(400, 550, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
     
       
        ButtonGroup Exist=new ButtonGroup();
        Exist.add(eno);
        Exist.add(eyes);
        
         
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
           
           
         //1
         String srelegion=(String) religiolist.getSelectedItem();
         //2
         String scategory=(String) categorylist.getSelectedItem();
         //3
         String sincome= (String)incomelist.getSelectedItem();
         //4
         String seniorcitizen=null;
         
         if(Cno.isSelected())
         {
             seniorcitizen="NO";
         }
         else if(cyes.isSelected())
         {
             seniorcitizen="YES";
         }
         //5
         String seducation=(String)edutxt.getText();
         //6
           String scustomer=null;
         if(eyes.isSelected())
         {
             scustomer="YES";
         }
         else if(eno.isSelected())
         {
             scustomer="NO";
         }
       //7
         String span=(String)pantxt.getText();
         //8
         String saadhar=(String)aadtxt.getText();
         //9
         String soccupation=(String)occutxt.getText();
       
         
         try{
        
         Conn c= new Conn();
         String query="insert into signuptwo values('"+formno+"','"+srelegion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+scustomer+"','"+span+"','"+saadhar+"')";
         c.s.executeUpdate(query);
         
         setVisible(false);
          new Signupthree(formno).setVisible(true);
         }
         
         catch(Exception e){
         System.out.println(e);
         }
         
         
       }
       
    
    public static void main(String[] args) {
        new Signuptwo("");
    }
    
}
