package demo.IMT2021545;

import ecomm.Globals;
import demo.*;

public class Mobile extends DemoProduct
{
    public Mobile(String name, int price, int quantity){
        this.unique_name = name;
        this.price = price;
        this.quantity = quantity;
        product_id++;         // Assigning new DemoProduct id
        String str = String.valueOf(product_id);
        this.id = str;
    }
    public String getName(){
        return this.unique_name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getProductID(){
        return this.id;
    }
    
    public Globals.Category getCategory(){
        return Globals.Category.Mobile;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}