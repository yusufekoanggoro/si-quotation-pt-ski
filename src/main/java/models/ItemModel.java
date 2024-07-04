package main.java.models;
 
import java.sql.Date;
import java.sql.Timestamp;

public class ItemModel {
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    private int id;
    private String name;
    private int price;
}
