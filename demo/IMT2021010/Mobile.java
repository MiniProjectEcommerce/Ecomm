package demo.IMT2021010;

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
    public String getName(){    // To get the name of a product
        return this.unique_name;
    }
    public float getPrice(){    // To get the price of a product
        return this.price;
    }
    public int getQuantity(){   // To get the quantity of a product
        return this.quantity;
    }
    public String getProductID(){   // To get the product_id of a product
        return this.id;
    }
    
    public Globals.Category getCategory(){  // To get the category
        return Globals.Category.Mobile;
    }
    public void setQuantity(int quantity){  // To update the quantity
        this.quantity = quantity;
    }

}