package demo;

import java.io.File;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoPlatform extends Platform {


	@Override
	public void addSeller(Seller aSeller) {
		this.sellers.add(aSeller);
	}

	@Override
	public void processRequests() throws Exception {
		File toFile = new File("demo/"+Globals.toPlatform);
		Scanner sc = new Scanner(toFile);
		FileWriter fromFile = new FileWriter("demo/"+Globals.fromPlatform, true);
		
		while (sc.hasNextLine()) {
			int PortalID = sc.nextInt();
			int RequestID = sc.nextInt();
			String Request = sc.next();
			System.out.print(PortalID);
			int quantity;
			String id,category;
			if (Request.equals("List")) {
				category = sc.next();
				ArrayList<Product> products = new ArrayList<>();
				for (Seller s : sellers) {
					if (category.equals("Book")) {
						products.addAll(s.findProducts(Globals.Category.Book));
					}
					if (category.equals("Mobile")) {
						products.addAll(s.findProducts(Globals.Category.Mobile));
					}
				}
				for (Product p : products) {
					fromFile.write(PortalID + " " + RequestID + " " + p.getName() + " " + p.getProductID() + " "
							+ p.getPrice() + " " + p.getQuantity()+"\n");
				}
			} else if (Request.equals("Buy")) {
				id = sc.next();
				quantity = sc.nextInt();
				boolean flag = true;
				for (Seller s : sellers) {
					if (flag == false) {
						break;
					}
					if (s.buyProduct(id, quantity)) {
						fromFile.write(PortalID + " " + RequestID + " " + "Success"+"\n");
						flag = false;
						break;
					}
				}
				if (flag) {
					fromFile.write(PortalID + " " + RequestID + " " + "Failure"+"\n");
				}
			}
			if(Request.equals("Start"))
			{
				fromFile.write(PortalID + " " + RequestID + " " + "Mobile"+" "+ "Book"+"\n");
			}
			fromFile.close();
			sc.close();
			// clear the file after reading to avoid reading the same request again
			FileWriter clearWriter = new FileWriter("demo/"+Globals.toPlatform);
			clearWriter.write("");
			clearWriter.close();
		}
	}
}
