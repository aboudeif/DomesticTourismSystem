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
    private TableView<Tourist> touristTable;

    @FXML
    private TableView<Guide> guideTable;

    @FXML
    private TableView<Agent> agentTable;

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
    void refreshTourist(ActionEvent event) {
        refreshTouristTableView();
    }
    
    @FXML
    void deleteTourist(ActionEvent event) {
        Tourist tourist = touristTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteTourist(tourist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        refreshTouristTableView();
    }
    
    @FXML
    void editTourist(ActionEvent event) {
        Tourist tourist = touristTable.getSelectionModel().getSelectedItem();
        if (tourist == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TouristWindow.fxml"));
            Parent root = loader.load();
            TouristWindowController controller = loader.getController();
            controller.setTourist(tourist);
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
    void addTourist(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TouristWindow.fxml"));
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
    void refreshGuide(ActionEvent event) {
        refreshGuideTableView();
    }
    
    @FXML
    void deleteGuide(ActionEvent event) {
        Guide guide = guideTable.getSelectionModel().getSelectedItem();
        try {
            DBQuery.deleteGuide(guide);
        } catch (Exception e) {
            e.printStackTrace();
        }
        refreshGuideTableView();
    }
    
    @FXML
    void editGuide(ActionEvent event) {
        Guide guide = guideTable.getSelectionModel().getSelectedItem();
        if (guide == null)
            return;
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideWindow.fxml"));
            Parent root = loader.load();
            GuideWindowController controller = loader.getController();
            controller.setGuide(guide);
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
    void addGuide(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideWindow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Store the Instance
        instance = this;

        // init database tables
        initAgentTableView();
        initTouristTableView();
        initGuideTableView();
        
    }

    // ------------- Internal Methods ------------- //

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
        
        TableColumn<Agent, String> cityIDColumn = new TableColumn<>("City");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        agentTable.getColumns().add(cityIDColumn);
        
        TableColumn<Agent, String> localAddressColumn = new TableColumn<>("Local Address");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        agentTable.getColumns().add(localAddressColumn);
        
        TableColumn<Agent, Date> createdDateColumn = new TableColumn<>("Created Date");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        agentTable.getColumns().add(createdDateColumn);
        
        TableColumn<Agent, Integer> idleColumn = new TableColumn<>("Idle");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        agentTable.getColumns().add(idleColumn);
        
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

    void initTouristTableView(){
        touristTable.getColumns().clear();
        
        TableColumn<Tourist, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        touristTable.getColumns().add(idColumn);
        
        TableColumn<Tourist, Integer> prtColumn = new TableColumn<>("Partner");
        prtColumn.setCellValueFactory(new PropertyValueFactory<>("partner"));
        touristTable.getColumns().add(prtColumn);
       
        TableColumn<Tourist, String> infoColumn = new TableColumn<>("Info");
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        touristTable.getColumns().add(infoColumn);
        
        TableColumn<Tourist, Double> balanceColumn = new TableColumn<>("Balance");
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        touristTable.getColumns().add(balanceColumn);
        
        TableColumn<Tourist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        touristTable.getColumns().add(nameColumn);
        
        TableColumn<Tourist, String> nidColumn = new TableColumn<>("NID");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        touristTable.getColumns().add(nidColumn);
        
        TableColumn<Tourist, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        touristTable.getColumns().add(genderColumn);
        
        TableColumn<Tourist, String> mobileColumn = new TableColumn<>("Mobile/Phone");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        touristTable.getColumns().add(mobileColumn);
        
        TableColumn<Tourist, Date> birthDateColumn = new TableColumn<>("Birth Date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        touristTable.getColumns().add(birthDateColumn);
        
        TableColumn<Tourist, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        touristTable.getColumns().add(emailColumn);
        
        TableColumn<Tourist, String> cityIDColumn = new TableColumn<>("City");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        touristTable.getColumns().add(cityIDColumn);
        
        TableColumn<Tourist, String> localAddressColumn = new TableColumn<>("Local Address");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        touristTable.getColumns().add(localAddressColumn);
        
        TableColumn<Tourist, Date> createdDateColumn = new TableColumn<>("Created Date");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        touristTable.getColumns().add(createdDateColumn);
        
        TableColumn<Tourist, Integer> idleColumn = new TableColumn<>("Idle");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        touristTable.getColumns().add(idleColumn);
        
        refreshTouristTableView();
    }

    void refreshTouristTableView(){
        // clear all items
        touristTable.getItems().clear();

        List<Tourist> list = null;
        try{
            list = DBQuery.getTouristsData();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(touristTable != null)
            for (Tourist t : list)
                touristTable.getItems().add(t);
    }

    void initGuideTableView(){
        guideTable.getColumns().clear();
        
        TableColumn<Guide, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        guideTable.getColumns().add(idColumn);
    
        TableColumn<Guide, Integer> specialtyColumn = new TableColumn<>("specialty");
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        guideTable.getColumns().add(specialtyColumn);
        
        TableColumn<Guide, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        guideTable.getColumns().add(nameColumn);
        
        TableColumn<Guide, String> nidColumn = new TableColumn<>("NID");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        guideTable.getColumns().add(nidColumn);
        
        TableColumn<Guide, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        guideTable.getColumns().add(genderColumn);
        
        TableColumn<Guide, String> mobileColumn = new TableColumn<>("Mobile/Phone");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        guideTable.getColumns().add(mobileColumn);
        
        TableColumn<Guide, Date> birthDateColumn = new TableColumn<>("Birth Date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        guideTable.getColumns().add(birthDateColumn);
        
        TableColumn<Guide, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        guideTable.getColumns().add(emailColumn);
        
        TableColumn<Guide, String> cityIDColumn = new TableColumn<>("City");
        cityIDColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        guideTable.getColumns().add(cityIDColumn);
        
        TableColumn<Guide, String> localAddressColumn = new TableColumn<>("Local Address");
        localAddressColumn.setCellValueFactory(new PropertyValueFactory<>("localAddress"));
        guideTable.getColumns().add(localAddressColumn);
        
        TableColumn<Guide, Double> rateColumn = new TableColumn<>("Rate");
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        guideTable.getColumns().add(rateColumn);
        
        TableColumn<Guide, Date> createdDateColumn = new TableColumn<>("Created Date");
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        guideTable.getColumns().add(createdDateColumn);
        
        TableColumn<Guide, Integer> idleColumn = new TableColumn<>("Idle");
        idleColumn.setCellValueFactory(new PropertyValueFactory<>("idle"));
        guideTable.getColumns().add(idleColumn);
        
        refreshGuideTableView();
    }

    void refreshGuideTableView(){
        // clear all items
        guideTable.getItems().clear();

        List<Guide> list = null;
        try{
            list = DBQuery.getGuideData();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(guideTable != null)
            for (Guide g : list)
                guideTable.getItems().add(g);
    }

}
