import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {
    public static final boolean DEBUG = false;
    public static Scene loginScene = null;
    public static Scene mainScene = null;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/LoginWindow.fxml"));
        loginScene = new Scene(loginLoader.load());
        
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        mainScene = new Scene(mainLoader.load());

        try {
            // connect to data base
            DBConnector.getConnection();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection Faild");
            alert.setContentText("Connection To DataBase Faild!");
            alert.showAndWait();
            return;
        }

        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
