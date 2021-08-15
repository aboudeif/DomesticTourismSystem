
import java.sql.Date;


public class Campaign {
    private int id;
    private int travel;
    private int advertisement;
    private String media;
    private int TargetedNum;
    private int reachedNum;
    private Date startDate;
    private Date endDate;
    private Date regDate;
    private double cost;
    private String idle;

    public Campaign() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(int advertisement) {
        this.advertisement = advertisement;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getTargetedNum() {
        return TargetedNum;
    }

    public void setTargetedNum(int TargetedNum) {
        this.TargetedNum = TargetedNum;
    }

    public int getReachedNum() {
        return reachedNum;
    }

    public void setReachedNum(int reachedNum) {
        this.reachedNum = reachedNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getIdle() {
        return idle;
    }

    public boolean isIdle() {  
        return (!"نشط".equals(idle));
    }

    public void setIdle(boolean idle) {
         if(!idle)
            this.idle = "نشط";
        else
            this.idle = "معطل";
    }
    
    
}
