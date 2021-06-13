package combini.ui;

import java.util.Scanner;

import combini.service.OrderProductsService;
import combini.service.ProductsService;
import combini.vo.OrderProducts;
import combini.vo.Ordering;
import combini.vo.Products;

public class OrderUI {

	Scanner sc = new Scanner(System.in);
	private ProductsService productsService = new ProductsService();
	private OrderProductsService orderService = new OrderProductsService();
	String error = "🚫";

	public void orderMenu() {
		subMenu();
		String choice = sc.nextLine();

		switch (choice) {
		case "1" :
			insertOrder();
			break;
		case "2" :
			selectOrderStatus();
			break;
		case "0" :
			return;
		default :
			System.out.println(error + " Please choose again ");
			break;
		}
	}

	// in orderMenu()
	private void subMenu() {
		System.out.println("====================================");
		System.out.println("    1) New order");
		System.out.println("    2) Search your order status");
		System.out.println("    0) Go to home");
		System.out.println("====================================");
		System.out.print  ("     >> choose : ");
	}

	// orderMenu() -> case 1
	private void insertOrder() {
		sc.nextLine(); // clear buffer after choice in menu
		String productName = null;
		int orderCount = 0;
		int totalOrderPrice = 0;
		int count = 0;

		// set sequence first
		Ordering startOrdering = new Ordering();
		startOrdering.setTotal_order_price(totalOrderPrice);
		startOrder(startOrdering);

		// to exit order process
		boolean flag = true;

		while (flag) {
			System.out.println("===========================");
			System.out.println("   [[  Make an order  ]]");
			System.out.println("===========================");

			// receive data
			System.out.print(" >> Product name (without spaces) : ");
			productName = sc.nextLine();

			if (productName == null || productName.trim().isEmpty()) {
				System.out.println("===========================");
				System.out.println(error + "Please order again" + error);
				continue;
			}

			System.out.print(" >> Count : ");
			orderCount = sc.nextInt();
			sc.nextLine(); // to clear buffer

			if (orderCount == 0) {
				System.out.println("===========================");
				System.out.println(error + "Please order again" + error);
				continue;
			}

			// set the object 'order products'
			OrderProducts orderProducts = setOrderProducts(productName, orderCount);

			// get the object 'product' that the product name is same
			Products product = productsService.selectOne(productName);

			// if the product is null, deal with exception
			try {
				// set product code
				if (orderProducts.getProduct_name().equals(product.getProduct_name()))
					orderProducts.setProduct_code(product.getProduct_code());

				totalOrderPrice = endOneOrder(orderProducts, product, totalOrderPrice);

				if (totalOrderPrice == 0) break; // exit

			} catch (NullPointerException e) {
				System.out.println(error + "There is not a product." + error);
				System.out.println(error + "Please enter correct product name" + error);

				if (++count == 5) break;
			}

			// ask continue or break
			int choice = orderAgainMenu();

			// if user enter other numeric, deal with exception
			if (!(choice > 0 || choice < 3)) {
				System.out.println(error + "Please choose 1 or 2" + error);
				sc.nextLine();
				continue;
			}

			if (choice == 1) continue;
			else {
				endTotalOrder(totalOrderPrice);
				flag = false;
			}
		}
	}

	// in insertOrder() -> to set sequence first
	private void startOrder(Ordering ordering) {
		int result = orderService.insertOrdering(ordering.getTotal_order_price());
		if (result == 1) {
			System.out.println("===========================");
			System.out.println("Order process can be started");
		}
		else {
			System.out.println(error + "Please exit and restart order process" + error);
			return;
		}
	}

	// in insertOrder() -> set product name, order count
	private OrderProducts setOrderProducts(String productName, int orderCount) {

		OrderProducts orderProducts = new OrderProducts();
		orderProducts.setProduct_name(productName);
		orderProducts.setOrder_count(orderCount);

		return orderProducts;
	}

	// in insertOrder() -> insert one order into table order_products
	private int endOneOrder(OrderProducts orderProducts, Products product, int totalOrderPrice) {
		int result = orderService.insertOrderProducts(orderProducts);

		if (result == 1)  {
			System.out.println(" ** Order is succeeded");
			totalOrderPrice += orderProducts.getOrder_count() * product.getCost_price();
		}
		else {
			System.out.println(error + "Order is failed" + error);
			return 0;
		}

		return totalOrderPrice;
	}

	// in insertOrder()
	private int orderAgainMenu() {
		System.out.println("=====================");
		System.out.println("	1. Order more");
		System.out.println("	2. exit");
		System.out.println("=====================");
		System.out.print(" >> choose : ");
		int choice = sc.nextInt();
		sc.nextLine();

		return choice;
	}

	// in insertOrder()
	private void endTotalOrder(int totalOrderPrice) {

		Ordering theLatest = orderService.selectTheLatest();
		Ordering newOrdering = new Ordering();

		newOrdering.setOrder_code(theLatest.getOrder_code());
		newOrdering.setTotal_order_price(totalOrderPrice);

		int result = orderService.updateOrdering(newOrdering);

		System.out.println("===========================");
		if (result == 1) {
			System.out.println(" ** Order is successfully ended");
			System.out.println(" ** Your total order price is " + newOrdering.getTotal_order_price());
			System.out.println(" ** Your order code is " + newOrdering.getOrder_code());
		}
		else {
			System.out.println(error + " Total Order is failed" + error);
			System.out.println(error + " Please order all again" + error);
		}
	}
	
	// orderMenu() -> case 2
	private void selectOrderStatus() {
		sc.nextLine();  // clear buffer after choice in menu
		System.out.println("==================================");
		System.out.println("   [[  Search order status  ]] ");
		System.out.println("==================================");

		String orderCode;
		System.out.print("  >> Enter order code : ");

		try {
			orderCode = sc.nextLine();
		} catch(Exception e) {
			System.out.println(error + " Please enter correct code ");
			return; 
		}

		Ordering ordering = orderService.selectOrderStatus(orderCode);
		if (ordering == null) {
			System.out.println(error + " There is no order data " + error);
			return; 
		}
		
		// print order data
		System.out.print(" - Order data : ");
		System.out.println(ordering);
		
		// print order status
		System.out.print(" - Order status : ");
		if (ordering.getOrder_status() == 1)
			System.out.println("Order fulfillment completed");
		else if (ordering.getOrder_status() == 2)
			System.out.println("Delivery in process");
		else if (ordering.getOrder_status() == 3)
			System.out.println("Delivery complete");
	}
}