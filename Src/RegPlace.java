
import java.sql.Date;


public class RegPlace {
    private Place place;
    private int travel;
    private Date regDate;
    private double totalCost;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getPlaceName() {
        return place.getName();
    }

    public void setPlaceName(String placeName) {
        this.place.setName(placeName);
    }

    public RegPlace() {
    }

    public int getPlaceId() {
        return place.getId();
    }

    public void setPlace(int placeId) {
        this.place.setId(placeId);
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
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
