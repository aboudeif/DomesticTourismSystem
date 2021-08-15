import java.sql.Date;

public class Guide extends Person {
    private String specialty;
    private double rate;

    public Guide(){
        
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
