package combini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import combini.vo.Products;

public class ProductsDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// get one product by product name
	public Products selectOne(String productName) {
		SqlSession session = null;

		Products product = null;

		try {
			session = factory.openSession();
			ProductsMapper mapper = session.getMapper(ProductsMapper.class);
			product = mapper.selectOne(productName);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return product;
	}
	
	// get multiple products by product name
	public List<Products> selectMultiple(String productName) {
		SqlSession session = null;
		List<Products> product = null;
		
		try {
			session = factory.openSession();
			ProductsMapper mapper = session.getMapper(ProductsMapper.class);
			product = mapper.selectMultiple(productName);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return product;
	}
	
	// get all products
	public List<Products> selectAll() {
		SqlSession session = null;
		
		List<Products> list = null;
		
		try {
			session = factory.openSession();
			ProductsMapper mapper = session.getMapper(ProductsMapper.class);
			list = mapper.selectAll();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	// update stock
	public int updateStock(Products product) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			ProductsMapper mapper = session.getMapper(ProductsMapper.class);
			result = mapper.updateStock(product);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return result;
	}
}
