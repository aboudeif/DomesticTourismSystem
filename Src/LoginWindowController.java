import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginWindowController implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void Login(ActionEvent event) {
        
        String name = nameField.getText();
        String password = passwordField.getText();
        nameField.clear();
        passwordField.clear();
        boolean isUser;
        
        try {
            isUser = DBConnector.checkAgentPassword(name, password);
    
            if(!isUser){
                Alert alert = new Alert(AlertType.NONE);
                alert.setAlertType(AlertType.INFORMATION);
                alert.setHeaderText("Incorrect User Name Or Password");
                alert.setContentText("Incorrect User Name Or Password");
                alert.showAndWait();
            }else{
                Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
                window.setScene(App.mainScene);
                window.setResizable(true);
                window.setMaximized(true);
            }            
        } catch (Exception e) {
            System.out.println(e.toString());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Faild To Retrieve Data From Data Base");
            alert.setContentText("Faild To Retrieve Data From Data Base!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub   
        
    }


    @FXML
    private void onEnter(KeyEvent ae) {
        
        if (ae.getCode().equals(KeyCode.ENTER)){ 
            String name = nameField.getText();
        String password = passwordField.getText();
        nameField.clear();
        passwordField.clear();
        boolean isUser;
        
        try {
            isUser = DBConnector.checkAgentPassword(name, password);
    
            if(!isUser){
                Alert alert = new Alert(AlertType.NONE);
                alert.setAlertType(AlertType.INFORMATION);
                alert.setHeaderText("Incorrect User Name Or Password");
                alert.setContentText("Incorrect User Name Or Password");
                alert.showAndWait();
            }else{
                Stage window = (Stage)(((Node)ae.getSource()).getScene().getWindow());
                window.setScene(App.mainScene);
                //window.getScene().getStylesheets().add("css/style.css");
                window.setResizable(true);
                window.setMaximized(true);
                window.setTitle("Domestic Tourism System");
                window.getIcons().add(new Image("/icon.png"));
            }            
        } catch (Exception e) {
            System.out.println(e.toString());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Faild To Retrieve Data From Data Base");
            alert.setContentText("Faild To Retrieve Data From Data Base!");
            alert.showAndWait();
        }
        }
}
}