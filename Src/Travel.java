import java.sql.Date;

public class Travel {
    private int id;
    private String title;
    private Date creatDate;
    private boolean idle;
    private Date startDate;
    private Date endDate;
    private double price;
    
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public boolean isIdle() {
        return idle;
    }
    public void setIdle(boolean idle) {
        this.idle = idle;
    }
    public Date getCreatDate() {
        return creatDate;
    }
    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(int id) {
        this.id = id;
    }

}
