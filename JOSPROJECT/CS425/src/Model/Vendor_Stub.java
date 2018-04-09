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
public final class Vendor_Stub implements Observable_Vendor{
    private final SimpleStringProperty VID;
    private final SimpleStringProperty name;
    
    public Vendor_Stub(String VID, String name)
    {
        this.VID = new SimpleStringProperty(VID);
        this.name = new SimpleStringProperty(name);
    }
    
    public String getVID()
    {
        return VID.get();
    }
    
    public String getName()
    {
        return name.get();
    }
    
    public ObservableValue<String> vidProperty()
    {
        return VID;
    }
    
    public ObservableValue<String> nameProperty()
    {
        return name;
    }
    
}
