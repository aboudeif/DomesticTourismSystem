
import java.sql.Date;


public class Advertisement {
    private int id;
    private String adService;
    private String info;
    private double designCost;
    private Date creatDate;
    private String idle;

    public Advertisement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdService() {
        return adService;
    }

    public void setAdService(String adService) {
        this.adService = adService;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getDesignCost() {
        return designCost;
    }

    public void setDesignCost(double designCost) {
        this.designCost = designCost;
    }
    
    public double getCost() {
        return designCost;
    }

    public void setCost(double cost) {
        this.designCost = cost;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
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
