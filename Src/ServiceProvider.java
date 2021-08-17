import java.sql.Date;
import java.time.LocalDate;

public abstract class ServiceProvider {
    private int id;
    private String cls;
    private String name;
    private String crn;
    private String email;
    private String city;
    private String localAddress;
    private String type;
    private Date createDate;
    private String idle;
    

    public ServiceProvider(){
        
    }



    public int getId() {
        return id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
