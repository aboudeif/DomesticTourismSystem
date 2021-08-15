
import java.sql.Date;


public class Schedule {
    private Date startDate;
    private int id;
    private String title;

    public Schedule() {
    }

    public Schedule(Date startDate,int id, String title) {
        this.id = id;
        this.startDate = startDate;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
  
    
    
    
    
}
