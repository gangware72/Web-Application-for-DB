/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Customer_Stub;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CustomerController implements Initializable {
    
    private Customer_Stub user;
    
    public CustomerController(Customer_Stub usern)
    {
        this.user=usern;
        
    }
    
   
    
    @FXML
    private Text Welcome;

    @FXML
    private Button orderButton;

    @FXML
    private Button infoButton;
    
   /* @FXML
    private Button signout;*/

    @FXML
    void infoButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) infoButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader info = new FXMLLoader(getClass().getResource("PersonalInfo.fxml"));
        info.setController(new CustInfoController(user));  //this needs functionality
        root2 = info.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void orderButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) orderButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader order = new FXMLLoader(getClass().getResource("CustOrders.fxml"));
        order.setController(new CustOrderController(user));
        root2 = order.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }
    /*
    @FXML
    void signOutFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) signout.getScene().getWindow();
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
    */
    
     
    @Override
    public void initialize(URL url, ResourceBundle rsrcs)
    {
         Welcome.setText("Welcome " + user.getName());
    }

}

