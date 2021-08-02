import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

    private static MainWindowController instance;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button loadAgentDataButton;

    @FXML
    private TableView<Tourist> touristTable;

    @FXML
    private Button loadTouristDataButton;

    @FXML
    private TableView<Guid> guidTable;

    @FXML
    private TableView<Agent> agentTable;

    @FXML
    private Button loadGuidDataButton;

    @FXML
    void refreshAgent(ActionEvent event) {
        refreshAgentTableView();
    }

    public static MainWindowController getInstance() {
        return instance;
    }

    @FXML
    void deleteAgent(ActionEvent event) {
        Agent agent = agentTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteAgent(agent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        refreshAgentTableView();
    }

    @FXML
    void editAgent(ActionEvent event) {
        Agent agent = agentTable.getSelectionModel().getSelectedItem();
        if (agent == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgentWindow.fxml"));
            Parent root = loader.load();
            AgentWindowController controller = loader.getController();
            controller.setAgent(agent);
            controller.setEditOp(true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void addAgent(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgentWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void loadTouristData(ActionEvent event) {

    }

    @FXML
    void loadGuidData(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Store the Instance
        instance = this;

        // refresh database
        initAgentTableView();
        
    }

    void initAgentTableView(){
        agentTable.getColumns().clear();
        
        TableColumn<Agent, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        agentTable.getColumns().add(idColumn);
        
        TableColumn<Agent, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        agentTable.getColumns().add(nameColumn);
        
        TableColumn<Agent, String> nidColumn = new TableColumn<>("NID");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        agentTable.getColumns().add(nidColumn);
        
        TableColumn<Agent, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        agentTable.getColumns().add(genderColumn);
        
        TableColumn<Agent, String> mobileColumn = new TableColumn<>("Mobile/Phone");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        agentTable.getColumns().add(mobileColumn);
        
        TableColumn<Agent, Date> birthDateColumn = new TableColumn<>("Birth Date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        agentTable.getColumns().add(birthDateColumn);
        
        TableColumn<Agent, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        agentTable.getColumns().add(emailColumn);
        
        TableColumn<Agent, Integer> cityIDColumn = new TableColumn<>("City ID");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("cityID"));
        agentTable.getColumns().add(cityIDColumn);
        
        TableColumn<Agent, String> localAddressColumn = new TableColumn<>("Local Address");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        agentTable.getColumns().add(localAddressColumn);
        
        TableColumn<Agent, Date> createdDateColumn = new TableColumn<>("Created Date");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        agentTable.getColumns().add(createdDateColumn);
        
        TableColumn<Agent, Integer> roleIDColumn = new TableColumn<>("Role ID");
        roleIDColumn.setCellValueFactory(new PropertyValueFactory<>("roleID"));
        agentTable.getColumns().add(roleIDColumn);
        
        refreshAgentTableView();
    }

    void refreshAgentTableView(){
        // clear all items
        agentTable.getItems().clear();

        List<Agent> angetList = null;
        try{
            angetList = DBQuery.getAgentData();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(angetList != null)
            for (Agent agent : angetList)
                agentTable.getItems().add(agent);
        
    }

}
