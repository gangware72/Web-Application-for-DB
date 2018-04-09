/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author danmo
 */
public final class Customer_Stub implements Observable_Customer {
    private final SimpleStringProperty name;
    private final SimpleStringProperty CID;
    private final SimpleStringProperty email;
    private final SimpleStringProperty CCN;
    private final SimpleStringProperty addr;
    
    private final SimpleStringProperty phone;
    
    public Customer_Stub(String rname, String CID, String email,String phone, String addr)
    {
        this.name = new SimpleStringProperty(rname);
        this.CID= new SimpleStringProperty(CID);
        this.email= new SimpleStringProperty(email);
        this.phone= new SimpleStringProperty(phone);
        this.CCN = new SimpleStringProperty("");
        this.addr = new SimpleStringProperty(addr);
    }
    
    public Customer_Stub(String rname, String CID, String email,String phone, String addr, String CCN)
    {
        this.name = new SimpleStringProperty(rname);
        this.CID= new SimpleStringProperty(CID);
        this.email= new SimpleStringProperty(email);
        this.CCN= new SimpleStringProperty(CCN);        
        this.phone= new SimpleStringProperty(phone);
        this.addr = new SimpleStringProperty(addr);
    }
    
    public String getName()
    {
        return name.get();
    }
    
    public String getCID()
    {
        return CID.get();
    }
    
    public String getEmail()
    {
        return email.get();
    }
    
    public String getCCN()
    {
        return CCN.get();
    }
    
       
    public String getPhone()
    {
        return phone.get();
    }
    
    public String getAddr()
    {
        return addr.get();
    }
    
    public ObservableValue<String> nameProperty()
    {
        return name;
    }
    
    public ObservableValue<String> emailProperty()
    {
        return email;
    }
    
    public ObservableValue<String> cidProperty()
    {
        return CID;
    }
        
    
    public ObservableValue<String> creditProperty()
    {
        return CCN;
    }
    
    public ObservableValue<String> phoneProperty()
    {
        return phone;
    }
    
    public ObservableValue<String> addrProperty()
    {
        return addr;
    }
    
    
    
    
    
}
