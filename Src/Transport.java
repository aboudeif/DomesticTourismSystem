
import java.sql.Date;


public class Transport {
    private int id;
    private String type;
    private String transportService;
    private String panelNo;
    private String model;
    private int capacity;
    private String city;
    private Date creatDate;
    private double cost;
    private String idle;

    public Transport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransportService() {
        return transportService;
    }

    public void setTransportService(String transportService) {
        this.transportService = transportService;
    }

    public String getPanelNo() {
        return panelNo;
    }

    public void setPanelNo(String panelNo) {
        this.panelNo = panelNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
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
