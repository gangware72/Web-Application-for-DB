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
public final class Shoe_Stub implements Observable_Shoe{
    private final SimpleStringProperty brand;
    private final SimpleStringProperty length;
    private final SimpleStringProperty width;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    public Shoe_Stub(String brand, String length, String width, String color, String SKU)
    {
        this.brand= new SimpleStringProperty(brand);
        this.length= new SimpleStringProperty(length);
        this.width= new SimpleStringProperty(width);
        this.color= new SimpleStringProperty(color);
        this.SKU= new SimpleStringProperty(SKU);
    }
    
    public String getBrand()
    {
        return brand.get();
    }
    
    public String getLength()
    {
        return length.get();
    }
    
    public String getWidth()
    {
        return width.get();
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
    
    public ObservableValue<String> lengthProperty()
    {
        return length;
    }
    
    public ObservableValue <String> widthProperty()
    {
        return width;
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
