
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class RegTransportWindowController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private TableView<Transport> transportTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTransportTableView();
    }    

    @FXML
    private void acceptOperation(ActionEvent event) {
        RegTransport regTransport = new RegTransport();
        regTransport.setTransport(transportTable.getSelectionModel().getSelectedItem());
        regTransport.setTravel(Travel.getSelectedTravel().getId());
        try{
            DBQuery.addRegTransport(regTransport);
        }catch(Exception e){
        }
        MainWindowController.getInstance().refreshRegTransportTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void cancleOperation(ActionEvent event) {
    }
    void initTransportTableView(){
        transportTable.getColumns().clear();
        
        TableColumn<Transport, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        transportTable.getColumns().add(idColumn);
        
        TableColumn<Transport, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        transportTable.getColumns().add(typeColumn);
        
        TableColumn<Transport, String> transportServiceColumn = new TableColumn<>("خدمة النقل");
        transportServiceColumn.setCellValueFactory(new PropertyValueFactory<>("transportService"));
        transportTable.getColumns().add(transportServiceColumn);
        
        TableColumn<Transport, String> panelNoColumn = new TableColumn<>("رقم اللوحة");
        panelNoColumn.setCellValueFactory(new PropertyValueFactory<>("panelNo"));
        transportTable.getColumns().add(panelNoColumn);
        
        TableColumn<Transport, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        transportTable.getColumns().add(capacityColumn);
        
        TableColumn<Transport, String> cityIDColumn = new TableColumn<>("المدينة");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        transportTable.getColumns().add(cityIDColumn);
        
        TableColumn<Transport, Double> costColumn = new TableColumn<>("السعر");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        transportTable.getColumns().add(costColumn);
        
      
        refreshTransportTableView();
    }

    void refreshTransportTableView(){
        // clear all items
        transportTable.getItems().clear();
        List<Transport> transportList = null;
        try{
            transportList = DBQuery.getResTransport(DBQuery.getData("Transport"));
        }catch(Exception e){
        }
        if(transportList != null)
            for (Transport transport : transportList)
                transportTable.getItems().add(transport);
        
    }

}
