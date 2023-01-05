package demo.IMT2021015;
import java.util.*;

import ecomm.Seller;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import demo.DemoProduct;

public class SellerTanmay extends Seller {

    private ArrayList<DemoProduct> products  = new ArrayList<>();  // To store products
                                                                // of the seller
    public SellerTanmay(String id){
        super(id);

        // Creating Mobile objects
        Mobile mob1 = new Mobile("Xiaomi",10000,5);
        Mobile mob2 = new Mobile("Samsung",25000,2);
        Mobile mob3 = new Mobile("IPhone",80000,1);

        // Creating Mobile objects
        Book b1 = new Book("Book1",650,12);
        Book b2 = new Book("Book2",199,3);
        Book b3 = new Book("Book3",500,1);

        // Adding the products to ArrayList
        products.add(mob1);
        products.add(mob2);
        products.add(mob3);
        products.add(b1);
        products.add(b2);
        products.add(b3);
    }

    public void addPlatform(Platform pf)
    {
        pf.addSeller(this);     // Attaching seller to platform
    }
    public ArrayList<Product> findProducts(Globals.Category whichOne){

        ArrayList<Product> arr2 = new ArrayList<>();  // To be returned
        for(DemoProduct pro : products){
            if(pro.getCategory() == whichOne){
                arr2.add(pro);
            }
        }
        
        return arr2;
    }  

    public boolean buyProduct(String id, int qty){
        boolean result = false;
        for(DemoProduct pro : products){
            if(pro.getProductID().equals(id) ){
                if(pro.getQuantity() >= qty){
                    result = true;
                    pro.setQuantity(pro.getQuantity() - qty);  // Updating product
                    break;                              // quantity after it has been
                    }                                   // bought
            }
        }
        return result;
    } 

}
