package combini.dao;

import java.util.List;

import combini.vo.Join;

public interface SaleProductsMapper {

	// 할인 상품 조회
	public List<Join> selectSaleProducts(String saleDate);

}
