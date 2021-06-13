package combini.vo;

public class OrderProducts {
	private String order_product_code;
	private String product_code;
	private String product_name;
	private int order_count;
	private String order_code; // fk
	
	// getter, setter
	public String getOrder_product_code() {
		return order_product_code;
	}
	public String getProduct_code() {
		return product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getOrder_count() {
		return order_count;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_product_code(String order_product_code) {
		this.order_product_code = order_product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
}
