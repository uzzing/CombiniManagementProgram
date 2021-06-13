package combini.dao;

import java.util.List;

import combini.vo.Products;

public interface ProductsMapper {
	
	// get one product by product name
	public Products selectOne(String productName);
	
	// get multiple products by product name
	public List<Products> selectMultiple(String productName);
	
	// get all products
	public List<Products> selectAll();
	
	// update stock
	public int updateStock(Products product);
}
