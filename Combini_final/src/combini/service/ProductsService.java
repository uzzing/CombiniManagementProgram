package combini.service;

import java.util.List;

import combini.dao.ProductsDAO;
import combini.vo.Products;

public class ProductsService {
	
	private ProductsDAO dao = new ProductsDAO();
	
	// get one product by product name
	public Products selectOne(String productName) {
		return dao.selectOne(productName);
	}
	
	// get multiple products by product name
	public List<Products> selectMultiple(String productname) {
		return dao.selectMultiple(productname);
	}
	
	// get all products
	public List<Products> selectAll() {
		return dao.selectAll();
	}
	
	// update stock
	public int updateStock(Products product) {
		return dao.updateStock(product);
	}

}
