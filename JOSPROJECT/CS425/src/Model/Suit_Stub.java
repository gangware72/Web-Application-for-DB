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
public final class Suit_Stub implements Observable_Suit {
    private final SimpleStringProperty brand;
    private final SimpleStringProperty chest;
    private final SimpleStringProperty length;
    private final SimpleStringProperty fit;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    public Suit_Stub(String brand, String chest, String length, String fit, String color, String SKU)
    {
        this.brand = new SimpleStringProperty(brand);
        this.chest = new SimpleStringProperty(chest);
        this.length = new SimpleStringProperty(length);
        this.fit = new SimpleStringProperty(fit);
        this.color = new SimpleStringProperty(color);
        this.SKU = new SimpleStringProperty(SKU);
    }
    
    @Override
    public String getBrand()
    {
        return brand.get();
    }
    
    @Override
    public String getChest()
    {
        return chest.get();
    }
    
    @Override
    public String getLength()
    {
        return length.get();
    }
    
    @Override
    public String getFit()
    {
        return fit.get();
    }
    
    @Override
    public String getColor()
    {
        return color.get();
    }
    
    @Override
    public String getSKU()
    {
        return SKU.get();
    }
    
    @Override
    public ObservableValue<String> brandProperty()
    {
        return brand;
    }
    
    @Override
    public ObservableValue <String> chestProperty()
    {
        return chest;
    }
    
    @Override
    public ObservableValue <String> lengthProperty()
    {
        return length;
    }
    
    @Override
    public ObservableValue <String> fitProperty()
    {
        return fit;
    }
    
    @Override
    public ObservableValue <String> colorProperty()
    {
        return color;
    }
    
    @Override
    public ObservableValue<String> skuProperty()
    {
        return SKU;
    }
    
    
}
