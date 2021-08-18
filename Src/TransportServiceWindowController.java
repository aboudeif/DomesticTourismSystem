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

public class TransportServiceWindowController implements Initializable {
    private boolean isEditOp;

    private TransportService trans;

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
            editTransportService(event);
        else
            addTransportService(event);

        MainWindowController.getInstance().refreshTransportServiceTableView();
        
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    private void editTransportService(ActionEvent event){
        this.trans.setCls("trs");
        this.trans.setName(this.nameField.getText());
        this.trans.setCrn(this.crnField.getText());
        this.trans.setEmail(this.emailField.getText());
        this.trans.setLocalAddress(this.localAddressField.getText());
        this.trans.setType(this.typeField.getText());
        this.trans.setCity(this.cityComboBox.getValue());
        this.trans.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.editServiceProvider(this.trans);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void addTransportService(ActionEvent event){
        this.trans = new TransportService();

        this.trans.setCls("trs");
        this.trans.setName(this.nameField.getText());
        this.trans.setCrn(this.crnField.getText());
        this.trans.setEmail(this.emailField.getText());
        this.trans.setLocalAddress(this.localAddressField.getText());
        this.trans.setType(this.typeField.getText());
        this.trans.setCity(this.cityComboBox.getValue());
        this.trans.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addServiceProvider(this.trans);
        } catch (Exception e) {
        } 
    }

    public TransportService getTrans() {
        return trans;
    }

    public void setTrans(TransportService trans) {
        this.trans = trans;

        this.nameField.setText(this.trans.getName());
        this.crnField.setText(this.trans.getCrn());
        this.emailField.setText(this.trans.getEmail());
        this.localAddressField.setText(this.trans.getLocalAddress());
        this.typeField.setText(this.trans.getType());
        this.cityComboBox.setValue(this.trans.getCity());
        this.idleCheckBox.setSelected(this.trans.isIdle());
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل خدمة النقل");
        else
            this.titleLabel.setText("خدمة النقل جديد");
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
