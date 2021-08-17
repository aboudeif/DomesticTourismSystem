import java.util.ArrayList;
import java.util.List;




public class Partner extends ServiceProvider {
    private double discount;
    private List<Tourist> tourist;
    public Partner() {
        
    }

    public List<Tourist> getTourist() {
        return tourist;
    }

    public void setTourist(List<Tourist> tourist) {
        this.tourist = tourist;
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
    
}
