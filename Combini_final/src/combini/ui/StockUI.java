package combini.ui;

import java.util.List;
import java.util.Scanner;

import combini.service.ProductsService;
import combini.vo.Products;

public class StockUI {
	
	Scanner sc = new Scanner(System.in);
	ProductsService stockService = new ProductsService();
	
	String er = "🚫";
	
	public void stockMenu() {
		subMenu();
		String choice = sc.nextLine();

		switch(choice) {
		case "1" :
			selectAll();
			break;
		case "2" :
			selectOne();
			break;
		case "3" :
			updateStock();
			break;
		case "0" :
			return;
		default :
			System.out.println(er + " Please choose again ");
			break;
		}
	}
	
	// in searchStock()
	private void subMenu() {
		System.out.println("========================================");
		System.out.println("        [[ Stock management ]] ");
		System.out.println("========================================");
		System.out.println("    1) Search stock of all products");
		System.out.println("    2) Search stock of one product");
		System.out.println("    3) Update stock");
		System.out.println("    0) Go to home");
		System.out.println("=======================================");
		System.out.print  ("    >> choose : ");
	}
	
	// in searchStock() -> case 1
	private void selectAll() {
		System.out.println("======================================");
		System.out.println("  [[ Search stock of all products ]]");
		System.out.println("======================================");

		List<Products> stockList = stockService.selectAll();

		if(stockList == null) {
			System.out.println(er + " There is no stock now");
			return;
		}

		for(Products p : stockList)
			System.out.println("   " + p.getProduct_name() + " : " + p.getStock());
	}
	
	// in searchStock() -> case 2
	private void selectOne() {
		System.out.println("=======================================");
		System.out.println("   [[ Search stock of one product ]]");
		System.out.println("=======================================");

		String productName;
		System.out.print(" >> Enter product name : ");
		productName = sc.nextLine();
		
		if (productName == null || productName.trim().isEmpty()) {
			System.out.println("===========================");
			System.out.println(er + "Please enter correct product name");
			return;
		}

		Products product = stockService.selectOne(productName);
		if (product == null) {
			System.out.println(er + " There is no product.");
			return;
		}
		
		System.out.println("   " + product.getProduct_name() + " : " + product.getStock());
	}
	
	// in searchStock() -> case 3
	private void updateStock() {

		System.out.println("=========================");
		System.out.println("   [[ Update stock ]] ");
		System.out.println("=========================");

		String productName;

		System.out.print(" >> Enter product name : ");
		productName = sc.nextLine();
		
		if (productName == null || productName.trim().isEmpty()) {
			System.out.println("===========================");
			System.out.println(er + "Please enter correct product name");
			return;
		}

		Products product = stockService.selectOne(productName);
		if (product == null) {
			System.out.println(er + " There is no product.");
			return;
		}
		System.out.println("   " + product.getStock() + " left in stock");

		// select update count
		int stock; 
		String answer = null; 
		System.out.println("\n Do you want to add stock of " + productName + "?");
		System.out.print(" >> choose (Y/N) : ");
		answer = sc.next();
		
		if (!answer.toUpperCase().equals("Y")) {
			System.out.println(" ** The process of updating stock is successfully ended");
			return;
		}

		// enter the count to be added
		System.out.print(" >> Enter the count to be added  : ");
		stock = sc.nextInt();

		Products temp = new Products(null, 0, productName, 0, stock, 0);
		int result = stockService.updateStock(temp);
		if(result == 1) {
			System.out.println(" ** Successfully added");
		
		//재고 동기화 성공으로 변경된 데이터 출력	
		Products updatedProduct = stockService.selectOne(productName);
		System.out.println("   " + updatedProduct.getProduct_name() + " : " + updatedProduct.getStock() + " left in stock");
		} else {
			System.out.println(er + " Add failed ");
		}
	}
}
