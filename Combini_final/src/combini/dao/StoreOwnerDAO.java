package combini.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import combini.vo.StoreOwner;

public class StoreOwnerDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	// register
	public int register(StoreOwner storeOwner) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			StoreOwnerMapper mapper = session.getMapper(StoreOwnerMapper.class);
			result = mapper.register(storeOwner);
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
	
	// login
	public StoreOwner login(StoreOwner storeOwner) {
		
		SqlSession session = null;
		
		StoreOwner owner = null;
		
		try {
			session = factory.openSession();
			StoreOwnerMapper mapper = session.getMapper(StoreOwnerMapper.class);
			owner = mapper.login(storeOwner);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return owner;
	}
	
}
