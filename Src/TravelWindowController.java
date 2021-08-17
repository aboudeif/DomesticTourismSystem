 
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdallah
 */
public class TravelWindowController implements Initializable {
    private Travel travel;
    private boolean isEditOp;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField titleField;
    @FXML
    private TextField priceField;
    @FXML
    private CheckBox idleCheckBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل رحلة");
        else
            this.titleLabel.setText("رحلة جديدة");
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;        
        
        this.titleField.setText(travel.getTitle());
        this.startDatePicker.setValue(travel.getStartDate().toLocalDate());
        this.endDatePicker.setValue(travel.getEndDate().toLocalDate());
        this.priceField.setText(Double.toString(travel.getPrice()));
        this.idleCheckBox.setSelected(travel.isIdle());

    }

    @FXML
    void acceptOperation(ActionEvent event) {
        if(isEditOp)
            editTravelOperation(event);
        else
            addTravelOperation(event);
    
        MainWindowController.getInstance().refreshTravelTableView();
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    @FXML
    void cancleOperation(ActionEvent event) {
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // init member variables
        this.setEditOp(false);
        this.travel = new Travel();
        
        // Add Text Fields Constriants
        this.titleField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 75) {
                    titleField.setText(oldValue);
                }
            }
        });
         this.priceField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    priceField.setText(oldValue);
                }
            }
        });
        
    }
private void editTravelOperation(Event event){
        

        this.travel.setTitle(this.titleField.getText());
        this.travel.setStartDate(Date.valueOf(this.startDatePicker.getValue())) ;
        this.travel.setEndDate(Date.valueOf(this.endDatePicker.getValue()));
        this.travel.setPrice(Double.parseDouble(this.priceField.getText()));
        this.travel.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.editTravel(this.travel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addTravelOperation(Event event){
        this.travel.setTitle(this.titleField.getText());
        this.travel.setStartDate(Date.valueOf(this.startDatePicker.getValue()));
        this.travel.setEndDate(Date.valueOf(this.endDatePicker.getValue()));
        this.travel.setPrice(Double.parseDouble(this.priceField.getText()));
        this.travel.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addTravel(this.travel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
