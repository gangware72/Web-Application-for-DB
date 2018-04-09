/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Daniel
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmployeeMenuController {

    @FXML
    private Button searchButton;

    @FXML
    private Button stockButton;
    
     @FXML
    private Button signOutButton;

    
    @FXML
    void signOutFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) signOutButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader customer = new FXMLLoader(getClass().getResource("JABMenu.fxml"));
        customer.setController(new JABMenuController());
        root2 = customer.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) searchButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader search = new FXMLLoader(getClass().getResource("EmployeeSearch.fxml"));
        search.setController(new EmpSearchController());
        root2 = search.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void stockButtonFired(ActionEvent event) throws Exception {
         Stage stage;
        Parent root2;
        
        stage=(Stage) searchButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader stock = new FXMLLoader(getClass().getResource("UpdateStock.fxml"));
        stock.setController(new StockUpdateController());
        root2 = stock.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();

    }

}

