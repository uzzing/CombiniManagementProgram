package combini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import combini.vo.Join;
import combini.vo.Products;

public class SaleProductsDAO {

	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// 할인 상품 조회
	public List<Join> selectSaleProducts(String saleDate) {
		SqlSession session = null;
		List<Join> list = null;
		
		try {
			session = factory.openSession();
			SaleProductsMapper mapper = session.getMapper(SaleProductsMapper.class);
			list = mapper.selectSaleProducts(saleDate);
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
}
