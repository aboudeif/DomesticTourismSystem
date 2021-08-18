
import java.util.List;


public class AdService extends ServiceProvider{
    private List<Advertisement> advertisement;

    public AdService() {
    }

    public List<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(List<Advertisement> advertisement) {
        this.advertisement = advertisement;
    }
    
}