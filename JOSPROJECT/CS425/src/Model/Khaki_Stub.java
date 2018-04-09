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
public class Khaki_Stub implements Observable_Khaki{
    private final SimpleStringProperty brand;
    private final SimpleStringProperty waist;
    private final SimpleStringProperty length;
    private final SimpleStringProperty fit;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
 
    public Khaki_Stub(String brand, String waist, String length, String fit, String color, String SKU)
    {
        this.brand = new SimpleStringProperty(brand);
        this.waist = new SimpleStringProperty(waist);
        this.length = new SimpleStringProperty(length);
        this.fit = new SimpleStringProperty(fit);
        this.color = new SimpleStringProperty(color);
        this.SKU = new SimpleStringProperty(SKU);
    }
    
    public String getBrand()
    {
        return brand.get();
    }
    
    public String getWaist()
    {
        return waist.get();
    }
    
    public String getLength()
    {
       return length.get();
    }
    
    public String getFit()
    {
        return fit.get();
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
    
    public ObservableValue<String> waistProperty()
    {
        return waist;
    }
    
    public ObservableValue <String> lengthProperty()
    {
        return length;
    }
    
    public ObservableValue <String> fitProperty()
    {
        return fit;
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
