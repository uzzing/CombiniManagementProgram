package combini.vo;

public class Ordering {
	
	private String order_code; // fk of order products
	private int total_order_price; // order_count * cost_price
	private int order_status;
	private String order_date; // sysdate we don't need to insert data directly

	// getter
	public String getOrder_code() {
		return order_code;
	}
	public int getTotal_order_price() {
		return total_order_price;
	}
	public int getOrder_status() {
		return order_status;
	}
	public String getOrder_date() {
		return order_date;
	}
	
	// setter
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public void setTotal_order_price(int total_order_price) {
		this.total_order_price = total_order_price;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	@Override
	public String toString() {
		return "[order_code=" + order_code + ", total_order_price=" + total_order_price + ", order_status="
				+ order_status + ", order_date=" + order_date + "]";
	}

}
