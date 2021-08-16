
import java.sql.Date;


public class RegTransport {
    private Transport transport;
    private int travel;
    private int daysNum;
    private Date regDate;
    private double totalCost;

    public RegTransport() {
    }

    public int getTransportId() {
        return transport.getId();
    }

    public String getTransportType() {
        return transport.getType();
    }
    public String getTransportPanelNo() {
        return transport.getPanelNo();
    }

    public String getTransportModel() {
        return transport.getModel();
    }
    
   public int getTransportCapacity() {
        return transport.getCapacity();
    }
   
    public String getTransportCity() {
        return transport.getCity();
    }
    
    public String getTransportService() {
        return transport.getTransportService();
    }
    
    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getDaysNum() {
        return daysNum;
    }

    public void setDaysNum(int daysNum) {
        this.daysNum = daysNum;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    
}
