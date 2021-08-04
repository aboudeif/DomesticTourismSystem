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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuideWindowController implements Initializable {
    private boolean isEditOp;
    private Guide  guide;

    @FXML
    private TextField specialtyField;

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
    private TextField rateField;

    @FXML
    private TextField nidField;

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
            this.titleLabel.setText("Edit Guide");
        else
            this.titleLabel.setText("Add Guide");
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;

        if(guide.getGender().equals("Female"))
            this.genderComboBox.setValue("Female");
        
        // String cityName = "";
        // try {
        //     cityName = DBQuery.getCityName(guide.getCityID());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        this.nameField.setText(guide.getName());
        this.nidField.setText(guide.getNid());
        this.mobileField.setText(guide.getMobile());
        this.datePicker.setValue(guide.getBirthDate().toLocalDate());
        this.emailField.setText(guide.getEmail());
        this.cityComboBox.setValue(guide.getCity());
        this.localAddressField.setText(guide.getLocalAddress());
        this.specialtyField.setText(guide.getSpecialty());
        this.rateField.setText(Double.toString(guide.getRate()));
        this.idleCheckBox.setSelected(guide.isIdle());
    }

    @FXML
    void acceptOperation(ActionEvent event) {
        if(isEditOp)
            editGuideOperation(event);
        else
            addGuideOperation(event);
    
        MainWindowController.getInstance().refreshGuideTableView();
        
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
        this.guide = new Guide();
        
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

        this.specialtyField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 15) {
                    specialtyField.setText(oldValue);
                }
            }
        });

        this.rateField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    rateField.setText(oldValue);
                }
            }
        });

        // Populate UI
        genderComboBox.getItems().add("Male");        
        genderComboBox.getItems().add("Female");
        genderComboBox.setValue("Male");

        try{
            List<String> cityList = DBQuery.getCityData();
            for (String city : cityList)
                cityComboBox.getItems().add(city);
            cityComboBox.getSelectionModel().select(0);      
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private void editGuideOperation(Event event){
        // int cityID = -1;
        // try{
        //     cityID = DBQuery.getCityID(this.cityComboBox.getValue());
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        this.guide.setName(this.nameField.getText());
        this.guide.setNid(this.nidField.getText());
        this.guide.setGender(this.genderComboBox.getValue());
        this.guide.setMobile(this.mobileField.getText());
        this.guide.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.guide.setEmail(this.emailField.getText());
        this.guide.setCity(this.cityComboBox.getValue());
        this.guide.setLocalAddress(this.localAddressField.getText());
        this.guide.setSpecialty(this.specialtyField.getText());
        this.guide.setRate(Double.parseDouble(this.rateField.getText()));
        this.guide.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.editGuide(this.guide);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addGuideOperation(Event event){
        this.guide.setName(this.nameField.getText());
        this.guide.setNid(this.nidField.getText());
        this.guide.setGender(this.genderComboBox.getValue());
        this.guide.setMobile(this.mobileField.getText());
        this.guide.setBirthDate(Date.valueOf(this.datePicker.getValue()));
        this.guide.setEmail(this.emailField.getText());
        
        // int cityID = -1;
        // try {
        //     cityID = DBQuery.getCityID(this.cityComboBox.getValue());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        this.guide.setCity(this.cityComboBox.getValue());
        this.guide.setLocalAddress(this.localAddressField.getText());
        this.guide.setSpecialty(this.specialtyField.getText());
        this.guide.setRate(Double.parseDouble(this.rateField.getText()));
        this.guide.setIdle(this.idleCheckBox.isSelected());

        try {
            DBQuery.addGuide(this.guide);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
