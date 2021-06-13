package combini.ui;

import java.util.List;
import java.util.Scanner;


import combini.service.SaleProductsService;
import combini.vo.Join;

public class SaleProductsUI {

	Scanner sc = new Scanner(System.in);
	SaleProductsService saleProductsService = new SaleProductsService();
	String er = "🚫";

	public void selectSaleProducts() {
		System.out.println("==============================================");
		System.out.println("  [[ Search sale products on specific day ]]");
		System.out.println("==============================================");
		System.out.print  ("  >> Enter day (ex. 2021/06/01) : ");
		String saleDate = sc.nextLine();

		if (saleDate == null || saleDate.trim().isEmpty()) {
			System.out.println("==============================================");
			System.out.println(er + "Please enter again" + er);
			return;
		}

		List<Join> list = saleProductsService.selectSaleProducts(saleDate);

		if (list == null || list.size() == 0) {
			System.out.println(er + " There is no sale products");
			return;
		}
		for (Join temp : list)
			System.out.println(temp);
	}
}