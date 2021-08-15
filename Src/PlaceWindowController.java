

import java.net.URL;


import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Abdallah
 */
public class PlaceWindowController implements Initializable {
    private Place place;
    private boolean isEditOp;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField capacityField;
    @FXML
    private TextField costField;
    @FXML
    private ComboBox<String> cityComboBox;
    @FXML
    private CheckBox idleCheckBox;
    @FXML
    private TextField titleField;
    @FXML
    private TextField priceField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    /**
     * Initializes the controller class.
     */
        public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل مزار");
        else
            this.titleLabel.setText("مزار جديد");
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) throws Exception {
        this.place = place;        
        
        this.nameField.setText(place.getName());
        this.typeField.setText(place.getType());
        this.capacityField.setText(Integer.toString(place.getCapacity()));
        this.costField.setText(Double.toString(place.getCost()));
        this.cityComboBox.setValue(place.getCity());
        this.idleCheckBox.setSelected(place.isIdle());

    }

    @FXML
    void acceptOperation(ActionEvent event) throws Exception {
        if(isEditOp)
            editPlaceOperation(event);
        else
            addPlaceOperation(event);
    
        MainWindowController.getInstance().refreshPlaceTableView();
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
        this.place = new Place();
        
        // Add Text Fields Constriants
        this.nameField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 75) {
                    nameField.setText(oldValue);
                }
            }
        });
         this.costField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    costField.setText(oldValue);
                }
            }
        });

        try{
            List<String> cityList = DBQuery.getCityData();
            for (String city : cityList)
                cityComboBox.getItems().add(city);
            cityComboBox.getSelectionModel().select(0);      
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private void editPlaceOperation(Event event) throws Exception{
        

        this.place.setName(this.nameField.getText());
        this.place.setType(this.typeField.getText());
        this.place.setCity(this.cityComboBox.getValue());
        this.place.setCapacity(Integer.parseInt(this.capacityField.getText()));
        this.place.setCost(Double.parseDouble(this.costField.getText()));
        this.place.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.editPlace(this.place);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addPlaceOperation(Event event) throws Exception{
        this.place.setName(this.nameField.getText());
        this.place.setType(this.typeField.getText());
        this.place.setCity(this.cityComboBox.getValue());
        this.place.setCapacity(Integer.parseInt(this.capacityField.getText()));
        this.place.setCost(Double.parseDouble(this.costField.getText()));
        this.place.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addPlace(this.place);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
