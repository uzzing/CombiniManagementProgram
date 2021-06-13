package combini.service;


import combini.dao.StoreOwnerDAO;
import combini.vo.StoreOwner;

public class StoreOwnerService {

	private StoreOwnerDAO dao = new StoreOwnerDAO();
	
	// register
	public int register(StoreOwner storeOwner) {
		return dao.register(storeOwner);
	}
	
	// login
	public StoreOwner login(StoreOwner storeOwner) {
		return dao.login(storeOwner);
	}

}
