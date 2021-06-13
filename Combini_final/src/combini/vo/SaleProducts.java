package combini.vo;

public class SaleProducts {
	private int saleseqno;
	private String product_code;
	private String start_date;
	private String last_date;
	private int discount_pct;
	
	// getter
	public int getSaleseqno() {
		return saleseqno;
	}

	public String getProduct_code() {
		return product_code;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getLast_date() {
		return last_date;
	}

	public int getDiscount_pct() {
		return discount_pct;
	}

	// setter
	public void setSaleseqno(int saleseqno) {
		this.saleseqno = saleseqno;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	public void setDiscount_pct(int discount_pct) {
		this.discount_pct = discount_pct;
	}

	@Override
	public String toString() {
		return "[saleseqno=" + saleseqno + ", product_code=" + product_code + ", start_date=" + start_date
				+ ", last_date=" + last_date + ", discount_pct=" + discount_pct + "]";
	}
}
