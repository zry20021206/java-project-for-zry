package javaProject;

public class User {
    private String username; 
    private String password;
    private String ID;
    private String phonenumber;
    public User() {
        this.username = "";
        this.password = "";
        this.ID = "";
        this.phonenumber = "";
    }
    public User(String username, String password, String ID, String phonenumber) {
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.phonenumber = phonenumber;
    }
    public String getusername() {  
        return username;  
    }
    public String getpassword() {
        return password;
    }
    public String getID() {
        return ID;
    }
    public String getphonenumber() {
        return phonenumber;
    }
    public void setusername(String username) {  
        this.username = username;  
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
