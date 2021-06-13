package combini.service;

import combini.dao.OrderProductsDAO;
import combini.vo.OrderProducts;
import combini.vo.Ordering;


public class OrderProductsService {

	private OrderProductsDAO dao = new OrderProductsDAO();
	
	// order items
	public int insertOrderProducts(OrderProducts orderProducts) {
		return dao.insertOrderProducts(orderProducts);
	}
	
	// insert total order
	public int insertOrdering(int totalOrderPrice) {
		return dao.insertOrdering(totalOrderPrice);
	}
	
	// get the order code
	public Ordering selectTheLatest() {
		return dao.selectTheLatest();
	}
	
	// update total order price & get ordering data
	public int updateOrdering(Ordering newOrdering) {
		return dao.updateOrdering(newOrdering);
	}
	
	// get Order status
	public Ordering selectOrderStatus(String orderCode) {
		return dao.selectOrderStatus(orderCode);
	}
}
