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

/**
 * FXML Controller class
 *
 * @author Abdallah
 */
public class RegPlaceWindowController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private TableView<Place> placeTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPlaceTableView();
    }    

    @FXML
    private void acceptOperation(ActionEvent event) {
     RegPlace regPlace = new RegPlace();
        regPlace.setPlace(placeTable.getSelectionModel().getSelectedItem());
        regPlace.setTravel(Travel.getSelectedTravel().getId());
        try{
            DBQuery.addRegPlace(regPlace);
        }catch(Exception e){
        }
        MainWindowController.getInstance().refreshRegPlaceTableView(Travel.getSelectedTravel());
    }

    @FXML
    private void cancleOperation(ActionEvent event) {
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.close();
    }
    
    void initPlaceTableView(){
        placeTable.getColumns().clear();
        
        TableColumn<Place, Integer> idColumn = new TableColumn<>("الرقم");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        placeTable.getColumns().add(idColumn);
    
        TableColumn<Place, String> typeColumn = new TableColumn<>("النوع");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        placeTable.getColumns().add(typeColumn);
        
        TableColumn<Place, String> nameColumn = new TableColumn<>("الاسم");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        placeTable.getColumns().add(nameColumn);
        
        TableColumn<Place, Integer> capacityColumn = new TableColumn<>("السعة");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        placeTable.getColumns().add(capacityColumn);
        
        
        refreshPlaceTableView();
    }

    void refreshPlaceTableView(){
        // clear all items
        placeTable.getItems().clear();

        List<Place> list = null;
        try{
            list = DBQuery.getResPlace(DBQuery.getData("Place"));
        }catch(Exception e){
        }
        if(placeTable != null)
            for (Place p : list)
                placeTable.getItems().add(p);
    }
}
