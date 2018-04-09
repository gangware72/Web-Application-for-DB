package model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public final class Polo_Stub implements Observable_Polo
{    
    private final SimpleStringProperty brand;
    private final SimpleStringProperty size;
    private final SimpleStringProperty fit;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    public Polo_Stub(String brand, String size, String fit, String color, String SKU)
    {
        this.brand = new SimpleStringProperty(brand);
        this.size = new SimpleStringProperty(size);
        this.fit = new SimpleStringProperty (fit);
        this.color = new SimpleStringProperty (color);
        this.SKU = new SimpleStringProperty (SKU);
    }
    
    @Override
    public String getBrand()
    {
        return brand.get();
    }
    
    @Override
    public String getSize()
    {
        return size.get();
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
    public ObservableValue<String> sizeProperty()
    {
        return size;
    }
    
    @Override
    public ObservableValue<String> fitProperty()
    {
        return fit;
    }
    
    @Override 
    public ObservableValue<String> colorProperty()
    {
        return color;
    }
    
    @Override
    public ObservableValue<String> skuProperty()
    {
        return SKU;
    }
    
    
    
    
}