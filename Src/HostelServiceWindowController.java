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

public class HostelServiceWindowController implements Initializable {
    private boolean isEditOp;

    private HostelService host;

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
            editHostleService(event);
        else
            addHostleService(event);

        MainWindowController.getInstance().refreshHostelServiceTableView();
        
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    private void editHostleService(ActionEvent event){
        this.host.setCls("hst");
        this.host.setName(this.nameField.getText());
        this.host.setCrn(this.crnField.getText());
        this.host.setEmail(this.emailField.getText());
        this.host.setLocalAddress(this.localAddressField.getText());
        this.host.setType(this.typeField.getText());
        this.host.setCity(this.cityComboBox.getValue());
        this.host.setIdle(this.idleCheckBox.isSelected());
        
        try {
            DBQuery.editServiceProvider(this.host);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void addHostleService(ActionEvent event){
        this.host = new HostelService();

        this.host.setCls("hst");
        this.host.setName(this.nameField.getText());
        this.host.setCrn(this.crnField.getText());
        this.host.setEmail(this.emailField.getText());
        this.host.setLocalAddress(this.localAddressField.getText());
        this.host.setType(this.typeField.getText());
        this.host.setCity(this.cityComboBox.getValue());
        this.host.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addServiceProvider(this.host);
        } catch (Exception e) {
        } 
    }

    public HostelService getHost() {
        return this.host;
    }

    public void setHost(HostelService host) {
        this.host = host;

        this.nameField.setText(this.host.getName());
        this.crnField.setText(this.host.getCrn());
        this.emailField.setText(this.host.getEmail());
        this.localAddressField.setText(this.host.getLocalAddress());
        this.typeField.setText(this.host.getType());
        this.cityComboBox.setValue(this.host.getCity());
        this.idleCheckBox.setSelected(this.host.isIdle());
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل خدمة الاقامة");
        else
            this.titleLabel.setText("خدمة الاقامة جديد");
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
