package combini.service;

import java.util.List;

import combini.dao.SaleProductsDAO;
import combini.vo.Join;

public class SaleProductsService {
	
	SaleProductsDAO dao = new SaleProductsDAO();
	
	// 할인 상품 조회
	public List<Join> selectSaleProducts(String saleDate) {
		return dao.selectSaleProducts(saleDate);
	}

}
