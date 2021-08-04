import java.sql.Date;
import java.time.LocalDate;

public class ServiceProvider {
    private int id;
    private String cls;
    private String name;
    private String crn;
    private String email;
    private int cityID;
    private String localAddress;
    private String type;
    private Date createDate;
    private boolean idle;
    private double discount;

    public ServiceProvider(){
        id = 0;
        cls = "";
        name = "";
        crn = "";
        email = "";
        cityID = 0;
        localAddress = "";
        type = "";
        createDate = Date.valueOf(LocalDate.now());
        idle = false;
        discount = 0.0;
    }

    public ServiceProvider(int id, String cls, String name, String crn, String email, int cityID,
     String localAddress, String type, Date createDate, boolean idle, double discount){
         this.setId(id);
         this.setCls(cls);
         this.setName(name);
         this.setCrn(crn);
         this.setEmail(email);
         this.setCityID(cityID);
         this.setLocalAddress(localAddress);
         this.setType(type);
         this.setCreateDate(createDate);
         this.setIdle(idle);
         this.setDiscount(discount);
     }


    public int getId() {
        return id;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        if((discount >= 0) || (discount <= 1.0))
            this.discount = discount;
        else
            this.discount = 0.0;
    }
    public boolean isIdle() {
        return idle;
    }
    public void setIdle(boolean idle) {
        this.idle = idle;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLocalAddress() {
        return localAddress;
    }
    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }
    public int getCityID() {
        return cityID;
    }
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCrn() {
        return crn;
    }
    public void setCrn(String crn) {
        this.crn = crn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCls() {
        return cls;
    }
    public void setCls(String cls) {
        this.cls = cls;
    }
    public void setId(int id) {
        this.id = id;
    } 
}
