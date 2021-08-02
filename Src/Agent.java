import java.sql.Date;


public class Agent extends Person {
    private String usrID;
    private String password;
    private int roleID;

    public Agent(){
    }

    public Agent(int id, String name, String nid, String gender, String mobile, Date birthDate,
     String email, int cityID, String localAddress, Date createDate, String userID, String password,
      int roleID){
        this.setId(id);
        this.setName(name);
        this.setNid(nid);
        this.setGender(gender);
        this.setMobile(mobile);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setCityID(cityID);
        this.setLocalAddress(localAddress);
        this.setCreateDate(createDate);
        this.setUsrID(usrID);
        this.setPassword(password);
        this.setRoleID(roleID);
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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}