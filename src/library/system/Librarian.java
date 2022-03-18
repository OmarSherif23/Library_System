
package library.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public final class Librarian extends Person
{
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    PreparedStatement ss=null;
     JTextField Name;
     JTextField ID_add;
     JTextField Number;
     JTextField ID_remove;
     JTextField ID_user_remove;
     JTextField ID_search_person;
     JTextField ID_search_book;
     JTextField ID_rent;
     JTextField Price;
     JFrame librarian=new JFrame("Librarian");
     JButton add_book=new JButton("Add Book");
     JButton remove_book=new JButton("Remove Book");
     JButton add_user=new JButton("Add User");
     JButton remove_user=new JButton("Remove User");
      JButton search_book=new JButton("Search Book");
      JButton search_user=new JButton("Search User");
      JButton add_book_orderlist=new JButton("Add Book To Order List");
      JButton remove_book_orderlist=new JButton("Remove Book To Order List");
      JButton block_user=new JButton("Block User");
      JButton rent_book=new JButton("Rent Book");
      JButton log_out=new JButton("Log Out");
       JButton back=new JButton("Back");
      
      
     public void add_book()
      {
       librarian.add(add_book);
      
      add_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                JFrame frame3 =new JFrame("Add Book");
                frame3.setSize(430,550);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setLocation(800, 200);
                frame3.setLayout(new FlowLayout());
                
                
                JLabel name=new JLabel("Name:");
                 Name=new JTextField(30);
                name.setFont(new Font("Arial", Font.PLAIN, 20));
                name.setLocation(100, 100);
                Name.setFont(new Font("Arial", Font.PLAIN, 15)); 
                frame3.add(name);
                frame3.add(Name);
                
                JLabel id=new JLabel("ID:");
                 ID_add=new JTextField(30);
                id.setFont(new Font("Arial", Font.PLAIN, 20));
                id.setLocation(100, 100);
                ID_add.setFont(new Font("Arial", Font.PLAIN, 15)); 
                frame3.add(id);
                frame3.add(ID_add);
          
                
                JLabel price=new JLabel("Price:");
                 Price=new JTextField(30);
                price.setFont(new Font("Arial", Font.PLAIN, 20));
                price.setLocation(100, 100);
                Price.setFont(new Font("Arial", Font.PLAIN, 15)); 
                frame3.add(price);
                frame3.add(Price);
                
                
                JButton ok=new JButton("Add");
                frame3.add(ok);
                frame3.add(back);
                
                ok.addActionListener(new ActionListener() 
            
            {
                    
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              
                if(Name.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame3, "You Should Full Name");
                     
                }
               else if(ID_add.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame3, "You Should Full ID");
                     
                }
               else if(price.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(frame3, "You Should Full First The Price");
                     
                }
                else
               {
                    try 
                    {
                        
                      String quary1="INSERT INTO `books`(`bookNumber`, `name` , `price`) VALUES (?,?,?)";
                      con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                      pst=con.prepareStatement(quary1);
                      pst.setString(1, ID_add.getText());
                      pst.setString(2, Name.getText());
                     
                      pst.setString(3, Price.getText());
                      pst.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Successful");
                      
                    } 
                    catch (SQLException ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Falied");
                    }
               
               }

            }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                frame3.setVisible(true);
                
            }
            
        });
      
      }
     
     public void remove_book()
     {
         librarian.add(remove_book);
         remove_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
               JFrame remove=new JFrame("Remove Book");
               remove.setSize(430,550);
               remove.setLocation(800, 200);
                remove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                remove.setLayout(new FlowLayout());
                
                JLabel id_remove=new JLabel("ID:");
                 ID_remove=new JTextField(30);
                id_remove.setFont(new Font("Arial", Font.PLAIN, 20));
                id_remove.setLocation(100, 100);
                ID_remove.setFont(new Font("Arial", Font.PLAIN, 15)); 
                remove.add(id_remove);
                remove.add(ID_remove);
               
                JButton remove_id=new JButton("Remove");
                remove.add(remove_id);
                remove.add(back);
                
               
                remove_id.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        if(ID_remove.getText().equals(""))
                        {
                          JOptionPane.showMessageDialog(remove, "You Should Full ID");
                     
                        }
                        else
                        {
                            try
                            {
                                String quary5 ="SELECT * FROM `books` WHERE bookNumber=?";
                            con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                            pst=con.prepareStatement(quary5);
                             pst.setString(1, ID_remove.getText());
                             rs=pst.executeQuery();
                           
                           if(rs.next())
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Correct");
                           
                            String quary2="DELETE FROM `books` WHERE bookNumber='"+ID_remove.getText()+"'";
                                   
                             
                             pst=con.prepareStatement(quary2);
                             pst.execute();
                             JOptionPane.showMessageDialog(null, "Successful");
                             
                          
                          }
                          else
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Not Correct");
                           ID_remove.setText("");
                          }
                            }
                            catch(Exception ex)
                            {
                                 JOptionPane.showMessageDialog(null, "Failed");
                            }
                        
                        
                        }
                    }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                remove.setVisible(true);
               
            }
            
        });
      
     }
     
     public void add_user()
     {
          librarian.add(add_user);
         add_user.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Register r=new Register();
            }
            
        });
     }
     
     public void remove_user()
     { 
         librarian.add(remove_user);
         remove_user.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFrame remove_user=new JFrame("Remove user");
               remove_user.setSize(430,550);
               remove_user.setLocation(800, 200);
                remove_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                remove_user.setLayout(new FlowLayout());
                
                JLabel id_remove_user=new JLabel("ID:");
                 ID_user_remove=new JTextField(30);
                id_remove_user.setFont(new Font("Arial", Font.PLAIN, 20));
                id_remove_user.setLocation(100, 100);
                ID_user_remove.setFont(new Font("Arial", Font.PLAIN, 15)); 
                remove_user.add(id_remove_user);
                remove_user.add(ID_user_remove);
               
                JButton remove_id_user=new JButton("Remove");
                remove_user.add(remove_id_user);
                remove_user.add(back);
                
                remove_id_user.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        
                        if(ID_user_remove.getText().equals(""))
                       {
                          JOptionPane.showMessageDialog(remove_user, "You Should Full ID");
                     
                       }
                        else
                        {
                            try
                            {
                                String quary6 ="SELECT `ID_user`, `password`, `type`, `First_name`, `last_name`, `address`, `CellPhone`, `Email`, `isblocked` FROM `user` WHERE ID_user=?";
                            con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                            pst=con.prepareStatement(quary6);
                             pst.setString(1, ID_user_remove.getText());
                             rs=pst.executeQuery();
                           
                           if(rs.next())
                          {
                              JOptionPane.showMessageDialog(null, "The Information Is Correct");
                             String quary4="DELETE FROM `user` WHERE ID_user='"+ID_user_remove.getText()+"' ";
                             
                             pst=con.prepareStatement(quary4);
                             
                             pst.executeUpdate();
                             JOptionPane.showMessageDialog(null, "Successful");
                             
                          }
                            }
                            catch(Exception ex)
                            {
                                JOptionPane.showMessageDialog(null, "Failed");
                            
                            }
                       
                        }
                    }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                remove_user.setVisible(true);
                
            }
            
        });
     }
     
     public void search_book()
     {
         librarian.add(search_book);
         
      search_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
               JFrame search=new JFrame("Search Book");
                search.setSize(430,550);
                search.setLocation(800, 200);
                search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 search.setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
                
                JLabel id_search=new JLabel("ID:");
                 ID_search_book=new JTextField(30);
                id_search.setFont(new Font("Arial", Font.PLAIN, 20));
                id_search.setBounds(0,0,100, 100);
                ID_search_book.setFont(new Font("Arial", Font.PLAIN, 15)); 
                ID_search_book.setBounds(30,40, 200, 20);
                search.add(id_search);
                search.add(ID_search_book);
               
                JButton id_search_book=new JButton("Search");
                search.add(id_search_book);
                
               
                search.add(back);
                
                 JLabel BookNumber=new JLabel("BookNumber");
                JLabel Name=new JLabel("Name");
                JLabel NumberOfCopies=new JLabel("NumberOfCopies");
                JLabel Price=new JLabel("price");
                JLabel BookNumber1=new JLabel();
                JLabel Name1=new JLabel();
                JLabel NumberOfCopies1=new JLabel();
                JLabel Price1=new JLabel();
                
                            
                BookNumber.setFont(new Font("Arial", Font.PLAIN, 15));
                Name.setFont(new Font("Arial", Font.PLAIN, 15));
                NumberOfCopies.setFont(new Font("Arial", Font.PLAIN, 15));
                Price.setFont(new Font("Arial", Font.PLAIN, 15));
                BookNumber1.setFont(new Font("Arial", Font.PLAIN, 15));
                Name1.setFont(new Font("Arial", Font.PLAIN, 15));
                NumberOfCopies1.setFont(new Font("Arial", Font.PLAIN, 15));
                Price1.setFont(new Font("Arial", Font.PLAIN, 15));

                
              
                
               
                id_search_book.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        
                        if(ID_search_book.getText().equals(""))
                         {
                            JOptionPane.showMessageDialog(search, "You Should Full ID");
                     
                         }
                        else
                        {
                            try
                            {
                                 String quary5 ="SELECT * FROM `books` WHERE bookNumber=?";
                            con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                            pst=con.prepareStatement(quary5);
                             pst.setString(1, ID_search_book.getText());
                             rs=pst.executeQuery();
                           
                           if(rs.next())
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Correct");
                           
                         
                           search.add(BookNumber);
                           search.add(Name);
                           
                           search.add(Price);
                           search.add(BookNumber1);
                           search.add(Name1);
                           
                           search.add(Price1);
                           
                            BookNumber1.setText(rs.getString("bookNumber"));
                           Name1.setText(rs.getString("name"));
                           
                           Price1.setText(rs.getString("price"));
                           
                           
                           
                          }
                          
                          else
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Not Correct");
                           ID_search_book.setText("");
                
                          }
                           
                          
            
                            }
                            catch(Exception ex)
                            {
                                JOptionPane.showMessageDialog(null, "");
                            }
                          
      
                            
                        }
                    }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                search.setVisible(true);
                
            }
            
        });
      
     }
     
     public void search_person()
     {
         librarian.add(search_user);
         search_user.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
               JFrame search_person=new JFrame("search person");
               search_person.setSize(430,550);
               search_person.setLocation(800, 200);
                search_person.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                search_person.setLayout(new FlowLayout( FlowLayout.CENTER,10,60));
                
                JLabel id_search_person=new JLabel("ID:");
                 ID_search_person=new JTextField(30);
                id_search_person.setFont(new Font("Arial", Font.PLAIN, 20));
                id_search_person.setLocation(100, 100);
                ID_search_person.setFont(new Font("Arial", Font.PLAIN, 15)); 
                search_person.add(id_search_person);
                search_person.add(ID_search_person);
                
                JLabel iduser=new JLabel("Id User");
                 JLabel firstname=new JLabel("First Name");
                JLabel lastname=new JLabel("Last Name");
                JLabel type=new JLabel("Type");
                JLabel address=new JLabel("Address");
                JLabel cellphone=new JLabel("Phone");
                JLabel email=new JLabel("Email");
                JLabel isblocked=new JLabel("Is Blocked");
                
                 JLabel paaword=new JLabel("password");
                
                            
                iduser.setFont(new Font("Arial", Font.PLAIN, 15));
                firstname.setFont(new Font("Arial", Font.PLAIN, 15));
                lastname.setFont(new Font("Arial", Font.PLAIN, 15));
                type.setFont(new Font("Arial", Font.PLAIN, 15));
                address.setFont(new Font("Arial", Font.PLAIN, 15));
                cellphone.setFont(new Font("Arial", Font.PLAIN, 15));
                email.setFont(new Font("Arial", Font.PLAIN, 15));
                isblocked.setFont(new Font("Arial", Font.PLAIN, 15));
                
                JLabel iduser1=new JLabel();
                 JLabel firstname1=new JLabel();
                JLabel lastname1=new JLabel();
                JLabel type1=new JLabel();
                JLabel address1=new JLabel();
                JLabel cellphone1=new JLabel();
                JLabel email1=new JLabel();
                JLabel isblocked1=new JLabel();
                
                 JLabel paaword1=new JLabel();
                
                            
                iduser1.setFont(new Font("Arial", Font.PLAIN, 15));
                firstname1.setFont(new Font("Arial", Font.PLAIN, 15));
                lastname1.setFont(new Font("Arial", Font.PLAIN, 15));
                type1.setFont(new Font("Arial", Font.PLAIN, 15));
                address1.setFont(new Font("Arial", Font.PLAIN, 15));
                cellphone1.setFont(new Font("Arial", Font.PLAIN, 15));
                email1.setFont(new Font("Arial", Font.PLAIN, 15));
                isblocked1.setFont(new Font("Arial", Font.PLAIN, 15));
                
                    
               
                JButton id_search=new JButton("Search");
                search_person.add(id_search);
                search_person.add(back);
                
               
                id_search.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        
                        if(ID_search_person.getText().equals(""))
                        {
                          JOptionPane.showMessageDialog(search_book, "You Should Full ID");
                     
                        }
                        
                        else
                        {
                            try
                            {
                                 String quary6 ="SELECT * FROM `user` WHERE ID_user=?";
                            con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                            pst=con.prepareStatement(quary6);
                             pst.setString(1, ID_search_person.getText());
                             rs=pst.executeQuery();
                           
                           if(rs.next())
                          {
                              JOptionPane.showMessageDialog(null,"The Information Is Correct");
                              search_person.add(firstname);
                              search_person.add(lastname);
                              search_person.add(iduser);
                              search_person.add(type);
                              search_person.add(address);
                              search_person.add(cellphone);
                              search_person.add(email);
                              search_person.add(isblocked);
                              search_person.add(paaword);
                
                              search_person.add(firstname1);
                              search_person.add(lastname1);
                              search_person.add(iduser1);
                              search_person.add(type1);
                              search_person.add(address1);
                              search_person.add(cellphone1);
                              search_person.add(email1);
                              search_person.add(isblocked1);
                              search_person.add(paaword1);
                           iduser1.setText(rs.getString("ID_user"));
                           firstname1.setText(rs.getString("First_name")); 	
                           lastname1.setText(rs.getString("last_name"));
                           type1.setText(rs.getString("type"));
                           address1.setText (rs.getString("address"));
                           paaword1.setText(rs.getString("password"));
                           cellphone1.setText(rs.getString("CellPhone"));
                           email1.setText(rs.getString("Email"));
                           isblocked1.setText(rs.getString("isblocked"));

                           
                           
                          }
                           
                          else
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Not Correct");
                           ID_search_person.setText("");
                
                          }
                           
                            }
                            catch(Exception ex)
                            {
                                JOptionPane.showMessageDialog(null, "");
                            }
                           
                        }
                    }
                    
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                search_person.setVisible(true);
                
            }
            
        });
      
     }
     
     public void add_book_to_orderlist()
     {
         librarian.add(add_book_orderlist);
          add_book_orderlist.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFrame orderlist=new JFrame();
                orderlist.setSize(430,550);
                orderlist.setLocation(800, 200);
                orderlist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                orderlist.setLayout(new FlowLayout());
                
               JLabel id_orderlist=new JLabel("ID_user:");
               JTextField ID_orderlist=new JTextField(30);
               id_orderlist.setFont(new Font("Arial", Font.PLAIN, 20));
               id_orderlist.setLocation(100, 100);
               ID_orderlist.setFont(new Font("Arial", Font.PLAIN, 15)); 
               orderlist.add(id_orderlist);
               orderlist.add(ID_orderlist);
               
               JLabel name_book=new JLabel("Name Of Book:");
               JTextField Name=new JTextField(30);
               name_book.setFont(new Font("Arial", Font.PLAIN, 20));
               name_book.setLocation(100, 100);
               Name.setFont(new Font("Arial", Font.PLAIN, 15)); 
               orderlist.add(name_book);
               orderlist.add(Name);
               
               JButton add_book =new JButton("Add");
               orderlist.add(add_book);
               orderlist.add(back);
               
               add_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(ID_orderlist.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(orderlist, "You Should Full ID");
                     
                }
               else if(Name.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(orderlist, "You Should Full Name");
                     
                }
                else
               {
                try{
                  String quary7="INSERT INTO `order list`(`ID_user`, `name_of_book`) VALUES (?,?)";
                  con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                  pst=con.prepareStatement(quary7);
                  pst.setString(1, ID_orderlist.getText());
                  pst.setString(2, Name.getText());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Successful");
                  
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Failed");
                }
            }
            }
            
        });
           back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });    
               orderlist.setVisible(true);
            }
            
        });
         
     }
     
     public void remove_book_from_orderlist()
     {
          librarian.add(remove_book_orderlist);
          remove_book_orderlist.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
               JFrame remove_orderlist=new JFrame("Remove Book");
               remove_orderlist.setSize(430,550);
               remove_orderlist.setLocation(800, 200);
                remove_orderlist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                remove_orderlist.setLayout(new FlowLayout());
                
                JLabel id_remove_book=new JLabel("ID:");
                JTextField ID_orderlist=new JTextField(30);
                id_remove_book.setFont(new Font("Arial", Font.PLAIN, 20));
                id_remove_book.setLocation(100, 100);
                ID_orderlist.setFont(new Font("Arial", Font.PLAIN, 15)); 
                remove_orderlist.add(id_remove_book);
                remove_orderlist.add(ID_orderlist);
               
                JButton Id_remove=new JButton("Remove");
                remove_orderlist.add(Id_remove);
                remove_orderlist.add(back);
                
               
                Id_remove.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        if(ID_orderlist.getText().equals(""))
                        {
                          JOptionPane.showMessageDialog(remove_orderlist, "You Should Full ID");
                     
                        }
                        else
                        {
                            try
                            {
                             String quary8="DELETE FROM `order list` WHERE ID_user=?";
                             con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                             pst=con.prepareStatement(quary8);
                             pst.setString(1, ID_orderlist.getText());
                             pst.executeUpdate();
                             JOptionPane.showMessageDialog(null, "Successful");
                             
                            }
                            catch(Exception ex)
                            {
                                 JOptionPane.showMessageDialog(null, "Failed");
                            }
                        
                        }
                    }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                remove_orderlist.setVisible(true);
                
            }
            
        });
         
     }
     
     public void block_user()
       {
//         r=ss.executeQuery(query8);
//while(r.next()){
//    
//
// 
//
//  query8="SELECT  `Date` FROM `rent` WHERE id_user=(423413)";
//        
//  java.sql.Date y=r.getDate(1);
//  System.out.println(r.getDate(1));
//  
//java.util.Date date=new java.util.Date();
// java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
// 
//System.out.println(sqlDate);
//
// int x=y.compareTo( sqlDate);
//if(x<0){
//a="UPDATE `user` SET`isblocked`='blocked' WHERE id=435428";
//ss.execute(a);
//}
//else {System.out.println("still have time to return book");}   
//}
     }
     
    @Override
     public void rent_book()
     {
         librarian.add(rent_book);
         
      rent_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
               JFrame rent=new JFrame("Rent Book");
               rent.setSize(430,550);
               rent.setLocation(800, 200);
                rent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rent.setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
                
                JLabel id_rent=new JLabel("ID:");
                 ID_rent=new JTextField(30);
                id_rent.setFont(new Font("Arial", Font.PLAIN, 20));
                id_rent.setLocation(100, 100);
                ID_rent.setFont(new Font("Arial", Font.PLAIN, 15)); 
                rent.add(id_rent);
                rent.add(ID_rent);
               
                
                JLabel booknumber=new JLabel("BookNumber");
                JLabel idUser=new JLabel("Name");
                JLabel date=new JLabel("NumberOfCopies");
                JLabel nameofbook=new JLabel("price");
               JLabel booknumber1=new JLabel("BookNumber");
                JLabel idUser1=new JLabel("Name");
                JLabel date1=new JLabel("NumberOfCopies");
                JLabel nameofbook1=new JLabel("price");
                
                            
                booknumber.setFont(new Font("Arial", Font.PLAIN, 15));
                idUser.setFont(new Font("Arial", Font.PLAIN, 15));
                date.setFont(new Font("Arial", Font.PLAIN, 15));
                nameofbook.setFont(new Font("Arial", Font.PLAIN, 15));
                booknumber1.setFont(new Font("Arial", Font.PLAIN, 15));
                idUser1.setFont(new Font("Arial", Font.PLAIN, 15));
                date1.setFont(new Font("Arial", Font.PLAIN, 15));
                nameofbook1.setFont(new Font("Arial", Font.PLAIN, 15));

                
              
               
                JButton id_search=new JButton("Search");
                rent.add(id_search);
                 rent.add(back);
                
               
                id_search.addActionListener(new ActionListener() 
            
                 {
                      @Override
                     public void actionPerformed(ActionEvent e) 
                    {
                        
                        if(ID_rent.getText().equals(""))
                         {
                            JOptionPane.showMessageDialog(rent, "You Should Full ID");
                     
                         }
                        else
                        {
                            try
                            {
                                 String quary9 ="SELECT * FROM `rent` where ID_user=?";
                            con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                            pst=con.prepareStatement(quary9);
                             pst.setString(1, ID_rent.getText());
                             rs=pst.executeQuery();
                           
                           if(rs.next())
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Correct");
                           rent.add(booknumber);
                           rent.add(idUser);
                           rent.add(date);
                           rent.add(nameofbook);
                           rent.add(booknumber1);
                           rent.add(idUser1);
                           rent.add(date1);
                           rent.add(nameofbook1);
                           booknumber1.setText(rs.getString("bookNumber"));
	
                           idUser1.setText(rs.getString("ID_user"));
                           date1.setText(rs.getString("Date"));
                           nameofbook1.setText(rs.getString("Name of book"));
                          }
                          else
                          {
                           JOptionPane.showMessageDialog(null,"The Information Is Not Correct");
                           ID_rent.setText("");
                
                          }
                           
                          
            
                            }
                            catch(Exception ex)
                            {
                                JOptionPane.showMessageDialog(null, "Faild");
                            }
                            
                        }
                    }
            
        });
                back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Librarian l=new Librarian();
            }
            
        });
                rent.setVisible(true);
                
            }
            
        });
      
         
     }
     
     public void logout()
     {
        librarian.add(log_out);
        log_out.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                login l=new login();
                l.setVisible(true);
            }
            
        });
      
        
     }
      
      public void my_frame()
     {
         
      librarian.setSize(430,550);
      librarian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      librarian.setLocation(800, 200);
      librarian.setLayout(new FlowLayout(FlowLayout.CENTER,70,30));
          
      this.add_book();
      this.remove_book();
      this.add_user();
      this.remove_user();
      this.search_book();
      this.search_person();
      this.add_book_to_orderlist();
      this.remove_book_from_orderlist();
      this.block_user();
      this.rent_book();
      this.logout();
      
      librarian.setVisible(true);
      
     }
     
    
    public Librarian()
    {
       
       my_frame();
    }
   
}
