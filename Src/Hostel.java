
import java.sql.Date;


public class Hostel {
    private int id;
    private String name;
    private String type;
    private String hostelService;
    private Date creatDate;
    private String idle;
    private String city;
    private String localAdd;
    private int capacity;
    private int hotelDegree;
    private double cost;

    public Hostel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHostelService() {
        return hostelService;
    }

    public void setHostelService(String hostelService) {
        this.hostelService = hostelService;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalAdd() {
        return localAdd;
    }

    public void setLocalAdd(String localAdd) {
        this.localAdd = localAdd;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHotelDegree() {
        return hotelDegree;
    }

    public void setHotelDegree(int hotelDegree) {
        this.hotelDegree = hotelDegree;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
