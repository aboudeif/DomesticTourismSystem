import java.sql.Date;

public class Guide extends Person {
    private String specialty;
    private double rate;

    public Guide(){
        
    }

    public Guide(int id, String specialty, String name, String nid, String gender,
     String mobile, String email, String city, String localAddress, double rate,
     Date createDate, boolean idle){
        this.setId(id);
        this.setSpecialty(specialty);
        this.setName(name);
        this.setNid(nid);
        this.setGender(gender);
        this.setMobile(mobile);
        this.setEmail(email);
        this.setCity(city);
        this.setLocalAddress(localAddress);
        this.setRate(rate);
        this.setCreateDate(createDate);
        this.setIdle(idle);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if(rate >= 0.0)
            this.rate = rate;
        else
            this.rate = 0.0;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
