import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TouristWindowController implements Initializable {
    private boolean isEditOp;
    private Tourist  tourist;
    @FXML
    private ComboBox<String> cityComboBox;
    @FXML
    private TextField mobileField;
    @FXML
    private CheckBox idleCheckBox;

    @FXML
    private Label titleLabel;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private TextField localAddressField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField emailField;
    @FXML
    private TextField nidField;
    @FXML
    private ComboBox<String> partnerComboBox;
    @FXML
    private TextField infoField;
    @FXML
    private TextField balanceField;
    @FXML
    

    void checkBirthDateConstraint(ActionEvent event) {
        LocalDate date = this.datePicker.getValue();
        if(LocalDate.now().compareTo(date) < 0) date = LocalDate.now();
        this.datePicker.setValue(date);
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل سائح");
        else
            this.titleLabel.setText("سائح جديد");
    }

    public Tourist getTourist() {
        return this.tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;

        if(tourist.getGender().equals("أنثي"))
            this.genderComboBox.setValue("أنثي");
        
        // String partnerName = "";
        // try {
        //     partnerName = DBQuery.getPartnerName(tourist.getPartnerID());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        this.nameField.setText(tourist.getName());
        this.nidField.setText(tourist.getNid());
        this.mobileField.setText(tourist.getMobile());
        this.datePicker.setValue(tourist.getBirthDate().toLocalDate());
        this.emailField.setText(tourist.getEmail());
        this.cityComboBox.setValue(tourist.getCity());
        this.localAddressField.setText(tourist.getLocalAddress());
        this.infoField.setText(tourist.getInfo());
        this.balanceField.setText(Double.toString(tourist.getBalance()));
        this.idleCheckBox.setSelected(tourist.isIdle());
        this.partnerComboBox.setValue(tourist.getPartner());
    }

    @FXML
    void acceptOperation(ActionEvent event) {
        if(isEditOp)
            editTouristOperation(event);
        else
            addTouristOperation(event);
    
        MainWindowController.getInstance().refreshTouristTableView();
        
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
        //clear();
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
        this.tourist = new Tourist();
        
        // Add Text Fields Constriants
        this.nameField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 75) {
                    nameField.setText(oldValue);
                }
            }
        });

        this.nidField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,14}?")) {
                    nidField.setText(oldValue);
                }
            }
        });

        this.mobileField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}?")) {
                    mobileField.setText(oldValue);
                }
            }
        });

        this.emailField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 75) {
                    emailField.setText(oldValue);
                }
            }
        });

        this.localAddressField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 100) {
                    localAddressField.setText(oldValue);
                }
            }
        });

        this.balanceField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    balanceField.setText(oldValue);
                }
            }
        });

        // Populate UI
        genderComboBox.getItems().add("ذكر");        
        genderComboBox.getItems().add("أنثي");
        genderComboBox.setValue("ذكر");

        try{
            List<String> cityList = DBQuery.getCityData();
            for (String city : cityList)
                cityComboBox.getItems().add(city);
            cityComboBox.getSelectionModel().select(0);      
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            partnerComboBox.getItems().add("");
            List<String> partnerList = DBQuery.getSPList("prt");
            for (String partner : partnerList)
                partnerComboBox.getItems().add(partner);
            partnerComboBox.getSelectionModel().select(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void editTouristOperation(Event event){
        // int partnerID = -1;
        // try {
        //     partnerID = DBQuery.getPartnerID(this.partnerComboBox.getValue());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        this.tourist.setName(this.nameField.getText());
        this.tourist.setNid(this.nidField.getText());
        this.tourist.setGender(this.genderComboBox.getValue());
        this.tourist.setMobile(this.mobileField.getText());
        this.tourist.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.tourist.setEmail(this.emailField.getText());
        this.tourist.setCity(this.cityComboBox.getValue());
        this.tourist.setLocalAddress(this.localAddressField.getText());
        this.tourist.setPartner(this.partnerComboBox.getValue());
        this.tourist.setInfo(this.infoField.getText());
        this.tourist.setBalance(Double.parseDouble(this.balanceField.getText()));
        this.tourist.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.editTourist(this.tourist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addTouristOperation(Event event){
        this.tourist.setName(this.nameField.getText());
        this.tourist.setNid(this.nidField.getText());
        this.tourist.setGender(this.genderComboBox.getValue());
        this.tourist.setMobile(this.mobileField.getText());
        this.tourist.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.tourist.setEmail(this.emailField.getText());        
        this.tourist.setCity(this.cityComboBox.getValue());
        this.tourist.setLocalAddress(this.localAddressField.getText());
        this.tourist.setIdle(this.idleCheckBox.isSelected());
        this.tourist.setPartner(this.partnerComboBox.getValue());
        this.tourist.setInfo(this.infoField.getText());
        this.tourist.setBalance(Double.parseDouble(this.balanceField.getText()));

        try {
            DBQuery.addTourist(this.tourist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
