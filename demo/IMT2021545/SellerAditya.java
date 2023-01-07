package demo.IMT2021545;
import java.util.*;

import demo.DemoProduct;
import ecomm.Seller;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;

public class SellerAditya extends Seller {

    private ArrayList<DemoProduct> prods;   // To store products

    public SellerAditya(String id){
        super(id);
        prods=new ArrayList<>();

        // Different mobiles available with seller
        Mobile mob1 = new Mobile("Nokia",5000,10);
        prods.add(mob1);

        Mobile mob2 = new Mobile("Vivo",40000,13);
        prods.add(mob2);

        Mobile mob3 = new Mobile("Oppo",60000,7);
        prods.add(mob3);

        // Different books available with seller
        Book b1 = new Book("Book1",650,12);
        prods.add(b1);

        Book b2 = new Book("Book2",199,3);
        prods.add(b2);

        Book b3 = new Book("Book3",500,1);
        prods.add(b3);

    }

    // To add seller to platform
    public void addPlatform(Platform platform){
        platform.addSeller(this);   
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne){

        ArrayList<Product> arr2 = new ArrayList<>();    // ArrayList to be returned
        for(DemoProduct pro : prods){
            if(pro.getCategory() == whichOne){  // If category of a product matches
                arr2.add(pro);                // add it to the ArrayList
            }
        }
        
        return arr2;
    }  


    // To buy a product with desired product id and quantity
    public boolean buyProduct(String id, int qty){
        boolean result = false;
        for(DemoProduct pro : prods){
            if(pro.getProductID().equals(id) ){     // Checking product id

                // A product can only be bought if its demanded quantity is greater 
                // than or equal to the available quantity
                if(pro.getQuantity() >= qty){  
                    result = true;
                    pro.setQuantity(pro.getQuantity() - qty);
                    break;
                }
            }
        }
        return result;
    } 

}
