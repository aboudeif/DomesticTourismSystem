/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Abdallah
 */
public class RegTransportWindowController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private TableView<?> transportTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acceptOperation(ActionEvent event) {
    }

    @FXML
    private void cancleOperation(ActionEvent event) {
    }
    
}
