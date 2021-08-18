import java.sql.Date;


public class RegHostel {
    private int hostel;
    private int travel;
    private int roomNum;
    private int nightsNum;
    private double totalCost;
    private Date regDate;

    public RegHostel() {
    }

    public int getHostel() {
        return hostel;
    }

    public void setHostel(int hostel) {
        this.hostel = hostel;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getNightsNum() {
        return nightsNum;
    }

    public void setNightsNum(int nightsNum) {
        this.nightsNum = nightsNum;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    
}
