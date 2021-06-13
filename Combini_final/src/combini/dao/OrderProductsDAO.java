package combini.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import combini.vo.OrderProducts;
import combini.vo.Ordering;

public class OrderProductsDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	// order items
	public int insertOrderProducts(OrderProducts orderProducts) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			OrderProductsMapper mapper = session.getMapper(OrderProductsMapper.class);
			result = mapper.insertOrderProducts(orderProducts);
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
	
	// start order
	public int insertOrdering(int totalOrderPrice) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			OrderProductsMapper mapper = session.getMapper(OrderProductsMapper.class);
			result = mapper.insertOrdering(totalOrderPrice);
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
	
	// get the order code
	public Ordering selectTheLatest() {
		SqlSession session = null;
		Ordering order = null;
		
		try {
			session = factory.openSession();
			OrderProductsMapper mapper = session.getMapper(OrderProductsMapper.class);
			order = mapper.selectTheLatest();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return order;
	}
	
	// update totalOrderPrice
	public int updateOrdering(Ordering newOrdering) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			OrderProductsMapper mapper = session.getMapper(OrderProductsMapper.class);
			result = mapper.updateOrdering(newOrdering);
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
	
	// get order status
	public Ordering selectOrderStatus(String orderCode) {
		SqlSession session = null;
		Ordering order = null;
		
		try {
			session = factory.openSession();
			OrderProductsMapper mapper = session.getMapper(OrderProductsMapper.class);
			order = mapper.selectOrderStatus(orderCode);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return order;
	}
}
