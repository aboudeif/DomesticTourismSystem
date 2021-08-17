import java.sql.Date;


public class Agent extends Person {
    private String usrID;
    private String password;

    public Agent(){
    }

   
    
    public String getUsrID() {
        return usrID;
    }

    public void setUsrID(String usrID) {
        this.usrID = usrID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}