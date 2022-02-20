package Model;

import java.util.ArrayList;
import java.util.List;

public class Shoe {
    private int id;
    private String color;
    private int price;
    private String name;
    private Brand brand;
    private List<ShoeType> shoeTypes = new ArrayList<>();

    public Shoe(int id, String color, int price, String name, Brand brand) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addToShoeType(ShoeType shoeType){
        shoeTypes.add(shoeType);
    }


    @Override
    public String toString() {
        return "Shoe name:"+name+", color:"+color+", Price:"+price+", Brand:"+brand.getName()+", Categories:" +shoeTypes.toString();
    }
}
