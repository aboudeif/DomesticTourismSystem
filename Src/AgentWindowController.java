import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class AgentWindowController implements Initializable {
    private boolean isEditOp;
    private Agent agent;

    @FXML
    private CheckBox idleCheckBox;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField userAccountField;

    @FXML
    private ComboBox<String> cityComboBox;

    @FXML
    private TextField mobileField;

    @FXML
    private PasswordField userPasswordField;

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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;

        if(agent.getGender().equals("أنثي"))
            this.genderComboBox.setValue("أنثي");
        
        // String cityName = "";
        // try {
        //     cityName = DBQuery.getCityName(agent.getCityID());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        this.nameField.setText(agent.getName());
        this.nidField.setText(agent.getNid());
        this.mobileField.setText(agent.getMobile());
        this.datePicker.setValue(agent.getBirthDate().toLocalDate());
        this.emailField.setText(agent.getEmail());
        this.cityComboBox.setValue(agent.getCity());
        this.localAddressField.setText(agent.getLocalAddress());
        this.userAccountField.setText(agent.getUsrID());
        this.userPasswordField.setText(agent.getPassword());
        this.idleCheckBox.setSelected(agent.isIdle());
        //if(agent.getIdle().equals("نشط"))
        //    this.idleCheckBox.setSelected(false);
        //if(agent.getIdle().equals("معطل"))
         //   this.idleCheckBox.setSelected(true); 
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("تعديل موظف");
        else
            this.titleLabel.setText("موظف جديد");
    }

    void addAgentOperation(ActionEvent event) {
        
        String name = nameField.getText();
        String nid = nidField.getText();
        boolean gender = false;
        if(genderComboBox.getSelectionModel().getSelectedIndex() > 0)
            gender = true;
        String mobile = mobileField.getText();
        Date birthDate = Date.valueOf(datePicker.getValue());
        String email = emailField.getText();        
        String city = cityComboBox.getValue();
        String localAddress = localAddressField.getText();
        String usrID = userAccountField.getText();
        String usrPassword = userPasswordField.getText();

        boolean idle = idleCheckBox.isSelected();

        try {
            DBQuery.addAgent(name, nid, gender, mobile, birthDate, email, city,
                localAddress, usrID, usrPassword, idle);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void editAgentOperation(ActionEvent event){
        // int cityID = -1;
        // try{
        //     cityID = DBQuery.getCityID(this.cityComboBox.getValue());
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        this.agent.setName(this.nameField.getText());
        this.agent.setNid(this.nidField.getText());
        this.agent.setGender(this.genderComboBox.getValue());
        this.agent.setMobile(this.mobileField.getText());
        this.agent.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.agent.setEmail(this.emailField.getText());
        this.agent.setCity(this.cityComboBox.getValue());
        this.agent.setLocalAddress(this.localAddressField.getText());
        this.agent.setUsrID(this.userAccountField.getText());
        this.agent.setPassword(this.userPasswordField.getText());
        this.agent.setIdle(this.idleCheckBox.isSelected());
        // if(agent.getIdle().equals("نشط"))
          //  this.idleCheckBox.setSelected(false);
        //if(agent.getIdle().equals("معطل"))
          //  this.idleCheckBox.setSelected(true); 

        try {
            DBQuery.editAgent(this.agent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void acceptOperation(ActionEvent event) {
        if(isEditOp)
            editAgentOperation(event);
        else
            addAgentOperation(event);
    
        MainWindowController.getInstance().refreshAgentTableView();
        
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
        this.isEditOp = false;

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

        this.userAccountField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    userAccountField.setText(oldValue);
                }
            }
        });

        this.userPasswordField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 30) {
                    userPasswordField.setText(oldValue);
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
    }
    

    // ----------- Check Constraints ----------- //
    @FXML
    private void checkBirthDateConstraint(ActionEvent event){
        LocalDate date = this.datePicker.getValue();
        if(LocalDate.now().compareTo(date) < 0) date = LocalDate.now();
        this.datePicker.setValue(date);
    }
}
