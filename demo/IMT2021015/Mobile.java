package demo.IMT2021015;

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
    public String getName(){    // Returns the name of the item
        return this.unique_name;
    }
    public float getPrice(){    // Returns the price of the item
        return this.price;
    }
    public int getQuantity(){   // Returns the available quantity of the item
        return this.quantity;
    }
    public String getProductID(){   // Returns the ProductID of the item
        return this.id;
    }
    
    public Globals.Category getCategory(){  // Returns the category of the item
        return Globals.Category.Mobile;
    }
    public void setQuantity(int quantity){  // Updates the quantity of the item
        this.quantity = quantity;           // after it has been bought
    }

}