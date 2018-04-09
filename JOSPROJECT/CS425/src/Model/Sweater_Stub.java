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
public final class Sweater_Stub {
    private final SimpleStringProperty brand;
    private final SimpleStringProperty size;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    public Sweater_Stub(String brand, String size, String color, String SKU)
    {
            this.brand = new SimpleStringProperty(brand);
            this.size = new SimpleStringProperty(size);
            this.color = new SimpleStringProperty(color);
            this.SKU = new SimpleStringProperty(SKU);
    
                    
    }
    
    public String getBrand()
    {
        return brand.get();
    }
    
    public String getSize()
    {
        return size.get();
    }
    
       
    public String getColor()
    {
        return color.get();
    }
    
    public String getSKU()
    {
        return SKU.get();
    }
    
    public ObservableValue<String> brandProperty()
    {
        return brand;
    }
    
    public ObservableValue<String> sizeProperty()
    {
        return size;
    }
    
        
    public ObservableValue <String> colorProperty()
    {
        return color;
    }
    
    public ObservableValue <String> skuProperty()
    {
        return SKU;
    }
    
}
