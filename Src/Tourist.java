import java.sql.Date;

public class Tourist extends Person {
    private String partner;
    private String info;
    private double balance;


    public Tourist(){
        
    }

    public Tourist(int id, String partner, String info, double balance, String name,
     String nid, String gender, String mobile, Date birthDate, String email,
     String city, String localAddress, Date createDate, boolean idle){
        this.setId(id);
        this.setPartner(partner);
        this.setInfo(info);
        this.setBalance(balance);
        this.setName(name);
        this.setNid(nid);
        this.setGender(gender);
        this.setMobile(mobile);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setCity(city);
        this.setLocalAddress(localAddress);
        this.setCreateDate(createDate);
        this.setIdle(idle);
    }

    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        if (balance >= 0.0)
            this.balance = balance;
        else
            this.balance = 0.0;
    }


    public String getInfo() {
        return info;
    }


    public void setInfo(String info) {
        this.info = info;
    }


    public String getPartner() {
        return partner;
    }


    public void setPartner(String partner) {
        this.partner = partner;
    }
}
