package combini.vo;

public class Products {
	private String product_code;
	private int productseqno;
	private String product_name;
	private int price;
	private int stock;
	private int cost_price;

	// »ý¼ºÀÚ
	public Products() { }

	public Products(String product_code, int productseqno, String product_name, int price, int stock, int cost_price) {
		super();
		this.product_code = product_code;
		this.productseqno = productseqno;
		this.product_name = product_name;
		this.price = price;
		this.stock = stock;
		this.cost_price = cost_price;
	}

	// getter
	public String getProduct_code() {
		return product_code;
	}
	public int getProductseqno() {
		return productseqno;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public int getCost_price() {
		return cost_price;
	}
	
	// setter
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public void setProductseqno(int productseqno) {
		this.productseqno = productseqno;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}
	
	@Override
	public String toString() {
		return "[product_name="	+ product_name + ", productseqno=" + productseqno + ", product_code=" + product_code + ", price=" + price + ", stock=" + stock + ", cost_price=" + cost_price + "]";
	}

}
