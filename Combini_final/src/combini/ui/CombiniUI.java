package combini.ui;

import java.sql.SQLException;
import java.util.Scanner;

public class CombiniUI {

	Scanner sc = new Scanner(System.in);
	StoreOwnerUI storeOwnerUI = new StoreOwnerUI();
	ProductsUI productsUI = new ProductsUI();
	SaleProductsUI saleProductsUI = new SaleProductsUI();
	OrderUI orderUI = new OrderUI();
	StockUI stockUI = new StockUI();
	String c = "🏪";
	String er = "🚫";
	
	// constructor
	public CombiniUI() {
		while(true) {
			menu();
			String choice = sc.nextLine();

			switch (choice) {
			case "1" :
				storeOwnerUI.register();
				break;
			case "2" :
				storeOwnerUI.login();
				break;
			case "3" :
				productsUI.selectProducts();
				break;
			case "4" :
				saleProductsUI.selectSaleProducts();
				break;
			case "5" :
				orderUI.orderMenu();
				break;
			case "6" :
				stockUI.stockMenu();
				break;
			case "7" :
				System.out.println("  " + c + " The program is successfully ended");
				System.out.println("  " + c + " Thank you");
				return;
			default :
				System.out.println("=======================================");
				System.out.println(er + " Please choose from 1 to 7 ");
				break;
			}
		}
	}

	// menu
	public void menu(){
		System.out.println("=======================================");
		System.out.println("   " + c + " Combini Management Program " + c);
		System.out.println("=======================================");
		System.out.println("	1. Register");
		System.out.println("	2. Login");
		System.out.println("	3. Products Management");
		System.out.println("	4. Sale products Management");
		System.out.println("	5. Order Management");
		System.out.println("	6. Stock Management");
		System.out.println("	7. exit");
		System.out.println("=======================================");
		System.out.print  ("	>> choose :  ");
	}
}
