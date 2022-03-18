
package library.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


  


public final class Reader extends Person
{
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    JFrame reader =new JFrame("Reader");
    JButton search_book=new JButton("Search Book");
    JButton search_person=new JButton("Search User");
    JButton add_orderlist=new JButton("Add Book To Order List");
    JButton rent_book=new JButton("Rent Book");
    JButton log_out=new JButton("Log Out");
    JButton back=new JButton("Back");
    
    public void search_book()
    {
        reader.add(search_book);
         
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
                JTextField ID_search_book=new JTextField(30);
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
                            back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Reader l=new Reader();
            }
            
        });
      
                            
                        }
                    }
            
        });
                search.setVisible(true);
                
            }
            
        });
    }
    
    public void search_User()
    {
         reader.add(search_person);
         search_person.addActionListener(new ActionListener() 
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
                 JTextField ID_search_person=new JTextField(30);
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
                            back.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 Reader l=new Reader();
            }
            
        });
                            
                            
                        
                        }
                    }
                    
            
        });
                search_person.setVisible(true);
                
            }
            
        });
      
    }
    
    public void add_book_to_orderlist()
    {
        reader.add(add_orderlist);
         add_orderlist.addActionListener(new ActionListener() 
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
                
                Reader l=new Reader();
            }
            
        });
               
               orderlist.setVisible(true);
            }
            
        });
    }
    
    @Override
    public void rent_book()
    {
        reader.add(rent_book);
         rent_book.addActionListener(new ActionListener() 
      {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFrame rent =new JFrame("Add Book");
                rent.setSize(430,550);
                rent.setLocation(800, 200);
                rent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rent.setLayout(new FlowLayout());
                
                JLabel book_number=new JLabel("Book Number:");
                JTextField Book_Number=new JTextField(30);
                book_number.setFont(new Font("Arial", Font.PLAIN, 20));
                book_number.setLocation(100, 100);
                Book_Number.setFont(new Font("Arial", Font.PLAIN, 15)); 
                rent.add(book_number);
                rent.add(Book_Number);
                
                JLabel id_user=new JLabel("ID:");
                JTextField ID_User=new JTextField(30);
                id_user.setFont(new Font("Arial", Font.PLAIN, 20));
                id_user.setLocation(100, 100);
                ID_User.setFont(new Font("Arial", Font.PLAIN, 15)); 
                rent.add(id_user);
                rent.add(ID_User);
                
                JLabel date=new JLabel("Date:");
                JTextField Date=new JTextField(30);
                date.setFont(new Font("Arial", Font.PLAIN, 20));
                date.setLocation(100, 100);
                Date.setFont(new Font("Arial", Font.PLAIN, 15)); 
                rent.add(date);
                rent.add(Date);
                
                JLabel name_book=new JLabel("Name Of Book:");
                JTextField name_Book=new JTextField(30);
                name_book.setFont(new Font("Arial", Font.PLAIN, 20));
                name_book.setLocation(100, 100);
                name_Book.setFont(new Font("Arial", Font.PLAIN, 15)); 
                rent.add(name_book);
                rent.add(name_Book);
                
                
                JButton Rent=new JButton("Add");
                rent.add(Rent);
                rent.add(back);
                
                Rent.addActionListener(new ActionListener() 
            
            {
                   
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              
                if(Book_Number.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(rent, "You Should Full Book Number");
                     
                }
               else if(ID_User.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(rent, "You Should Full ID");
                     
                }
               else if(Date.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(rent, "You Should Full Date");
                     
                }
               else if(name_Book.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(rent, "You Should Full Date");
                     
                }
                else
               {
                    try 
                    {
                        
                      String quary10="INSERT INTO `rent`(`bookNumber`, `ID_user`, `Date`,`Name of book`) VALUES (?,?,?,?)";
                      con=DriverManager.getConnection("jdbc:mysql://localhost/library system","root","");
                      pst=con.prepareStatement(quary10);
                      pst.setString(1, Book_Number.getText());
                      pst.setString(2, ID_User.getText());
                      pst.setString(3, Date.getText());
                      pst.setString(4, name_Book.getText());
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
                
                Reader l=new Reader();
            }
            
        });
                rent.setVisible(true);
                
            }
            
        });
    }
    
     public void logout()
     {
        reader.add(log_out);
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
    
    
      public  void my_frame()
      {
           
           reader.setSize(430,550);
           reader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           reader.setLocation(800, 200);
           reader.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
           reader.setVisible(true);
           
           this.search_book();
           this.search_User();
           this.add_book_to_orderlist();
           this.rent_book();
           this.logout();
           
           reader.setVisible(true);
           
      }
      
      public Reader()
      {
        
        my_frame();
      }
}
