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
import javafx.stage.Stage;

public class AdServiceWindowController implements Initializable {
    private boolean isEditOp;

    private AdService ad;

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
            editAdService(event);
        else
            addAdService(event);

        MainWindowController.getInstance().refreshAdServiceTableView();
        
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    private void editAdService(ActionEvent event){
        this.ad.setCls("ad");
        this.ad.setName(this.nameField.getText());
        this.ad.setCrn(this.crnField.getText());
        this.ad.setEmail(this.emailField.getText());
        this.ad.setLocalAddress(this.localAddressField.getText());
        this.ad.setType(this.typeField.getText());
        this.ad.setCity(this.cityComboBox.getValue());
        this.ad.setIdle(this.idleCheckBox.isSelected());
        
        try {
            DBQuery.editServiceProvider(this.ad);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void addAdService(ActionEvent event){
        this.ad = new AdService();

        this.ad.setCls("ad");
        this.ad.setName(this.nameField.getText());
        this.ad.setCrn(this.crnField.getText());
        this.ad.setEmail(this.emailField.getText());
        this.ad.setLocalAddress(this.localAddressField.getText());
        this.ad.setType(this.typeField.getText());
        this.ad.setCity(this.cityComboBox.getValue());
        this.ad.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addServiceProvider(this.ad);
        } catch (Exception e) {
        } 
    }

    public AdService getAd() {
        return this.ad;
    }

    public void setAd(AdService ad) {
        this.ad = ad;

        this.nameField.setText(this.ad.getName());
        this.crnField.setText(this.ad.getCrn());
        this.emailField.setText(this.ad.getEmail());
        this.localAddressField.setText(this.ad.getLocalAddress());
        this.typeField.setText(this.ad.getType());
        this.cityComboBox.setValue(this.ad.getCity());
        this.idleCheckBox.setSelected(this.ad.isIdle());
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل خدمة الدعاية");
        else
            this.titleLabel.setText("خدمة الدعاية جديد");
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
