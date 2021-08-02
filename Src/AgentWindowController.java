import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class AgentWindowController implements Initializable {
    private boolean isEditOp;
    private Agent agent;

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
    private ComboBox<String> roleComboBox;

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

        if(agent.getGender().equals("Female"))
            this.genderComboBox.setValue("Female");
        
        String cityName = "";
        try {
            cityName = DBQuery.getCityName(agent.getCityID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String role = "";
        try {
            role = DBQuery.getAgentRole(agent.getRoleID());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.nameField.setText(agent.getName());
        this.nidField.setText(agent.getNid());
        this.mobileField.setText(agent.getMobile());
        this.datePicker.setValue(agent.getBirthDate().toLocalDate());
        this.emailField.setText(agent.getEmail());
        this.cityComboBox.setValue(cityName);
        this.localAddressField.setText(agent.getLocalAddress());
        this.userAccountField.setText(agent.getUsrID());
        this.userPasswordField.setText(agent.getPassword());
        this.roleComboBox.setValue(role);
    }

    public boolean isEditOp() {
        return isEditOp;
    }

    public void setEditOp(boolean isEditOp) {
        this.isEditOp = isEditOp;
        if(isEditOp)
            this.titleLabel.setText("Edit Agent");
        else
            this.titleLabel.setText("Add Agent");
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
        
        int cityID = -1;
        try {
            cityID = DBQuery.getCityID(cityComboBox.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String localAddress = localAddressField.getText();
        String usrID = userAccountField.getText();
        String usrPassword = userPasswordField.getText();
        int roleID = -1;
        try {
            roleID = DBQuery.getAgentRoleID(roleComboBox.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DBQuery.addAgent(name, nid, gender, mobile, birthDate, email, cityID,
                localAddress, usrID, usrPassword, roleID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void editAgentOperation(ActionEvent event){
        int cityID = -1;
        try{
            cityID = DBQuery.getCityID(this.cityComboBox.getValue());
        }catch(Exception e){
            e.printStackTrace();
        }

        int roleID = -1;
        try {
            roleID = DBQuery.getAgentRoleID(this.roleComboBox.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.agent.setName(this.nameField.getText());
        this.agent.setNid(this.nidField.getText());
        this.agent.setGender(this.genderComboBox.getValue());
        this.agent.setMobile(this.mobileField.getText());
        this.agent.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.agent.setEmail(this.emailField.getText());
        this.agent.setCityID(cityID);
        this.agent.setLocalAddress(this.localAddressField.getText());
        this.agent.setUsrID(this.userAccountField.getText());
        this.agent.setPassword(this.userPasswordField.getText());
        this.agent.setRoleID(roleID);

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

    // @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // init member variables
        this.isEditOp = false;
        // this.setAgent(new Agent());
        
        // Populate UI
        genderComboBox.getItems().add("Male");        
        genderComboBox.getItems().add("Female");
        genderComboBox.setValue("Male");

        try{
            List<String> cityList = DBQuery.getCityData();
            for (String city : cityList)
                cityComboBox.getItems().add(city);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            List<String> roleList = DBQuery.getAgentRoleData();
            for (String role : roleList)
                roleComboBox.getItems().add(role);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
