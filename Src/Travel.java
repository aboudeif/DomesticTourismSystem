import java.sql.Date;
import java.util.List;


public class Travel {
    private int id;
    private String title;
    private Date creatDate;
    private String idle;
    private Date startDate;
    private Date endDate;
    private double price;
    private static Travel selectedTravel;
    private List<Campaign> campaign;
    private List<RegTourist> regTourist;
    private List<RegGuide> regGuide;
    private List<RegHostel> regHostel;
    private List<RegTransport> regTransport;
    private List<RegPlace> regPLace;
    
    public Travel() {
    }
    
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
        public String getIdle() {
        return idle;
   }
    public boolean isIdle() {
        return (idle != "نشط");
    }
    public void setIdle(boolean idle) {
         if(!idle)
            this.idle = "نشط";
        else
            this.idle = "معطل";
    }

    public List<Campaign> getCampaign() {
        return campaign;
    }

    public void setCampaign(List<Campaign> campaign) {
        this.campaign = campaign;
    }

    public List<RegTourist> getRegTourist() {
        return regTourist;
    }

    public void setRegTourist(List<RegTourist> regTourist) {
        this.regTourist = regTourist;
    }

    public List<RegGuide> getRegGuide() {
        return regGuide;
    }

    public void setRegGuide(List<RegGuide> regGuide) {
        this.regGuide = regGuide;
    }

    public List<RegHostel> getRegHostel() {
        return regHostel;
    }

    public void setRegHostel(List<RegHostel> regHostel) {
        this.regHostel = regHostel;
    }

    public List<RegTransport> getRegTransport() {
        return regTransport;
    }

    public void setRegTransport(List<RegTransport> regTransport) {
        this.regTransport = regTransport;
    }

    public List<RegPlace> getRegPLace() {
        return regPLace;
    }

    public void setRegPLace(List<RegPlace> regPLace) {
        this.regPLace = regPLace;
    }
    public static Travel getSelectedTravel() {
        return selectedTravel;
    }

    public static void setSelectedTravel(Travel selectedTravel) {
        Travel.selectedTravel = selectedTravel;
    }
}
