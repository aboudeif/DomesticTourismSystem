
import java.util.List;


public class TransportService extends ServiceProvider {
    private List<Transport> transport;

    public TransportService() {
    }


    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }
    
}


