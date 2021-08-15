
import java.sql.Date;


public class TrvReport {
    private int id;
    private String title;
    private Date creatDate;
    private String idle;
    private Date startDate;
    private Date endDate;
    private int dayNum;
    private double price;
    private int turNum;
    private int trsNum;
    private double trsCost;
    private int hstNum;
    private double hstCost;
    private int gudNum;
    private double gudCost;
    private int plcNum;
    private double plcCost;
    private int adNum;
    private double adCost;
    private double trvProfit;
    private double trvCost;
    private double trvNetProfit;

    public TrvReport() {
    }

   /* public TrvReport(int id, String title, Date creatDate, String idle, Date startDate, Date endDate, int dayNum, double price, int turNum, int trsNum, double trsCost, int hstNum, double hstCost, int gudNum, double gudCost, int plcNum, double plcCost, int adNum, double adCost, double trvProfit, double trvCost, double trvNetProfit) {
        this.setId(id);
        this.setTitle(title);
        this.setCreatDate(creatDate);
        this.setIdle(idle);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setDayNum(dayNum);
        this.setPrice(price);
        this.setTurNum(turNum);
        this.setTrsNum(trsNum);
        this.setTrsCost(trsCost);
        this.setHstNum(hstNum);
        this.setHstCost(hstCost);
        this.setGudNum(gudNum);
        this.setGudCost(gudCost);
        this.setPlcNum(plcNum);
        this.setPlcCost(plcCost);
        this.setAdNum(adNum);
        this.setAdCost(adCost);
        this.trvProfit = trvProfit;
        this.trvCost = trvCost;
        this.trvNetProfit = trvNetProfit;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTurNum() {
        return turNum;
    }

    public void setTurNum(int turNum) {
        this.turNum = turNum;
    }

    public int getTrsNum() {
        return trsNum;
    }

    public void setTrsNum(int trsNum) {
        this.trsNum = trsNum;
    }

    public double getTrsCost() {
        return trsCost;
    }

    public void setTrsCost(double trsCost) {
        this.trsCost = trsCost;
    }

    public int getHstNum() {
        return hstNum;
    }

    public void setHstNum(int hstNum) {
        this.hstNum = hstNum;
    }

    public double getHstCost() {
        return hstCost;
    }

    public void setHstCost(double hstCost) {
        this.hstCost = hstCost;
    }

    public int getGudNum() {
        return gudNum;
    }

    public void setGudNum(int gudNum) {
        this.gudNum = gudNum;
    }

    public double getGudCost() {
        return gudCost;
    }

    public void setGudCost(double gudCost) {
        this.gudCost = gudCost;
    }

    public int getPlcNum() {
        return plcNum;
    }

    public void setPlcNum(int plcNum) {
        this.plcNum = plcNum;
    }

    public double getPlcCost() {
        return plcCost;
    }

    public void setPlcCost(double plcCost) {
        this.plcCost = plcCost;
    }

    public int getAdNum() {
        return adNum;
    }

    public void setAdNum(int adNum) {
        this.adNum = adNum;
    }

    public double getAdCost() {
        return adCost;
    }

    public void setAdCost(double adCost) {
        this.adCost = adCost;
    }

    public double getTrvProfit() {
        return trvProfit;
    }

    public void setTrvProfit(double trvProfit) {
        this.trvProfit = trvProfit;
    }

    public double getTrvCost() {
        return trvCost;
    }

    public void setTrvCost(double trvCost) {
        this.trvCost = trvCost;
    }

    public double getTrvNetProfit() {
        return trvNetProfit;
    }

    public void setTrvNetProfit(double trvNetProfit) {
        this.trvNetProfit = trvNetProfit;
    }
    
    
    
}
