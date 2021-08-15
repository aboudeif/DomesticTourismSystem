/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class RegTouristWindowController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private TableView<Tourist> touristTable;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTouristTableView();
        
    }    

    @FXML
    private void acceptOperation(ActionEvent event) {
        RegTourist regTourist = new RegTourist();
        regTourist.setTourist(touristTable.getSelectionModel().getSelectedItem());
        regTourist.setTravel(Travel.getSelectedTravel().getId());
        try{
            DBQuery.addRegTourist(regTourist);
        }catch(Exception e){
        }
        MainWindowController.getInstance().refreshRegTouristTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void cancleOperation(ActionEvent event) {
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }

    
     void initTouristTableView(){
        touristTable.getColumns().clear();
        
        TableColumn<Tourist, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        touristTable.getColumns().add(idColumn);
        
        TableColumn<Tourist, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        touristTable.getColumns().add(nameColumn);
        
        TableColumn<Tourist, String> nidColumn = new TableColumn<>("الرقم القومي");
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        touristTable.getColumns().add(nidColumn);
        
        refreshTouristTableView();
    }

    void refreshTouristTableView(){
        // clear all items
        touristTable.getItems().clear();

        List<Tourist> list = null;
        try{
            list = DBQuery.getResTourist(DBQuery.getData("Tourist"));
        }catch(Exception e){
        }
        if(touristTable != null)
            for (Tourist t : list)
                touristTable.getItems().add(t);
    }
    
}
