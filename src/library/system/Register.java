
package library.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register 
{
  
    Connection con =null;
    PreparedStatement pst=null;

    public void register()
    {
        JFrame frame =new JFrame("Register");
      frame.setSize(430,550);
      frame.setLocation(800,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      
    
        
      
      
      JLabel first_name=new JLabel("First Name:");
      JTextField firstName=new JTextField(30);
      first_name.setFont(new Font("Arial", Font.PLAIN, 20));
      first_name.setLocation(100, 100);
      firstName.setFont(new Font("Arial", Font.PLAIN, 15));
      frame.add(first_name);
      frame.add(firstName);
      
      JLabel last_name=new JLabel("Last Name:");
      JTextField lastName=new JTextField(30);
      last_name.setFont(new Font("Arial", Font.PLAIN, 20));
      last_name.setLocation(100, 100); 
      lastName.setFont(new Font("Arial", Font.PLAIN, 15));      
      frame.add(last_name);
      frame.add(lastName);
      
      
      JLabel id=new JLabel("ID:");
      JTextField ID=new JTextField(30);
      id.setFont(new Font("Arial", Font.PLAIN, 20));
      id.setLocation(100, 100);
       ID.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(id);
      frame.add(ID);
      
      JLabel password=new JLabel("Password:");
      JPasswordField Password=new JPasswordField(30);
      password.setFont(new Font("Arial", Font.PLAIN, 20));
      password.setLocation(100, 100);
       Password.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(password);
      frame.add(Password);
      
      
      
      JLabel email=new JLabel("E_mail:");
      JTextField Email=new JTextField(30);
      email.setFont(new Font("Arial", Font.PLAIN, 20));
      email.setLocation(100, 100);
       Email.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(email);
      frame.add(Email);
      
      JLabel address=new JLabel("Address:");
      JTextField Address=new JTextField(30);
      address.setFont(new Font("Arial", Font.PLAIN, 20));
      address.setLocation(100, 100);
       Address.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(address);
      frame.add(Address);
      
      JLabel phone=new JLabel("Cell_Phone:");
      JTextField Phone=new JTextField(30);
      phone.setFont(new Font("Arial", Font.PLAIN, 20));
      phone.setLocation(100, 100);
       Phone.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(phone);
      frame.add(Phone);
      
       JLabel type=new JLabel("Type:");
      JTextField Type=new JTextField(30);
      type.setFont(new Font("Arial", Font.PLAIN, 20));
      type.setLocation(100, 100);
       Type.setFont(new Font("Arial", Font.PLAIN, 15)); 
      frame.add(type);
      frame.add(Type);
      
       

      

       

      JButton button=new JButton("Sumbit");
      frame.add(button);
      button.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                  if(firstName.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full First Name");

                     
                }
               else if(lastName.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full Last Name");
                }
               
               else if(ID.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full ID");
                }
               
               else if(Password.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full Password ");
                }
                boolean check=false;
                boolean check1=false;
                for(int i=0;i<Email.getText().length();i++)
                {
                    if(Email.getText().charAt(i)=='@')
                    {
                       check=true;
                    }
                    if(Email.getText().charAt(i)=='.')
                    {
                       check1=true;
                    }
                   
                }
                if(check==false||check1==false)
                {
                    JOptionPane.showMessageDialog(frame, "Email should have @ and .");
                }
               
               else if(Address.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full Address");
                }
                
               else if(Phone.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full Phone ");
                }
               
                else if(Type.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame, "You Should Full Type ");
                }
                
              
                
                else
                {
       
                   try
                   {
                  String quary3=     "INSERT INTO `user`(`ID_user`, `password`, `type`, `First_name`, `last_name`, `address`, `CellPhone`, `Email`, `isblocked`) VALUES (?,?,?,?,?,?,?,?,?)";
                  con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                  pst=con.prepareStatement(quary3);
                  pst.setString(1, ID.getText());
                  pst.setString(2, Password.getText());
                  pst.setString(3, Type.getText());
                  pst.setString(4, firstName.getText());
                  pst.setString(5, lastName.getText());
                  pst.setString(6, Address.getText());
                  pst.setString(7, Phone.getText());
                  pst.setString(8, Email.getText());
                  pst.setString(9, "Not Blocked");
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Successful");
                  login l=new login();
                  l.setVisible(true);
                   }
                   catch(Exception ex)
                   {
                       JOptionPane.showMessageDialog(null, "Failed");
                   }
                } 
                
               
            }

         
            
        });

     
     
      frame.setVisible(true);
    } 
    
   
    public Register()
    {
       register();
        
    }
}
