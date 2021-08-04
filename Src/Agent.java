import java.sql.Date;


public class Agent extends Person {
    private String usrID;
    private String password;

    public Agent(){
    }

    public Agent(int id, String name, String nid, String gender, String mobile, Date birthDate,
     String email, String city, String localAddress, Date createDate, String userID, String password,
     boolean idle){
        this.setId(id);
        this.setName(name);
        this.setNid(nid);
        this.setGender(gender);
        this.setMobile(mobile);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setCity(city);
        this.setLocalAddress(localAddress);
        this.setCreateDate(createDate);
        this.setUsrID(usrID);
        this.setPassword(password);
        this.setIdle(idle);
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