package combini.ui;

import java.util.List;
import java.util.Scanner;

import combini.service.ProductsService;
import combini.vo.Products;

public class ProductsUI {

	Scanner sc = new Scanner(System.in);
	ProductsService productsService = new ProductsService();
	String er = "🚫";

	// first ui
	public void selectProducts() {
		subMenu();
		String choice = sc.nextLine();
		
		switch(choice) {
		case "1" :
			selectAll();
			break;
		case "2" :
			selectMultiple();
			break;
		case "0" :
			return;
		default :
			System.out.println(er + " Please choose again ");
			break;
		}
	}
	
	// in selectProducts()
	private void subMenu() {
		System.out.println("=======================================");
		System.out.println("    1) Search all products");
		System.out.println("    2) Search products by product name");
		System.out.println("    0) Go to home");
		System.out.println("=======================================");
		System.out.print  ("       >> choose : ");
	}
	
	// selectProducts() -> case 1
	private void selectAll() {
		System.out.println("===============================");
		System.out.println("   [[ Search all products ]]");
		System.out.println("===============================");

		List<Products> list = productsService.selectAll();
		
		for (Products temp : list) {
			System.out.println(temp);
		}
	}
	
	// selectProducts() -> case 2
	private void selectMultiple() {
		System.out.println("===============================");
		System.out.print("  >> Enter product name : ");
		String productName = sc.nextLine();

		List<Products> list = productsService.selectMultiple(productName);
		
		if (list == null || list.size() == 0) {
			System.out.println(er + " There are no products");
			return;
		}
		
		for (Products temp : list)
			System.out.println(temp);
	}

}
