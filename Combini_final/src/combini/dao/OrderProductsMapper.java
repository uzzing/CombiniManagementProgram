package combini.dao;

import combini.vo.OrderProducts;
import combini.vo.Ordering;

public interface OrderProductsMapper {
	
	// order items
	public int insertOrderProducts(OrderProducts orderProducts);
	
	// insert total order
	public int insertOrdering(int totalOrderPrice);
	
	// get the order code 
	public Ordering selectTheLatest();
	
	// update total order price
	public int updateOrdering(Ordering newOrdering);
	
	// get order status
	public Ordering selectOrderStatus(String orderCode);	
}
