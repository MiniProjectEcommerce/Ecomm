package demo.IMT2021015;

import ecomm.Globals;
import demo.DemoProduct;

public class Book extends DemoProduct
{
    public Book(String name, int price, int quantity)   
    {
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
    public float getPrice(){   // Returns the price of the item
        return this.price;
    }
    public int getQuantity(){    // Returns the available quantity of the item
        return this.quantity;
    }
    public String getProductID(){   // Returns the product id
        return this.id;
    }
    public Globals.Category getCategory(){   // Returns the category
        return Globals.Category.Book;
    }
    public void setQuantity(int quantity){    // Updates the quantity of item 
        this.quantity = quantity;             // after it has been bought
    }

}