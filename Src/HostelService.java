
import java.util.List;


public class HostelService extends ServiceProvider {
    private List<Hostel> hostel;

    public HostelService() {
    }

    public List<Hostel> getHostel() {
        return hostel;
    }

    public void setHostel(List<Hostel> hostel) {
        this.hostel = hostel;
    }
    
}
