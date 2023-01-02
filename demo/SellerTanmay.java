package demo;
import java.util.*;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Globals;
import ecomm.Platform;

public class SellerTanmay extends Seller {

    private ArrayList<Product> arr2 = new ArrayList<>();

    public SellerTanmay(String id){
        super(id);
    }

    public void addPlatform(Platform pf)
    {
        pf.addSeller(this);
    }
    public ArrayList<Product> findProducts(Globals.Category whichOne){

        for(Product pro : products){
            if(pro.getCategory() == whichOne){
                arr2.add(pro);
            }
        }
        
        return arr2;
    }  

    public boolean buyProduct(int id, int qty){
        boolean result = false;
        for(Product pro : products){
            if(pro.getProductID() == id){
                if(pro.getQuantity() >= qty){
                    result = true;
                    break;
                }
            }
        }
        return result;
    } 

}
