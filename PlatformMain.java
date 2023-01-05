import demo.DemoPlatform;
import demo.IMT2021010.SellerRaj;
import demo.IMT2021015.SellerTanmay;
import demo.IMT2021545.SellerAditya;
import ecomm.Platform;
import ecomm.Seller;
import java.util.Scanner;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform();  // replace with appropriate derived class
		
		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.
		
		// replace each of the XYZ below with the derived class name of one of the
		// team members.
		
		Seller s1 = new SellerRaj("Raj"); 
		s1.addPlatform(pf);

		Seller s2 = new SellerAditya("Aditya");
		s2.addPlatform(pf);
		
		Seller s3 = new SellerTanmay("Tanmay");
		s3.addPlatform(pf);
		// keep reading from System.in
		// If "Check" typed in
		// invoke
		String s;
		Scanner sc=new Scanner(System.in);
		while (true)
		{
			if(sc.nextLine().equals("Check"))
			{
				try{

					pf.processRequests();
				}
				catch(Exception e)
				{
				}
			}
		}
			
	}

}
