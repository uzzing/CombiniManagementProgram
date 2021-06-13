package combini.vo;

// join products & sale products
public class Join {
	
	private String product_code;
	private String product_name;
	private int price;
	private String start_date;
	private String last_date;
	
	// getter
	public String getProduct_code() {
		return product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getPrice() {
		return price;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getLast_date() {
		return last_date;
	}
	
	// setter 
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	
	@Override
	public String toString() {
		return "[product_name=" + product_name + ", product_code=" + product_code + ", price=" + price
				+ ", start_date=" + start_date + ", last_date=" + last_date + "]";
	}
	

}