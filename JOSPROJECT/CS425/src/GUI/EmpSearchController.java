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
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;



public class EmpSearchController {
    ArrayList <String> results;
    ObservableList<Object> result= FXCollections.observableArrayList();
    
    @FXML
    private ListView <Object> searchResult;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;
        
    @FXML
    private Button signOutButton;

    @FXML
    private Button backButton;

    @FXML
    void backButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) backButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader employee = new FXMLLoader(getClass().getResource("EmployeeMenu2.fxml"));
        employee.setController(new EmployeeMenuController());
        root2 = employee.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }
    

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
    void searchButtonFired(ActionEvent event) {
        Connection con1=null;
        String product="";
        boolean connect=false;
        int stock;
        String orderset;
        
        
        String storeID="";
        String brand="";
        String color="";
        
        String search = searchField.getText();
        System.out.println(search);
        
        searchResult.getItems().removeAll(result);
        result.clear();
        
        
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con1 = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl", "DMOCTEZUMA", "123456");

            if(con1 != null){
                System.out.println("Connection success!");
            }
            connect = true;

        } catch (Exception sqle) {
            System.out.println("An error occurred.");
            sqle.printStackTrace();
        }  
        
        try
        {
            
            //PreparedStatement stmt;
            
            String query = "select * " +
                    "from INVENTORY NATURAL JOIN PRODUCT" +
                    " where UPC_CODE= '" + search + "'" ;
            System.out.println(query);
            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            rs.next();
            product = rs.getString("DESCRIPTION");
            brand = rs.getString("BRANDNAME");
            color = rs.getString("COLOR");
            storeID=rs.getString("SID");
            stock = rs.getInt("STOCK");
            result.add(product + "    " + brand + "     " + color);
            result.add("Store: " +storeID + "     Stock: " +stock);
            while(rs.next())
            {
                storeID= rs.getString("SID");
                stock = rs.getInt("STOCK");
                orderset =  "Store: " +storeID + "     Stock: " + stock;
                result.add(orderset);
                
                
                
            }
           
        }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
        
        searchResult.getItems().addAll(result);
        
        
    }

}

