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
public final class Store_Stub {
    private final SimpleStringProperty SID;
    
    
    public Store_Stub(String SID)
    {
        this.SID = new SimpleStringProperty(SID);
        
    }
    
    public String getSID()
    {
        return SID.get();
    }    
        
    public ObservableValue<String> sidProperty()
    {
        return SID;
    }
    
    
}
