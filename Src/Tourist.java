import java.sql.Date;

public class Tourist extends Person {
    private String partner;
    private String info;
    private double balance;


    public Tourist(){
        
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
