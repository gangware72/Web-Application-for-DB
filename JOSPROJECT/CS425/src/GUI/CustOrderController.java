/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Customer_Stub;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustOrderController implements Initializable {
    
    //need an intizalizable that sets the editing to false
    //on completion of edit, also sets it to false, perhaps a confirm button
    //CID needs to be passed to every customer menu

    Customer_Stub user;
    Connection con1=null;
    ArrayList <String> purchaseID = new ArrayList <String>();
    ArrayList <String> products = new ArrayList<String>();
    
    public CustOrderController(Customer_Stub user)
    {
        this.user = user;
    }
    
       
    @FXML
    private Text orderText;
    
    @FXML
    private ListView<Object> resultList;
    
    

    @FXML
    private Button viewButton;

    @FXML
    private ListView<Object> orderList;
    
    @FXML
    private Button backButton;

    @FXML
    private Button signOut;
    
    
    //Create connection and list all customer orders
    public void initialize(URL url, ResourceBundle rsrcs)
    {
         String order="";
              
       try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con1 = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl", "DMOCTEZUMA", "123456");

            if(con1 != null){
                System.out.println("Connection success!");
            }
            //connect = true;

        } catch (Exception sqle) {
            System.out.println("An error occurred.");
            sqle.printStackTrace();
        } 
        
       System.out.println(user.getCID());
        
       try
       {
            
            //PreparedStatement stmt;
            
            String query = "select PID " +
                    "from ORDERS" +
                    " where CID= '" + user.getCID() + "'" ;
            System.out.println(query);
            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                //product = rs.getString("DESCRIPTION");
                order = rs.getString("PID");
                if(!purchaseID.contains(order))
                {
                    System.out.println("not in order");
                    purchaseID.add(order);
                    orderList.getItems().addAll(order);
                }
                
                //orderList.getItems().addAll(order);               
                
                
            }
            if(order.equals(""))
            {
                System.out.println("whoops");
            }
            else
                System.out.println(order);
        }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
        
        
    }

    @FXML
    void backButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) backButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader customer = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
        customer.setController(new CustomerController(user));
        root2 = customer.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void signOutFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) signOut.getScene().getWindow();
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
    void viewButtonFired(ActionEvent event) {
        String find = "";
        String orderset="";
        String order2="";
        String price;
        String cparse = "";
        float cost;
        
        
        resultList.getItems().removeAll(products);
        products.clear();
        
        //this needs functionality
        String check = orderList.getSelectionModel().getSelectedItems().toString();
        
        
        
        //parse the string
        
        for(int i=1; i<check.length()-1; i++)
        {
            find += check.charAt(i); 
        }
        System.out.println(find);
        
        orderText.setText("Order no: " + find);
        
        
        
        try
       {
            
            //PreparedStatement stmt;
            
            String query = "select UPC_CODE, DESCRIPTION, CURRENTDATE, COLOR, PRICE, BRANDNAME " +
                    "from ORDERS NATURAL JOIN PRODUCT" +
                    " where PID= '" + find + "'" ;
            System.out.println(query);
            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            rs.next();
            orderset = "Purchased on:      " + rs.getString("CURRENTDATE");
            products.add(orderset);
            while(rs.next())
            {
                //product = rs.getString("DESCRIPTION");
                price = rs.getString("PRICE");
                System.out.println(price);
                for(int i=1; i<price.length();i++)
                {
                    cparse+= cparse + price.charAt(i);
                }
                System.out.println(cparse);
                //Float scost = new Float(cparse);
                //cost = scost.floatValue();
                orderset = rs.getString("UPC_CODE") + "      "  + rs.getString("DESCRIPTION") +
                        "     " + rs.getString("COLOR") + "     " + rs.getString("BRANDNAME");
                products.add(orderset);
               
                System.out.println(orderset);   
                cparse ="";
            }
             resultList.getItems().addAll(products);
           
        }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
        
       

    }
    

}
