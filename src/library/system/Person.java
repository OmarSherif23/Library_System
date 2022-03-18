
package library.system;


public abstract class Person 
{
   private final int id ;
private  int password ;
private String type ;
private  String f_name ;
private  String l_name ;
private  String address ;

    public Person(int id) {
        this.id = id;
    }
private int cellphone ;
private String email ;
private boolean isblocked ;


    public Person(int id, int password, String type, String f_name, String l_name, String address, int cellphone, String email, boolean isblocked) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.f_name = f_name;
        this.l_name = l_name;
        this.address = address;
        this.cellphone = cellphone;
        this.email = email;
        this.isblocked = isblocked;
    }
    public Person()
    {
         this.id = 0;
        this.password = 0;
        this.type =null;
        this.f_name = null;
        this.l_name = null;
        this.address = null;
        this.cellphone = 0;
        this.email = null;
        this.isblocked = false;
    }
    

    public  int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getAddress() {
        return address;
    }

    public int getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIsblocked() {
        return isblocked;
    }
     
   public  void rent_book(){};
   
}
