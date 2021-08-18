
import java.sql.Date;


public class RegTourist {
    private Tourist tourist;
    private int travel;
    private Date regDate;
    private double actualProfit;

    public Tourist getTourist() {
        return tourist;
    }
    
    public String getTouristName() {
        return tourist.getName();
    }
    
    public int getTouristId() {
        return tourist.getId();
    }
    
    public String getTouristNID() {
        return tourist.getNid();
    }
    
    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }
    
    
    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(double actualProfit) {
        this.actualProfit = actualProfit;
    }
    
}
