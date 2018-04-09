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
public final class Order_Stub implements Observable_Order{
    private final SimpleStringProperty PID;
    private final SimpleStringProperty CID;
    private final SimpleStringProperty SID;
    
    public Order_Stub(String PID, String CID, String SID)
    {
        this.PID = new SimpleStringProperty(PID);
        this.CID = new SimpleStringProperty(CID);
        this.SID = new SimpleStringProperty(SID);
    }
    
    public String getPID()
    {
        return PID.get();
    }
    
    public String getCID()
    {
        return CID.get();
    }
    
    public String getSID()
    {
        return SID.get();
    }
    
    public ObservableValue<String> pidProperty()
    {
        return PID;
    }
    
    public ObservableValue<String> cidProperty()
    {
        return CID;
    }
    
    public ObservableValue<String> sidProperty()
    {
        return SID;
    }
    
}
