
import java.sql.Date;


public class Place {
    private int id;
    private String type;
    private String idle;
    private String name;
    private String city;
    private int capacity;
    private double cost;
    private Date createDate;

    public Place() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    
}
