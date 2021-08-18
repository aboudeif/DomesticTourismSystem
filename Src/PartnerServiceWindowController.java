import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class PartnerServiceWindowController implements Initializable {
    private boolean isEditOp;

    private Partner prt;

    @FXML
    private TextField discountField;

    @FXML
    private TextField crnField;

    @FXML
    private ComboBox<String> cityComboBox;

    @FXML
    private CheckBox idleCheckBox;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField localAddressField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField typeField;

    @FXML
    void acceptOperation(ActionEvent event) {
        if(isEditOp)
            editPartnerService(event);
        else
            addPartnerService(event);

        MainWindowController.getInstance().refreshPartnerTableView();
        
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    private void editPartnerService(ActionEvent event){
        this.prt.setCls("prt");
        this.prt.setName(this.nameField.getText());
        this.prt.setCrn(this.crnField.getText());
        this.prt.setEmail(this.emailField.getText());
        this.prt.setLocalAddress(this.localAddressField.getText());
        this.prt.setType(this.typeField.getText());
        this.prt.setCity(this.cityComboBox.getValue());
        this.prt.setIdle(this.idleCheckBox.isSelected());
        
        try {
            DBQuery.editServiceProvider(this.prt);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void addPartnerService(ActionEvent event){
        this.prt = new Partner();

        this.prt.setCls("prt");
        this.prt.setName(this.nameField.getText());
        this.prt.setCrn(this.crnField.getText());
        this.prt.setEmail(this.emailField.getText());
        this.prt.setLocalAddress(this.localAddressField.getText());
        this.prt.setType(this.typeField.getText());
        this.prt.setCity(this.cityComboBox.getValue());
        this.prt.setIdle(this.idleCheckBox.isSelected());
        this.prt.setDiscount(Double.parseDouble(this.discountField.getText()));

        try {
            DBQuery.addServiceProvider(this.prt);
        } catch (Exception e) {
        } 
    }

    public Partner getPartner() {
        return this.prt;
    }

    public void setPartner(Partner prt) {
        this.prt = prt;

        this.nameField.setText(this.prt.getName());
        this.crnField.setText(this.prt.getCrn());
        this.emailField.setText(this.prt.getEmail());
        this.localAddressField.setText(this.prt.getLocalAddress());
        this.typeField.setText(this.prt.getType());
        this.cityComboBox.setValue(this.prt.getCity());
        this.idleCheckBox.setSelected(this.prt.isIdle());
        this.discountField.setText(Double.toString(this.prt.getDiscount()));
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل الشركاء");
        else
            this.titleLabel.setText("الشركاء جديد");
    }

    @FXML
    void cancleOperation(ActionEvent event) {
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // init member variables
        this.setEditOp(false);

        // Add Text Fields Constriants
        this.nameField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 75) {
                    nameField.setText(oldValue);
                }
            }
        });
        
        this.crnField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 30) {
                    crnField.setText(newValue.substring(0, 30));
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

        this.typeField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 30) {
                    typeField.setText(oldValue);
                }
            }
        });
        
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0d);
        this.discountField.setTextFormatter(formatter);

        try{
            List<String> cityList = DBQuery.getCityData();
            for (String city : cityList)
                cityComboBox.getItems().add(city);
            cityComboBox.getSelectionModel().select(0);      
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
